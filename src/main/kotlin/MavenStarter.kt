package org.example

import com.hexagontk.http.server.*
import com.hexagontk.http.server.jetty.JettyServletAdapter
import com.hexagontk.core.media.TEXT_PLAIN
import com.hexagontk.http.model.ContentType
import com.hexagontk.http.model.Header

internal val server: HttpServer by lazy {
    HttpServer(JettyServletAdapter()) {
        before("*") {
            send(headers = response.headers + Header("server", "Servlet/3.1"))
        }

        get("/text") {
            ok("Hello, World!", contentType = ContentType(TEXT_PLAIN))
        }
    }
}

internal fun main() {
    server.start()
}
