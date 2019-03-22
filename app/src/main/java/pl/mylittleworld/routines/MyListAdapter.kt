package pl.mylittleworld.routines

import android.content.Context
import android.support.animation.DynamicAnimation
import android.support.animation.FlingAnimation
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.TextView
import pl.mylittleworld.routines.cache.Cache
import pl.mylittleworld.routines.database.ThingToDo
import pl.mylittleworld.rutines.R


class MyListAdapter(context: Context, objects: ArrayList<ThingToDo>,val control: Control) : ArrayAdapter<ThingToDo>(context,0,objects) {

    override fun getView(position: Int, convertViewP: View?, parent: ViewGroup): View {
        var convertView=convertViewP
        val thingToDo: ThingToDo? = getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row, parent, false)

            if(convertView==null)
                throw  RuntimeException()
        }
        if(thingToDo==null) return convertView

        val name = convertView.findViewById<TextView>(R.id.name)

        name.text = thingToDo?.name

        val gestureDetector: GestureDetector= GestureDetector(context, SwipeHandler(thingToDo,convertView))
        convertView.setOnTouchListener(View.OnTouchListener {v, event ->
        gestureDetector.onTouchEvent(event)
        })

        return convertView
    }


    inner class SwipeHandler(val thingToDo: ThingToDo,val view: View) : GestureDetector.OnGestureListener{

        val fling = FlingAnimation(view, DynamicAnimation.SCROLL_X).apply {
            setStartVelocity(0f)
            setMinValue(0f)
            setMaxValue(2000f)
            friction = 1.1f
            start()
        }
        override fun onShowPress(e: MotionEvent?) {
      //do nothing
        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            //do nothing
            Log.d("swipe","onsingletapup")
            return true
        }

        override fun onDown(e: MotionEvent?): Boolean {
            //do nothing
            Log.d("swipe","onFDown")
            fling.start()
            return true
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            //do nothing
            Log.d("swipe","onScroll")
            return true

        }

        override fun onLongPress(e: MotionEvent?) {
            //do nothing
            Log.d("swipe","longPress")

        }

            override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

                Log.d("swipe","onFling")
                val SWIPE_DISTANCE_THRESHOLD = 10
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


    }


