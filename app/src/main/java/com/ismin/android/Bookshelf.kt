package com.ismin.androidtp1

import com.ismin.androidtp1.Book;

class Bookshelf() {
  private var books: MutableList<Book> = mutableListOf();

  init {
    this.books = mutableListOf()
  }


  public fun addBook(book: Book) {
    if (this.books.find{it.title == book.title} == null) {
      this.books.add(book)
    }
  }

  public fun getBook(title: String): Book? {
    return this.books.find{ it.title == title}
  }

  public fun getBooksOf(author: String): List<Book> {
    return this.books.filter{ it.author == author }.sortedBy { it.title }
  }

  public fun getAllBooks(): List<Book> {
    return this.books.sortedBy { it.title }
  }

  public fun getTotalNumberOfBooks(): Int {
    return books.size
  }
}