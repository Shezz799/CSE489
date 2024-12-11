package com.example.broadcastdemo.viewmodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u0013J\u0018\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/example/broadcastdemo/viewmodel/EntityViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_errorMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "entities", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/example/broadcastdemo/data/GeoEntity;", "getEntities", "()Lkotlinx/coroutines/flow/StateFlow;", "errorMessage", "getErrorMessage", "repository", "Lcom/example/broadcastdemo/repository/EntityRepository;", "clearError", "", "createEntity", "title", "lat", "", "lon", "imageFile", "Ljava/io/File;", "deleteEntity", "entity", "refreshEntities", "updateEntity", "app_debug"})
public final class EntityViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.example.broadcastdemo.repository.EntityRepository repository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.broadcastdemo.data.GeoEntity>> entities = null;
    
    public EntityViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.broadcastdemo.data.GeoEntity>> getEntities() {
        return null;
    }
    
    public final void refreshEntities() {
    }
    
    public final void createEntity(@org.jetbrains.annotations.NotNull
    java.lang.String title, double lat, double lon, @org.jetbrains.annotations.Nullable
    java.io.File imageFile) {
    }
    
    public final void updateEntity(@org.jetbrains.annotations.NotNull
    com.example.broadcastdemo.data.GeoEntity entity, @org.jetbrains.annotations.Nullable
    java.io.File imageFile) {
    }
    
    public final void deleteEntity(@org.jetbrains.annotations.NotNull
    com.example.broadcastdemo.data.GeoEntity entity) {
    }
    
    public final void clearError() {
    }
}