package com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list.more

fun manifestTemplateXml(packageName: String, activityClassName: String) = """
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:tools="http://schemas.android.com/tools">
    <application>
      <activity
        android:name="$packageName.${activityClassName}Activity"
        android:exported="false"
        android:screenOrientation="portrait"
        android:windowSoftInputMode="adjustResize|stateHidden|stateUnspecified" />
    </application>
</manifest>
"""