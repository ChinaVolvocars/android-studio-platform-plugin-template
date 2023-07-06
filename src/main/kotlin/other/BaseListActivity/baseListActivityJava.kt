package other.BaseListActivity


fun baseListActivityJava(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """

package ${packageName};

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;
import ${applicationPackage}.R;

import io.github.chinavolvocars.common.ui.activity.BaseListActivity;
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;

public class ${activityClass}Activity extends BaseListActivity {

  @Override
  protected int getContentViewLayoutID() {
    return R.layout.${layoutName};
  }

  @Override
  protected void initViewsAndEvents(Bundle savedInstanceState) {
    super.initViewsAndEvents(savedInstanceState);
    setTitle("${layoutName}");
  }

  @Override
  protected BaseRecyclerAdapter<Object, RecyclerView.ViewHolder> getAdapter() {
    ${activityClass}Adapter ${activityClass}Adapter = new ${activityClass}Adapter(mContext);
    return ${activityClass}Adapter;
  }

}
"""
