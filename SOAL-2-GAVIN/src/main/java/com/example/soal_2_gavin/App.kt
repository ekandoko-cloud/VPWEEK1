package com.example.soal_2_gavin

import java.util.Scanner

class App {
    val scannerString = Scanner(System.`in`)
    val scannerInt = Scanner(System.`in`)

    fun startMenu() {
        print("What's your name? ")
        var name = scannerString.nextLine()

        while (name == "") {
            println("Name cant be empty. Try again:")
            name = scannerString.nextLine()
        }

        val wizard = Wizard(name)
        var running = true
        while (running) {
            println("")
            println("What're you going to do?")
            println("1. View Stats")
            println("2. Enter battle")
            println("3. Exit")
            print("Choice: ")

            var choice = 0
            try {
                choice = scannerInt.nextInt()
            } catch (e: Exception) {
                println("Invalid Input")
                scannerInt.nextLine()
                choice = -1
            }

            if (choice == 1) {
                statsMenu(wizard)
            } else if (choice == 2) {
                battle(wizard)
            } else if (choice == 3) {
                println("Thank you")
                running = false
                System.exit(0)
            } else if (choice != -1) {
                println("Invalid Input")
            }
        }
    }

    fun statsMenu(wizard: Wizard) {
        var running = true
        while (running) {
            wizard.printWizard()
            println("1. Drink Mana Potion")
            println("2. Drink Health Potion")
            println("3. Rename self")
            println("4. Back")
            print("Pilihan: ")

            var choice = 0
            try {
                choice = scannerInt.nextInt()
            } catch (e: Exception) {
                println("Invalid Input")
                scannerInt.nextLine()
                choice = -1
            }

            if (choice == 1) {
                wizard.drinkManaPotion()
            } else if (choice == 2) {
                wizard.drinkHealthPotion()
            } else if (choice == 3) {
                print("New name: ")
                val newName = scannerString.nextLine()
                if (newName != "") {
                    wizard.name = newName
                    println("Name successfully changed to $newName.")
                } else {
                    println("Nama cant be empty.")
                }
            } else if (choice == 4) {
                running = false
            } else if (choice != -1) {
                println("Invalid Input")
            }
        }
    }

    fun battle(wizard: Wizard) {
        val randomNumber = (1..3).random()
        var enemyType = "Fire"
        if (randomNumber == 2) {
            enemyType = "Water"
        } else if (randomNumber == 3) {
            enemyType = "Grass"
        }

        val enemy = Enemy(enemyType)
        println("")
        println("----- BATTLE -----")
        var inBattle = true
        while (inBattle) {
            printBattleStatus(wizard, enemy)
            println("1. Fire Attack")
            println("2. Water Attack")
            println("3. Grass Attack")
            println("4. Drink potion")
            println("5. Run")
            print("Pilihan: ")

            var choice = 0
            try {
                choice = scannerInt.nextInt()
            } catch (e: Exception) {
                println("Invalid Input")
                scannerInt.nextLine()
                choice = -1
            }

            if (choice == 1) {
                inBattle = playerTurn(wizard, "Fire", enemy)
            } else if (choice == 2) {
                inBattle = playerTurn(wizard, "Water", enemy)
            } else if (choice == 3) {
                inBattle = playerTurn(wizard, "Grass", enemy)
            } else if (choice == 4) {
                potionMenu(wizard)
            } else if (choice == 5) {
                println("${wizard.name} run from battle")
                inBattle = false
            } else if (choice != -1) {
                println("Invalid Input")
            }
        }
    }

    fun potionMenu(wizard: Wizard) {
        println("1. Health Potion")
        println("2. Mana Potion")
        print("Choose: ")

        var choice = 0
        try {
            choice = scannerInt.nextInt()
        } catch (e: Exception) {
            println("Invalid Input")
            scannerInt.nextLine()
            choice = -1
        }

        if (choice == 1) {
            wizard.drinkHealthPotion()
        } else if (choice == 2) {
            wizard.drinkManaPotion()
        } else if (choice != -1) {
            println("Invalid Input")
        }
    }

    fun playerTurn(wizard: Wizard, type: String, enemy: Enemy): Boolean {
        wizard.attack(type, enemy)
        if (enemy.isDead()) {
            println("${enemy.name} defeated!")
            wizard.registerKill()
            return false
        }

        wizard.takeDamage(enemy.damage)
        println("${enemy.name} attack doing ${enemy.damage} damage!")
        if (wizard.isDead()) {
            println("${wizard.name} lost in battle")
            wizard.resetAfterDeath()
            return false
        }
        return true
    }

    fun printBattleStatus(wizard: Wizard, enemy: Enemy) {
        println("")
        wizard.printWizard()
        enemy.printEnemy()
    }
}