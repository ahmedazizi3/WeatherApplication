package azizi.ahmed.weather.packages.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import azizi.ahmed.weather.packages.model.UnitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UnitDAO {
    //    Unit Table

    @Query("SELECT * from unitsTable")
    fun getUnits(): Flow<List<UnitEntity>>

    @Query("SELECT * from unitstable where unit =:unit")
    suspend fun getAUnit(unit: String): UnitEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnit(unitEntity: UnitEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUnit(unitEntity: UnitEntity)

    @Query("DELETE from UnitsTable")
    suspend fun deleteAllUnits()

    @Query("DELETE from UnitsTable where unit =:unit")
    suspend fun deleteUnit(unit: String)
}
