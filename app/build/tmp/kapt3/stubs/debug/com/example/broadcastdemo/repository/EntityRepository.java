package com.example.broadcastdemo.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J3\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ\u0011\u0010 \u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J#\u0010\"\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/example/broadcastdemo/repository/EntityRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allEntities", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/broadcastdemo/data/GeoEntity;", "getAllEntities", "()Lkotlinx/coroutines/flow/Flow;", "apiService", "Lcom/example/broadcastdemo/api/ApiService;", "dao", "Lcom/example/broadcastdemo/data/EntityDao;", "createEntity", "", "title", "", "lat", "", "lon", "imageFile", "Ljava/io/File;", "(Ljava/lang/String;DDLjava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEntity", "entity", "(Lcom/example/broadcastdemo/data/GeoEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEntityById", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshEntities", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEntity", "(Lcom/example/broadcastdemo/data/GeoEntity;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class EntityRepository {
    private final com.example.broadcastdemo.data.EntityDao dao = null;
    private final com.example.broadcastdemo.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.broadcastdemo.data.GeoEntity>> allEntities = null;
    
    public EntityRepository(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.broadcastdemo.data.GeoEntity>> getAllEntities() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object refreshEntities(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createEntity(@org.jetbrains.annotations.NotNull
    java.lang.String title, double lat, double lon, @org.jetbrains.annotations.Nullable
    java.io.File imageFile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateEntity(@org.jetbrains.annotations.NotNull
    com.example.broadcastdemo.data.GeoEntity entity, @org.jetbrains.annotations.Nullable
    java.io.File imageFile, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteEntity(@org.jetbrains.annotations.NotNull
    com.example.broadcastdemo.data.GeoEntity entity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteEntityById(int id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}