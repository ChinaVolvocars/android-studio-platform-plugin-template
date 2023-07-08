package com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import com.github.chinavolvocars.android.studio.platform.plugin.template.SourceLanguage
import other.toSnakeCase

val baseListFragmentTemplate
  get() = template {
    name = "Base List Fragment"
    description = "Fragments for the Base List Fragment framework"
    minApi = MIN_API

    category = Category.Fragment
    formFactor = FormFactor.Mobile
    screens = listOf(
      WizardUiContext.FragmentGallery,
      WizardUiContext.MenuEntry,
      WizardUiContext.NewProject,
      WizardUiContext.NewModule
    )

    lateinit var layoutName: StringParameter

    val activityClass = stringParameter {
      name = "Fragment Name"
      default = "SimpleList"
      help = "name only，Do not include Fragment"
      constraints = listOf(Constraint.NONEMPTY)
    }

    layoutName = stringParameter {
      name = "Layout Name"
      default = "fragment_main"
      help = "Please enter a name for the layout"
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { fragmentToLayout(activityClass.value.toSnakeCase()) }
    }

    val packageName = defaultPackageNameParameter

    val sourceLanguage = enumParameter<SourceLanguage> {
      name = "Source Language"
      default = SourceLanguage.Kotlin
    }

    widgets(
      TextFieldWidget(activityClass),
      TextFieldWidget(layoutName),
      PackageNameWidget(packageName),
      EnumWidget(sourceLanguage)
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
      baseListFragmentRecipe(
        data as ModuleTemplateData,
        activityClass.value,
        layoutName.value,
        packageName.value,
        sourceLanguage.value,
      )
    }
  }


val defaultPackageNameParameter
  get() = stringParameter {
    name = "Package Name"
    visible = { !isNewModule }
    default = "com.dev996"
    constraints = listOf(Constraint.PACKAGE)
    suggest = { packageName }
  }
