
package com.github.chinavolvocars.android.studio.platform.plugin.template.activity.src.app_package

fun mvvmAcitivityKt(
  applicationPackage:String?,
  activityClass:String,
  layoutName:String,
  packageName:String
)="""
package ${packageName}
import android.os.Bundle
import com.bigademo.baselib.base.BaseActivity
import ${applicationPackage}.R
import ${applicationPackage}.BR;
import ${applicationPackage}.databinding.Activity${activityClass}Binding
class ${activityClass}Activity : BaseActivity<${activityClass}ViewModel, Activity${activityClass}Binding>() {
    override fun getContentView(): Int {
        return R.layout.${layoutName}
    }

    override fun init(savedInstanceState: Bundle?) {
        super.init(savedInstanceState)
        isShowTopBar = false
    }

    override fun initViewModel() {
        viewModel = ${activityClass}ViewModel()
    }
    /**
     *	监听数据的变化
     */
    override fun observe() {

    }
    
    /**
     *  控件的点击事件
     */
    override fun onClick() {
    }

    override fun initData() {
        super.initData()
    }
    override fun initVariableId(): Int {
        TODO("Not yet implemented")
    }
    } 
"""
