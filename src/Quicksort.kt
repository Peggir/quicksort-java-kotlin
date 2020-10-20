fun main() {
    // Initial unsorted list
    val inputList: List<Int> = listOf(1, 2, 1, 60, 4, -10, 50)

    // Sort the list and print it
    println(quicksort(inputList));
}

fun quicksort(items: List<Int>): List<Int> {
    // Return if the input list is empty or only has 1 entry, since it's already sorted
    if (items.size <= 1) {
        return items
    }

    // Pick a pivot
    val chosenItem: Int = items[items.size / 2]

    // Partition items in three sets: smaller, equal and greater than chosen item
    val smallerList: MutableList<Int> = mutableListOf()
    val equalList: MutableList<Int> = mutableListOf()
    val greaterList: MutableList<Int> = mutableListOf()
    items.forEach {
        when {
            it < chosenItem -> smallerList.add(it)
            it > chosenItem -> greaterList.add(it)
            else -> equalList.add(it)
        }
    }

    // Combine results and return
    val sortedList: MutableList<Int> = mutableListOf()
    sortedList.addAll(quicksort(smallerList)) // Recursive call
    sortedList.addAll(equalList)
    sortedList.addAll(quicksort(greaterList)) // Recursive call
    return sortedList
}
