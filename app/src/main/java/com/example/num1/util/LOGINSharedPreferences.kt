package com.example.num1.util

import android.content.Context
import android.content.SharedPreferences

object LOGINSharedPreferences {
    private const val STORAGE_KEY = "USER_AUTO"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    fun getSharedPreference(context: Context): SharedPreferences =
        context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
    //sharedpreferences객체를 획득하 떄 지정하는 MODE_PRIVATE는 자기 앱 내에서 사용, 외부 앱에서 접근 불가

    fun getAutoLogin(context: Context): Boolean {
        return getSharedPreference(context).getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(context: Context, value: Boolean) {
        getSharedPreference(context).edit()
                //데이터를 저장할때 사용하는 editor클래스의 함수
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun setLogin(context: Context) {
        getSharedPreference(context)
            .edit()
            .remove(AUTO_LOGIN)
            .clear()
            .apply()
    }
}
