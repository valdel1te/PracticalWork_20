package model

import java.lang.StringBuilder

class University(name: String) {

    var name = name

    private val facultyList: List<Faculty> = FacultyName.values().map { Faculty(it.facultyName) }

    fun distribute(student: Student) =
            facultyList.find { it.facultyName.equals(student.faculty.facultyName) }!!.distribute(student)

    fun removeStudent(student: Student) {
        val f = facultyList.find {
            it.facultyName.equals(student.faculty.facultyName)
        }!!.groups.find {
            it.groupName.equals("${student.faculty.facultyName.toUpperCase()[0]}-${student.course}")
        }//!!.removeStudent(student)
        f!!.students.remove(student)
        println(f)
        println(student)
    }

    private fun findStudent(student: Student) : Boolean {
        val search = facultyList.find { it.facultyName.equals(student.faculty.facultyName) }
        return if (search != null) {
            Faculty(student.faculty.facultyName).findStudent(student)
            true
        } else false
    }

    fun studentIsExist(student: Student) : Boolean {
        val studentFaculty = Faculty(student.faculty.facultyName)
        //val studentGroup = Group(, student.faculty.facultyName, student.course)
        return findStudent(student) && studentFaculty.findStudent(student)
    }

    override fun toString(): String {
        val sb = StringBuilder("Институт -> $name:\n")
        facultyList.forEach {
            sb.append(it.toString())
        }
        return sb.toString()
    }
//    fun printAllStudents() {
//        println("Институт -> $name:")
//        facultyList.forEach { it.printFaculties() }
//    }
}