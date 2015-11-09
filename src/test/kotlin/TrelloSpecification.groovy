import spock.lang.Specification


class TrelloSpecification extends Specification {
    def "Trello object contains an endpoint"() {
        given:
            def key = "asdf"
            def token = "qwer"

            def trello = new Trello(key, token)
        expect:
            trello.apiVersion == "1"
            trello.apiUrl == "https://api.trello.com/1"
            trello.key == key
            trello.token == token
    }

}