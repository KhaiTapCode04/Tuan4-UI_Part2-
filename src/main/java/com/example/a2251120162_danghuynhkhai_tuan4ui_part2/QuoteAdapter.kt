package com.example.a2251120162_danghuynhkhai_tuan4ui_part2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class QuoteAdapter(context: Context, private val quotes: List<String>) :
    ArrayAdapter<String>(context, R.layout.item_quote, quotes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_quote, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        // Định dạng số thứ tự (01, 02, ..., 1.000.000)
        val formattedPosition = String.format("%02d", position + 1)
        val displayText = "$formattedPosition ] ${quotes[position]}"
        viewHolder.quoteText.text = displayText

        return view
    }

    private class ViewHolder(view: View) {
        val quoteText: TextView = view.findViewById(R.id.quoteText)
    }
}