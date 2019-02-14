package com.spider.twitteranalyzer.feature.list.viewslice.list.injection

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.spider.twitteranalyzer.base.injection.qualifiers.ForActivity
import com.spider.twitteranalyzer.base.injection.scopes.PerActivity
import com.spider.twitteranalyzer.feature.list.viewslice.list.ListViewSlice
import com.spider.twitteranalyzer.feature.list.viewslice.list.adapter.TweetAdapter
import dagger.Module
import dagger.Provides

@Module
class ListViewSliceModule {

    @Provides
    @PerActivity
    fun provideListViewSlice(viewSlice: ListViewSlice.Impl): ListViewSlice =
        viewSlice

    @Provides
    @PerActivity
    fun provideListActionLiveData(): MutableLiveData<ListViewSlice.Action> =
        MutableLiveData()

    @Provides
    @PerActivity
    fun provideLayoutManager(@ForActivity context: Context): LinearLayoutManager =
        LinearLayoutManager(context)

    @Provides
    @PerActivity
    fun provideTweetsAdapter(adapter: TweetAdapter.Impl): TweetAdapter =
        adapter
}