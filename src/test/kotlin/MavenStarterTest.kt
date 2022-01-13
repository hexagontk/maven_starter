package org.example

import com.hexagonkt.http.client.HttpClient
import com.hexagonkt.http.client.jetty.JettyClientAdapter
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS
import java.net.URL
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

@TestInstance(PER_CLASS)
class MavenStarterTest {

    private val client by lazy {
        HttpClient(JettyClientAdapter(), URL("http://localhost:${server.runtimePort}"))
    }

    @BeforeAll fun beforeSpec() {
        main()
        client.start()
    }

    @AfterAll fun afterSpec() {
        client.stop()
        server.stop()
    }

    @Test fun `HTTP request returns proper status, headers and body`() = runBlocking {
        val response = client.get("/text")
        val content = response.body

        assertNotNull(response.headers["server"])
        assertEquals("text/plain", response.contentType?.mediaType?.fullType)

        assertEquals(content, "Hello, World!")
    }
}
