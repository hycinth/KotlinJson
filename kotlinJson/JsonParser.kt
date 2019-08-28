package com.iuliao.forecast.vender.kotlinJson

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import java.nio.charset.Charset

/**
 * Created by Christian on 17/09/2016.
 */

object JsonParser {
    private val mapper = ObjectMapper()

    /**
     * Parse a Json string into a Json object.
     *
     * @param string A valid json string.
     * @return The Json object parsed from the string.
     */
    fun parse(string: String): Json {
        val value: Map<String, Any> = mapper.readValue(string, JsonMapType())
        return Json(value)
    }

    fun parse(file: File, charset: Charset): Json {
        val string = file.readText(charset)
        return parse(string)
    }

    class JsonMapType: TypeReference<Map<String, Any>>()

    class JsonArrayType: TypeReference<List<Any>>()
}
