package com.example.myapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapp.R
import com.example.myapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), ProductClickListener {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val productViewModel : ProductViewModel by viewModels()
    private val cartViewModel : CartViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by viewModels()
    private lateinit var productAdapter : ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_cart)
            //findNavController().navigate(R.id.action_navigation_home_to_navigation_productDetailFragment)
        }
        binding.rvproducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvproducts.adapter = ProductAdapter(layoutInflater,productViewModel.productList, this)
//            object : ProductAdapter.ItemListener{
//            override fun onItemClicked(index: Int) {
//                //sharedViewModel.position = index
//                sharedViewModel.selectedProduct(productViewModel.productList[index])
//                findNavController().navigate(R.id.action_navigation_home_to_navigation_productDetailFragment)
//            }
//
//            override fun onItemLongClick(index: Int) {
//                TODO("Not yet implemented")
//            }
//        }){ product ->
//            cartViewModel.addItem(CartItem(product, 1))
//        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onProductClicked(product: Product) {
        //sharedViewModel.selectedProduct(product)
        val bundle = bundleOf("num" to product.id, "name" to product.name, "description" to product.description, "price" to product.price.toString(), "imageUrl" to product.imageUrl, "imageResID" to product.imageResID)
        findNavController().navigate(R.id.action_navigation_home_to_navigation_productDetailFragment, bundle)
    }

    override fun onAddToCartClicked(product: Product) {
        cartViewModel.addItem(CartItem(product, 1))
    }
}