package com.meifagundes.polarisai.model

import com.meifagundes.polarisai.util.getCurrentDateTime
import com.meifagundes.polarisai.util.getFormattedString
import java.util.*

class Message(val message : String,  val userId : Int) {

    var timestamp : String = ""
    init {
        timestamp = getFormattedString(getCurrentDateTime(), "H:mm aa")
    }
}