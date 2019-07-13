package com.devesh.mvvm.kotlin.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devesh.mvvm.kotlin.data.database.entities.CURRENT_USER_ID
import com.devesh.mvvm.kotlin.data.database.entities.User

// Data access object
@Dao
interface UserDao {

    // update + insert = upsert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(user:User) : Long

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}