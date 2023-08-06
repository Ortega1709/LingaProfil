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
 * @property phone optional phone of user
 * @property profession optional profession of user
 * @property email optional email of user
 * @property address optional physic address of user
 * @property image optional image of user
 * @property isFavorite favorite profile or not
 */

@Entity(tableName = "profile")
data class ProfileEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,

    @ColumnInfo(defaultValue = "")
    val phone: String,

    @ColumnInfo(defaultValue = "")
    val profession: String,

    @ColumnInfo(defaultValue = "")
    val email: String? = null,

    @ColumnInfo(defaultValue = "")
    val address: String,

    @ColumnInfo(defaultValue = "")
    val image: String? = null,
    val isFavorite: Boolean = false
)

