package com.spider.twitteranalyzer.tests.feature.list.screen

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.BoundedMatcher
import com.agoda.kakao.BaseActions
import com.agoda.kakao.KBaseView
import com.agoda.kakao.ViewBuilder
import com.agoda.kakao.ViewMarker
import com.miguelcatalan.materialsearchview.MaterialSearchView
import org.hamcrest.Description
import org.hamcrest.Matcher


@ViewMarker
class KMaterialSearchView(function: ViewBuilder.() -> Unit) : KBaseView<KMaterialSearchView>(function),
    MaterialSearchViewEditableActions

interface MaterialSearchViewEditableActions : BaseActions {
    fun submitSearchQuery(text: String) {
        view.perform(object : ViewAction {
            override fun getDescription(): String {
                val msg = StringBuilder("Running view assertions[")
                return msg.toString()
            }

            override fun getConstraints(): Matcher<View>? {
                return object : BoundedMatcher<View, MaterialSearchView>(MaterialSearchView::class.java) {
                    override fun describeTo(description: Description?) {
                    }

                    override fun matchesSafely(foundView: MaterialSearchView): Boolean {
                        return true
                    }
                }
            }

            override fun perform(uic: UiController, view: View) {
                (view as MaterialSearchView).setQuery(text, true)
            }
        })
    }
}
