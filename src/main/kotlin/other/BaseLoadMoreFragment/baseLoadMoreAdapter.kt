package other.BaseLoadMoreFragment

fun baseLoadMoreAdapter(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.chinavolvocars.common.ui.adapter.BaseLoadMoreRecyclerAdapter
import ${applicationPackage}.R

class ${fragmentClass}Adapter(context: Context?) : BaseLoadMoreRecyclerAdapter<Any>(context) {
  override fun onCreateViewHolderCustom(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val view = inflater.inflate(R.layout.item_${layoutName}, parent, false)
    return ${fragmentClass}Holder(view)
  }

  override fun onBindViewHolderCustom(holder: RecyclerView.ViewHolder, position: Int) {
    super.onBindViewHolderCustom(holder, position)
  }

  inner class ${fragmentClass}Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {}
  }
}
"""
