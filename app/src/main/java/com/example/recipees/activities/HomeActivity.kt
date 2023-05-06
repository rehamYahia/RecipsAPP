package com.example.recipees.activities

//import android.os.Bundle
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipees.adapter.MainAdapter
import com.example.recipees.adapter.SupAdapter
import com.example.recipees.databinding.ActivityHomeBinding
import com.example.recipees.entities.Category
import com.example.recipees.entities.Recipies
import com.example.recipees.network.RecipiesApiServices
import com.example.recipees.retrofit.RecipesRetrofit
import retrofit2.Call
import retrofit2.Response


class HomeActivity  : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    lateinit var mainArrayList :ArrayList<Recipies>
    lateinit var mainAdapter :MainAdapter
//   public var  subArrayList = ArrayList<Recipies>()
    var supAdapter = SupAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        getRecipies()

        setDataInMainRecyclerView()
//        setDataInSupRecyclerView()

        binding.mainRecycle.adapter = mainAdapter
        binding.mainRecycle.layoutManager = LinearLayoutManager(this@HomeActivity , LinearLayoutManager.HORIZONTAL , false)

        binding.subDataName.adapter = supAdapter
        binding.subDataName.layoutManager = LinearLayoutManager(this@HomeActivity , LinearLayoutManager.HORIZONTAL , false)


    }

    fun setDataInMainRecyclerView()
    {
        mainArrayList = ArrayList()
        mainArrayList.add(Recipies(1 , "fhhfhj"))
        mainArrayList.add(Recipies(2 , "bfefjefi"))
        mainArrayList.add(Recipies(3 , "dywdhwdj"))
        mainArrayList.add(Recipies(4 , "bdybdhjbd"))
        mainArrayList.add(Recipies(5 , "hbhwdbhwdb"))
        mainAdapter = MainAdapter(mainArrayList)

    }

//    fun setDataInSupRecyclerView()
//    {
////        subArrayList.add(Recipies(1 , "fhhfhj"))
////        subArrayList.add(Recipies(2 , "bfefjefi"))
////        subArrayList.add(Recipies(3 , "dywdhwdj"))
////        subArrayList.add(Recipies(4 , "bdybdhjbd"))
////        subArrayList.add(Recipies(5 , "hbhwdbhwdb"))
//        supAdapter.setArray(subArrayList)
//    }


    fun getRecipies()
    {
        val servise = RecipesRetrofit.RETROFIT_INSTANCE.create(RecipiesApiServices::class.java)
        val call = servise.getAllRecipies()
        call.enqueue(object:retrofit2.Callback<List<Category>>{
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                supAdapter.setArray(response.body())
                //insertDataIntoRoomDB(response.body())
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                Toast.makeText(this@HomeActivity , " wont an error in network" , Toast.LENGTH_LONG).show()
            }

        })
    }
}