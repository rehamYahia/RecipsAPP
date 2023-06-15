package com.example.recipees.ui

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipees.adapter.SupAdapter
import com.example.recipees.databinding.FragmentHomeBinding
import com.example.recipees.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : Fragment() {
    private  var _binding: FragmentHomeBinding?=null
    private val binding get()= _binding!!
    private val mealsViewModel :MealsViewModel by viewModels()

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

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val supAdapter = SupAdapter()
        //check to internet connection
        if(activity?.let { isOnline(it.applicationContext) } == true){
            mealsViewModel.getFirstMeal()
            lifecycleScope.launch{
                try {
                    mealsViewModel.firstMeal.collect{
                        if (it != null) {
                            supAdapter.setData(it.categories)
                            binding.firstMeal.adapter = supAdapter
                            binding.firstMeal.layoutManager = LinearLayoutManager(activity ,RecyclerView.HORIZONTAL ,false)
                            //local database
                            mealsViewModel.insertData()
                            Toast.makeText(activity , "inserted data to room" , Toast.LENGTH_LONG).show()
                        }

                    }
                }catch (e:Exception){
                    Toast.makeText(activity , e.message.toString() , Toast.LENGTH_LONG).show()
                    binding.error.text = e.message.toString()
                }

            }

        }else{
            mealsViewModel.getDataFromDatabase()
            lifecycleScope.launch {
                mealsViewModel.roomMeal?.collect{
                    if (it != null) {
                        supAdapter.setData(it)
                        binding.firstMeal.adapter = supAdapter
                        binding.firstMeal.layoutManager = LinearLayoutManager(activity ,RecyclerView.HORIZONTAL ,false)
                    }
                }
            }

            binding.error.text = "Internet is not available"
        }



    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
                    return true
                }
            }
        }
        return false
    }
}
