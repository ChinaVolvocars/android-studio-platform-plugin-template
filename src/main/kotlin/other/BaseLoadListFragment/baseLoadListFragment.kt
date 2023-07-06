package other.BaseLoadListFragment


fun baseLoadListFragment(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.os.Bundle
import android.view.View
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter
import io.github.chinavolvocars.common.ui.fragment.BaseLoadListFragment
import io.github.chinavolvocars.common.ui.utils.BaseLoadListHelper
import io.reactivex.Observable
import ${applicationPackage}.R

class ${fragmentClass}Fragment : BaseLoadListFragment<Any>() {

  override fun getLayoutId(): Int {
    return R.layout.${layoutName}
  }

  private lateinit var loadListHelper: BaseLoadListHelper<Any>

  override fun initViewsAndEvents(root: View?, savedInstanceState: Bundle?) {
    super.initViewsAndEvents(root, savedInstanceState)
    loadListHelper = object : BaseLoadListHelper<Any>(this, this) {
      override fun load(): Observable<out Collection<Any>> {
        return TODO()
      }
    }
  }

  override fun getAdapter(): BaseRecyclerAdapter<Any, ${fragmentClass}Adapter.${fragmentClass}Holder> {
    val adapter = ${fragmentClass}Adapter(mActivity)
    return adapter
  }

  override fun loadData() {
    loadListHelper.loadData()
  }
}
"""
