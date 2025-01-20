package com.purplestudio

import io.ktor.client.request.*
import io.ktor.client.statement.bodyAsText
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {

    @Test
    fun testRoot() = testApplication {
//        application {
//            module()
//        }
        client.get("/").apply {
            // 驗證回應內容
            val responseBody = bodyAsText()
            assertEquals(expected = "welcome to Boruto API !",
                         actual = responseBody)
            assertEquals(expected = HttpStatusCode.OK,
                         actual = status)
        }
    }

}
