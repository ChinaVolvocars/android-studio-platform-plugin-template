package com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list

fun baseListActivityXml(
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
	
	<androidx.recyclerview.widget.RecyclerView
		android:id="@id/recycler_view"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:clipToPadding="false"
		android:paddingBottom="15dp" />

</LinearLayout>
"""