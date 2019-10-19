package org.kotlin.preacher.jok3r.utils

import android.content.Context
import android.net.ConnectivityManager

//TODO Runtime Permissions
fun isOnline(context: Context):Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnected
}