package com.ortega.lingaprofil.data.datasource

import androidx.room.Database


/**
 * Profile DB, class of our database,
 * and provide Profile Data Access Object
 *
 */
@Database(entities = [ProfileEntity::class], version = 1)
abstract class ProfileDB {
    abstract fun profileDAO(): ProfileDAO
}