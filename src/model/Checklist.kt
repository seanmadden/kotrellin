class Checklist(
    var id: String = "",
    var name: String = "",
    var checkListItems: List<CheckListItem> = kotlin.emptyList(),
    var cards: List<CardMetadata> = kotlin.emptyList()
) {

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
}