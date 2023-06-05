package com.codingstuff.loginandsignup

class Event {
    companion object Factory {
        fun create(): Event = Event()
    }
    var objectId: String? = null
    var description: String? = null
    var name:  String? = null
    var type: String? = null
    var location: String? = null
    var price: String? = null
    var date: String? = null
}