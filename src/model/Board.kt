public class Board(
       id: String = "",
       name: String = "",
       lists: List<TrelloList> = listOf()){

    private var id: String
    private var name: String
    private var lists: List<TrelloList>

    init {
        this.id = id
        this.name = name
        this.lists = lists
    }

    fun addList(list: List<TrelloList>) {
        lists += list
    }

}

public data class ListMetadata(
        val id: String = "",
        var name: String = ""
)
