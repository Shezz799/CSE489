package com.example.broadcastdemo.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EntityDao {
    @Query("SELECT * FROM entities")
    fun getAllEntities(): Flow<List<GeoEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: GeoEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<GeoEntity>)

    @Update
    suspend fun update(entity: GeoEntity)

    @Delete
    suspend fun delete(entity: GeoEntity)

    @Query("DELETE FROM entities WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM entities WHERE id = :id")
    suspend fun getEntityById(id: Int): GeoEntity?

    @Query("DELETE FROM entities")
    suspend fun deleteAll()
}
