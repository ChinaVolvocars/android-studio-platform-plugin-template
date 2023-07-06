package other.BaseLoadMoreActivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.SourceLanguage
import other.toSnakeCase

val baseLoadMoreActivityTemplate
  get() = template {
    name = "Base Load More Activity"
    description = "Activities for the Base Load More Activity framework"
    minApi = MIN_API

    category = Category.Activity
    formFactor = FormFactor.Mobile
    screens = listOf(
      WizardUiContext.ActivityGallery,
      WizardUiContext.MenuEntry,
      WizardUiContext.NewProject,
      WizardUiContext.NewModule
    )

    lateinit var layoutName: StringParameter

    val activityClass = stringParameter {
      name = "Activity Name"
      default = "SimpleList"
      help = "name only，Do not include Activity"
      constraints = listOf(Constraint.NONEMPTY)
    }

    layoutName = stringParameter {
      name = "Layout Name"
      default = "activity_main"
      help = "Please enter a name for the layout"
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { activityToLayout(activityClass.value.toSnakeCase()) }
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
      baseLoadMoreActivityRecipe(
        data as ModuleTemplateData,
        activityClass.value,
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
