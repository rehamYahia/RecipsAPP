package com.example.recipees.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.recipees.R
import com.example.recipees.databinding.FragmentDetailBinding
import com.example.recipees.databinding.FragmentHomeBinding
import com.example.recipees.model.Meal
import com.example.recipees.viewmodel.MealsViewModel
import kotlinx.coroutines.launch


class DetailFragment : Fragment() {
    private  var _binding: FragmentDetailBinding?=null
    private val binding get()= _binding!!
    private val mealsViewModel : MealsViewModel by viewModels()
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var meal: Meal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        meal = args.meal
        lifecycleScope.launch {
            val resultImage =  getBitmap(meal.strMealThumb)
            binding.urlImage.setImageBitmap(resultImage)
        }



    }

    private suspend fun getBitmap(imageUrl :String): Bitmap {
        val loading = activity?.let { ImageLoader(it) }
        val request = activity?.let {
            ImageRequest.Builder(it)
                .data(imageUrl)
                .build()
        }
        val result = (request?.let { loading?.execute(it) } as SuccessResult).drawable
        return (result as BitmapDrawable).bitmap
    }



}