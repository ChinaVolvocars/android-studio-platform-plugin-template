package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.refresh

fun baseLoadListFragmentAdapterXml(
  packageName: String,
  activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:orientation="horizontal">
	
	<TextView
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:padding="@dimen/dp_10"
		android:text="itemView" />

</LinearLayout>
"""