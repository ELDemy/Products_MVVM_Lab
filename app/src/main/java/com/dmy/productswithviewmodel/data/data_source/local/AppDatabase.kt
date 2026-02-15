package com.dmy.productswithviewmodel.data.data_source.local

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dmy.productswithviewmodel.data.model.Product

@Database(entities = [Product::class], version = 2)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "color_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}

@Dao
interface ProductDao {
    @Query("SELECT * FROM Product")
    fun getAll(): LiveData<List<Product>>

    @Query("SELECT * FROM Product WHERE isFavorite = 1")
    fun getFavProducts(): LiveData<List<Product>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(products: List<Product>)

    @Query("SELECT * FROM Product WHERE id = :id")
    suspend fun getProductById(id: Int): Product?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(product: Product)

    @Query("UPDATE product SET isFavorite = NOT isFavorite WHERE id = :id")
    suspend fun updateFavoriteState(id: Int)

    @Delete
    suspend fun delete(product: Product)
}