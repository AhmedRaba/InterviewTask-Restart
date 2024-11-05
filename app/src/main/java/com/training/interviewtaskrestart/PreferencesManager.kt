package com.training.interviewtaskrestart

import android.content.Context
import android.content.SharedPreferences

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    var showTutorial: Boolean
        get() = sharedPreferences.getBoolean("showTutorial", false)
        set(value) = sharedPreferences.edit().putBoolean("showTutorial", value).apply()

    var userFirstTime: Boolean
        get() = sharedPreferences.getBoolean("userFirstTime", true)
        set(value) = sharedPreferences.edit().putBoolean("userFirstTime", value).apply()

    var coverBottomNav: Boolean
        get() = sharedPreferences.getBoolean("coverBottomNav", false)
        set(value) = sharedPreferences.edit().putBoolean("coverBottomNav", value).apply()

    var highlightPosition: Int
        get() = sharedPreferences.getInt("highlightPosition", 0)
        set(value) = sharedPreferences.edit().putInt("highlightPosition", value).apply()


}