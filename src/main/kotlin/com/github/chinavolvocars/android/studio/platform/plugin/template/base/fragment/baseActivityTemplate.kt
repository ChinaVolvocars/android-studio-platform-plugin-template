package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.chinavolvocars.android.studio.platform.plugin.template.SourceLanguage
import other.toSnakeCase

val baseFragmentTemplate
  get() = template {
    name = "Base Fragment"
    description = "Fragments for the Base Fragment framework"
    minApi = MIN_API

    category = Category.Fragment
    formFactor = FormFactor.Mobile
    screens = listOf(
      WizardUiContext.ActivityGallery,
      WizardUiContext.MenuEntry,
      WizardUiContext.NewProject,
      WizardUiContext.NewModule
    )

    lateinit var layoutName: StringParameter

    val fragmentClass = stringParameter {
      name = "fragment Name"
      default = "Main"
      help = "name only，Do not include Fragment"
      constraints = listOf(Constraint.NONEMPTY)
    }

    layoutName = stringParameter {
      name = "Layout Name"
      default = "fragment_main"
      help = "Please enter a name for the layout"
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { fragmentToLayout(fragmentClass.value.toSnakeCase()) }
    }

    val packageName = defaultPackageNameParameter

    val sourceLanguage = enumParameter<SourceLanguage> {
      name = "Source Language"
      default = SourceLanguage.Kotlin
    }


    widgets(
      TextFieldWidget(fragmentClass),
      TextFieldWidget(layoutName),
      PackageNameWidget(packageName),
      EnumWidget(sourceLanguage)
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
      baseFragmentRecipe(
        data as ModuleTemplateData,
        fragmentClass.value,
        layoutName.value,
        packageName.value,
        sourceLanguage.value
      )
    }
  }


val defaultPackageNameParameter
  get() = stringParameter {
    name = "Package name"
    visible = { !isNewModule }
    default = "com.dev996"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
  }
