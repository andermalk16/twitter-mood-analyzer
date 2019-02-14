package com.spider.twitteranalyzer.feature.list.injection

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import com.spider.twitteranalyzer.base.injection.qualifiers.ForActivity
import com.spider.twitteranalyzer.base.injection.scopes.PerActivity
import com.spider.twitteranalyzer.feature.list.domain.FetchTweetsUseCase
import com.spider.twitteranalyzer.feature.list.repository.TweetsRepository
import com.spider.twitteranalyzer.feature.list.view.TweetsListActivity
import com.spider.twitteranalyzer.feature.list.viewmodel.ListViewModel
import com.spider.twitteranalyzer.feature.list.viewmodel.ListViewModelFactory
import com.spider.twitteranalyzer.feature.list.viewslice.list.injection.ListViewSliceModule
import com.spider.twitteranalyzer.feature.list.viewslice.search.injection.SearchViewSliceModule
import com.spider.twitteranalyzer.feature.list.viewslice.state.injection.StateViewSliceModule
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        TweetsListModule.Repository::class,
        TweetsListModule.UseCase::class,
        TweetsListModule.ViewModel::class,
        TweetsListModule.View::class,
        ListViewSliceModule::class,
        SearchViewSliceModule::class,
        StateViewSliceModule::class
    ]
)
class TweetsListModule {

    @Module
    abstract class Repository {
        @Binds
        @PerActivity
        abstract fun provideTweetsRepository(repository: TweetsRepository.Impl): TweetsRepository
    }

    @Module
    abstract class UseCase {
        @Binds
        @PerActivity
        abstract fun provideFetchTweetsUseCase(useCase: FetchTweetsUseCase.Impl): FetchTweetsUseCase
    }

    @Module
    class ViewModel {
        @Provides
        @PerActivity
        fun provideListViewModel(
            activity: TweetsListActivity,
            factory: ListViewModelFactory
        ): ListViewModel =
            ViewModelProviders.of(activity, factory).get(ListViewModel::class.java)
    }

    @Module
    class View {
        @Provides
        @PerActivity
        @ForActivity
        fun provideContext(activity: TweetsListActivity): Context = activity
    }
}
