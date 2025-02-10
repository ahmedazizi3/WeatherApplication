package azizi.ahmed.weather.packages.repository

import azizi.ahmed.weather.packages.data.WeatherDAO
import azizi.ahmed.weather.packages.model.FavoriteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val weatherDAO: WeatherDAO)  {
    fun getFavorites(): Flow<List<FavoriteEntity>> = weatherDAO.getFavorites()
    suspend fun getFavoriteByCity(city: String): FavoriteEntity? = weatherDAO.getFavoriteByCity(city)
    suspend fun deleteAllFavorites() = weatherDAO.deleteAllFavorites()
    suspend fun deleteFavoriteByCity(city: String) = weatherDAO.deleteFavoriteByCity(city)
    suspend fun insertFavorite(favoriteEntity: FavoriteEntity) = weatherDAO.insertFavorite(favoriteEntity)
    suspend fun updateFavorite(favoriteEntity: FavoriteEntity) = weatherDAO.updateFavorite(favoriteEntity)
}