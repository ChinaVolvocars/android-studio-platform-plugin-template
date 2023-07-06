package other.BaseLoadMoreFragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.SourceLanguage
import other.toSnakeCase

val baseLoadMoreFragmentTemplate
  get() = template {
    name = "Base Load More Fragment"
    description = "Fragments for the Base Load More Fragment framework"
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
      name = "Fragment Name"
      default = "SimpleList"
      help = "Please enter a name for the layout"
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
      baseLoadMoreFragmentRecipe(
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
