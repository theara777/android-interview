package com.stablekernel.interview.login.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

import com.stablekernel.interview.R
import com.stablekernel.interview.common.InterviewApplication
import com.stablekernel.interview.common.api.InterviewWebService
import com.stablekernel.interview.login.api.model.LoginCredentials
import com.stablekernel.interview.login.api.model.TokenResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    companion object {
        val TAG = LoginActivity::class.java.simpleName
    }
}

