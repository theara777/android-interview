package com.stablekernel.interview.internal

import com.google.gson.Gson
import com.stablekernel.interview.common.InterviewApplication
import com.stablekernel.interview.login.api.model.LoginCredentials

import java.nio.charset.Charset

import javax.inject.Inject

import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import okio.Buffer
import retrofit2.Retrofit

/**
 * You should not need to edit or otherwise interact with this file.
 */
class MockBackendClient {

    @Inject lateinit var retrofit: Retrofit

    val interviewClient: OkHttpClient
        get() = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(Interceptor { chain ->
                    val request = chain.request()
                    if (request.method() == "POST") {
                        if (request.url().toString().endsWith("localhost/auth/token")) {
                            val body = request.body()
                            val buff = Buffer()
                            body!!.writeTo(buff)
                            val content = buff.readString(Charset.forName("UTF-8"))
                            val loginCredentials = Gson().fromJson(content, LoginCredentials::class.java)
                            val validCredentials = (loginCredentials != null
                                    && loginCredentials.username == VALID_USERNAME
                                    && loginCredentials.password == VALID_PASSWORD)
                            if (validCredentials) {
                                val responseBody = ResponseBody.create(MediaType.parse(APPLICATION_JSON), LOGIN_RESPONSE_BODY)
                                return@Interceptor createResponse(200, request, responseBody)
                            } else {
                                val responseBody = ResponseBody.create(MediaType.parse(APPLICATION_JSON), UNAUTHORIZED_RESPONSE_BODY)
                                return@Interceptor createResponse(401, request, responseBody)
                            }
                        }
                    } else if (request.method() == "GET") {
                        if (request.url().toString().endsWith("localhost/me") && request.header(AUTHORIZATION) != null) {
                            if (request.header(AUTHORIZATION) == "Bearer abcdefg") {
                                val responseBody = ResponseBody.create(MediaType.parse(APPLICATION_JSON), PROFILE_RESPONSE_BODY)
                                return@Interceptor createResponse(200, request, responseBody)
                            } else {
                                val responseBody = ResponseBody.create(MediaType.parse(APPLICATION_JSON), BAD_REQUEST_RESPONSE_BODY)
                                return@Interceptor createResponse(400, request, responseBody)
                            }
                        }
                    }
                    chain.proceed(request)
                }).build()

    init {
        InterviewApplication.component.inject(this)
    }

    private fun createResponse(statusCode: Int, request: Request, body: ResponseBody) =
        Response.Builder()
                .code(statusCode)
                .request(request)
                .protocol(Protocol.HTTP_1_1)
                .body(body)
                .addHeader(CONTENT_TYPE, APPLICATION_JSON)
                .build()

    companion object {
        private const val LOGIN_RESPONSE_BODY = "{\"access_token\": \"abcdefg\"}"
        private const val PROFILE_RESPONSE_BODY = "{\"name\": \"Bob\", \"progress\": 20.0, \"skills\": [\"java\", \"kotlin\", \"rest\", \"android studio\"]}"
        private const val UNAUTHORIZED_RESPONSE_BODY = "{\"error\": \"Invalid credentials\", \"error_code\": 1013}"
        private const val BAD_REQUEST_RESPONSE_BODY = "{\"error\": \"Bad request.\", \"error_code\": 400}"
        private const val APPLICATION_JSON = "application/json"
        private const val CONTENT_TYPE = "content-type"
        private const val VALID_USERNAME = "user"
        private const val VALID_PASSWORD = "pw"
        private const val AUTHORIZATION = "Authorization"
    }
}
