package pl.mylittleworld.routines

import pl.mylittleworld.routines.database.ThingToDo

interface Control{
    fun userSwipedRightAtTask(thingToDo: ThingToDo)
    fun userSwipedLeftAtTask(thingToDo: ThingToDo)
    fun refreshView()
}