package other.BaseListActivity


fun baseListActivity(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import ${applicationPackage}.R
import io.github.ChinaVolvocars.common.ui.activity.BaseListActivity
import io.github.ChinaVolvocars.common.ui.adapter.BaseRecyclerAdapter
import java.util.*

class ${activityClass}Activity : BaseListActivity() {

  override fun getContentViewLayoutID(): Int {
    return R.layout.${layoutName}
  }

  override fun initViewsAndEvents(savedInstanceState: Bundle?) {
    super.initViewsAndEvents(savedInstanceState)
  }

  override fun getAdapter(): BaseRecyclerAdapter<Objects, ${activityClass}Adapter.${activityClass}Holder> {
    return ${activityClass}Adapter(mContext)
  }
}

"""
