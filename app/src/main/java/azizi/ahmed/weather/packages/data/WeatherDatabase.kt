package azizi.ahmed.weather.packages.data

import androidx.room.Database
import androidx.room.RoomDatabase
import azizi.ahmed.weather.packages.model.FavoriteEntity

@Database(entities = [FavoriteEntity::class], version = 1, exportSchema = false)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDAO(): WeatherDAO
}