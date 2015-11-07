
public data class Board(
    val id: String,
    var name: String,
    var lists: List<ListMetadata>
)

public data class ListMetadata(
        val id: String,
        var name: String
)
