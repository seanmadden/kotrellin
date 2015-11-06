import com.beust.klaxon.JsonObject
import com.beust.klaxon.string
import com.beust.klaxon.Parser
import com.beust.klaxon.json
import khttp.get

fun main(args: Array<String>) {
    val config = loadConfig("keys.json") as JsonObject
    val key = config.string("key")
    val token = config.string("token")
    val trello : Trello

    trello = if (key != null && token != null) {
        Trello(key, token)
    } else {
        return
    }

    trello.boards()


}

class Trello(key: String, token: String) {
    private val url = "https://api.trello.com"
    private val key = key
    private val token = token

    public fun boards() {
        val response = get("$url/1/members/me/boards?key=$key&token=$token")
        println(response.jsonArray)
    }

}

fun loadConfig(fileName: String) : Any {
    return Parser().parse(fileName) ?: json {}
}

