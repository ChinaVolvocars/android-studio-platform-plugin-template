package other.activity


fun baseActivity(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import ${packageName}.R
import io.github.chinavolvocars.common.ui.activity.BaseActivity

class ${activityClass}Activity : BaseActivity() {

  override fun getContentViewLayoutID(): Int {
    return R.layout.${layoutName}
  }
  
  override fun initViewsAndEvents(savedInstanceState: Bundle?) {
    title = "${layoutName}"
  }

}
   
"""
