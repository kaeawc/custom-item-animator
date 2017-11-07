package io.kaeawc.customitemanimator

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import java.lang.ref.WeakReference

class WidgetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val widgetName: TextView? = itemView.findViewById(R.id.widget_name)
    private var weakAdapter: WeakReference<WidgetAdapter>? = null

    fun bind(widget: Widget, adapter: WidgetAdapter) {
        weakAdapter = WeakReference(adapter)

        widgetName?.text = widget.name
        widgetName?.setOnClickListener {
            weakAdapter?.get()?.removeWidget(widget)
        }
    }
}
