package com.codingstuff.loginandsignup

import android.graphics.Bitmap

class EventData (
    var name: String,
    var type: String,
    var location: String,
    var price: String,
    var date: String,
    var optionalText: String,
    var image: Bitmap?=null
)