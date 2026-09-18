package com.example.soal_2_gavin

open class Character(
    var name: String,
    var maxHp: Int
) {
    var hp: Int = maxHp

    fun isDead(): Boolean {
        return hp <= 0
    }

    fun takeDamage(damage: Int) {
        hp -= damage
        if (hp < 0) {
            hp = 0
        }
    }

    fun heal(heal: Int) {
        hp += heal
        if (hp > maxHp) {
            hp = maxHp
        }
    }

    fun printChara() {
        println(name)
        println("HP: $hp/ $maxHp")
    }
}
