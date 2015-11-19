import java.lang.reflect.Type
import com.github.salomonbrys.kotson.*
import com.google.gson.*

class CardSerializer() : JsonSerializer<Card> {
    override fun serialize(src: Card?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement? {
        if (src == null)
            return JsonPrimitive("")

        val json = JsonObject()
        json.add("id", JsonPrimitive(src.id))

        //gather the checklist ids
        val array = JsonArray()
        src.idChecklists.forEach { array.add(JsonPrimitive(it.id)) }

        json.add("idChecklists", array)

        return json as JsonElement
    }
}
