package com.iuliao.forecast.vender.kotlinJson

import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Created by Christian on 17/09/2016.
 */
data class Json(private val value: Any? = Any()) {
    private val mapper = ObjectMapper()

    operator fun get(key: String): Json {
        val currentObject = jsonObject ?: return Json(null)
        return currentObject[key]
    }

    /**
     * Gives a json object from String to Json.
     */
    val jsonObject: JsonObject?
        get() {
            if (value !is Map<*, *>) return null

            val map: Map<String, Any> = mapper.convertValue(value, JsonParser.JsonMapType())
            return JsonObject(map)
        }
    /**
     * Gives a json array of Json.
     */
    val array: JsonArray?
        get() {
            if (value !is List<*>) return null

            val array: List<Any> = mapper.convertValue(value, JsonParser.JsonArrayType())
            return JsonArray(array)
        }

    val arrayValue: JsonArray
        get() = array ?: JsonArray(listOf())


    /**
     * Gives a String if the value is a String else null
     */
    val string: String?
        get() = TypeUtils.castToString(value)
    val stringValue: String
        get() = string ?: ""

    /**
     * Gives a Int if the value is a Int else null
     */
    val int: Int?
        get() = TypeUtils.castToInt(value)
    val intValue: Int
        get() = int ?: 0

    /**
     * Gives a Boolean if the value is a Boolean else null
     */
    val boolean: Boolean?
        get() = TypeUtils.castToBoolean(value)
    val booleanValue: Boolean
        get() = boolean ?: false

    /**
     * Gives a Double if the value is a Double else null
     */
    val double: Double?
        get() = TypeUtils.castToDouble(value)
    val doubleValue: Double
        get() = double ?: 0.0

    /**
     * Gives a Long if the value is a Long else null
     */
    val long: Long?
        get() = TypeUtils.castToLong(value)
    val longValue: Long
        get() = long ?: 0

    /**
     * Gives a Float if the value is a Float else null
     */
    val float: Float?
        get() = TypeUtils.castToFloat(value)
    val floatValue: Float
        get() = float ?: 0f
}