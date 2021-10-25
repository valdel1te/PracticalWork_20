package model

class Group(
    students: MutableList<Student>,
    facultyName: String,
    numberCourse: Int
) {
    var numberCourse = numberCourse
    var groupName = "${facultyName.toUpperCase()[0]}-$numberCourse"
    val students = students

    fun addStudent(student: Student) =
        students.add(student)

    fun removeStudent(student: Student) {
        students.remove(findStudent(student))
    }

    fun clearList() =
        students.clear()

    fun findStudent(student: Student): Student? {
        return students.find { it.name == student.name && it.surname == student.surname }
    }

    override fun toString(): String {
        val sb = StringBuilder("    Группа -> $groupName:\n")
        students.forEach {
            sb.append(it.toString() + "\n")
        }
        return sb.toString()
    }
}


