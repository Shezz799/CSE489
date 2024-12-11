package com.example.broadcastdemo.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\u000e2\b\b\u0001\u0010\b\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u0013H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00160\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J?\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\r2\b\b\u0001\u0010\u0007\u001a\u00020\u000e2\b\b\u0001\u0010\b\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019JI\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/example/broadcastdemo/api/ApiService;", "", "createEntity", "Lretrofit2/Response;", "Lcom/example/broadcastdemo/data/GeoEntity;", "title", "Lokhttp3/RequestBody;", "lat", "lon", "image", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createEntityWithoutImage", "", "", "(Ljava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEntity", "", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEntities", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEntity", "(ILjava/lang/String;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEntityWithImage", "(ILokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "entities")
    public abstract java.lang.Object getEntities(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.broadcastdemo.data.GeoEntity>>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "entities")
    @retrofit2.http.Multipart
    public abstract java.lang.Object createEntity(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "title")
    okhttp3.RequestBody title, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "lat")
    okhttp3.RequestBody lat, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "lon")
    okhttp3.RequestBody lon, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part
    okhttp3.MultipartBody.Part image, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.broadcastdemo.data.GeoEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "entities")
    public abstract java.lang.Object createEntityWithoutImage(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "title")
    java.lang.String title, @retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.broadcastdemo.data.GeoEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.PUT(value = "entities/{id}")
    @retrofit2.http.Multipart
    public abstract java.lang.Object updateEntityWithImage(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "title")
    okhttp3.RequestBody title, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "lat")
    okhttp3.RequestBody lat, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "lon")
    okhttp3.RequestBody lon, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part
    okhttp3.MultipartBody.Part image, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.broadcastdemo.data.GeoEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.PUT(value = "entities/{id}")
    public abstract java.lang.Object updateEntity(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "title")
    java.lang.String title, @retrofit2.http.Query(value = "lat")
    double lat, @retrofit2.http.Query(value = "lon")
    double lon, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.broadcastdemo.data.GeoEntity>> continuation);
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.DELETE(value = "entities/{id}")
    public abstract java.lang.Object deleteEntity(@retrofit2.http.Path(value = "id")
    int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<kotlin.Unit>> continuation);
}