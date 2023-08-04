package com.ortega.lingaprofil.data.datasource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

/**
 * Profile Data Access Object,
 * Define all actions we'll do on our Profile Entity like
 *
 * ( insertProfile, deleteProfile, updateProfile, getAll, getFavoriteProfile )
 */
@Dao
interface ProfileDAO {

    @Insert
    suspend fun insertProfile(profile: ProfileEntity)

    @Delete
    suspend fun deleteProfile(profile: ProfileEntity)

    @Update
    suspend fun updateProfile(profile: ProfileEntity)

    @Query("SELECT * FROM profile")
    fun getAll(): Flow<List<ProfileEntity>>

    @Query("SELECT * FROM profile WHERE isFavorite = :isFavorite")
    fun getFavoriteProfile(isFavorite: Boolean): Flow<List<ProfileEntity>>


}