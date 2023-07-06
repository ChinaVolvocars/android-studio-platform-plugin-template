package other.BaseLoadListFragment


fun baseLoadListAdapterJava(
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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Objects;
import ${applicationPackage}.R

import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;

public class ${fragmentClass}Adapter extends BaseRecyclerAdapter<Objects, ${fragmentClass}Adapter.${fragmentClass}Holder> {

  public ${fragmentClass}Adapter(Context context) {
    super(context);
  }

  @NonNull
  @Override
  public ${fragmentClass}Adapter.${fragmentClass}Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_${layoutName}, parent, false);
    ${fragmentClass}Holder holder = new ${fragmentClass}Holder(view);
    return holder;
  }

  @Override
  public void onBindViewHolder(${fragmentClass}Holder holder, int position) {
    super.onBindViewHolder(holder, position);
  }

  @Override
  public void onBindViewHolder(@NonNull ${fragmentClass}Holder holder, int position, @NonNull List<Object> payloads) {
    super.onBindViewHolder(holder, position, payloads);
  }

  public class ${fragmentClass}Holder extends RecyclerView.ViewHolder {

    public ${fragmentClass}Holder(@NonNull View itemView) {
      super(itemView);
    }

  }

}
"""
