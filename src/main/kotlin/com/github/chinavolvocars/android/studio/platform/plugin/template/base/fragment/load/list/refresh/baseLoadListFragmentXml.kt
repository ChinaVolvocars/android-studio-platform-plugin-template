package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.refresh

fun baseLoadListFragmentXml(
  packageName: String,
  fragmentClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	xmlns:tools="http://schemas.android.com/tools"
	android:layout_width="match_parent"
	android:layout_height="match_parent"
	android:orientation="vertical"
    tools:context="${packageName}.${fragmentClass}Activity">
	
	<include layout="@layout/actionbar_common2" />
	
	<include layout="@layout/layout_simple_swipe_recycler_view" />

</LinearLayout>
"""