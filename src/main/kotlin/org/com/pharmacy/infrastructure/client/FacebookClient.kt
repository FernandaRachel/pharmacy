package org.com.org.com.pharmacy.infrastructure.client

import okhttp3.Headers
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.com.org.com.pharmacy.domain.ports.FacebookClient
import org.slf4j.LoggerFactory
import java.io.IOException

//curl -i -X GET \
// "https://graph.facebook.com/v23.0/me?fields=id%2Cname%2Cmiddle_name%2Cbirthday%2Cemail&access_token=EAAcVE5S8tqMBPg9mLOYOG2BwBUDzcpmoa2hxxudDAqnbTQ8gahanLzM9U5XpB5O1aXPUfCTA2qEuzJ5hs2AsEHPGzVDN9E20IwRf3GqbMqeR2CZAVxRbfFJej9McZAcyZAZCtJcGHFi29diQydTXiiS2jh6uwtJqRf5B8hzyuDIYQdpcMbKu9ueEgtJKNIwVjXu0yWvDZBRoAxLThLwMYIRcrR0GOjBqrLZArsyCwOFHlQZBp0jpXD9TaUYkpw1pwVixM2ZCkF4ZD"

class HttpFacebookClient : FacebookClient {
    private val LOG = LoggerFactory.getLogger(HttpFacebookClient::class.java)
    private val AUTH_TOKEN = ""

    private val client: OkHttpClient = OkHttpClient()

    private val url = "https://graph.facebook.com/v23.0/me?fields=id%2Cname%2Cmiddle_name%2Cbirthday%2Cemail&access_token=$AUTH_TOKEN"

    override fun get(): String? {
        val request = Request.Builder()
            .url(url)
            .headers(getHeaders())
            .build()

        return try {
            val response = client.newCall(request).execute()
            val result = response.body?.string()

            println(result)
            result
        } catch (e: IOException) {
            LOG.error("Request failed", e)
            null
        } catch (e: IllegalStateException) {
            LOG.error("Illegal State", e)
            null
        }
    }


    private fun getHeaders(): Headers {
        return Headers.Builder()
            .add("User-Agent", "Pharmacy")
            .add("Accept", "application/json")
//            .add("Authorization", "Basic")
            .build()
    }
}
