package com.example.myapp.ui.home

interface ProductClickListener {
    fun onProductClicked(product: Product)
    fun onAddToCartClicked(product: Product)
}