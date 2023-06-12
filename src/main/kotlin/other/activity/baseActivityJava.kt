package other.activity


fun baseActivityJava(
  applicationPackage: String?,
  activityClass: String,
  layoutName: String,
  packageName: String
) = """

package ${packageName};

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ${packageName}.R;
import io.github.chinavolvocars.common.ui.activity.BaseActivity;

public class ${activityClass}Activity extends BaseActivity {

  @Override
  protected int getContentViewLayoutID() {
    return R.layout.${layoutName};
  }

  @Override
  protected void initViewsAndEvents(Bundle savedInstanceState) {
        setTitle("${layoutName}");
  }
  
}
   
"""
