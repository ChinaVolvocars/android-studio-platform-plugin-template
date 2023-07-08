package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list

fun baseListFragmentXml(
  packageName: String,
  activityClass: String
) = """
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
	android:layout_width="match_parent"
	android:layout_height="match_parent">
	
	<androidx.recyclerview.widget.RecyclerView
		android:id="@id/recycler_view"
		android:layout_width="match_parent"
		android:layout_height="match_parent"
		android:clipToPadding="false"
		android:paddingBottom="15dp" />
	
	<io.github.chinavolvocars.empty.EmptyView
		android:id="@id/empty_view"
		android:layout_width="match_parent"
		android:layout_height="match_parent" />

</FrameLayout>
"""