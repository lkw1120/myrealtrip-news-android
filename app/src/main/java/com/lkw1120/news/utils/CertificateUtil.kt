package com.lkw1120.news.utils

import java.io.IOException
import java.net.MalformedURLException
import java.net.URL
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*

class CertificateUtil {

    private val DO_NOT_VERIFY = HostnameVerifier { hostname, session -> true }

    private fun trustAllHosts() {
        val trustAllCerts =
            arrayOf<TrustManager>(object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }

                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }
            })
        try {
            val sc = SSLContext.getInstance("TLS")
            sc.init(null, trustAllCerts, SecureRandom())
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.socketFactory)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun postHttps(
        url: String?,
        connTimeout: Int,
        readTimeout: Int
    ): HttpsURLConnection? {
        trustAllHosts()
        val https: HttpsURLConnection
        try {
            https = URL(url).openConnection() as HttpsURLConnection
            https.hostnameVerifier = DO_NOT_VERIFY
            https.connectTimeout = connTimeout
            https.readTimeout = readTimeout
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            return null
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return https
    }
}