public data class TrelloList(
        val id: String,
        var name: String,
        var closed: Boolean?,
        val idBoard: String,
        var pos: Int,
        var subscribed: Boolean
)
