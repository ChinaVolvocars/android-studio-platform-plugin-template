package com.github.chinavolvocars.androidstudioplatformplugintemplate.services

import com.github.chinavolvocars.androidstudioplatformplugintemplate.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

  init {
    println(MyBundle.message("projectService", project.name))
  }
}
