import khttp.get
import com.google.gson.Gson
import com.github.salomonbrys.kotson.*
import khttp.responses.Response
import java.io.File
import java.security.InvalidParameterException

fun main(args: Array<String>) {
    val config = loadConfig("keys.json") ?: return
    val trello = Trello(config.key, config.token)

    val boards = trello.getMemberBoards("me")

    val choreBoardMetadata = boards?.single { it.name == "Chores" }
    val choreBoardId = choreBoardMetadata?.id ?: throw InvalidParameterException("No Board found")

    val choreLists = trello.getListsOnBoard(choreBoardId)
    val firstChoreListId = choreLists?.get(1)?.id ?: return;
    val choreCardsOnFirstList = trello.getCardsOnList(firstChoreListId)
    var chores = choreCardsOnFirstList?.filter { it.name.toLowerCase() != "schedule" }
    val choreList = chores?.map { it.name }
    println(choreList)


}

class Trello(key: String, token: String) {
    private val apiVersion = "1"
    private val apiUrl = "https://api.trello.com/$apiVersion"
    private val key = key
    private val token = token
    private val gson = Gson()

    private fun makeRequest(verb: String, url: String) : Response {
        //TODO: Move response code handling here
        return get("$apiUrl$url", params = mapOf(
                "key" to key,
                "token" to token
        ))
    }

    public fun getMemberBoards(memberIdOrName: String) : List<Boards>? {
        val url = "/members/$memberIdOrName/boards"
        val response = makeRequest("get", url)

        return gson.fromJson<List<Boards>>(response.text)
    }

    public fun getBoard(id: String) : Boards? {
        val response = makeRequest("get", "/boards/$id")

        return gson.fromJson<Boards>(response.text)
    }

    public fun getListsOnBoard(boardId: String) : List<TrelloList>? {
        val response = makeRequest("get", "/boards/$boardId/lists")

        if (response.statusCode == 200)
            return gson.fromJson<List<TrelloList>>(response.text)
        else
            throw Exception("request failed!")

    }

    public fun getCardsOnList(listId: String) : List<Card>? {
        val response = makeRequest("get", "/lists/$listId/cards")

        if (response.statusCode == 200)
            return gson.fromJson<List<Card>>(response.text)
        else
            throw Exception("request failed!")
    }

    public fun getCard(cardId: String) : Card? {
        val response = makeRequest("get", "/cards/$cardId/")

        if (response.statusCode == 200)
            return gson.fromJson<Card>(response.text)
        else
            throw Exception("request failed!")
    }

}

fun loadConfig(fileName: String) : Configuration? {
    val config = Gson().fromJson<Configuration>(File(fileName).readText())

    return config
}

