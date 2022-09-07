package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.activity.baseActivityTemplate
import other.mvvm.activity.mvvmActivityTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

  override fun getTemplates(): List<Template> = listOf(
    // activity的模板
    mvvmActivityTemplate,
    // baseActivity的模板
    baseActivityTemplate,
  )
}
