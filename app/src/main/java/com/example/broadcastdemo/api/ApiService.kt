package com.example.broadcastdemo.api

import com.example.broadcastdemo.data.GeoEntity
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("entities")
    suspend fun getEntities(): Response<List<GeoEntity>>

    @Multipart
    @POST("entities")
    suspend fun createEntity(
        @Part("title") title: RequestBody,
        @Part("lat") lat: RequestBody,
        @Part("lon") lon: RequestBody,
        @Part image: MultipartBody.Part
    ): Response<GeoEntity>

    @POST("entities")
    suspend fun createEntityWithoutImage(
        @Query("title") title: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<GeoEntity>

    @Multipart
    @PUT("entities/{id}")
    suspend fun updateEntityWithImage(
        @Path("id") id: Int,
        @Part("title") title: RequestBody,
        @Part("lat") lat: RequestBody,
        @Part("lon") lon: RequestBody,
        @Part image: MultipartBody.Part
    ): Response<GeoEntity>

    @PUT("entities/{id}")
    suspend fun updateEntity(
        @Path("id") id: Int,
        @Query("title") title: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): Response<GeoEntity>

    @DELETE("entities/{id}")
    suspend fun deleteEntity(@Path("id") id: Int): Response<Unit>
}
