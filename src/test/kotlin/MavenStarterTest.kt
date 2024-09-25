package org.example

import com.hexagontk.core.urlOf
import com.hexagontk.http.client.HttpClient
import com.hexagontk.http.client.HttpClientSettings
import com.hexagontk.http.client.jetty.JettyClientAdapter
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@TestInstance(PER_CLASS)
class MavenStarterTest {

    private val client by lazy {
        val clientSettings = HttpClientSettings(urlOf("http://localhost:${server.runtimePort}"))
        HttpClient(JettyClientAdapter(), clientSettings)
    }

    @BeforeAll fun beforeSpec() {
        main()
        client.start()
    }

    @AfterAll fun afterSpec() {
        client.stop()
        server.stop()
    }

    @Test fun `HTTP request returns proper status, headers and body`() {
        val response = client.get("/text")
        val content = response.body

        assertNotNull(response.headers["server"])
        assertEquals("text/plain", response.contentType?.mediaType?.fullType)

        assertEquals(content, "Hello, World!")
    }
}
