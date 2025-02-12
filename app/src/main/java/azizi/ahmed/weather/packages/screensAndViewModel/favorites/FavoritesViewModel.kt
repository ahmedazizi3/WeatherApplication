package azizi.ahmed.weather.packages.screensAndViewModel.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azizi.ahmed.weather.packages.model.FavoriteEntity
import azizi.ahmed.weather.packages.repository.FavoriteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val favoriteRepository: FavoriteRepository) : ViewModel() {
    private val _favoriteList = MutableStateFlow<List<FavoriteEntity>>(emptyList())
    val favoriteList = _favoriteList.asStateFlow()

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteRepository
                .getFavorites()
                .distinctUntilChanged()
                .collect { listOfFavorites ->
                    if (listOfFavorites.isEmpty()) {
                        _favoriteList.value = emptyList()
                    } else {
                        _favoriteList.value = listOfFavorites
                    }
                }
        }
    }

    fun insertFavorite(favoriteEntity: FavoriteEntity) = viewModelScope.launch {
        favoriteRepository.insertFavorite(favoriteEntity)
    }

    fun updateFavorite(favoriteEntity: FavoriteEntity) = viewModelScope.launch {
        favoriteRepository.updateFavorite(favoriteEntity)
    }

    fun deleteFavoriteByCity(city: String) = viewModelScope.launch {
        favoriteRepository.deleteFavoriteByCity(city)
    }

    fun deleteAllFavorites() = viewModelScope.launch {
        favoriteRepository.deleteAllFavorites()
    }

    fun getFavoriteByCity(city: String) = viewModelScope.launch {
        favoriteRepository.getFavoriteByCity(city)
    }
}