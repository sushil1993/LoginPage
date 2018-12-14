package sushillogin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(LoginDetailEntity::class),version = 1)
abstract  class RoomSingleton: RoomDatabase() {

    abstract fun LoginDao():LoginDao

    companion object {
        private var INSTANCE:RoomSingleton?=null
        fun getInstance(context: Context):RoomSingleton{
            if (INSTANCE==null){
                INSTANCE=Room.databaseBuilder(context,RoomSingleton::class.java,"roomDb").allowMainThreadQueries().build()
            }
            return INSTANCE as RoomSingleton
        }
    }


}