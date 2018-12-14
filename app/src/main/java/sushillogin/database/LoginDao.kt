package sushillogin.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
@Dao
interface LoginDao {
    @Query("Select * from loginDetail")
    fun getLoginDetail(): List<LoginDetailEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(loginDetailEntity: LoginDetailEntity)

}