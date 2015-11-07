public data class TrelloList(
        val id: String,
        var name: String,
        var closed: Boolean?,
        val idBoard: String,
        var pos: Int,
        var subscribed: Boolean
)

public data class CardMetadata(
        val id: String,
        var name: String
)