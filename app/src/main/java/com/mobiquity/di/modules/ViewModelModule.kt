package com.mobiquity.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mobiquity.di.base.ViewModelFactory
import com.mobiquity.di.base.ViewModelKey
import com.mobiquity.ui.products_list.ProductsListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ProductsListViewModel::class)
    internal abstract fun productListVM(viewModel: ProductsListViewModel): ViewModel


}