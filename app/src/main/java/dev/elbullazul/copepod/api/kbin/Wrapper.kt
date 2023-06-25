package dev.elbullazul.copepod.api.kbin

import dev.elbullazul.copepod.api.kbin.models.Comment
import dev.elbullazul.copepod.api.kbin.models.Magazine
import dev.elbullazul.copepod.api.kbin.models.Thread

class Wrapper {

    fun Authenticate(): Boolean {
        return false
    }

    fun GetFeed(userId: String): List<Thread> {
        return emptyList()
    }

    fun GetSubscriptions(userId: String): List<Magazine> {
        return emptyList()
    }

    fun GetThread(threadId: String): Thread {
        return Thread()
    }

    fun GetComment(commentId: String): Comment {
        return Comment()
    }
}