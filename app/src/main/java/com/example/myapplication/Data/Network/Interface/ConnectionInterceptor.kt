package com.example.myapplication.Data.Network.Interface

import okhttp3.Interceptor


// impedisce il crash se non c'è connessione internet
interface ConnectionInterceptor : Interceptor

