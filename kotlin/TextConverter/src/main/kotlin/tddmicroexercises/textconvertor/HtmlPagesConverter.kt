package tddmicroexercises.textconvertor

import java.io.IOException
import java.io.StringReader

class HtmlPagesConverter(htmlContent: String) {
    private val pages = htmlContent.split("\nPAGE_BREAK\n")

    @Throws(IOException::class)
    fun getHtmlPage(page: Int): String {
        val htmlPage = pages[page]
        val converter = HtmlTextConverter(StringReader(htmlPage))
        return converter.convertToHtml()
    }
}
