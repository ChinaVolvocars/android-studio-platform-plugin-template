package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.refresh


fun baseLoadListFragmentJava(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName};

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import ${applicationPackage}.R

import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;
import io.github.chinavolvocars.common.ui.adapter.OnRecyclerItemClickListener;
import io.github.chinavolvocars.common.ui.fragment.BaseLoadListFragment;
import io.github.chinavolvocars.common.ui.utils.BaseLoadListHelper;
import io.reactivex.Observable;

public class ${fragmentClass}Fragment extends BaseLoadListFragment<Object> {

  private BaseLoadListHelper<Object> baseLoadListHelper;

  @Override
  protected int getLayoutId() {
    return R.layout.${layoutName};
  }

  @Override
  protected void initViewsAndEvents(View root, @Nullable Bundle savedInstanceState) {
    super.initViewsAndEvents(root, savedInstanceState);
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
    baseLoadListHelper.loadData();
  }

  @Override
  protected BaseRecyclerAdapter getAdapter() {
    ${fragmentClass}Adapter adapter = new ${fragmentClass}Adapter(mActivity);
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
