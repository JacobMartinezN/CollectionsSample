package pe.edu.upc.gdsg.colletionssample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import pe.edu.upc.gdsg.colletionssample.adapters.ItemsAdapter
import pe.edu.upc.gdsg.colletionssample.models.Item

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        itemsRecyclerView.layoutManager = GridLayoutManager(this,1)

        var items = listOf<Item>(   Item(1, "Sample 1", "https://cdn-images-1.medium.com/max/1200/1*Y0UYuGcFGSCfs5Eexafq6A.png"),
                                    Item(2, "Sample 2", "https://dl1.cbsistatic.com/i/r/2017/05/18/4008a654-efcc-476b-8b8c-e2989a845d5d/resize/696xauto/25c899d26c657e0d8f0d4deaf37e55ea/devtoolspromo.jpg"))

        itemsRecyclerView.adapter = ItemsAdapter(items) { Toast.makeText(this, "${it.title} Selected" , Toast.LENGTH_LONG).show()}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
