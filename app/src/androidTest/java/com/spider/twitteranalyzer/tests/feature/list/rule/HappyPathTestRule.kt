package com.spider.twitteranalyzer.tests.feature.list.rule

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.spider.twitteranalyzer.App
import com.spider.twitteranalyzer.base.test.ActivityInjectorForTest
import com.spider.twitteranalyzer.feature.list.view.TweetsListActivity
import com.spider.twitteranalyzer.feature.list.viewmodel.ListViewModel
import com.spider.twitteranalyzer.feature.list.viewslice.list.ListViewSlice
import com.spider.twitteranalyzer.feature.list.viewslice.list.adapter.TweetAdapter
import com.spider.twitteranalyzer.feature.list.viewslice.search.SearchViewSlice
import com.spider.twitteranalyzer.feature.list.viewslice.state.StateViewSlice
import com.spider.twitteranalyzer.tests.feature.list.Mocks

class HappyPathTestRule : ActivityTestRule<TweetsListActivity>(TweetsListActivity::class.java, true, true) {

    override fun beforeActivityLaunched() {
        super.beforeActivityLaunched()

        val app = InstrumentationRegistry.getTargetContext().applicationContext as App
        app.activityInjector = ActivityInjectorForTest.create<TweetsListActivity> {
            viewModel = ListViewModel.Impl(
                Mocks.state,
                Mocks.useCase
            )
            stateViewSlice = StateViewSlice.Impl(Mocks.errorMessageFactory)
            listViewSlice = ListViewSlice.Impl(
                Mocks.liveDataListViewSlice,
                LinearLayoutManager(app),
                TweetAdapter.Impl(Mocks.liveDataListViewSlice)
            )
            searchViewSlice = SearchViewSlice.Impl(
                actionLiveData = Mocks.liveDataSearchViewSlice,
                showcaseEnabled = false
            )
        }
    }
}