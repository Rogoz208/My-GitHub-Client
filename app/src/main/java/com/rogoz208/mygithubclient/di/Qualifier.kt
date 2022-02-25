package com.rogoz208.mygithubclient.di

import kotlin.reflect.KClass

data class Qualifier(val kClass: KClass<*>, val name: String = "default")