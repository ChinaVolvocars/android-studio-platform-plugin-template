package other.BaseFragment


fun baseFragment(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import android.view.View
import io.github.ChinaVolvocars.common.ui.fragment.BaseFragment

class ${fragmentClass}Fragment : BaseFragment() {
  override fun getLayoutId(): Int {
    return R.layout.${layoutName}
  }

  override fun initViewsAndEvents(root: View?, savedInstanceState: Bundle?) {
    
  }
}
   
"""
