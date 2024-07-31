package com.muhasib.recyclerview

import MyAdapter
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import news

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView: RecyclerView

    lateinit var newsArray: ArrayList<news>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        myRecyclerView=findViewById(R.id.recyclerView)


        val newsArrayHealine = arrayOf(
            "Record heatwave sweeps Europe, raising wildfire concerns and emergency responses.",
            "New AI technology revolutionizes healthcare with faster and accurate diagnostics.",
            "Global markets surge as investors gain confidence in economic recovery.",
            "World leaders convene at the climate summit, stressing the urgency of immediate action.",
            "Breakthrough in cancer research unveils a promising new treatment, offering renewed hope.",
            "Tech giant introduces a groundbreaking foldable smartphone, setting a new industry standard.",
            "Historic peace agreement signed between long-standing rivals, marking a significant milestone."
        )
        val newsContent= arrayOf(
            getString(R.string.news1),
            getString(R.string.actualnews),
            getString(R.string.news2),
            getString(R.string.actualnews),
            getString(R.string.actualnews),
            getString(R.string.news3),
            getString(R.string.actualnews),


        )

        val newsArrayImage= arrayOf(

            R.drawable.user1,
            R.drawable.user2,
            R.drawable.user3,
            R.drawable.user4,
            R.drawable.user5,
            R.drawable.user6,
            R.drawable.user7,



        )
        myRecyclerView.layoutManager=LinearLayoutManager(this)
        newsArray = arrayListOf()

        for(index in newsArrayImage.indices){

            var News =news(newsArrayHealine[index], newsArrayImage[index], newsContent[index])

            newsArray.add(News)
        }


val myadapter= MyAdapter(newsArray, this)
        myRecyclerView.adapter= myadapter

        myadapter.setItemClickListener(object : MyAdapter.onItemClickListerner{
            override fun onItemClicking(position: Int) {


                var intent= Intent(applicationContext, NewsDetailActivity::class.java)

                intent.putExtra("Heading", newsArray[position].headline)
                intent.putExtra("ImageId", newsArray[position].image)
                intent.putExtra("Content",newsArray[position].newsContent)
                startActivity(intent)
            }


        })
    }
}