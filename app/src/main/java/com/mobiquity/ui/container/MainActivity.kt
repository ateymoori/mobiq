package com.mobiquity.ui.container

import android.os.Bundle
import com.mobiquity.R
import com.mobiquity.utils.bases.BaseActivity

class MainActivity : BaseActivity(transparentStatusBar = true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
