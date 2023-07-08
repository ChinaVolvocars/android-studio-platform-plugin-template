package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.github.chinavolvocars.android.studio.platform.plugin.template.SourceLanguage

fun RecipeExecutor.baseListFragmentRecipe(
  moduleData: ModuleTemplateData,
  fragmentClass: String,
  layoutName: String,
  packageName: String,
  sourceLanguage: Any,
) {
  val (projectData, srcOut, resOut, manifestDir) = moduleData
//  val ktOrJavaExt = projectData.language.extension
  if (sourceLanguage == SourceLanguage.Kotlin) {
    val baseListFragment =
      baseListFragment(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseListFragment, srcOut.resolve("${fragmentClass}Fragment.kt"))
    val baseListAdapter =
      baseListAdapter(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseListAdapter, srcOut.resolve("${fragmentClass}Adapter.kt"))
  } else {
    val baseListFragmentJava =
      baseListFragmentJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseListFragmentJava, srcOut.resolve("${fragmentClass}Fragment.java"))
    val baseListAdapterJava =
      baseListAdapterJava(projectData.applicationPackage, fragmentClass, layoutName, packageName)
    save(baseListAdapterJava, srcOut.resolve("${fragmentClass}Adapter.java"))
  }
  save(baseListFragmentXml(packageName, fragmentClass), resOut.resolve("layout/${layoutName}.xml"))
  save(
    baseListAdapterXml(packageName, fragmentClass),
    resOut.resolve("layout/item_${layoutName}.xml")
  )
}
