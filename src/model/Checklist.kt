class Checklist(name: String) {
    public val id: String?
    public var name: String
    public var checkListItems: List<CheckListItem>
    public var cards: List<CardMetadata>

    init {
        id = null
        this.name = name
        checkListItems = listOf()
        cards = listOf()
    }

    /**
     * Appends the given checklist item to the list
     *
     * @param item the item to add to the checklist
     */
    fun appendToList(item: CheckListItem) {
        checkListItems += item
    }
}

class CheckListItem(
        var state: String,
        val id: String,
        var name: String,
        var nameData: String?,
        var pos: Long
)