package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.more

fun baseLoadMoreFragment(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import ${applicationPackage}.R
import android.os.Bundle
import android.view.View
import io.github.chinavolvocars.common.ui.adapter.BaseLoadMoreRecyclerAdapter
import io.github.chinavolvocars.common.ui.fragment.BaseLoadMoreFragment
import io.github.chinavolvocars.common.ui.utils.BaseLoadMoreHelper
import io.reactivex.Observable

class ${fragmentClass}Fragment() : BaseLoadMoreFragment<Any>() {

  lateinit var loadListHelper: BaseLoadMoreHelper<Any>

  override fun getLayoutId(): Int {
    return R.layout.$layoutName
  }

  override fun initViewsAndEvents(root: View?, savedInstanceState: Bundle?) {
    super.initViewsAndEvents(root, savedInstanceState)
    loadListHelper = object : BaseLoadMoreHelper<Any>(this, this) {
      override fun load(pageIndex: Int, pageSize: Int): Observable<out MutableCollection<Any>?> {
        return TODO()
      }
    }
    loadListHelper.loadData()
  }

  override fun getAdapter(): BaseLoadMoreRecyclerAdapter<Any> {
    val adapter = ${fragmentClass}Adapter(mActivity)
    return adapter
  }

  override fun scrollLoadMore() {
    loadListHelper.loadDataMore()
  }

  override fun pullLoad() {
    loadListHelper.loadData()
  }
}

"""
