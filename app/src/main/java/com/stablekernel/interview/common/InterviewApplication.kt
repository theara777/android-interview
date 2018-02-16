package com.stablekernel.interview.common

import android.app.Application
import com.stablekernel.interview.common.injection.InterviewComponent
import com.stablekernel.interview.common.injection.InterviewModule

class InterviewApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerInterviewComponent.builder()
                .interviewModule(InterviewModule(this)).build
    }

    companion object {
        lateinit var component: InterviewComponent
            private set
    }
}