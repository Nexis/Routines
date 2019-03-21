package pl.mylittleworld.rutines.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import pl.mylittleworld.rutines.Status

@Entity
data class ThingToDo(
        @PrimaryKey val id: Int,
        var status: Status = Status.TO_DO,
        var name: String)


