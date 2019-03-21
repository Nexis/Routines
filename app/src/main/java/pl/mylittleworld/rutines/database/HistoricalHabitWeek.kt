package pl.mylittleworld.rutines.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import pl.mylittleworld.rutines.Status

@Entity
data class HistoricalHabitWeek constructor(@PrimaryKey(autoGenerate = true) val id : Int,
                                           val week: Int,
                                           val routineType : ThingToDo,
                                           var status: List<Status>)