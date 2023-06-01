package com.example.recipees.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recipees.adapter.MainAdapter
import com.example.recipees.databinding.ActivitySplashBinding
import com.example.recipees.entities.Category
import com.example.recipees.network.RecipiesApiServices
import com.example.recipees.retrofit.RecipesRetrofit
import retrofit2.Call
import retrofit2.Response

class SplashActivity : AppCompatActivity() {
   private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.splashBtn.setOnClickListener{
            val intent = Intent(this@SplashActivity , HomeActivity::class.java )
            startActivity(intent)
            finish()
        }
    }




}