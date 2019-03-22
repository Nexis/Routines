package pl.mylittleworld.routines

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

import pl.mylittleworld.routines.cache.Cache
import pl.mylittleworld.routines.database.ThingToDo
import pl.mylittleworld.rutines.R

class MainActivity : FragmentActivity(), Control {
    override fun refreshView() {
        val adapter=listView.adapter
        if(adapter is ArrayAdapter<*>){
            adapter.notifyDataSetChanged()
        }
    }

    override fun userSwipedRightAtTask(thingToDo: ThingToDo) {
        if(visibleListStatus==Status.TO_DO){
             cache?.assignTaskAsDone(thingToDo)
        }
        else{
            cache?.postponedToToDo(thingToDo)
        }
        refreshView()
    }

    override fun userSwipedLeftAtTask(thingToDo: ThingToDo) {
        if(visibleListStatus==Status.TO_DO){
             cache?.postponeTask(thingToDo)
        }
        else{
            cache?.DoneToToDo(thingToDo)
        }
        refreshView()
    }

    lateinit var postponedListAdapter: MyListAdapter
    lateinit var toDoListAdapter: MyListAdapter
    lateinit var doneListAdapter: MyListAdapter
    var cache: Cache? = null

    var visibleListStatus: Status=Status.TO_DO

    @BindView(R.id.postponed) lateinit var postponedButton: Button
    @BindView(R.id.to_do) lateinit var toDoButton: Button
    @BindView(R.id.done) lateinit var doneButton: Button
    @BindView(R.id.list_view) lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ButterKnife.bind(this)


/*Only for tests*/

        val postponedToDoList: ArrayList<ThingToDo> = ArrayList()
        postponedToDoList.add(ThingToDo(1, Status.TO_DO, "POSTPONED"))

        val thingToDoList: ArrayList<ThingToDo> = ArrayList()
        thingToDoList.add(ThingToDo(1, Status.TO_DO, "TO_DO"))

        val doneToDoList: ArrayList<ThingToDo> = ArrayList()
        doneToDoList.add(ThingToDo(1, Status.TO_DO, "DONE"))

        cache= Cache(postponedToDoList,thingToDoList,doneToDoList)

        postponedListAdapter = MyListAdapter(this, postponedToDoList,this)
        toDoListAdapter = MyListAdapter(this, thingToDoList,this)
        doneListAdapter = MyListAdapter(this, doneToDoList,this)


        /* End*/


        listView.adapter = toDoListAdapter
    }

    @OnClick(R.id.postponed)
    fun showPostponedTasks(): Unit {
        listView.adapter =postponedListAdapter
        visibleListStatus=Status.NOT_TO_DO
    }

    @OnClick(R.id.to_do)
    fun showToDoTasks(): Unit {
        listView.adapter =toDoListAdapter
        visibleListStatus=Status.TO_DO
    }

    @OnClick(R.id.done)
    fun showDoneTasks(): Unit {
        listView.adapter =doneListAdapter
        visibleListStatus=Status.DONE
    }


}
