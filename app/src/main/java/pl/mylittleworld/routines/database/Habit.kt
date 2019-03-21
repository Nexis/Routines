package pl.mylittleworld.routines.database

import android.arch.persistence.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime

/**
 * np mycie zebow
 */


data class Habit(
        @PrimaryKey(autoGenerate = true) val id: Int,
        var thingToDo: ThingToDo? = null,
        var timesInWeek: Int = 0,
        var daysOfWeek: List<DayOfWeek>? = null,
        var timeAtDay: LocalTime? = null,
        var notification: Boolean = false
 )
