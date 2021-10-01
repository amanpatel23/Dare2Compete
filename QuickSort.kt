fun main(args: Array<String>) {

    // input size of the integer array
    val n = readLine()!!.toInt()

    // initializing 'arr' IntArray and taking integers as input
    val arr = readLine()!!.split(' ').map { it.toInt() }.toIntArray()

    // calling quickSort function
    /* at starting 'low' will be the 0th index and
    'high' will be the last index i.e. (n - 1) */
    quickSort(arr, 0, n - 1)

    // printing the 'nums' array after sorting
    System.out.print(arr.joinToString { "$it" })

}

private fun quickSort(arr: IntArray, low: Int, high: Int) {

    // base case
    if (low >= high)
        return

    // get the index of pivot element in the sorted array after partition
    val pi = partition(arr, low, high)

    // calling quickSort recursively for the left subarray
    quickSort(arr, low, pi - 1)
    // calling quickSort recursively for the right subarray
    quickSort(arr, pi + 1, high)
}

private fun partition(arr: IntArray, low: Int, high: Int): Int {
    var (i, j) = listOf(low, low)
    val pivot = arr[high]
    while (i <= high) {
        if (arr[i] > pivot)
            i++
        else {
            swap(arr, i, j)
            i++; j++
        }
    }
    return j - 1
}

private fun swap(arr: IntArray, i: Int, j: Int) {
    arr[i] = arr[j].also { arr[j] = arr[i] }
}