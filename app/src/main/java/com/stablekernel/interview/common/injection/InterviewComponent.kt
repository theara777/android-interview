package com.stablekernel.interview.common.injection

import com.stablekernel.interview.internal.MockBackendClient
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(InterviewModule::class))
interface InterviewComponent {

    fun inject(manager: MockBackendClient)

}