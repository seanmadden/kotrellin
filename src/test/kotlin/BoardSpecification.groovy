import spock.lang.Specification

class BoardSpecification extends Specification {
    def "Board object is instantiated with no parameters"() {
        given:
            def board = new Board()
        expect:
            board.name == ""
            board.id == ""
            board.lists.isEmpty()
    }

    def "Board instantiated with all parameters"() {
        given:
            def list = new kotlin.EmptyList()
            def board = new Board(name: "test-1", lists: list)
        expect:
            board.name == "test-1"
            board.id == ""
            board.lists.isEmpty()

    }

}