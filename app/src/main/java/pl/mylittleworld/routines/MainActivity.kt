package pl.mylittleworld.routines

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.Button
import android.widget.ListView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

import pl.mylittleworld.routines.cache.Cache
import pl.mylittleworld.routines.database.ThingToDo
import pl.mylittleworld.rutines.R

class MainActivity : FragmentActivity() {

    lateinit var postponedListAdapter: MyListAdapter
    lateinit var toDoListAdapter: MyListAdapter
    lateinit var doneListAdapter: MyListAdapter
    val cache: Cache? = null

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



        postponedListAdapter = MyListAdapter(this, postponedToDoList)
        toDoListAdapter = MyListAdapter(this, thingToDoList)
        doneListAdapter = MyListAdapter(this, doneToDoList)


        /* End*/


        listView.adapter = toDoListAdapter
    }

    @OnClick(R.id.postponed)
    fun showPostponedTasks(): Unit {
        listView.adapter =postponedListAdapter
    }

    @OnClick(R.id.to_do)
    fun showToDoTasks(): Unit {
        listView.adapter =toDoListAdapter
    }

    @OnClick(R.id.done)
    fun showDoneTasks(): Unit {
        listView.adapter =doneListAdapter
    }


}
