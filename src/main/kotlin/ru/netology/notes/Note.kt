package ru.netology.notes

open class Note<T>(var item1: T, var item2: T, var item3: T) : Notes<T> {
    private var critems: List<T> = emptyList()
    private var deletedItems: List<T> = emptyList()
    private var emptyItems: List<T> = emptyList()

    override fun add(item1: T) {
        this.item1 = item1
        critems.plus(item1)
//        critems.apply {
//            add(item1)
//            add(item2)
//            add(item3)
//        }
    }

    override fun get(): List<T> {
        return critems
    }


    override fun edit(item1: T, item2: List<T>): T {
//        if (item2 == item1) {
//            this.items = item2
//        } else throw RestoreException("Not exist")
        return item1
    }


    override fun delete(item1: T): T? {
//        if (item2 != item1 || items.isEmpty()) {
//            throw RestoreException("Note is not exist or was already deleted")
//        } else {
//            deletedItems = items
//            println("Notes have been deleted")
//            items = emptyItems
        return item1
    }


//        fun getById(): T {
//            if
//        return item1
//    }

    //    fun getFriendsNotes(): T {
//        return item1
//    }
    override fun toString(): String {
        return "Note: $item1, $item2, $item3"
    }


}