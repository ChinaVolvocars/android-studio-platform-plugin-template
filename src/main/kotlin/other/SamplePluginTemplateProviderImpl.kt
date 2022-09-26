package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import fragment.baseFragmentTemplate
import other.BaseListActivity.baseListActivityTemplate
import other.BaseLoadListActivity.baseLoadListActivityTemplate
import other.BaseLoadListFragment.baseLoadListFragmentTemplate
import other.BaseLoadMoreActivity.baseLoadMoreActivityTemplate
import other.BaseLoadMoreFragment.baseLoadMoreFragmentTemplate
import other.activity.baseActivityTemplate
import other.mvvm.activity.mvvmActivityTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

  override fun getTemplates(): List<Template> = listOf(
    mvvmActivityTemplate,
    baseActivityTemplate,
    baseListActivityTemplate,
    baseLoadListActivityTemplate,
    baseLoadMoreActivityTemplate,
    baseFragmentTemplate,
    baseLoadListFragmentTemplate,
    baseLoadMoreFragmentTemplate,
  )
}
