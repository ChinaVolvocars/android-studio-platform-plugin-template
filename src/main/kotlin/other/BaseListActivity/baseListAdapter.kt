package other.BaseListActivity


fun baseListAdapter(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName}

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ${applicationPackage}.R
import androidx.recyclerview.widget.RecyclerView
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter
import java.util.*

class ${activityClass}Adapter(context: Context?) :
  BaseRecyclerAdapter<Objects, ${activityClass}Adapter.${activityClass}Holder>(context) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${activityClass}Holder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_${layoutName}, parent, false)
    return ${activityClass}Holder(view)
  }

  override fun onBindViewHolder(holder: ${activityClass}Holder, position: Int) {
    super.onBindViewHolder(holder, position)
  }

  class ${activityClass}Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  }

}

"""
