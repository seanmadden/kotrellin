import com.google.gson.Gson
import com.github.salomonbrys.kotson.*
import java.io.File
import java.security.InvalidParameterException

fun main(args: Array<String>) {
    val config = loadConfig("keys.json") ?: return
    val trello = Trello(config.key, config.token)

    val boards = trello.getMemberBoards("me")

    val choreBoardMetadata = boards?.single { it.name == "Chores" }
    val choreBoardId = choreBoardMetadata?.id ?: throw InvalidParameterException("No Board found")

    val choreLists = trello.getListsOnBoard(choreBoardId)
    val firstChoreListId = choreLists?.get(1)?.id ?: return;
    val choreCardsOnFirstList = trello.getCardsOnList(firstChoreListId)
    var chores = choreCardsOnFirstList?.filter { it.name.toLowerCase() != "schedule" }
    val choreList = chores?.map { it.id }
    var choreChecklist = Checklist("Chores")
    val board = Board(name = "board1")
    println(choreChecklist.checkListItems)

    choreList?.forEach { choreChecklist.appendToList(CheckListItem("incomplete", "id-2", it, null, 123L)) }
    println(choreChecklist.checkListItems.map { it.name })

}


fun loadConfig(fileName: String) : Configuration? {
    val config = Gson().fromJson<Configuration>(File(fileName).readText())

    return config
}

