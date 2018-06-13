package pe.edu.upc.gdsg.colletionssample.adapters


import android.net.Uri
import android.support.annotation.LayoutRes
import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.item_view.view.*
import pe.edu.upc.gdsg.colletionssample.R
import pe.edu.upc.gdsg.colletionssample.models.Item

//extender funcionalidad de elementos
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View{
    return LayoutInflater.from(context).inflate(layoutRes,  this,attachToRoot)
}

fun ImageView.loadUrl(url: String){
    Picasso.get().load(Uri.parse(url)).into(this)
    Log.d("Sample" , Uri.parse(url).toString())
}
class ItemsAdapter(val items: List<Item>, val listener: (Item) -> Unit): RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {



    override fun getItemCount() = items.size

    //retorna un obejeto de la clase ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_view ))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            itemTitle.text = item.title
            //itemImage.loadUrl(item.url)
            Log.d("Sample", item.url)
            setOnClickListener { (listener(item)) }
        }

    }
}