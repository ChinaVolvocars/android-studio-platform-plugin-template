package other.BaseLoadMoreActivity

fun baseLoadMoreActivity(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import ${packageName}.R
import io.github.ChinaVolvocars.common.ui.activity.BaseLoadListActivity
import io.github.ChinaVolvocars.common.ui.adapter.BaseRecyclerAdapter
import io.github.ChinaVolvocars.common.ui.utils.BaseLoadListHelper
import io.reactivex.Observable
import java.util.*

class ${activityClass}Activity : BaseLoadMoreActivity<Objects>() {

  override fun getContentViewLayoutID(): Int {
    return R.layout.${layoutName}
  }

  private lateinit var loadMoreHelper: BaseLoadMoreHelper<String>
  
  override fun initViewsAndEvents(savedInstanceState: Bundle?) {
    super.initViewsAndEvents(savedInstanceState)
    loadMoreHelper = object : BaseLoadMoreHelper<String>(this, this) {
      override fun load(pageIndex: Int, pageSize: Int): Observable<out MutableCollection<String>> {
        return TODO()
      }
    }
  }

  override fun getAdapter(): BaseLoadMoreRecyclerAdapter<String> {
    return TODO()
  }

  override fun scrollLoadMore() {
    loadMoreHelper.loadDataMore()
  }

  override fun pullLoad() {
    loadMoreHelper.loadData()
  }
  
}
"""
