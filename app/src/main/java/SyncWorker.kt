import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.buscor.ViewModels.Database.MainDatabase
import com.example.buscor.ViewModels.Retrofit.Retrofit

class SyncWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val db = MainDatabase.getDatabase(applicationContext)
        val api =  Retrofit.RetrofitInstance.api

        return try {

             val id: Int = 1
            // 1. Push offline changes to the server
            val unsyncedTrip = db.Dao().geTrip(id)
            for (trip in unsyncedTrip) {
                val response = api.addTrip(
                    token = trip.userId,
                    amount = trip.fairAmount,
                    userStartLocation = trip.userStartLocation,
                    userEndLocation = trip.userEndLocation,
                    isSynced = true
                )
                if (response.isSuccessful && response.body() != null) {
                    db.Dao().UpdateTrip(trip.id)
                } else {
                    return Result.retry() // Try again later if server fails
                }
            }

            // 2. Pull fresh data from server (Optional)
            val serverResponse = api.getTrips()
                serverResponse.forEach { serverNote ->
                    db.Dao().addTrip(serverNote.copy(isSynced = true))
            }

            Result.success()
        } catch (e: Exception) {
            Result.retry() // Network exception; WorkManager will retry automatically
        }
    }
}