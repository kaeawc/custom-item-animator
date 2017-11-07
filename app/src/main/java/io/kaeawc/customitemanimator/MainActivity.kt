package io.kaeawc.customitemanimator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter: WidgetAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view?.layoutManager = LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        adapter = WidgetAdapter()
        recycler_view?.adapter = adapter
        recycler_view?.itemAnimator = CustomItemAnimator()

        add_widget_button?.setOnClickListener {
            adapter?.addWidget(Widget((Math.random() * 1000).toString()))
        }
    }
}
