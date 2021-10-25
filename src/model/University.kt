package model

import java.lang.StringBuilder

class University(name: String) {

    var name = name

    private val facultyList: List<Faculty> = FacultyName.values().map { Faculty(it.facultyName) }

    fun distribute(student: Student) =
        findFaculty(student.faculty.facultyName)!!.distribute(student)

    fun removeStudent(student: Student) =
        findFaculty(student.faculty.facultyName)!!.findGroup(student)!!.removeStudent(student)

    private fun findFaculty(fname: String): Faculty? {
        return facultyList.find { it.facultyName == fname }
    }

    private fun findStudent(student: Student): Student? =
        facultyList.find { it.facultyName.equals(student.faculty.facultyName) }?.findStudent(student)


    fun studentIsExist(student: Student): Boolean {
        return findStudent(student) != null
    }

    override fun toString(): String {
        val sb = StringBuilder("Институт -> $name:\n")
        facultyList.forEach {
            sb.append(it.toString())
        }
        return sb.toString()
    }
}