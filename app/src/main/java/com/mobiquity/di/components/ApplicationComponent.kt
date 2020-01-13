package com.mobiquity.di.components

import android.app.Application
import com.mobiquity.di.modules.ApplicationModule
import com.mobiquity.di.modules.FragmentModule
import com.mobiquity.utils.bases.MyApplication
import com.pixabay.di.modules.*
import com.mobiquity.di.modules.ViewModelModule
import dagger.Component
import javax.inject.Singleton
import dagger.BindsInstance
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.DaggerApplication

@Singleton
@Component(modules = [ContextModule::class, ApplicationModule::class, AndroidSupportInjectionModule::class, ViewModelModule::class, FragmentModule::class ])
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: MyApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}