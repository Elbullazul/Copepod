package dev.elbullazul.copepod.api.kbin

import dev.elbullazul.copepod.api.kbin.data.TEST_MAGAZINES
import dev.elbullazul.copepod.api.kbin.data.TEST_THREADS
import dev.elbullazul.copepod.api.kbin.models.Magazine
import dev.elbullazul.copepod.api.kbin.models.Thread

class Wrapper() {

    val token: String = ""      // TODO: load from memory

    // TODO: authenticate with kbin via API
    fun Authenticate(): Boolean {
        return true
    }

    fun GetDefaultFeed(): List<Thread> {
        return TEST_THREADS
    }

    // get user feed
    fun GetHomeFeed(id: String): List<Thread> {
        return TEST_THREADS
    }

    // get user subscriptions
    fun GetMagazineSubscriptions(id: String): List<Magazine> {
        return TEST_MAGAZINES
    }

    // use for Post and Comments, cast as needed
    fun GetThread(id: String): Thread {
        return TEST_THREADS[2]
    }

    // TODO?
    //fun GetComment(id: String)
}