package com.spider.twitteranalyzer.feature.list.viewslice.list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.spider.twitteranalyzer.base.domain.model.Tweet

class TweetDiifCallback: DiffUtil.ItemCallback<Tweet>() {
    override fun areItemsTheSame(oldItem: Tweet, newItem: Tweet): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Tweet, newItem: Tweet): Boolean =
        oldItem == newItem
}