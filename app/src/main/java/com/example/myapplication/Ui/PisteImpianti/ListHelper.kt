package com.example.myapplication.Ui.PisteImpianti

import android.widget.ListAdapter
import android.widget.ListView

object ListHelper {
    fun getListViewSize(listView: ListView) {
        val listAdapter: ListAdapter = listView.adapter
            ?: return

        var totalHeight = 0
        for (size in 0 until listAdapter.count) {
            val listItem = listAdapter.getView(size, null, listView)
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }

        val params = listView.layoutParams
        params.height = totalHeight + listView.dividerHeight + (listAdapter.count - 1)
        listView.layoutParams = params
    }

}
