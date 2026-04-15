package edu.cit.melocoton.grindset

import android.content.Context
import android.content.SharedPreferences

object GrindsetPrefs {
    private const val PREF_NAME = "GrindsetSession"
    private const val KEY_USERNAME = "username"
    private const val KEY_IS_LOGGED_IN = "isLoggedIn"

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // SAVE DATA
    fun loginUser(context: Context, username: String) {
        val editor = getPrefs(context).edit()
        editor.putString(KEY_USERNAME, username)
        editor.putBoolean(KEY_IS_LOGGED_IN, true)
        editor.apply()
    }

    // RETRIEVE DATA
    fun getUsername(context: Context): String? {
        return getPrefs(context).getString(KEY_USERNAME, "Guest")
    }

    fun isLoggedIn(context: Context): Boolean {
        return getPrefs(context).getBoolean(KEY_IS_LOGGED_IN, false)
    }

    // CLEAR DATA (Logout)
    fun logoutUser(context: Context) {
        val editor = getPrefs(context).edit()
        editor.clear()
        editor.apply()
    }
}