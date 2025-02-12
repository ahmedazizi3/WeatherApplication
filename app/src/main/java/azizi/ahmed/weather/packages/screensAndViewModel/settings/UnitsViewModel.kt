package azizi.ahmed.weather.packages.screensAndViewModel.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import azizi.ahmed.weather.packages.model.UnitEntity
import azizi.ahmed.weather.packages.repository.UnitsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnitsViewModel @Inject constructor(private val unitsRepository: UnitsRepository) : ViewModel() {
    private val _unitList = MutableStateFlow<List<UnitEntity>>(emptyList())
    val unitList = _unitList

    init {
        getUnits()
    }

    private fun getUnits() {
        viewModelScope.launch(Dispatchers.IO) {
            unitsRepository
                .getUnits()
                .distinctUntilChanged()
                .collect { listOfUnits ->
                    if (listOfUnits.isEmpty()) {
                        _unitList.value = emptyList()
                    } else {
                        _unitList.value = listOfUnits
                    }
                }
        }
    }

    fun insertUnit(unitEntity: UnitEntity) = viewModelScope.launch {
        unitsRepository.insertUnit(unitEntity)
    }

    fun updateUnit(unitEntity: UnitEntity) = viewModelScope.launch {
        unitsRepository.updateUnit(unitEntity)
    }

    fun deleteUnit(unit: String) = viewModelScope.launch {
        unitsRepository.deleteUnit(unit)
    }

    fun deleteAllUnits() = viewModelScope.launch {
        unitsRepository.deleteAllUnits()
    }

    fun getAUnit(unit: String) = viewModelScope.launch {
        unitsRepository.getAUnit(unit)
    }
}