package com.example.buscor.Model.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.buscor.Model.Card.Card
import com.example.buscor.Model.PaymentInformation.Paymentinformation
import com.example.buscor.Model.Trip.Trip
import com.example.buscor.Model.User.User
import kotlinx.coroutines.flow.Flow
import java.util.Date

@Dao
interface DAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun Register(user: User)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrip(trip: Trip)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCard(card: Card)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun paymentInformation(paymentinformation: Paymentinformation)


//    @Query("SELECT * FROM user_table ORDER BY id ASC")
//    fun logIn(): Flow<List<User>>
//
//
//    @Query("SELECT * FROM ExpensesTable WHERE startDate = :startDate AND endDate = :endDate")
//    fun getAllRecWithDates(startDate: Date,endDate: Date ): Flow<List<ExpensesTable>>
//
//    @Query("SELECT * FROM ExpensesTable WHERE id = :id and startDate > :startSelectedDate AND endDate < :endSelectedDate ")
//    fun getAllRecByDates(id: Int,startSelectedDate: String,endSelectedDate: String ): Flow<List<ExpensesTable>>
//
//
//    @Query("SELECT * FROM trips")
//    fun getAllRec(): Flow<List<ExpensesTable>>
//
//
//    @Query("SELECT * FROM Caregories WHERE InorEx = :income ")
//    fun getAllIncome(income: String = "Income"): Flow<List<Caregories>>
//
//
//    @Query("SELECT * FROM Caregories WHERE InorEx = :Expense ")
//    fun getAllExpense(Expense: String = "Expense"): Flow<List<Caregories>>
//
//
//    @Query("SELECT id FROM user_table WHERE email =:Email AND password = :Password")
//    suspend fun logIn(Email : String, Password: String) : Int

}