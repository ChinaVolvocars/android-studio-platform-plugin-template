package other.BaseLoadListFragment

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.SourceLanguage

fun RecipeExecutor.baseLoadListFragmentRecipe(
  moduleData: ModuleTemplateData,
  fragmentClass: String,
  layoutName: String,
  packageName: String,
  sourceLanguage: Any
) {
  val (projectData, srcOut, resOut, manifestDir) = moduleData
  val ktOrJavaExt = projectData.language.extension

  if (sourceLanguage == SourceLanguage.Kotlin) {
    val baseLoadListFragment =
      baseLoadListFragment(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseLoadListFragment, srcOut.resolve("${fragmentClass}Fragment.kt"))
    save(baseLoadListFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
    val baseListAdapter =
      baseLoadListFragmentAdapter(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseListAdapter, srcOut.resolve("${fragmentClass}Adapter.kt"))
    save(baseLoadListFragmentAdapterXml(packageName, fragmentClass), resOut.resolve("layout/item_${layoutName}.xml"))
  } else {
    val baseLoadListFragmentJava =
      baseLoadListFragmentJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseLoadListFragmentJava, srcOut.resolve("${fragmentClass}Fragment.java"))
    save(baseLoadListFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
    val baseLoadListAdapterJava =
      baseLoadListAdapterJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseLoadListAdapterJava, srcOut.resolve("${fragmentClass}Adapter.java"))
    save(baseLoadListFragmentAdapterXml(packageName, fragmentClass), resOut.resolve("layout/item_${layoutName}.xml"))
  }


}
