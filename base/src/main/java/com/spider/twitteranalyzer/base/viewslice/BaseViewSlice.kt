package com.spider.twitteranalyzer.base.viewslice

import android.content.Context
import android.content.res.Resources
import android.view.View
import androidx.lifecycle.Lifecycle
import kotlinx.android.extensions.LayoutContainer

abstract class BaseViewSlice : ViewSlice, LayoutContainer {

    protected lateinit var context: Context
    private lateinit var resources: Resources

    override lateinit var containerView: View

    override fun init(lifecycle: Lifecycle, view: View) {
        lifecycle.addObserver(this)
        context = view.context
        resources = view.resources
        containerView = view
    }
}
