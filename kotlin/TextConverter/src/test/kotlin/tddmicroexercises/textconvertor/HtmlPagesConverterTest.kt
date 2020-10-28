package tddmicroexercises.textconvertor

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException

class HtmlPagesConverterTest {
    @Test
    @Throws(IOException::class)
    fun `Convert ampersand symbol`() {
        val converter = createHtmlPageConvertWithText("copy & paste")
        assertEquals("copy &amp; paste<br />", converter.getHtmlPage(0))
    }

    @Test
    fun `Convert less then symbol`() {
        val converter = createHtmlPageConvertWithText("5 < 6")
        assertEquals("5 &lt; 6<br />", converter.getHtmlPage(0))
    }

    @Test
    fun `Convert greater then symbol`() {
        val converter = createHtmlPageConvertWithText("10 > 3")
        assertEquals("10 &gt; 3<br />", converter.getHtmlPage(0))
    }

    @Test
    fun `Convert double quote`() {
        val converter = createHtmlPageConvertWithText("\"Bonjour\"")
        assertEquals("&quot;Bonjour&quot;<br />", converter.getHtmlPage(0))
    }

    @Test
    fun `Convert single quote`() {
        val converter = createHtmlPageConvertWithText("'Bonjour'")
        assertEquals("&quot;Bonjour&quot;<br />", converter.getHtmlPage(0))
    }

    @Test
    fun `Convert multiline`() {
        val converter = createHtmlPageConvertWithText("test1\ntest2\ntest3")
        assertEquals("test1<br />test2<br />test3<br />", converter.getHtmlPage(0))
    }

    @Test
    fun `Split into two pages when PAGE_BREAK`() {
        val converter = createHtmlPageConvertWithText("test1\nPAGE_BREAK\ntest2")
        assertEquals("test1<br />", converter.getHtmlPage(0))
        assertEquals("test2<br />", converter.getHtmlPage(1))
    }

    private fun createHtmlPageConvertWithText(text: String): HtmlPagesConverter {
        return HtmlPagesConverter(text)
    }
}
