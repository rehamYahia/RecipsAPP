package com.example.recipees.ui


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
import com.example.recipees.databinding.FragmentSplashBinding
import com.example.recipees.viewmodel.MealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



@AndroidEntryPoint
 class SplashFragment : Fragment() //, EasyPermissions.RationaleCallbacks , EasyPermissions.PermissionCallbacks
{
    private  var _binding: FragmentSplashBinding?=null
    private val mealsViewModel : MealsViewModel by viewModels()
    private val binding get()= _binding!!
    private lateinit var navControler: NavController

//    private var READ_STORAGE_PERM = 123
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
        //readStorageTask()

        binding.splashBtn.setOnClickListener {
            binding.splashBtn.visibility = View.INVISIBLE
            binding.progress.visibility = View.VISIBLE

            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
            navControler.navigate(action)
//            mealsViewModel.getFirstMeal()
//            lifecycleScope.launch {
//                try{
//                    mealsViewModel.firstMeal.collect {
//                        if (it != null) {
//                            val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
//                            navControler.navigate(action)
//                        }
//                    }
//                }catch (e:Exception){
//                    Toast.makeText(activity , e.message.toString() , Toast.LENGTH_LONG).show()
//                }
//
//            }
        }
    }

//    private fun hasReadStoragePermission():Boolean{
//        return EasyPermissions.hasPermissions(this.requireActivity().applicationContext  , android.Manifest.permission.READ_EXTERNAL_STORAGE)
//    }
//
//    private fun readStorageTask(){
//        if(hasReadStoragePermission()){
//            getDataFromRemote()
//        }else{
//            EasyPermissions.requestPermissions(
//                this.requireActivity().applicationContext as Activity,
//                "This app needs access to your storage",
//                READ_STORAGE_PERM,
//                android.Manifest.permission.READ_EXTERNAL_STORAGE)
//        }
//    }
//
//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        EasyPermissions.onRequestPermissionsResult(requestCode , permissions , grantResults , this)
//    }
//
//    override fun onRationaleAccepted(requestCode: Int) {
//
//    }
//
//    override fun onRationaleDenied(requestCode: Int) {
//
//    }
//
//    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
//
//    }
//
//    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
//        if(EasyPermissions.somePermissionPermanentlyDenied(this , perms)){
//            AppSettingsDialog.Builder(this).build().show()
//        }
//    }
}