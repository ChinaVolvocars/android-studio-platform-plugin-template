package other.BaseLoadListFragment

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.toSnakeCase

val baseLoadListFragmentTemplate
  get() = template {
    name = "BaseLoadListFragment"
    description = "适用于BaseLoadListFragment框架的Activity"
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
      help = "只输入名字，不要包含Fragment"
      constraints = listOf(Constraint.NONEMPTY)
    }

    layoutName = stringParameter {
      name = "Layout Name"
      default = "fragment_main"
      help = "请输入布局的名字"
      constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
      suggest = { fragmentToLayout(fragmentClass.value.toSnakeCase()) }
    }

    val packageName = defaultPackageNameParameter

    widgets(
        TextFieldWidget(fragmentClass),
        TextFieldWidget(layoutName),
        PackageNameWidget(packageName)
    )
//        thumb { File("logo.png") }
    recipe = { data: TemplateData ->
      baseLoadListFragmentRecipe(
          data as ModuleTemplateData,
          fragmentClass.value,
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
