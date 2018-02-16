package com.stablekernel.interview.login.manager

import android.util.Log
import com.stablekernel.interview.common.api.InterviewWebService
import com.stablekernel.interview.login.api.model.LoginCredentials
import com.stablekernel.interview.login.api.model.TokenResponse
import com.stablekernel.interview.login.ui.LoginActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginManager {

    private val interviewWebService: InterviewWebService? = null

    private fun onLogin(username: String, password: String) {
        if (!isInputValid(username, password)) {
            Log.d(LoginActivity.TAG, "Invalid input")
        }
        else {
            val loginCredentials = LoginCredentials(username, password)

            interviewWebService!!.login(loginCredentials)
                    .enqueue(object : Callback<TokenResponse> {
                        override fun onResponse(call: Call<TokenResponse>, response: Response<TokenResponse>) {
                            Log.d(LoginActivity.TAG, "onResponse() called with: call = [$call], response = [$response]")
                        }

                        override fun onFailure(call: Call<TokenResponse>, t: Throwable) {
                            Log.d(LoginActivity.TAG, "onFailure() called with: call = [$call], t = [$t]")
                        }
                    })
        }
    }

    private fun isInputValid(username: String, password: String): Boolean {
        return false
    }
}