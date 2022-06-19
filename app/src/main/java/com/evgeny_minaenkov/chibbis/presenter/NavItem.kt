package com.evgeny_minaenkov.chibbis.presenter

import com.evgeny_minaenkov.chibbis.R

sealed class NavItem(var route: String, var icon: Int, var title: String) {
    object Restaurants : NavItem("restaurants",
        R.drawable.ic_baseline_restore_24, "Рестораны")

    object Hits : NavItem("hits", R.drawable.ic_baseline_favorite_24, "Хиты")
    object Reviews : NavItem("reviews", R.drawable.ic_baseline_chat_24, "Отзывы")
}
