package com.example.recipees.ui

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.recipees.R
import com.example.recipees.databinding.FragmentSplashBinding
import com.example.recipees.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SplashFragment : Fragment()//, EasyPermissions
{
    private  var _binding: FragmentSplashBinding?=null
    private val mealsViewModel : MealsViewModel by viewModels()
    private val binding get()= _binding!!
    private lateinit var navControler: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControler = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.splashBtn.setOnClickListener {
            binding.splashBtn.visibility = View.INVISIBLE
            binding.progress.visibility = View.VISIBLE
            mealsViewModel.getFirstMeal()
            lifecycleScope.launch {
                try{
                    mealsViewModel.firstMeal.collect {
                        if (it != null) {
                            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                            navControler.navigate(action)
                        }
                    }
                }catch (e:Exception){
                    Toast.makeText(activity , e.message.toString() , Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}