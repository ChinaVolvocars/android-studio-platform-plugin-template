package other.BaseLoadMoreActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.SourceLanguage

fun RecipeExecutor.baseLoadMoreActivityRecipe(
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
    val baseLoadMoreActivity =
      baseLoadMoreActivity(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseLoadMoreActivity, srcOut.resolve("${activityClass}Activity.kt"))
    save(baseLoadMoreActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    val baseListAdapter = baseLoadMoreAdapter(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseListAdapter, srcOut.resolve("${activityClass}Adapter.kt"))
    save(baseLoadMoreAdapterXml(packageName, activityClass), resOut.resolve("layout/item_${layoutName}.xml"))
  } else {
    val baseLoadMoreActivityJava =
      baseLoadMoreActivityJava(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseLoadMoreActivityJava, srcOut.resolve("${activityClass}Activity.java"))
    save(baseLoadMoreActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    val baseLoadMoreAdapterJava =
      baseLoadMoreAdapterJava(projectData.applicationPackage, activityClass, layoutName, packageName)
    save(baseLoadMoreAdapterJava, srcOut.resolve("${activityClass}Adapter.java"))
    save(baseLoadMoreAdapterXml(packageName, activityClass), resOut.resolve("layout/item_${layoutName}.xml"))
  }

}
