package other.BaseFragment


fun baseFragmentJava(
  applicationPackage: String?,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) = """
package ${packageName};

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import io.github.chinavolvocars.common.ui.fragment.BaseFragment;
import ${applicationPackage}.R;

public class ${fragmentClass}Fragment extends BaseFragment {
  @Override
  protected int getLayoutId() {
    return R.layout.${layoutName};
  }

  @Override
  protected void initViewsAndEvents(View root, @Nullable Bundle savedInstanceState) {

  }
}  
"""
