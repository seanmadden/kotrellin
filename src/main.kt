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

    //Get all cards not the schedule card
    val chores = choreCardsOnFirstList?.filter { it.name.toLowerCase() != "schedule" } ?: return

    //Create the checklist with the names on the chore cards
    val checklist = Checklist(id = "checklist-1")
    checklist.addAll(chores.map {
        CheckListItem(name = it.name)
    })

    //Grab a card to try to add a list to
    val cardId = Card(id = chores[0].id)
    val card = trello.get(cardId)

    println("Checklists: ${card.idChecklists}");
    println(checklist.checkListItems.map { it.name })

    card.addChecklist(checklist)

    println("Checklists: ${card.idChecklists}");
    println(trello.save(card))


    //    val choreList = chores?.map { it.id }
    //
    //    println(card)


    //    var choreChecklist = Checklist("Chores")
    //    val board = Board(name = "board1")
    //    println(choreChecklist.checkListItems)

    //    choreList?.forEach { choreChecklist.appendToList(CheckListItem("incomplete", "id-2", it, null, 123L)) }
    //    println(choreChecklist.checkListItems.map { it.name })

}


fun loadConfig(fileName: String): Configuration? {
    val config = Gson().fromJson<Configuration>(File(fileName).readText())

    return config
}

