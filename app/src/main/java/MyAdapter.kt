import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.muhasib.recyclerview.R

class MyAdapter(var newsArray : ArrayList<news>, var context : Activity):
RecyclerView.Adapter<MyAdapter.MyViewHolder>()


{

    private lateinit  var  myListener : onItemClickListerner

    interface onItemClickListerner{

        fun onItemClicking(position : Int)
    }

    fun setItemClickListener(listener : onItemClickListerner){
        myListener=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {

        val itemView= LayoutInflater.from(parent.context)
            .inflate(R.layout.each_row, parent, false)

        return MyViewHolder(itemView, myListener)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        var currentItem=newsArray[position]

        holder.hTitle.text=currentItem.headline
        holder.hImage.setImageResource(currentItem.image)

    }

    override fun getItemCount(): Int {
        return newsArray.size
    }
    class MyViewHolder(itemView : View, listener :onItemClickListerner) : RecyclerView.ViewHolder(itemView) {

        var hTitle=itemView.findViewById<TextView>(R.id.headline)
        var hImage=itemView.findViewById<ShapeableImageView>(R.id.newsImage)

        init {

            itemView.setOnClickListener{

                listener.onItemClicking(adapterPosition)

            }


        }

    }
}