package com.evgeny_minaenkov.chibbis.utils

import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import java.util.*

class DateFormatter{
    @RequiresApi(Build.VERSION_CODES.N)
    fun formatDate(date: String): String {
        val inputDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault())
            .parse(date)
        return SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(inputDate)
    }
}