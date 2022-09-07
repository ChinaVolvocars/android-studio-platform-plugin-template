package other.activity

import com.android.tools.idea.npw.module.recipes.generateManifest
import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.baseActivityRecipe(
  moduleData: ModuleTemplateData,
  activityClass: String,
  layoutName: String,
  packageName: String
) {
  val (projectData, srcOut, resOut,manifestDir) = moduleData
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
  mergeXml(manifestTemplateXml(packageName, activityClass), manifestDir.resolve("AndroidManifest.xml"))

  val baseActivity =
    baseActivity(projectData.applicationPackage, activityClass, layoutName, packageName)
  // 保存Activity
  save(baseActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
  // 保存xml
  save(baseActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
  // 保存viewmodel
  //save(mvvmViewModel(packageName, activityClass), srcOut.resolve("${activityClass}ViewModel.${ktOrJavaExt}"))
  // 保存repository
  //save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}
