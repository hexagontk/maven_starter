package org.example

import com.hexagonkt.http.server.*
import com.hexagonkt.http.server.jetty.JettyServletAdapter
import com.hexagonkt.core.logging.LoggingManager
import com.hexagonkt.core.media.TextMedia.PLAIN
import com.hexagonkt.http.model.ContentType
import com.hexagonkt.logging.slf4j.jul.Slf4jJulLoggingAdapter

internal val server: HttpServer by lazy {
    HttpServer(JettyServletAdapter()) {
        on("*") {
            send(headers = response.headers + ("server" to "Servlet/3.1"))
        }

        get("/text") {
            ok("Hello, World!", contentType = ContentType(PLAIN))
        }
    }
}

internal fun main() {
    LoggingManager.adapter = Slf4jJulLoggingAdapter()
    server.start()
}
