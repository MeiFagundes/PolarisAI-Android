package com.meifagundes.polarisai.util

import java.text.SimpleDateFormat
import java.util.*


    fun getFormattedString(calendar: Calendar, format: String, locale: Locale = Locale.getDefault()) : String{
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(calendar.time)
    }

    fun getCurrentDateTime(): Calendar {
        return Calendar.getInstance()
    }