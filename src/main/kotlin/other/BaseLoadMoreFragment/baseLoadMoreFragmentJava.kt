package other.BaseLoadMoreFragment

fun baseLoadMoreFragmentJava(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName};

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import ${applicationPackage}.R;
import java.util.ArrayList;
import java.util.Collection;

import io.github.chinavolvocars.common.ui.adapter.BaseLoadMoreRecyclerAdapter;
import io.github.chinavolvocars.common.ui.adapter.OnRecyclerItemClickListener;
import io.github.chinavolvocars.common.ui.fragment.BaseLoadMoreFragment;
import io.github.chinavolvocars.common.ui.utils.BaseLoadMoreHelper;
import io.reactivex.Observable;

public class ${fragmentClass}Fragment extends BaseLoadMoreFragment<Object> {

  private BaseLoadMoreHelper<Object> baseLoadMoreHelper;

  @Override
  protected int getLayoutId() {
    return R.layout.$layoutName;
  }

  @Override
  protected void initViewsAndEvents(View root, @Nullable Bundle savedInstanceState) {
    super.initViewsAndEvents(root, savedInstanceState);
    baseLoadMoreHelper = new BaseLoadMoreHelper<Object>(this, this) {
      @Override
      protected Observable<? extends Collection<Object>> load(int pageIndex, int pageSize) {
        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
          objects.add(new Object());
        }
        return Observable.just(objects);
      }
    };
    baseLoadMoreHelper.loadData();
  }

  @Override
  protected BaseLoadMoreRecyclerAdapter<Object> getAdapter() {
    ${fragmentClass}Adapter adapter = new ${fragmentClass}Adapter(mActivity);
    adapter.setOnItemClickListener(new OnRecyclerItemClickListener() {
      @Override
      public void onItemClick(View view, int position) {

      }
    });
    return adapter;
  }

  @Override
  protected void scrollLoadMore() {
    baseLoadMoreHelper.loadDataMore();
  }

  @Override
  protected void pullLoad() {
    baseLoadMoreHelper.loadData();
  }
}
"""
