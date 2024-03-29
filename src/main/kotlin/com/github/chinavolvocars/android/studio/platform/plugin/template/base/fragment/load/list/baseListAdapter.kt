package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list


fun baseListAdapter(
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
import ${applicationPackage}.R
import androidx.recyclerview.widget.RecyclerView
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter
import java.util.*

class ${fragmentClass}Adapter(context: Context?) :
  BaseRecyclerAdapter<String, ${fragmentClass}Adapter.${fragmentClass}Holder>(context) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ${fragmentClass}Holder {
    val view = LayoutInflater.from(context).inflate(R.layout.item_${layoutName}, parent, false)
    return ${fragmentClass}Holder(view)
  }

  override fun onBindViewHolder(holder: ${fragmentClass}Holder, position: Int) {
    super.onBindViewHolder(holder, position)
  }

  class ${fragmentClass}Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

  }

}
"""
