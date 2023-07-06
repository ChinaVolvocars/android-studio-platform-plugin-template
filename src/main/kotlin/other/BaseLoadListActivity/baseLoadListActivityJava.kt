package other.BaseLoadListActivity


fun baseLoadListActivityJava(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName};

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collection;

import io.github.ChinaVolvocars.app.R;
import io.github.chinavolvocars.common.ui.activity.BaseLoadListActivity;
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;
import io.github.chinavolvocars.common.ui.adapter.OnRecyclerItemClickListener;
import io.github.chinavolvocars.common.ui.utils.BaseLoadListHelper;
import io.reactivex.Observable;

public class ${activityClass}Activity extends BaseLoadListActivity<Object> {

  private BaseLoadListHelper<Object> baseLoadListHelper;

  @Override
  protected int getContentViewLayoutID() {
    return R.layout.${layoutName};
  }
  
  @Override
  protected void initViewsAndEvents(Bundle savedInstanceState) {
    super.initViewsAndEvents(savedInstanceState);
    setTitle("${activityClass}");

    baseLoadListHelper = new BaseLoadListHelper<Object>(this, this) {
      @Override
      protected Observable<? extends Collection<Object>> load() {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
          objects.add(new Object());
        }
        return Observable.just(objects);
      }
    };
  }

  @Override
  protected BaseRecyclerAdapter getAdapter() {
    ${activityClass}Adapter adapter = new ${activityClass}Adapter(mContext);
    adapter.setOnItemClickListener(new OnRecyclerItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {

      }
    });
    return adapter;
  }

  @Override
  protected void loadData() {
    baseLoadListHelper.loadData();
  }
}



"""
