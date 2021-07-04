package org.example

import com.hexagonkt.http.server.*
import com.hexagonkt.http.server.jetty.JettyServletAdapter
import com.hexagonkt.injection.InjectionManager

internal val server: Server by lazy {
    Server {
        before {
            response.headers["Server"] = "Servlet/3.1"
        }

        get("/text") {
            ok("Hello, World!", "text/plain")
        }
    }
}

internal fun main() {
    InjectionManager.apply {
        module.bind<ServerPort>(JettyServletAdapter())
    }

    server.start()
}
