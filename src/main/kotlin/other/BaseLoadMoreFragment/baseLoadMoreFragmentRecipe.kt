package other.BaseLoadMoreFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.baseLoadMoreFragmentRecipe(
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
//  mergeXml(
//      manifestTemplateXml(packageName, activityClass),
//      manifestDir.resolve("AndroidManifest.xml")
//  )

  val baseLoadMoreFragment = baseLoadMoreFragment(projectData.applicationPackage, activityClass, layoutName, packageName)
  save(baseLoadMoreFragment, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
  save(baseLoadMoreFragmentXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
  val baseListAdapter = baseLoadMoreAdapter(projectData.applicationPackage, activityClass, layoutName, packageName)
  save(baseListAdapter, srcOut.resolve("${activityClass}Adapter.${ktOrJavaExt}"))
  save(baseLoadMoreAdapterXml(packageName, activityClass), resOut.resolve("layout/item_${layoutName}.xml"))
}
