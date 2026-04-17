package com.spirovski.kentapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform