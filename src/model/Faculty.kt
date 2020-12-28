package model

class Faculty(val facultyName: String) {

    val groups: MutableList<Group> = mutableListOf() // пустой

    fun addGroup(group: Group) =
            groups.add(group)

    fun removeGroup(group: Group) =
            groups.remove(group)


    fun clearList() {
        groups.clear()
    }

    private fun findGroup(student: Student) : Group? =
            groups.find { it.groupName.equals("${student.faculty.facultyName.toUpperCase()[0]}-${student.course}") }

    private fun groupIsExists(student: Student) : Boolean =
            findGroup(student) != null

    fun distribute(student: Student) {
        if (!groupIsExists(student))
            groups.add(Group(mutableListOf(student), facultyName, student.course))
        else
            findGroup(student)!!.addStudent(student)
    }

    fun removeStudent(student: Student) =
        findGroup(student)!!.removeStudent(student)

    fun findStudent(student: Student) : Boolean {
        val search = groups.find { it.groupName.equals(findGroup(student)) }
        return if (search != null) {
            Group(search.students, student.faculty.facultyName, student.course).findStudent(student)
            true
        } else false
    }

    override fun toString(): String {
        val sb = StringBuilder("  Факультет -> $facultyName:\n")
        groups.forEach {
            sb.append(it.toString())
        }
        return sb.toString()
    }
//    fun printFaculties() {
//        println("\tФакультет -> $facultyName:")
//        groups.forEach {
//            it.printGroup()
//        }
//    }
}