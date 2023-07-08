package com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list.refresh


fun baseLoadListAdapterJava(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName};

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;
import ${applicationPackage}.R;
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;

public class ${activityClass}Adapter extends BaseRecyclerAdapter<Objects, ${activityClass}Adapter.${activityClass}Holder> {

  public ${activityClass}Adapter(Context context) {
    super(context);
  }

  @NonNull
  @Override
  public ${activityClass}Adapter.${activityClass}Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_${layoutName}, parent, false);
    ${activityClass}Holder holder = new ${activityClass}Holder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(${activityClass}Holder holder, int position) {
    super.onBindViewHolder(holder, position);
  }

  @Override
  public void onBindViewHolder(@NonNull ${activityClass}Holder holder, int position, @NonNull List<Object> payloads) {
    super.onBindViewHolder(holder, position, payloads);
  }

  public class ${activityClass}Holder extends RecyclerView.ViewHolder {

    public ${activityClass}Holder(@NonNull View itemView) {
      super(itemView);
    }

  }

}
"""
