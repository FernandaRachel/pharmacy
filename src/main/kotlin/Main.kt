package org.com

import org.springframework.boot.autoconfigure.SpringBootApplication
import java.util.*

@SpringBootApplication
open class MainApplication

fun main() {
    val elements = Stack<Int>()

    elements.add(1)
    elements.add(2)
    elements.add(3)

    println(elements.pop())
    println(elements.peek())

//    val name = "Kotlin"
//    println("Hello, " + name + "!")
//
//    for (i in 1..5) {
//        println("i = $i")
//    }
}