package com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list.refresh

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.chinavolvocars.android.studio.platform.plugin.template.SourceLanguage

fun RecipeExecutor.baseLoadListActivityRecipe(
  moduleData: ModuleTemplateData,
  activityClass: String,
  layoutName: String,
  packageName: String,
  sourceLanguage: Any,
) {
  val (projectData, srcOut, resOut, manifestDir) = moduleData
  val ktOrJavaExt = projectData.language.extension
  /*    generateManifest(
              moduleData = moduleData,
              activityClass = "${activityClass}Activity",
              activityTitle = activityClass,
              packageName = packageName,
              isLauncher = false,
              hasNoActionBar = false,
              generateActivityTitle = true,
              requireTheme = false,
              useMaterial2 = false
      )*/
  mergeXml(
    manifestTemplateXml(packageName, activityClass),
    manifestDir.resolve("AndroidManifest.xml")
  )

  if (sourceLanguage == SourceLanguage.Kotlin) {
    val baseLoadListActivity =
      baseLoadListActivity(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseLoadListActivity, srcOut.resolve("${activityClass}Activity.kt"))
    save(
      baseLoadListActivityXml(packageName, activityClass),
      resOut.resolve("layout/${layoutName}.xml")
    )
    val baseListAdapter =
      baseLoadListAdapter(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseListAdapter, srcOut.resolve("${activityClass}Adapter.kt"))
    save(
      baseLoadListAdapterXml(packageName, activityClass),
      resOut.resolve("layout/item_${layoutName}.xml")
    )
  } else {
    val baseLoadListActivity =
      baseLoadListActivityJava(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseLoadListActivity, srcOut.resolve("${activityClass}Activity.java"))
    save(
      baseLoadListActivityXml(packageName, activityClass),
      resOut.resolve("layout/${layoutName}.xml")
    )
    val baseLoadListAdapterJava =
      baseLoadListAdapterJava(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseLoadListAdapterJava, srcOut.resolve("${activityClass}Adapter.java"))
    save(
      baseLoadListAdapterXml(packageName, activityClass),
      resOut.resolve("layout/item_${layoutName}.xml")
    )
  }


}
