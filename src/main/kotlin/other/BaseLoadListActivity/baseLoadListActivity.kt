package other.BaseLoadListActivity


fun baseLoadListActivity(
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

class ${activityClass}Activity : BaseLoadListActivity<Objects>() {

  override fun getContentViewLayoutID(): Int {
    return R.layout.${layoutName}
  }

  private lateinit var loadListHelper: BaseLoadListHelper<Objects>

  override fun initViewsAndEvents(savedInstanceState: Bundle?) {
    super.initViewsAndEvents(savedInstanceState)
    loadListHelper = object : BaseLoadListHelper<Objects>(this, this) {
      override fun load(): Observable<out Collection<Objects>> {
        return TODO()
      }
    }
  }

  override fun getAdapter(): BaseRecyclerAdapter<Objects, ${activityClass}Adapter.${activityClass}Holder> {
    val adapter = ${activityClass}Adapter(mContext)
    return adapter
  }

  override fun loadData() {
    loadListHelper.loadData()
  }
}
"""
