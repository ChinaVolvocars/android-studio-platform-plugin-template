package other.BaseLoadMoreActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.baseLoadMoreActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String
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

  val baseLoadMoreActivity = baseLoadMoreActivity(projectData.applicationPackage, activityClass, layoutName, packageName)
  save(baseLoadMoreActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
  save(baseLoadMoreActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
  val baseListAdapter = baseLoadMoreAdapter(projectData.applicationPackage, activityClass, layoutName, packageName)
  save(baseListAdapter, srcOut.resolve("${activityClass}Adapter.${ktOrJavaExt}"))
  save(baseLoadMoreAdapterXml(packageName, activityClass), resOut.resolve("layout/item_${layoutName}.xml"))
}
