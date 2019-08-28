package com.iuliao.forecast.vender.kotlinJson

/**
 * Created by Christian on 17/09/2016.
 */
data class JsonArray(private val values: List<Any> = listOf()) : Collection<Json> {

    val jsonValues: MutableList<Json> = values.map { Json(it) }.toMutableList()

    /**
     * @param index The index to get the element form.
     * @return The Json element at index. If index out of bounds an empty Json element is returned.
     */
    operator fun get(index: Int): Json {
        if (index >= jsonValues.size) return Json(null)
        return jsonValues[index]
    }

    operator fun plusAssign(value: Any) {
        jsonValues.add(Json(value))
    }

    /**
     * The size of the json array.
     */
    override val size: Int
        get() = values.size

    /**
     * @param element The element to look for.
     * @return True if the element is contained in the json array.
     */
    override fun contains(element: Json): Boolean = jsonValues.contains(element)

    /**
     * @param elements The elements to look for.
     * @return True if all the elements are contained in the json array.
     */
    override fun containsAll(elements: Collection<Json>): Boolean = jsonValues.containsAll(elements)

    /**
     * @return True if json array is empty.
     */
    override fun isEmpty(): Boolean = jsonValues.isEmpty()

    /**
     * @return An iterator for the json array.
     */
    override fun iterator(): Iterator<Json> = jsonValues.iterator()


}