package com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list


fun baseListActivity(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import ${applicationPackage}.R
import io.github.chinavolvocars.common.ui.activity.BaseListActivity
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter
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
