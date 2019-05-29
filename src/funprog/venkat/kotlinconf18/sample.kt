package funprog.venkat.kotlinconf18

import kotlinx.coroutines.experimental.*

/**
 * @author Akash Patra
 */
suspend fun process(n: Int): Int {
    delay(1000L)
    println("process:")
    return n
}

fun main(args: Array<String>) = runBlocking {
    launch {
        println(process(2))
    }
    println(Thread.currentThread())
}


