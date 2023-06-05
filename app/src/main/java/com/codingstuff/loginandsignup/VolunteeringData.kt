package com.codingstuff.loginandsignup

class VolunteeringData {
    companion object Factory {
        fun create(): VolunteeringData = VolunteeringData()
    }

    var name:  String? = null
    var description: String? = null
    var location: String? = null
    var imageURL: String? = null
}