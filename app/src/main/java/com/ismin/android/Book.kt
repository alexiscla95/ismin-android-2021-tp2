package com.ismin.androidtp1

import java.io.Serializable

data class Book(
  val title: String,
  val author: String,
  val date: String
): Serializable {

}