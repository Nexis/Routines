package pl.mylittleworld.routines

import android.content.Context
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import pl.mylittleworld.routines.cache.Cache
import pl.mylittleworld.routines.database.ThingToDo
import pl.mylittleworld.rutines.R


class MyListAdapter(context: Context, objects: ArrayList<ThingToDo>,val control: Control) : ArrayAdapter<ThingToDo>(context,0,objects) {

    val swipeHandler: SwipeHandler=SwipeHandler()
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

        val gestureDetector: GestureDetector= GestureDetector(context,  swipeHandler)
        convertView.setOnTouchListener(View.OnTouchListener {v, event ->
          swipeHandler.thingToDo=thingToDo
        gestureDetector.onTouchEvent(event)
        })

        return convertView
    }


    inner class SwipeHandler : GestureDetector.OnGestureListener {
       var thingToDo: ThingToDo?=null

        override fun onShowPress(e: MotionEvent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onDown(e: MotionEvent?): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onLongPress(e: MotionEvent?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        //synchronized
      //  {
            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {



                val SWIPE_DISTANCE_THRESHOLD = 100
                val SWIPE_VELOCITY_THRESHOLD = 100

                val distanceX = e2.getX() - e1.getX();
                val distanceY = e2.getY() - e1.getY();
                if (Math.abs(distanceX) > Math.abs(distanceY) && Math.abs(distanceX) > SWIPE_DISTANCE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (distanceX > 0) {
                        control.userSwipedRightAtTask(thingToDo)
                    } else {
                        control.userSwipedLeftAtTask(thingToDo)
                    }

                    return true
                }
                return false
            }
        }

  //  }

    }


