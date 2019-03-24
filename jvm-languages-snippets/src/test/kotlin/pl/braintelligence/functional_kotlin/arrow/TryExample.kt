package pl.braintelligence.functional_kotlin.arrow

import arrow.core.Try
import arrow.core.getOrElse
import arrow.core.orElse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import pl.braintelligence.BaseIntegrationTest
import pl.braintelligence.BaseStubs
import pl.braintelligence.domain.Article
import java.net.URL

open class TryExample : BaseIntegrationTest(), BaseStubs {

    @Test
    fun tryExample_createURL() {
        // given: invalid URL
        val result = Try { URL("BLAAH//hHttp://braintelligence.pl") }
                .map { it.host }
                .getOrElse { "google.pl" }

        assertThat(result)
                .isEqualTo("google.pl")
    }

    @Test
    fun tryExample_searchForArticles() {
        val result = fetchArticlesFromFacebook()
                .orElse { fetchArticlesFromGoogle() }
                .getOrElse { emptyList() }
                .filterNot { it.name.contains("123") }
                .map { it.name }

        assertThat(result)
                .isEqualTo(listOf("name"))
    }

    private fun fetchArticlesFromFacebook() = Try {
        throw NoSuchElementException()
    }

    private fun fetchArticlesFromGoogle() = Try {
        listOf(
                Article("name", "content"),
                Article("123", "content")
        )
    }
}
