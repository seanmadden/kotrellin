public class Board {

    constructor(id: String = "", name: String = "", lists: List<ListMetadata> = listOf()) {
        this.id = id
        this.name = name
        this.lists = lists
    }

    private var id: String
    private var name: String
    private var lists: List<ListMetadata>

}

public data class ListMetadata(
        val id: String,
        var name: String
)
