package com.codingstuff.loginandsignup


class ToursData {
    companion object Factory {
        fun create(): ToursData = ToursData()
    }
    var objectId: String? = null
    var transport: String? = null
    var name:  String? = null
    var duration: String? = null
    var location: String? = null
    var price: String? = null
    var date: String? = null
    var imageURL: String? = null
}