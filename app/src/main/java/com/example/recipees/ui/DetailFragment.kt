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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.example.recipees.R
import com.example.recipees.databinding.FragmentDetailBinding
import com.example.recipees.databinding.FragmentHomeBinding
import com.example.recipees.model.Meal
import com.example.recipees.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailFragment : Fragment() {
    private  var _binding: FragmentDetailBinding?=null
    private val binding get()= _binding!!
    private val mealsViewModel : MealsViewModel by viewModels()
    private val args : DetailFragmentArgs by navArgs()
    private lateinit var meal: Meal
    private lateinit var navControler: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navControler = findNavController()
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
        binding.back.setOnClickListener {
            val action = DetailFragmentDirections.actionDetailFragmentToHomeFragment()
            navControler.navigate(action)

        }
        meal = args.meal
        lifecycleScope.launch {
            val resultImage =  getBitmap(meal.strMealThumb)
            binding.urlImage.setImageBitmap(resultImage)
            binding.instructions.text = args.mealId.toString()
            mealsViewModel.getSpecificItem(args.mealId)

            mealsViewModel.specificItem.collect{
                if(it != null){
                    for(i in it.meals){
                        binding.strMeal.text = i.strMeal
                        var ingredients = " ${i.strIngredient1} ${i.strMeasure1}\n" +
                                " ${i.strIngredient2}\t ${i.strMeasure2}\n" +
                                "${i.strIngredient3} \t${i.strMeasure3}\n" +
                                "${i.strIngredient4} \t${i.strMeasure4}\n" +
                                "${i.strIngredient5} \t${i.strMeasure5}\n" +
                                " ${i.strIngredient6} \t ${i.strMeasure6}\n " +
                                "${i.strIngredient7}  \t ${i.strMeasure7}\n" +
                                "${i.strIngredient8}  \t ${i.strMeasure8}\n" +
                                " ${i.strIngredient9} \t  ${i.strMeasure9}\n" +
                                " ${i.strIngredient10} \t  ${i.strMeasure10}\n " +
                                "${i.strIngredient11} \t  ${i.strMeasure11}\n"  +
                                "${i.strIngredient12} \t  ${i.strMeasure12}\n " +
                                "${i.strIngredient13}  \t ${i.strMeasure13}\n" +
                                "${i.strIngredient14}  \t ${i.strMeasure14}\n" +
                                " ${i.strIngredient15} \t  ${i.strMeasure15}\n"+
                            "${i.strIngredient16}  \t ${i.strMeasure16}\n" +
                                " ${i.strIngredient17}  \t ${i.strMeasure17}\n " +
                                " ${i.strIngredient18}  \t  ${i.strMeasure18}\n" +
                                "${i.strIngredient19}  \t  ${i.strMeasure19}\n"+
                                "${i.strIngredient20} \t  ${i.strMeasure20}\n"
                        binding.ingredients.text = ingredients
                        binding.instructions.text = i.strInstructions
                    }
                }
            }
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