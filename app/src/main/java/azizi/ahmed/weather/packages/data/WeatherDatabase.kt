package azizi.ahmed.weather.packages.data

import androidx.room.Database
import androidx.room.RoomDatabase
import azizi.ahmed.weather.packages.model.FavoriteEntity
import azizi.ahmed.weather.packages.model.UnitEntity

@Database(
    entities = [
        FavoriteEntity::class,
        UnitEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class WeatherDatabase: RoomDatabase() {
    abstract fun weatherDAO(): FavoriteDAO
    abstract fun unitsDAO(): UnitDAO

}