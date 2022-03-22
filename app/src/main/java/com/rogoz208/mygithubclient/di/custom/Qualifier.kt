package com.rogoz208.mygithubclient.di.custom

import kotlin.reflect.KClass

data class Qualifier(val kClass: KClass<*>, val name: String = "default")