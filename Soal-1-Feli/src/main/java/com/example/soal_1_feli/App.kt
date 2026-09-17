package com.example.soal_1_feli

class App {
    var ListMenu = ArrayList<Menu>()
    var ListOrder = ArrayList<Order>()

    init{
        ListMenu.add(Menu("Nasi Goreng", "Nasi goreng spesial", 25000.00))
        ListMenu.add(Menu("Mie Ayam", "Mie ayam dengan bakso", 20000.0))
        ListMenu.add(Menu("Es Teh", "Es teh manis", 5000.0))
    }

    fun startMenu(){
        var running = true
        while (running == true){
            println("")
            println("===== ORDER SYSTEM =====")
            println("1. Make Order")
            println("2. View Orders")
            println("3. View Menu")
            println("4. Add Menu")
            println("5. Edit Menu")
            println("6. Delete Menu")
            println("7. Exit")
            print("Pilih menu: ")


        }
    }
}