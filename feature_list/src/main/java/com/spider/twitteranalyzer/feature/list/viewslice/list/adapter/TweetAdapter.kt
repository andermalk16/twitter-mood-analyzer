package com.spider.twitteranalyzer.feature.list.viewslice.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.spider.twitteranalyzer.base.domain.model.Tweet
import com.spider.twitteranalyzer.feature.list.R
import com.spider.twitteranalyzer.feature.list.viewslice.list.ListViewSlice
import javax.inject.Inject


abstract class TweetAdapter : ListAdapter<Tweet, TweetViewHolder>(TweetDiifCallback()) {

    abstract fun setTweets(tweets: List<Tweet>)

    class Impl @Inject constructor(
        private val actionLiveData: MutableLiveData<ListViewSlice.Action>
    ) : TweetAdapter() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
            val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_tweet, parent, false)
            return TweetViewHolder(itemView, actionLiveData)
        }

        override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        override fun setTweets(tweets: List<Tweet>) {
            submitList(tweets)
        }
    }
}
