package com.example.memessharing.deps

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.memessharing.MemesContract
import com.example.memessharing.databinding.ActivityMainBinding
import com.example.memessharing.view.MainActivity
import com.google.android.exoplayer2.SimpleExoPlayer
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.plus

@Module
@InstallIn(ActivityComponent::class)
abstract class MainModule {

    companion object {
        @Provides
        @ActivityScoped
        fun providesMainActivityBinding(@ActivityContext context: Context): ActivityMainBinding {
            return ActivityMainBinding.inflate(LayoutInflater.from(context))
        }

        @Provides
        @ActivityScoped
        fun providesCoroutineScope(): CoroutineScope {
            return MainScope() + CoroutineName("MemesCoroutine")
        }

        @Provides
        @ActivityScoped
        fun providesSimpleExoPlayer(@ActivityContext context: Context): SimpleExoPlayer {
            return SimpleExoPlayer.Builder(context).build()
        }
    }

    @Binds
    @ActivityScoped
    abstract fun providesView(@ActivityContext memeView: MainActivity): MemesContract.MemeView
}
