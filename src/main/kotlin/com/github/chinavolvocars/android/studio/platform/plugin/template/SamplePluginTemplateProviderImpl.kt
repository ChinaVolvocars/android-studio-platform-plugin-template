package com.github.chinavolvocars.android.studio.platform.plugin.template

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.baseActivityTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list.baseListActivityTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list.more.baseLoadMoreActivityTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.activity.load.list.refresh.baseLoadListActivityTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.baseFragmentTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.more.baseLoadMoreFragmentTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.base.fragment.load.list.refresh.baseLoadListFragmentTemplate
import com.github.chinavolvocars.android.studio.platform.plugin.template.activity.mvvmActivityTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

  override fun getTemplates(): List<Template> = listOf(
    baseActivityTemplate,
    baseListActivityTemplate,
    baseLoadListActivityTemplate,
    baseLoadMoreActivityTemplate,
    baseFragmentTemplate,
    baseLoadListFragmentTemplate,
    baseLoadMoreFragmentTemplate,
  )
}
