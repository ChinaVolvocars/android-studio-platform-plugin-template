package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.more

fun baseLoadMoreAdapterJava(
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

import io.github.chinavolvocars.common.ui.adapter.BaseLoadMoreRecyclerAdapter;

public class ${fragmentClass}Adapter extends BaseLoadMoreRecyclerAdapter<Object> {

  public ${fragmentClass}Adapter(Context context) {
    super(context);
  }

  @Override
  protected RecyclerView.ViewHolder onCreateViewHolderCustom(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_${layoutName}, parent, false);
    ${fragmentClass}Holder holder = new ${fragmentClass}Holder(view);
    return holder;

  }

  @Override
  protected void onBindViewHolderCustom(RecyclerView.ViewHolder holder, int position) {
    super.onBindViewHolderCustom(holder, position);

  }

  public class ${fragmentClass}Holder extends RecyclerView.ViewHolder {

    public ${fragmentClass}Holder(@NonNull View itemView) {
      super(itemView);
    }
  }

}

"""
