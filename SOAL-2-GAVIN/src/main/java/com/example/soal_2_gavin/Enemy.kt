package com.example.soal_2_gavin

class Enemy(var type: String) : Character(type + "mon", 50) {

    var damage = 10

    fun printEnemy() {
        println(name)
        println("HP: $hp/ $maxHp")
        println("Type: $type")
        println("--------------------------")
    }
}
