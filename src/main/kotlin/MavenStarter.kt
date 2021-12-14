package org.example

import com.hexagonkt.http.server.*
import com.hexagonkt.http.server.jetty.JettyServletAdapter
import com.hexagonkt.core.logging.LoggingManager
import com.hexagonkt.logging.slf4j.jul.Slf4jJulLoggingAdapter

internal val server: Server by lazy {
    Server(JettyServletAdapter()) {
        before {
            response.headers["Server"] = "Servlet/3.1"
        }

        get("/text") {
            ok("Hello, World!", "text/plain")
        }
    }
}

internal fun main() {
    LoggingManager.adapter = Slf4jJulLoggingAdapter
    server.start()
}
