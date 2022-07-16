package com.example.myapplication.Internal.Exception

import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun <T> lazyDeffered(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>> {
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}