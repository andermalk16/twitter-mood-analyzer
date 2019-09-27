package com.spider.twitteranalyzer.feature.list.viewslice.list

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.recyclerview.widget.LinearLayoutManager
import com.spider.twitteranalyzer.base.domain.model.Tweet
import com.spider.twitteranalyzer.base.viewslice.BaseViewSlice
import com.spider.twitteranalyzer.base.viewslice.ViewSlice
import com.spider.twitteranalyzer.feature.list.viewslice.list.adapter.TweetAdapter
import kotlinx.android.synthetic.main.activity_tweet_list.*
import javax.inject.Inject


interface ListViewSlice : ViewSlice {

    sealed class Action {
        data class TweetClicked(val tweet: Tweet) : Action()
    }

    fun getAction(): LiveData<Action>

    fun fillData(tweet: List<Tweet>)

    class Impl @Inject constructor(
        private val actionLiveData: MutableLiveData<Action>,
        private val layoutManager: LinearLayoutManager,
        private val adapter: TweetAdapter
    ) : BaseViewSlice(),
        ListViewSlice {

        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun onCreate() {
            setUpRecyclerView()
        }

        private fun setUpRecyclerView() {
            tweets_recycler_view.layoutManager = layoutManager
            tweets_recycler_view.adapter = adapter
        }

        override fun getAction(): LiveData<Action> = actionLiveData

        override fun fillData(tweet: List<Tweet>) {
            adapter.setTweets(tweet)
        }
    }
}
