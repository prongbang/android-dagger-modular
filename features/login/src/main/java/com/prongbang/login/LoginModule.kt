package com.prongbang.login

import com.prongbang.login.data.LoginApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityRetainedComponent::class)
object LoginModule {

    @Provides
    internal fun provideLoginApi(retrofit: Retrofit): LoginApi =
        retrofit.create(LoginApi::class.java)

}