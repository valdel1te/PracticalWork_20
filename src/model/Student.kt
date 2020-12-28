package model

class Student(name: String, surname: String, course: Int, faculty: FacultyName) {
    val name = name.toLowerCase().capitalize().trim()
    val surname = surname.toLowerCase().capitalize().trim()
    val course = course
    val faculty = faculty

    override fun toString(): String =
            "      Студент($name $surname, $course курс, ${faculty.facultyName})"
}