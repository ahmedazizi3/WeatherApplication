package azizi.ahmed.weather.packages.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import azizi.ahmed.weather.packages.model.FavoriteEntity
import azizi.ahmed.weather.packages.model.UnitEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface FavoriteDAO {

//    Favorite Table

    @Query("SELECT * from favoriteTable")
    fun getFavorites(): Flow<List<FavoriteEntity>>

    @Query("SELECT * from favoriteTable where city =:city")
    suspend fun getFavoriteByCity(city: String): FavoriteEntity?

    @Query("DELETE from favoriteTable")
    suspend fun deleteAllFavorites()

    @Query("DELETE from favoriteTable where city =:city")
    suspend fun deleteFavoriteByCity(city: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteEntity: FavoriteEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateFavorite(favoriteEntity: FavoriteEntity)


}