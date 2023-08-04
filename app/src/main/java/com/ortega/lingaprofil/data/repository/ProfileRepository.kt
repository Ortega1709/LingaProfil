package com.ortega.lingaprofil.data.repository

import com.ortega.lingaprofil.data.datasource.ProfileDAO
import com.ortega.lingaprofil.data.datasource.ProfileEntity
import javax.inject.Inject

/**
 * Profile Repository,
 *
 * Implements all actions of our Profile DAO
 *
 * @property profileDAO
 */
class ProfileRepository @Inject constructor(private val profileDAO: ProfileDAO) {

    suspend fun insert(profile: ProfileEntity) = profileDAO.insertProfile(profile)
    suspend fun delete(profile: ProfileEntity) = profileDAO.deleteProfile(profile)
    suspend fun update(profile: ProfileEntity) = profileDAO.updateProfile(profile)
    fun getAll() = profileDAO.getAll()
    fun getFavoriteProfile(isFavorite: Boolean) = profileDAO.getFavoriteProfile(isFavorite)

}