package tddmicroexercises.textconvertor

import java.io.BufferedReader
import java.io.IOException
import java.io.Reader
import kotlin.streams.toList

class HtmlTextConverter(private val reader: Reader) {

    @Throws(IOException::class)
    fun convertToHtml(): String {
        return BufferedReader(reader)
                .lines()
                .map(StringEscapeUtils::escapeHtml)
                .toList()
                .joinToString("<br />", postfix = "<br />")
    }
}
