package pl.mylittleworld.rutines

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import pl.mylittleworld.rutines.database.ThingToDo


class MyListAdapter(context: Context, objects: ArrayList<ThingToDo>) : ArrayAdapter<ThingToDo>(context,0,objects) {

    override fun getView(position: Int, convertViewP: View?, parent: ViewGroup): View {
        var convertView=convertViewP
        val thingToDo: ThingToDo? = getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false)

            if(convertView==null)
                throw  RuntimeException()
        }
        val name = convertView.findViewById<TextView>(R.id.name)

        name.text = thingToDo?.name

        convertView.setOnTouchListener{ v, event ->
            if(event.action== MotionEvent.ACTION_MOVE){
                Log.d()
            }
            true
        }


        return convertView
    }


}
