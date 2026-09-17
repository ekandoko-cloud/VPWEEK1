package com.example.soal_1_feli

class Order(
    var namaCust: String
) {
    var pesanan = ArrayList<ItemOrder>()

    fun addItem(namaMenu: String, harga: Int, quantity: Int){
        pesanan.add(ItemOrder(namaMenu, harga, quantity))
    }

    fun getTotal(): Int{
        var total = 0
        for(item in pesanan){
            total += item.getSubtotal()
        }
        return total;
    }

    fun print(){
        println("--- $namaCust's Order ---")
        var count = 1
        for(item in pesanan){
            println("$count. ${item.Namamenu} x${item.quantity}   $${item.price}")
            count++
        }
        println("-------------------------")
        println("TOTAL      $${getTotal()}")
    }
}