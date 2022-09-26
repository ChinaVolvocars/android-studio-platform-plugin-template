package other.BaseLoadMoreFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.baseLoadMoreFragmentRecipe(
  moduleData: ModuleTemplateData,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) {
  val (projectData, srcOut, resOut, manifestDir) = moduleData
  val ktOrJavaExt = projectData.language.extension

  val baseLoadMoreFragment =
    baseLoadMoreFragment(projectData.applicationPackage, fragmentClass, layoutName, packageName)
  save(baseLoadMoreFragment, srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
  //save(baseLoadMoreFragmentXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
  val baseListAdapter = baseLoadMoreAdapter(projectData.applicationPackage, fragmentClass, layoutName, packageName)
  save(baseListAdapter, srcOut.resolve("${fragmentClass}Adapter.${ktOrJavaExt}"))
  save(baseLoadMoreAdapterXml(packageName, fragmentClass), resOut.resolve("layout/item_${layoutName}.xml"))
}
