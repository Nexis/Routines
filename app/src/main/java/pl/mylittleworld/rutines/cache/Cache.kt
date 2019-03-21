package pl.mylittleworld.rutines.cache

import pl.mylittleworld.rutines.database.ThingToDo

class Cache(
        val postponed: ArrayList<ThingToDo>,
        val toDo: ArrayList<ThingToDo>,
        val done: ArrayList<ThingToDo>
        ){

    fun postponeTask(toDoThing:ThingToDo): Boolean{
        if(toDo.remove(toDoThing)){
            if(postponed.add(toDoThing)){
                return true
            }
        }
        return false
    }

    fun assignTaskAsDone(toDoThing:ThingToDo): Boolean{
        if(toDo.remove(toDoThing)){
            if(done.add(toDoThing)){
                return true
            }
        }
        return false
    }

    fun DoneToToDo(toDoThing:ThingToDo): Boolean{
        if(done.remove(toDoThing)){
            if(toDo.add(toDoThing)){
                return true
            }
        }
        return false
    }

    fun postponedToToDo(toDoThing:ThingToDo): Boolean{
        if(postponed.remove(toDoThing)){
            if(toDo.add(toDoThing)){
                return true
            }
        }
        return false
    }
    fun addToDoThing(toDoThing:ThingToDo): Unit{
        toDo.add(toDoThing)
    }
}