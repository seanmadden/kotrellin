public class Card (
    var id: String = "",
    var badges: Badges = Badges(),
    var checkItemStates: List<Any> = kotlin.emptyList(),
    var closed: Boolean = false,
    var dateLastActivity: String? = "",
    var desc: String = "",
    var descData: Any? = "",
    var due: String? = "",
    var email: String? = "",
    var idAttachmentCover: String? = "",
    var idBoard: String = "",
    var idChecklists: List<Checklist> = kotlin.emptyList(),
    var idLabels: List<Any> = kotlin.emptyList(),
    var idList: String = "",
    var idMembers: List<Any> = kotlin.emptyList(),
    var idMembersVoted: List<Any> = kotlin.emptyList(),
    var idShort: Int = 0,
    var labels: List<Any> = kotlin.emptyList(),
    var manualCoverAttachment: Boolean? = false,
    var name: String = "",
    var pos: Double = 0.0,
    var shortLink: String = "",
    var shortUrl: String = "",
    var subscribed: Boolean? = false,
    var url: String = ""
) {

    public fun addChecklist(checklist: Checklist) {
        this.idChecklists += checklist
    }
}

public data class Badges (
        val votes: Int = 0,
        val viewingMemberVoted: Boolean = false,
        val subscribed: Boolean = false,
        val fogbugz: String = "",
        val checkItems: Int = 0,
        val checkItemsChecked: Int = 0,
        val comments: Int = 0,
        val attachments: Int = 0,
        val description: Boolean = false ,
        val due: String? = ""
)

public data class CardMetadata(
        val id: String,
        var name: String
)
