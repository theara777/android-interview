package com.stablekernel.interview.common.injection

import android.content.Context
import com.stablekernel.interview.internal.MockBackendClient
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class InterviewModule(context: Context) {

    val context = context.applicationContext

    @Singleton
    @Provides
    fun provideInterviewClient(): OkHttpClient =
            MockBackendClient().interviewClient

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder =
        Retrofit.Builder()
                .baseUrl("http://localhost")
                .client(provideInterviewClient())
                .addConverterFactory(GsonConverterFactory.create())
}