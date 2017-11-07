package io.kaeawc.customitemanimator

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

class WidgetAdapter(private val widgets: MutableList<Widget> = mutableListOf()) : RecyclerView.Adapter<WidgetViewHolder>() {

    override fun getItemCount(): Int = widgets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder =
            WidgetViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.widget_item, parent, false))

    override fun onBindViewHolder(holder: WidgetViewHolder?, position: Int) {
        if (position < 0 || position >= widgets.size) return
        val widget = widgets[position]
        when (holder) {
            is WidgetViewHolder -> {
                holder.bind(widget, this)
            }
        }
    }

    fun addWidget(widget: Widget) {
        widgets.add(0, widget)
        notifyItemInserted(0)
    }

    fun removeWidget(widget: Widget) {
        val position = widgets.indexOf(widget)
        widgets.removeAt(position)
        notifyItemRemoved(position)
    }
}
