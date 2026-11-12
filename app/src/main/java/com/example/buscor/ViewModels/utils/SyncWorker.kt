package com.example.buscor.ViewModels.utils

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.buscor.Model.MainRepository.MainRepository

class SyncWorker(
    appContext: Context,
    workerParams: WorkerParameters,
    private val repo: MainRepository
) : CoroutineWorker(appContext, workerParams) {

    override suspend fun doWork(): Result {
        // Initialize or inject your repository here
        val repository = repo

        return if (repository.syncTripData()) {
            Result.success()
        } else {
            Result.retry() // Automatically retries with exponential backoff
        }

        return if (repository.syncCardData()) {
            Result.success()
        } else {
            Result.retry() // Automatically retries with exponential backoff
        }
    }
}