package azizi.ahmed.weather.packages.repository

import azizi.ahmed.weather.packages.data.UnitDAO
import azizi.ahmed.weather.packages.model.UnitEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UnitsRepository @Inject constructor(private val unitDAO: UnitDAO) {
    fun getUnits(): Flow<List<UnitEntity>> = unitDAO.getUnits()
    suspend fun getAUnit(unit: String): UnitEntity? = unitDAO.getAUnit(unit)
    suspend fun deleteAllUnits() = unitDAO.deleteAllUnits()
    suspend fun deleteUnit(unit: String) = unitDAO.deleteUnit(unit)
    suspend fun insertUnit(unitEntity: UnitEntity) = unitDAO.insertUnit(unitEntity)
    suspend fun updateUnit(unitEntity: UnitEntity) = unitDAO.updateUnit(unitEntity)
}