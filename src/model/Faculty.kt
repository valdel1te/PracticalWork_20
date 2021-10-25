package model

class Faculty(val facultyName: String) {

    val groups: MutableList<Group> = mutableListOf()

    fun addGroup(group: Group) =
        groups.add(group)

    fun removeGroup(group: Group) =
        groups.remove(group)

    fun clearList() {
        groups.clear()
    }

    fun findGroup(student: Student): Group? =
        groups.find { it.groupName.equals("${student.faculty.facultyName.toUpperCase()[0]}-${student.course}") }

    private fun groupIsExists(student: Student): Boolean =
        findGroup(student) != null

    fun distribute(student: Student) {
        if (!groupIsExists(student))
            addGroup(Group(mutableListOf(student), facultyName, student.course))
        else
            findGroup(student)!!.addStudent(student)
    }

    fun findStudent(student: Student): Student? =
        findGroup(student)?.findStudent(student)


    override fun toString(): String {
        val sb = StringBuilder("  Факультет -> $facultyName:\n")
        groups.forEach {
            sb.append(it.toString())
        }
        return sb.toString()
    }
}