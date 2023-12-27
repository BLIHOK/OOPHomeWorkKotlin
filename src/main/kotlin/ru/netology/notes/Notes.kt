package ru.netology.notes

interface Notes<T> {
    fun add(item1: T)
    fun edit(item1: T, item2: List<T>): T
    fun delete(item1:T): T?
    fun get(): List<T>
}