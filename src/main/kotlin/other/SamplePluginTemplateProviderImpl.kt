package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.BaseListActivity.baseListActivityTemplate
import other.BaseLoadListActivity.baseLoadListActivityTemplate
import other.activity.baseActivityTemplate
import other.mvvm.activity.mvvmActivityTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

  override fun getTemplates(): List<Template> = listOf(
      mvvmActivityTemplate,
      baseActivityTemplate,
      baseListActivityTemplate,
      baseLoadListActivityTemplate,
  )
}
