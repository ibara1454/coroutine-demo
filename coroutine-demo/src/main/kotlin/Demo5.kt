import com.github.kittinunf.fuel.*
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import kotlinx.coroutines.*

fun main() = runBlocking {
    val (req, res, result) = "http://localhost/hello".httpGet().awaitStringResponseResult()
    result.fold(
        { data -> println(data) },
        { error -> println("An error occurred. Message: ${error.message}") }
    )
}