package com.example.mobilebrowser

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class WebsiteAdapter(private val context: Context, private val websites: List<Website>) : BaseAdapter() {
    override fun getCount(): Int = websites.size

    override fun getItem(position: Int): Any = websites[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val textView = view.findViewById<TextView>(R.id.textView)

        val website = websites[position]

        imageView.setImageResource(website.imageResId)
        textView.text = website.name

        return view
    }
}
