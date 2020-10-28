package tddmicroexercises.textconvertor

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File
import java.io.StringReader
import java.nio.file.Files

class HtmlTextConverterTest {

    @Test
    fun `Convert ampersand symbol`() {
        val converter = createHtmlConverterWithText("copy & paste")
        assertEquals("copy &amp; paste<br />", converter.convertToHtml())
    }

    @Test
    fun `Convert less then symbol`() {
        val converter = createHtmlConverterWithText("5 < 6")
        assertEquals("5 &lt; 6<br />", converter.convertToHtml())
    }

    @Test
    fun `Convert greater then symbol`() {
        val converter = createHtmlConverterWithText("10 > 3")
        assertEquals("10 &gt; 3<br />", converter.convertToHtml())
    }

    @Test
    fun `Convert double quote`() {
        val converter = createHtmlConverterWithText("\"Bonjour\"")
        assertEquals("&quot;Bonjour&quot;<br />", converter.convertToHtml())
    }

    @Test
    fun `Convert single quote`() {
        val converter = createHtmlConverterWithText("'Bonjour'")
        assertEquals("&quot;Bonjour&quot;<br />", converter.convertToHtml())
    }

    @Test
    fun `Convert multiline`() {
        val converter = createHtmlConverterWithText("test1\ntest2\ntest3")
        assertEquals("test1<br />test2<br />test3<br />", converter.convertToHtml())
    }

    private fun createHtmlConverterWithText(text: String): HtmlTextConverter {
        return HtmlTextConverter(reader = StringReader(text))
    }
}
