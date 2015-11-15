import spock.lang.Specification


class TrelloListSpecification extends Specification {
    def "List is created properly"() {
        given:
        def list1 = new TrelloList()

        expect:
        list1.cards.size() == 0

    }

    def "Cards can be added to a list"() {
        given:
        def list = new TrelloList()
        def card = new Card()

        when:
        list.addCard(card)

        then:
        list.cards.size() == 1
    }

}