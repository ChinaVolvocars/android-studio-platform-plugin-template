package other.BaseLoadMoreActivity

fun baseLoadMoreActivityXml(
  packageName: String,
  activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	android:orientation="vertical"
    tools:context="${packageName}.${activityClass}Activity">
	
	<include layout="@layout/actionbar_common2" />
	
	<include layout="@layout/layout_simple_swipe_recycler_view" />

</LinearLayout>
"""