package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list


fun baseListFragmentJava(
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

import ${packageName}.${fragmentClass}Adapter;
import ${applicationPackage}.R;
import io.github.chinavolvocars.common.ui.adapter.BaseRecyclerAdapter;
import io.github.chinavolvocars.common.ui.adapter.OnRecyclerItemClickListener;
import io.github.chinavolvocars.common.ui.fragment.BaseListFragment;
import io.github.chinavolvocars.common.ui.utils.BaseLoadHelper;
import io.reactivex.Observable;

public class ${fragmentClass}Fragment extends BaseListFragment<String> {

  private BaseLoadHelper<String> baseLoadHelper;

  @Override
  protected int getLayoutId() {
    return R.layout.${layoutName};
  }

  @Override
  protected void initViewsAndEvents(View root, @Nullable Bundle savedInstanceState) {
    super.initViewsAndEvents(root, savedInstanceState);
    baseLoadHelper = new BaseLoadHelper<String>(this, this) {
      @Override
      protected Observable<? extends Collection<String>> load() {
        ArrayList<String> objects = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
          objects.add(new String());
        }
        return Observable.just(objects);
      }
    };
    baseLoadHelper.loadData();
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
    baseLoadHelper.loadData();
  }

}
"""
