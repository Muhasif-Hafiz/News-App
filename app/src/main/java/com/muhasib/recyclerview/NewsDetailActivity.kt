package com.muhasib.recyclerview

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        var headline= intent.getStringExtra("Heading")
        var content= intent.getStringExtra("Content")
        var image=intent.getIntExtra("ImageId",R.drawable.news)


        val heading =findViewById<TextView>(R.id.newsHeadlineActivity)
        val newsContent= findViewById<TextView>(R.id.newsActualActivity)
        val newsImage=findViewById<ImageView>(R.id.newsImageActivity)

        heading.text=headline
        newsContent.text=content
        newsImage.setImageResource(image)

    }
}