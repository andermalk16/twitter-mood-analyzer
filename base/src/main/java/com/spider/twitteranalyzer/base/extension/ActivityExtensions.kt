package com.spider.twitteranalyzer.base.extension

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.IdRes

fun Activity.getContentView(): View = this.findViewById(android.R.id.content)
fun <T : View?> Context.findViewById(@IdRes id: Int): T? = (this as? Activity)?.findViewById<T>(id)
