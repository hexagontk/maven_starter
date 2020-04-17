package org.example

import com.hexagonkt.helpers.logger
import com.hexagonkt.http.httpDate
import com.hexagonkt.http.server.*
import com.hexagonkt.http.server.jetty.JettyServletAdapter
import com.hexagonkt.injection.InjectionManager

val injector: InjectionManager = InjectionManager.apply {
    bindObject<ServerPort>(JettyServletAdapter())
}

val server: Server = Server {
    before {
        response.headers["Server"] = "Servlet/3.1"
        response.headers["Transfer-Encoding"] = "chunked"
        response.headers["Date"] = httpDate()
    }

    get("/text") {
        ok("Hello, World!", "text/plain")
    }
}

/**
 * Start the service from the command line.
 */
fun main() {
    logger.info { injector }
    server.start()
}
