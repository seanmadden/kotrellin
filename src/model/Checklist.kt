class Checklist(
    var id: String? = "",
    var name: String = "",
    var checkListItems: List<CheckListItem> = kotlin.emptyList(),
    var cards: List<CardMetadata> = kotlin.emptyList()
) {

    init {
        this.id = null
        this.name = name
        this.checkListItems = listOf()
        this.cards = listOf()
    }

    /**
     * Appends the given checklist item to the list
     *
     * @param item the item to add to the checklist
     */
    public fun addItem(item: CheckListItem) {
        checkListItems += item
    }

    public fun addAll(items: Collection<CheckListItem>) {
        for (item in items) {
            addItem(item)
        }
    }
}

class CheckListItem(
        var state: String = "",
        var id: String = "",
        var name: String = "",
        var nameData: String? = "",
        var pos: Long = 0
) {
    init {
        this.state = state
        this.id = id
        this.name = name
        this.nameData = nameData
        this.pos = pos
    }
}