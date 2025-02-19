package com.example.myapp.ui.home

import android.icu.text.Transliterator.Position
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.example.myapp.R

class SharedViewModel : ViewModel() {
    private val _selectedProduct = MutableLiveData<Product>()
    val selectedProduct: LiveData<Product> = _selectedProduct

    fun selectedProduct(product: Product){
        _selectedProduct.value = product
    }
}


