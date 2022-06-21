package com.dekola.dekk22.data.local

import androidx.room.*
import com.dekola.dekk22.data.model.ProductEntity

@Dao
interface ProductDao {

    @Transaction
    suspend fun updatePopularProducts(users: List<ProductEntity?>) {
        deleteAllProducts()
        savePopularProducts(users)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePopularProducts(users: List<ProductEntity?>)

    @Query("DELETE FROM product_table")
    suspend fun deleteAllProducts()

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun savePopularProducts(product... ProductEntity)

    @Query("SELECT * FROM product_table")
    suspend fun getAllProducts(): List<ProductEntity>

}