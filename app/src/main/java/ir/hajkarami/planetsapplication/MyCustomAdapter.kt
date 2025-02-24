package ir.hajkarami.planetsapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCustomAdapter(context: Context, private val planetsList: ArrayList<Planets>) :
    ArrayAdapter<Planets>(context, R.layout.planets_item, planetsList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val viewHolder : MyViewHolder
        val view : View

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.planets_item,parent,false)
            viewHolder = MyViewHolder(view)
            view.tag = viewHolder
        }
        else{
            view = convertView
            viewHolder = convertView.tag as MyViewHolder
        }

        val planets : Planets = getItem(position)!!

        planets.let {
            viewHolder.planetName.text = it.planetsName
            viewHolder.planetImg.setImageResource(it.planetsImage)
            viewHolder.planetsCount.text = it.planetsCount
        }

        return view
    }
    private class MyViewHolder(view: View) {
        val planetName: TextView = view.findViewById(R.id.planet_title)
        val planetsCount: TextView = view.findViewById(R.id.planets_moon)
        val planetImg: ImageView = view.findViewById(R.id.planet_imageView)
    }
}

