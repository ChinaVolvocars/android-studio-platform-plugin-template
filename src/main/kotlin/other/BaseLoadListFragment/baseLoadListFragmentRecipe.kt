package other.BaseLoadListFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor

fun RecipeExecutor.baseLoadListFragmentRecipe(
  moduleData: ModuleTemplateData,
  fragmentClass: String,
  layoutName: String,
  packageName: String
) {
  val (projectData, srcOut, resOut, manifestDir) = moduleData
  val ktOrJavaExt = projectData.language.extension

  val baseLoadListFragment =
    baseLoadListFragment(projectData.applicationPackage, fragmentClass, layoutName, packageName)
  save(baseLoadListFragment, srcOut.resolve("${fragmentClass}Fragment.${ktOrJavaExt}"))
  save(baseLoadListFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
  val baseListAdapter =
    baseLoadListFragmentAdapter(projectData.applicationPackage, fragmentClass, layoutName, packageName)
  save(baseListAdapter, srcOut.resolve("${fragmentClass}Adapter.${ktOrJavaExt}"))
  save(baseLoadListFragmentAdapterXml(packageName, fragmentClass), resOut.resolve("layout/item_${layoutName}.xml"))
}
