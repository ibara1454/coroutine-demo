import com.github.kittinunf.fuel.*
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import kotlinx.coroutines.*

suspend fun String.get(): String {
    val (req, res, result) = httpGet().awaitStringResponseResult()
    result.fold<Nothing>(
        { data -> return data },
        { error -> throw error }
    )
}

fun main(): Unit = runBlocking {
    val urls = (1..10).map("http://localhost/hello"::plus)
    try {
        val results = urls.map { s -> async { s.get() } }.awaitAll()
        println("results = $results")
    } catch (e: Exception) {
        println("An error occurred.")
    }
}