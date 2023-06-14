package other.BaseListActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.SourceLanguage
import other.activity.baseActivity
import other.activity.baseActivityJava

fun RecipeExecutor.baseListActivityRecipe(
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


  // 保存Activity
  if (sourceLanguage == SourceLanguage.Kotlin) {
    val baseListActivity =
      baseListActivity(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseListActivity, srcOut.resolve("${activityClass}Activity.kt"))
    val baseListAdapter =
      baseListAdapter(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseListAdapter, srcOut.resolve("${activityClass}Adapter.kt"))
  } else {
    val baseListActivityJava =
      baseListActivityJava(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseListActivityJava, srcOut.resolve("${activityClass}Activity.java"))
    val baseListAdapterJava =
      baseListAdapterJava(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseListAdapterJava, srcOut.resolve("${activityClass}Adapter.java"))
  }


  // 保存xml
  save(baseListActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
  save(
    baseListAdapterXml(packageName, activityClass),
    resOut.resolve("layout/item_${layoutName}.xml")
  )
  // 保存repository
  //save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}
