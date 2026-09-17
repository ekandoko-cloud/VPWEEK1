package com.example.soal_1_feli

class ItemOrder (
    var Namamenu: String,
    var price: Int,
    var quantity: Int){

    fun getSubtotal(): Int{
        return price * quantity
    }
}