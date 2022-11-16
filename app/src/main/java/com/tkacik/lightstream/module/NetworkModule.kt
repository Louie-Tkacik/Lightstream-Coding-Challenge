package com.tkacik.lightstream.module



import com.tkacik.lightstream.api.ServiceRickandMorty
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideClient(): OkHttpClient = OkHttpClient.Builder().addInterceptor(
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
    ).build()

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideRickandMortyService(
        retrofit: Retrofit
    ): ServiceRickandMorty = retrofit.create(ServiceRickandMorty::class.java)

}