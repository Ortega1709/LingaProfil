package com.ortega.lingaprofil.data.datasource

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

/**
 * Profile Entity for Application,
 * get information of users to add in
 * our database room
 *
 * @property id unique for profile
 * @property name name of user
 * @property phone phone of user
 * @property profession profession of user
 * @property email optional email of user
 * @property address physic address of user
 * @property image optional image of user
 * @property isFavorite favorite profile or not
 */

@Entity(tableName = "profile")
data class ProfileEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val phone: String,
    val profession: String,

    @ColumnInfo(defaultValue = "")
    val email: String? = null,
    val address: String,

    @ColumnInfo(defaultValue = "")
    val image: String? = null,
    val isFavorite: Boolean = false
)

