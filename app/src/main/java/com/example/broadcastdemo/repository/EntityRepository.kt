package com.example.broadcastdemo.repository

import android.content.Context
import com.example.broadcastdemo.api.RetrofitClient
import com.example.broadcastdemo.data.AppDatabase
import com.example.broadcastdemo.data.GeoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class EntityRepository(context: Context) {
    private val dao = AppDatabase.getDatabase(context).entityDao()
    private val apiService = RetrofitClient.apiService

    val allEntities: Flow<List<GeoEntity>> = dao.getAllEntities()

    suspend fun refreshEntities() {
        withContext(Dispatchers.IO) {
            try {
                val response = apiService.getEntities()
                if (response.isSuccessful) {
                    response.body()?.let { serverEntities ->
                        dao.insertAll(serverEntities)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun createEntity(title: String, lat: Double, lon: Double, imageFile: File?) {
        withContext(Dispatchers.IO) {
            val localEntity = GeoEntity(
                id = 0,
                title = title,
                lat = lat,
                lon = lon,
                image = imageFile?.name ?: ""
            )
            val localId = dao.insert(localEntity)

            try {
                val response = if (imageFile != null) {
                    val titlePart = title.toRequestBody("text/plain".toMediaTypeOrNull())
                    val latPart = lat.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                    val lonPart = lon.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                    
                    val imagePart = MultipartBody.Part.createFormData(
                        "image",
                        imageFile.name,
                        imageFile.asRequestBody("image/*".toMediaTypeOrNull())
                    )

                    apiService.createEntity(titlePart, latPart, lonPart, imagePart)
                } else {
                    apiService.createEntityWithoutImage(title, lat, lon)
                }

                if (response.isSuccessful) {
                    response.body()?.let { serverEntity ->
                        dao.insert(serverEntity)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun updateEntity(entity: GeoEntity, imageFile: File?) {
        withContext(Dispatchers.IO) {
            dao.update(entity)

            try {
                val response = if (imageFile != null) {
                    val titlePart = entity.title.toRequestBody("text/plain".toMediaTypeOrNull())
                    val latPart = entity.lat.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                    val lonPart = entity.lon.toString().toRequestBody("text/plain".toMediaTypeOrNull())
                    
                    val imagePart = MultipartBody.Part.createFormData(
                        "image",
                        imageFile.name,
                        imageFile.asRequestBody("image/*".toMediaTypeOrNull())
                    )

                    apiService.updateEntityWithImage(entity.id, titlePart, latPart, lonPart, imagePart)
                } else {
                    apiService.updateEntity(entity.id, entity.title, entity.lat, entity.lon)
                }

                if (response.isSuccessful) {
                    response.body()?.let { serverEntity ->
                        dao.update(serverEntity)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun deleteEntity(entity: GeoEntity) {
        withContext(Dispatchers.IO) {
            dao.delete(entity)

            try {
                val response = apiService.deleteEntity(entity.id)
                if (!response.isSuccessful) {
                    println("Failed to delete entity on server: ${response.code()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    suspend fun deleteEntityById(id: Int) {
        withContext(Dispatchers.IO) {
            dao.deleteById(id)

            try {
                val response = apiService.deleteEntity(id)
                if (!response.isSuccessful) {
                    println("Failed to delete entity on server: ${response.code()}")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
