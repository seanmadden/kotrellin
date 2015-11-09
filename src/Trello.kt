import com.google.gson.Gson
import com.github.salomonbrys.kotson.*
import khttp.get
import khttp.responses.Response

/**
 * Kotrellin - A Kotlin Trello library.
 *
 * My Idea is this:
 *
 * Trello.get(card: Card) : Card        - To get an entity, pass an entity to the get method. Trello will fetch the
 *                                        card from the server that matches the ID on the original card.
 *
 * Trello.post(card: Card) : Card       - To create a new card, pass a card object. An exception will be thrown if the
 *                                        http request fails. Returns the created card.
 *
 * Trello.put(card: Card) : Card        - Returns the updated card.
 *
 * Trello.delete(card: Card)            - TODO: Figure out what to do for return type
 *
 */
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
