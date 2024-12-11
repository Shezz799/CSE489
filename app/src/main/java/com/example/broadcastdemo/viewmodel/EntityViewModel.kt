package com.example.broadcastdemo.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.broadcastdemo.data.GeoEntity
import com.example.broadcastdemo.repository.EntityRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.File

class EntityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = EntityRepository(application)
    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage = _errorMessage.asStateFlow()

    val entities = repository.allEntities
        .catch { e -> 
            _errorMessage.value = e.message
            emit(emptyList())
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    init {
        refreshEntities()
    }

    fun refreshEntities() {
        viewModelScope.launch {
            try {
                repository.refreshEntities()
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun createEntity(title: String, lat: Double, lon: Double, imageFile: File?) {
        viewModelScope.launch {
            try {
                repository.createEntity(title, lat, lon, imageFile)
                refreshEntities()
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun updateEntity(entity: GeoEntity, imageFile: File?) {
        viewModelScope.launch {
            try {
                repository.updateEntity(entity, imageFile)
                refreshEntities()
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun deleteEntity(entity: GeoEntity) {
        viewModelScope.launch {
            try {
                repository.deleteEntity(entity)
                refreshEntities()
                _errorMessage.value = null
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun clearError() {
        _errorMessage.value = null
    }
}
