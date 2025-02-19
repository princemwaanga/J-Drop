package com.example.myapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.R
import kotlinx.coroutines.launch

class ProductViewModel: ViewModel() {
    val productList = listOf(
        Product("101","Product 1","Products",10.0,"image " ,R.drawable.watch1),
        Product("102","Product 2","Products",10.0,"image " , R.drawable.tv),
        Product("103","Product 3","Products",10.0,"image " , R.drawable.bag),
        Product("104","Product 4","Products",10.0,"image " , R.drawable.orange),
        Product("105","Product 5","Products",10.0,"image " , R.drawable.phone),
        Product("106","Product 6","Products",10.0,"image " , R.drawable.laptop)

    )
}
