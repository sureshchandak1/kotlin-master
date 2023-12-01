package composite

fun main(args: Array<String>) {
    val root = Folder(0.5)
    root.addChild(File(10.0))
    root.addChild(File(2.0))
    root.addChild(File(5.0))
    val subFolder1 = Folder()
    val subFolder2 = Folder()
    val subFolder3 = Folder()
    subFolder1.addChild(subFolder2)
    subFolder2.addChild(File(3.0))
    subFolder2.addChild(subFolder3)
    subFolder3.addChild(File(8.0))
    root.addChild(subFolder1)

    println(root.getSize())
}

private interface FileSystemElement {
    fun getSize() : Double
}

private class File(private val size: Double) : FileSystemElement {
    override fun getSize(): Double {
        return size
    }
}

private class Folder(private val size: Double = 0.0) : FileSystemElement {

    private val children: MutableList<FileSystemElement> = mutableListOf()

    fun addChild(element: FileSystemElement) {
        children.add(element)
    }

    override fun getSize(): Double {
        var size = 0.0
        children.forEach {
            size += it.getSize()
        }
        return size + this.size
    }
}