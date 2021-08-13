package org.example

import com.hexagonkt.http.server.*
import com.hexagonkt.http.server.jetty.JettyServletAdapter
import com.hexagonkt.logging.LoggingManager
import com.hexagonkt.logging.Slf4jJulLoggingAdapter

internal val server: Server by lazy { createServer() }

internal fun createServer(): Server =
    Server(JettyServletAdapter()) {
        before {
            response.headers["Server"] = "Servlet/3.1"
        }

        get("/text") {
            ok("Hello, World!", "text/plain")
        }
    }

internal fun main() {
    LoggingManager.adapter = Slf4jJulLoggingAdapter
    server.start()
}
