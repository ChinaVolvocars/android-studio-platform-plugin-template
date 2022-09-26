package other.BaseLoadMoreFragment

fun baseLoadMoreFragment(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import ${packageName}.R
import android.os.Bundle
import android.view.View
import io.github.ChinaVolvocars.common.ui.adapter.BaseLoadMoreRecyclerAdapter
import io.github.ChinaVolvocars.common.ui.fragment.BaseLoadMoreFragment
import io.github.ChinaVolvocars.common.ui.utils.BaseLoadMoreHelper
import io.reactivex.Observable

class ${fragmentClass}Fragment() : BaseLoadMoreFragment<Any>() {

  lateinit var loadListHelper: BaseLoadMoreHelper<Any>

  override fun getLayoutId(): Int {
    return R.layout.layout_simple_swipe_recycler_view
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
