package com.mobiquity.ui.products_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.flyco.tablayout.listener.OnTabSelectListener
import com.mobiquity.R
import com.mobiquity.utils.adapters.BannersAdapter
import com.mobiquity.utils.adapters.ResultsAdapter
import com.mobiquity.utils.bases.Constants.Companion.ITEM_BUNDLE
import com.mobiquity.utils.entities.*
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_products_list.*
import javax.inject.Inject

class ProductsListFragment : Fragment(), ProductListContract, ResultsAdapter.OnItemClick,
    OnTabSelectListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var productsAdapter: ResultsAdapter
    @Inject
    lateinit var bannersAdapter: BannersAdapter

    private lateinit var viewModel: ProductsListViewModel
    private lateinit var categories: List<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_products_list, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidSupportInjection.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = productsAdapter.apply { itemClick = this@ProductsListFragment }
        banners.adapter = bannersAdapter
        catList.setOnTabSelectListener(this)

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ProductsListViewModel::class.java)
                .apply {
                    navigator = this@ProductsListFragment
                    onViewCreated()
                }

        viewModel.getProducts().also {
            observerVM()
        }


    }

    override fun onLoadCategories(categories: List<String>) {
        this.categories = categories
        catList.setTabData(categories.toTypedArray())
    }


    private fun observerVM() {
        viewModel.result.observe(this, Observer {
            when (it) {
                is Success -> {
                    productsAdapter.items = (it.data as List<ProductModel>)
                }
                is ErrorIn -> {
                }
                is Loading -> {
                }
            }
        })
    }

    override fun loadBanners(banners: List<BannerModel>) {
        bannersAdapter.items = banners
    }

    override fun onItemClick(item: ProductModel) {
        Navigation.findNavController(list).navigate(
            R.id.action_productsListFragment_to_productDetailFragment,
            bundleOf(ITEM_BUNDLE to item)
        )
    }

    override fun onTabSelect(position: Int) {
        viewModel.onCategorySelect(categories[position])
    }

    override fun onTabReselect(position: Int) {
        viewModel.onCategorySelect(categories[position])
    }

}
