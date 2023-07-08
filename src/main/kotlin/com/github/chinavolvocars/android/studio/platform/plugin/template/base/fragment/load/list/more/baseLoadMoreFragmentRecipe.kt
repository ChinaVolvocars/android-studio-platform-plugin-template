package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.more

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.chinavolvocars.android.studio.platform.plugin.template.SourceLanguage

fun RecipeExecutor.baseLoadMoreFragmentRecipe(
  moduleData: ModuleTemplateData,
  fragmentClass: String,
  layoutName: String,
  packageName: String,
  sourceLanguage: Any,
) {
  val (projectData, srcOut, resOut, manifestDir) = moduleData
  val ktOrJavaExt = projectData.language.extension
  if (sourceLanguage == SourceLanguage.Kotlin) {
    val baseLoadMoreFragment =
      baseLoadMoreFragment(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseLoadMoreFragment, srcOut.resolve("${fragmentClass}Fragment.kt"))
    save(baseLoadMoreFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
    val baseListAdapter = baseLoadMoreAdapter(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseListAdapter, srcOut.resolve("${fragmentClass}Adapter.kt"))
    save(baseLoadMoreAdapterXml(packageName, fragmentClass), resOut.resolve("layout/item_${layoutName}.xml"))
  } else {
    val baseLoadMoreFragmentJava =
      baseLoadMoreFragmentJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseLoadMoreFragmentJava, srcOut.resolve("${fragmentClass}Fragment.java"))
    save(baseLoadMoreFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
    val baseLoadMoreAdapterJava =
      baseLoadMoreAdapterJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseLoadMoreAdapterJava, srcOut.resolve("${fragmentClass}Adapter.java"))
    save(baseLoadMoreAdapterXml(packageName, fragmentClass), resOut.resolve("layout/item_${layoutName}.xml"))
  }

}
