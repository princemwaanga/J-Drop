package com.example.myapp.ui.home

import androidx.lifecycle.ViewModel

class CartViewModel : ViewModel() {
    val cartItems = CartRepository.cartItems
    val totalPrice get() = CartRepository.getTotalPrice()

    fun removeItem(item: CartItem){
        CartRepository.removeFromCart(item)
    }
    fun addItem(item: CartItem){
        CartRepository.addToCart(item)
    }
}