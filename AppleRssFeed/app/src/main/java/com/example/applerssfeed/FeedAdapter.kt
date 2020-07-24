package com.example.applerssfeed

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.applerssfeed.Model.FeedEntry



class ViewHolder(v:View){
    val tvName = v.findViewById<TextView>(R.id.tvName)
    val tvArtist = v.findViewById<TextView>(R.id.tvArtist)
    val imageView = v.findViewById<ImageView>(R.id.imageView)
}

class FeedAdapter(context: Context, private val resource :Int, private val collection:List<FeedEntry>):ArrayAdapter<FeedEntry>(context,resource,collection) {
    private val TAG = "FeedAdapter"
    //inflate the xml resource to create the view
    //we will be saving the view in inflator rather than fetching it again and again


    private val inflator = LayoutInflater.from(context)
    override fun getCount(): Int {

        return collection.size

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder:ViewHolder
// if view is already present and saved to view holder , we will reuse it instea of inflationa new one eveytime.
        if(convertView == null){
            view = inflator.inflate(resource,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

//         lets use viewholder pattern to save the view instead of finding it again and again .
//        val tvName = view.findViewById<TextView>(R.id.tvName)
//        val tvArtist = view.findViewById<TextView>(R.id.tvArtist)
//        val Image = view.findViewById<ImageView>(R.id.imageView)

        val currentApp = collection[position]

        viewHolder.tvName.text = currentApp.name
        viewHolder.tvArtist.text = currentApp.artist
        Glide
            .with(context)
            .load(currentApp.imageURL)
            .into(viewHolder.imageView)


        return  view
    }
}