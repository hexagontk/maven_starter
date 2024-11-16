package org.example

import com.hexagontk.http.server.*
import com.hexagontk.http.server.helidon.HelidonHttpServer
import com.hexagontk.core.media.TEXT_PLAIN
import com.hexagontk.http.model.ContentType
import com.hexagontk.http.model.Field

internal val server: HttpServer by lazy {
    HttpServer(HelidonHttpServer()) {
        before("*") {
            send(headers = response.headers + Field("server", "Servlet/3.1"))
        }

        get("/text") {
            ok("Hello, World!", contentType = ContentType(TEXT_PLAIN))
        }
    }
}

internal fun main() {
    server.start()
}
