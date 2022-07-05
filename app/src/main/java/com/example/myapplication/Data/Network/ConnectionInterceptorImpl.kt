package com.example.myapplication.Data.Network

import android.content.Context
import android.net.ConnectivityManager
import com.example.myapplication.Data.Network.Interface.ConnectionInterceptor
import com.example.myapplication.Internal.Exception.NoConnetionException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectionInterceptorImpl(context: Context) : ConnectionInterceptor {

    private val appContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isOnline())
            throw NoConnetionException()
        return chain.proceed(chain.request())
            }

    private fun isOnline(): Boolean {
        val connetctionManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
        as ConnectivityManager
        val netInfo = connetctionManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}