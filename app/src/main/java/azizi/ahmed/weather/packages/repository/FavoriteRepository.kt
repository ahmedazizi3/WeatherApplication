package azizi.ahmed.weather.packages.repository

import azizi.ahmed.weather.packages.data.FavoriteDAO
import azizi.ahmed.weather.packages.model.FavoriteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteRepository @Inject constructor(private val favoriteDAO: FavoriteDAO)  {
    fun getFavorites(): Flow<List<FavoriteEntity>> = favoriteDAO.getFavorites()
    suspend fun getFavoriteByCity(city: String): FavoriteEntity? = favoriteDAO.getFavoriteByCity(city)
    suspend fun deleteAllFavorites() = favoriteDAO.deleteAllFavorites()
    suspend fun deleteFavoriteByCity(city: String) = favoriteDAO.deleteFavoriteByCity(city)
    suspend fun insertFavorite(favoriteEntity: FavoriteEntity) = favoriteDAO.insertFavorite(favoriteEntity)
    suspend fun updateFavorite(favoriteEntity: FavoriteEntity) = favoriteDAO.updateFavorite(favoriteEntity)
}