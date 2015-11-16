import spock.lang.Specification


class CardSpecification extends Specification {
    def trello = Mock(Trello)

    def "Card can be created"() {
        given:
        def card = new Card()

        expect:
        card.desc.isEmpty()
        card.id.isEmpty()
    }

    def "Card can be created with an id and pulled from Trello"() {
        given:
        def card = new Card().id = "id-1"

        expect:
        card.id == "id-1"

    }

}