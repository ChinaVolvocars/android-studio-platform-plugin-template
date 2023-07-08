package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list


fun baseListAdapterJava(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName};

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import ${applicationPackage}.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;

public class ${fragmentClass}Adapter extends BaseRecyclerAdapter<String, RecyclerView.ViewHolder> {

  public ${fragmentClass}Adapter(Context context) {
    super(context);
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater from = LayoutInflater.from(parent.getContext());
    View view = from.inflate(R.layout.item_${layoutName}, parent, false);
    ${fragmentClass}Holder holder = new ${fragmentClass}Holder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    super.onBindViewHolder(holder, position);

  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List payloads) {
    super.onBindViewHolder(holder, position, payloads);

  }

  public class ${fragmentClass}Holder extends RecyclerView.ViewHolder {

    public ${fragmentClass}Holder(@NonNull View itemView) {
      super(itemView);
    }
  }
  
}
"""
