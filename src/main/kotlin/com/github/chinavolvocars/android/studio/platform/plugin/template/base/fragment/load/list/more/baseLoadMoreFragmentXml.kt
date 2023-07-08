package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.more

fun baseLoadMoreFragmentXml(
  packageName: String,
  activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	android:orientation="vertical">
	
	<include layout="@layout/layout_simple_swipe_recycler_view" />

</LinearLayout>
"""