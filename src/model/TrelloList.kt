public class TrelloList(
        var id: String = "",
        var name: String = "",
        var closed: Boolean? = false,
        var idBoard: String = "",
        var pos: Long = 65567L,
        var subscribed: Boolean = false,
        var cards: List<Card> = emptyList() ) {

    init {
        this.id = id
        this.name = name
        this.closed = closed
        this.idBoard = idBoard
        this.pos = pos
        this.subscribed = subscribed
        this.cards = cards
    }

    fun addCard(card: Card) {
        cards += card
    }


}
