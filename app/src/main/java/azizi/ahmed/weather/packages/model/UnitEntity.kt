package azizi.ahmed.weather.packages.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "unitsTable")
data class UnitEntity(
    @PrimaryKey
    @ColumnInfo(name = "unit")
    val unit: String
)
