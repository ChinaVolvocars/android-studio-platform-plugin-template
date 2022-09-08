package other.BaseListActivity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.baseListActivityRecipe(
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

  val baseListActivity =
    baseListActivity(projectData.applicationPackage, activityClass, layoutName, packageName)
  // 保存Activity
  save(baseListActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
  // 保存xml
  save(baseListActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
  val baseListAdapter =
    baseListAdapter(projectData.applicationPackage, activityClass, layoutName, packageName)
  save(baseListAdapter, srcOut.resolve("${activityClass}Adapter.${ktOrJavaExt}"))
  save(baseListAdapterXml(packageName, activityClass), resOut.resolve("layout/item_${layoutName}.xml"))
  // 保存repository
  //save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}
