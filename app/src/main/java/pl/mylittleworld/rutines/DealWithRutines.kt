package pl.mylittleworld.rutines;

import pl.mylittleworld.rutines.database.Habit
import java.time.DayOfWeek

public interface DealWithRutines {

    fun addHabit(routineAtDay :Habit)
    fun deleteHabit(routineAtDay :Habit)
    fun updateHabit(routineAtDay :Habit)
    fun getRoutinesAtDay(day: DayOfWeek) : List<Habit>
    fun getRoutinesWithNoDayAssignedNotDoneThisWeek() :List<Habit>

    /**
     * Going to be extended
     */

}