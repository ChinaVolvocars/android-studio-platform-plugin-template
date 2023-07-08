package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list


fun baseListFragment(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import android.view.View
import ${packageName}.${fragmentClass}Adapter
import ${applicationPackage}.R
import io.github.chinavolvocars.common.ui.fragment.BaseListFragment
import io.github.chinavolvocars.common.ui.utils.BaseLoadHelper
import io.reactivex.Observable

class ${fragmentClass}Fragment : BaseListFragment<String>() {

  private var baseLoadHelper: BaseLoadHelper<String>? = null

  override fun getLayoutId(): Int {
    return R.layout.${layoutName}
  }

  override fun initViewsAndEvents(root: View?, savedInstanceState: Bundle?) {
    super.initViewsAndEvents(root, savedInstanceState)
    baseLoadHelper = object : BaseLoadHelper<String>(this, this) {
      override fun load(): Observable<out MutableCollection<String>?> {
        val objects = ArrayList<String>()
        for (i in 0..9) {
          objects.add(String())
        }
        return Observable.just(objects)
      }
    }
    baseLoadHelper?.loadData()
  }

  override fun getAdapter(): ${fragmentClass}Adapter {
    val adapter = ${fragmentClass}Adapter(mActivity)
    adapter.setOnItemClickListener { view, position -> }
    return adapter
  }

  override fun loadData() {
    baseLoadHelper?.loadData()
  }
}
"""
