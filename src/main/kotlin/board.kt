class board {
    val width = 7
    val height = 6

    val boardList: MutableList<MutableList<String>> = mutableListOf(mutableListOf())

    init {
        for (i in 1..height) {
            val tempRowList: MutableList<String> = mutableListOf()
            for (i in 1..width) {
                tempRowList.add(" ■ ")
            }
            boardList.add(tempRowList)
        }
        boardList.removeFirst()
    }
}