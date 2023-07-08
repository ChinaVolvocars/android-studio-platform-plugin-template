package com.github.chinavolvocars.android.studio.platform.plugin.services

import com.github.chinavolvocars.android.studio.platform.plugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

  init {
    println(MyBundle.message("projectService", project.name))
  }
}
