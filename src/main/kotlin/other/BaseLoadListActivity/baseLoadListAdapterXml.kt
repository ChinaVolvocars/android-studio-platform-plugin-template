package other.BaseLoadListActivity

fun baseLoadListAdapterXml(
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
		android:layout_height="@dimen/dp_48"
		android:gravity="center_vertical"
		android:padding="@dimen/dp_10"
		android:text="itemView"
		android:textColor="@color/black"
		android:textSize="@dimen/sp_16" />

</LinearLayout>
"""