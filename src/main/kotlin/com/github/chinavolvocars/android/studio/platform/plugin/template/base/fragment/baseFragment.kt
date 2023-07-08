package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment


fun baseFragment(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import android.view.View
import io.github.chinavolvocars.common.ui.fragment.BaseFragment
import ${applicationPackage}.R

class ${fragmentClass}Fragment : BaseFragment() {
  override fun getLayoutId(): Int {
    return R.layout.${layoutName}
  }

  override fun initViewsAndEvents(root: View?, savedInstanceState: Bundle?) {
    
  }
}
   
"""
