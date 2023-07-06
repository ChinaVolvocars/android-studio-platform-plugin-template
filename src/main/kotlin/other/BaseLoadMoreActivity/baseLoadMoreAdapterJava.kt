package other.BaseLoadMoreActivity

fun baseLoadMoreAdapterJava(
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

import io.github.chinavolvocars.common.ui.adapter.BaseLoadMoreRecyclerAdapter;

public class ${activityClass}Adapter extends BaseLoadMoreRecyclerAdapter<Object> {

  public ${activityClass}Adapter(Context context) {
    super(context);
  }

  @Override
  protected RecyclerView.ViewHolder onCreateViewHolderCustom(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.item_${layoutName}, parent, false);
    ${activityClass}Holder holder = new ${activityClass}Holder(view);
    return holder;

  }

  @Override
  protected void onBindViewHolderCustom(RecyclerView.ViewHolder holder, int position) {
    super.onBindViewHolderCustom(holder, position);

  }

  public class ${activityClass}Holder extends RecyclerView.ViewHolder {

    public ${activityClass}Holder(@NonNull View itemView) {
      super(itemView);
    }
  }

}

"""
