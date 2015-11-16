import spock.lang.Specification


class CardSpecification extends Specification {
    def "Card can be created"() {
        given:
        def card = new Card()

        expect:
        card.desc.isEmpty()
    }

}