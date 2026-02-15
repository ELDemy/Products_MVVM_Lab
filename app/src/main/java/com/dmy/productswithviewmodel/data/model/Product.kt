package com.dmy.productswithviewmodel.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Product(
    @PrimaryKey
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: String,
    val category: String?,
    val price: Double?,
    val discountPercentage: Double?,
    val rating: Float?,
    val stock: Int?,
    val brand: String?,
    var isFavorite: Boolean = false
) : Serializable