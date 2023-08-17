package com.example.recipees.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipees.adapter.MainAdapter
import com.example.recipees.adapter.SupAdapter
import com.example.recipees.databinding.FragmentHomeBinding
import com.example.recipees.model.NameCat
import com.example.recipees.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding?=null
    private val binding get()= _binding!!
    private val mealsViewModel :MealsViewModel by viewModels()
    val supAdapter = SupAdapter()
    val mainAdapter = MainAdapter()
     var queryName:String = "Dessert"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    @SuppressLint("NotifyDataSetChanged", "SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            lifecycleScope.launch {
                mealsViewModel.getFirstMeal()
                mealsViewModel.firstMeal.collect {
                    if (it != null) {
                        mainAdapter.setArray(it.categories)
                        binding.mainRecy.adapter = mainAdapter
                        binding.mainRecy.layoutManager =
                            LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
//                            local database
                        for (data in it.categories) {
                            mealsViewModel.insertData(data)
                        }
//                            mealsViewModel.insertData(it)
                        Toast.makeText(activity, "room database inserted", Toast.LENGTH_LONG).show()
                    }
                }

        }

        fillData(queryName , queryName)

        binding.searchBar.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
              if(query != null){
                  fillData(query , query)
              }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {

                return true
            }

        })

    }

    private fun fillData(queryName:String , categoryName:String){
        mealsViewModel.getMealFilter(queryName)
        lifecycleScope.launch {
            mealsViewModel.filterMeal.collect{
                if (it != null) {
                    binding.catName.setText("$queryName Category")
                    supAdapter.setData(it.meals)
                    binding.firstMeal.adapter = supAdapter
                    binding.firstMeal.layoutManager =
                        LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                    for(meal in it.meals){
                        mealsViewModel.insertMealFilterINRoom(meal , NameCat(categoryName))
                    }
                }
            }
        }
    }
}
