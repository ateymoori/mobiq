package com.mobiquity.di.modules

import com.mobiquity.ui.product_detail.ProductDetailFragment
import com.mobiquity.ui.products_list.ProductsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    internal abstract fun contributeProductListFragment(): ProductsListFragment

    @ContributesAndroidInjector
    internal abstract fun contributeProductsDetailFragment(): ProductDetailFragment

}