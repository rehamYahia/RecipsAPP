package com.example.recipees.activities


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipees.adapter.MainAdapter
import com.example.recipees.databinding.ActivityHomeBinding
import com.example.recipees.entities.Category
import com.example.recipees.network.RecipiesApiServices
import com.example.recipees.retrofit.RecipesRetrofit
import retrofit2.Call
import retrofit2.Response


class HomeActivity  : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    //lateinit var mainArrayList :ArrayList<Recipie>
    lateinit var mainAdapter :MainAdapter
    lateinit var recipesRetrofit:RecipesRetrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        recipesRetrofit = RecipesRetrofit()

        getRecipies()



    }

    fun getRecipies()
    {
        val servise = recipesRetrofit.getRetrofit()?.create(RecipiesApiServices::class.java)
        val call = servise?.getAllRecipies()
        call?.enqueue(object:retrofit2.Callback<List<Category>>{
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                mainAdapter.setData(response.body())
               // mainAdapter.notifyDataSetChanged()
                //insertDataIntoRoomDB(response.body())
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Toast.makeText(this@HomeActivity , " wont an error in network" , Toast.LENGTH_LONG).show()
            }

        })
        binding.mainRecycle.adapter = mainAdapter
        binding.mainRecycle.layoutManager = LinearLayoutManager(this@HomeActivity , LinearLayoutManager.HORIZONTAL , false)



    }







}