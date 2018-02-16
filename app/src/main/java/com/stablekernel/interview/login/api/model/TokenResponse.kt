package com.stablekernel.interview.login.api.model

import com.google.gson.annotations.SerializedName

class TokenResponse(@SerializedName("access_token") val accessToken: String) {

    val bearerToken = "Bearer $accessToken"

    override fun toString() = "TokenResponse{accessToken='$accessToken'}"
}
