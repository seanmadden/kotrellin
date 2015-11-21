import java.lang.reflect.Type
import com.github.salomonbrys.kotson.*
import com.google.gson.*

class CardSerializer() : JsonSerializer<Card> {
    override fun serialize(card: Card?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (card == null)
            return JsonPrimitive("")

        val json = JsonObject()
        json.add("id", JsonPrimitive(card.id))
        json.add("badges", JsonPrimitive("TODO")) //TODO
        json.add("checkItemStates", JsonArray()) //TODO
        json.add("name", JsonPrimitive(card.name))

        //gather the checklist ids
        val array = JsonArray()
        card.idChecklists.forEach { array.add(JsonPrimitive(it.id)) }

        json.add("idChecklists", array)

        return json
    }
}
