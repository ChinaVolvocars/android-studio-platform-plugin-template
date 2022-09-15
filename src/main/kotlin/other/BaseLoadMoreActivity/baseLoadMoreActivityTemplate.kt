package other.BaseLoadMoreActivity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.toSnakeCase

val baseLoadMoreActivityTemplate
  get() = template {
    name = "BaseLoadMoreActivity"
    description = "适用于BaseLoadMoreActivityTemplate框架的Activity"
    minApi = MIN_API

    category = Category.Other
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
      help = "只输入名字，不要包含Activity"
      constraints = listOf(Constraint.NONEMPTY)
    }

    layoutName = stringParameter {
      name = "Layout Name"
      default = "activity_main"
      help = "请输入布局的名字"
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { activityToLayout(activityClass.value.toSnakeCase()) }
    }

    val packageName = defaultPackageNameParameter

    widgets(
        TextFieldWidget(activityClass),
        TextFieldWidget(layoutName),
        PackageNameWidget(packageName)
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
      baseLoadMoreActivityRecipe(
          data as ModuleTemplateData,
          activityClass.value,
          layoutName.value,
          packageName.value
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
