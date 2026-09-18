package com.example.soal_2_gavin

class Wizard(name: String) : Character(name, 100) {

    var maxMana = 30
    var mana = 30
    var hpPotions = 5
    var manaPotions = 5
    var kills = 0
    var killsNeeded = 5
    var isStrong = false
    var lifesteal = 0

    fun drinkHealthPotion() {
        if (hpPotions <= 0) {
            println("Out of Health potion!")
        } else {
            hpPotions -= 1
            heal(25)
            println("$name drinked a health potion. HP now: $hp/$maxHp")
        }
    }

    fun drinkManaPotion() {
        if (manaPotions <= 0) {
            println("Out of Mana potion!")
        } else {
            manaPotions -= 1
            mana += 15
            if (mana > maxMana) {
                mana = maxMana
            }
            println("$name drinked a mana potion. Mana now: $mana/$maxMana")
        }
    }

    fun attack(type: String, enemy: Enemy) {
        if (mana < 10) {
            println("Insufficient mana!")
            return
        }

        mana -= 10
        var damage = 10

        if (type == "Fire" && enemy.type == "Grass") {
            damage *= 2
        } else if (type == "Water" && enemy.type == "Fire") {
            damage *= 2
        } else if (type == "Grass" && enemy.type == "Water") {
            damage *= 2
        }

        if (isStrong) {
            damage = (damage * 1.5).toInt()
        }

        enemy.takeDamage(damage)
        println("$name attacked with a $type attack dealing $damage damage!")

        if (isStrong && lifesteal > 0) {
            heal(lifesteal)
            println("$name absorb $lifesteal HP from lifesteal.")
        }
    }

    fun registerKill() {
        kills += 1
        if (isStrong) {
            lifesteal += 1
        } else if (kills >= killsNeeded) {
            evolve()
        }
    }

    fun evolve() {
        isStrong = true
        maxHp = (maxHp * 1.5).toInt()
        maxMana = (maxMana * 1.5).toInt()
        hp = maxHp
        mana = maxMana
        lifesteal = 1
        println("")
        println("$name evolved into a Strong Wizard!")
        println("")
    }

    fun resetAfterDeath() {
        hp = maxHp
        mana = maxMana
    }

    fun printWizard() {
        println("----- $name's STATS -----")
        println("HP: $hp/ $maxHp")
        println("Mana: $mana/ $maxMana")
        if (isStrong) {
            println("Kills needed to evolve: MAX (Strong Wizard)")
            println("Lifesteal: $lifesteal")
        } else {
            println("Kills needed to evolve: $kills/ $killsNeeded")
        }
        println("Mana Potions held: $manaPotions")
        println("Health Potions held: $hpPotions")
        println("--------------------------")
    }
}
