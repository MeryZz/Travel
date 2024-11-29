package com.example.travel

import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Conecta con el archivo XML "activity_main"

        // Encuentra las vistas
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val imageSwitcher: ImageSwitcher = findViewById(R.id.imageSwitcher)

        // Lista de imágenes
        val images = listOf(
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9
        )

        // Configura el ImageSwitcher
        imageSwitcher.setFactory {
            ImageView(this).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
                layoutParams = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
            }
        }

        // Configura el RecyclerView con un adaptador
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = ImageAdapter(images) { selectedImage ->
            imageSwitcher.setImageResource(selectedImage)
        }
        recyclerView.adapter = adapter
    }
}