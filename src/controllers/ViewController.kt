package controllers

import guiModel.View
import model.FacultyName
import model.Student
import model.University
import java.awt.event.ActionListener

class ViewController(
        private val university: University,
        private val view: View
) {
    init {
        fillComboBoxes()
        addActionListeners()
        view.createForm()
    }

    private fun fillComboBoxes() {
        (1..4).forEach { view.courseChoice.addItem(it) }

        FacultyName.values().forEach {
            view.facultyChoice.addItem(it)
        }
    }

    fun addReadyStudent(student: Student) =
            university.distribute(student)

    private fun addStudent() = ActionListener {
        if (view.nameField.text.trim() == "" || view.surnameField.text.trim() == "") {
            view.textInfo.text += "Имя или фамилия студента не указаны.\n"
            return@ActionListener
        }
        val newStudent = Student(
                view.nameField.text,
                view.surnameField.text,
                view.courseChoice.selectedItem as Int,
                view.facultyChoice.selectedItem as FacultyName
        )
        university.distribute(newStudent)
        view.textInfo.text += "----- Студент \"${newStudent.name} ${newStudent.surname}\" добавлен -----\n"

        clearValues()
    }

    private fun removeStudent() = ActionListener {
        val student = Student(
                view.nameField.text,
                view.surnameField.text,
                view.courseChoice.selectedItem as Int,
                view.facultyChoice.selectedItem as FacultyName
        )
        view.textInfo.text += "----- Проводится поиск указанного студента -----\n"
        if (university.studentIsExist(student)) {
            university.removeStudent(student)
            view.textInfo.text += "----- Студент \"${student.name} ${student.surname}\" удален -----\n"
        } else view.textInfo.text += "----- Студент не найден -----\n"
        clearValues()
    }

    private fun clearValues() {
        view.nameField.text = ""
        view.surnameField.text = ""
        view.courseChoice.selectedIndex = 0
        view.facultyChoice.selectedIndex = 0
    }

    private fun addActionListeners() {
        view.addButton.addActionListener(addStudent())
        view.removeButton.addActionListener(removeStudent())
        view.printButton.addActionListener(printStudents())
    }

    private fun printStudents() = ActionListener {
        view.textInfo.text += "------------------\n${university.toString()}------------------\n"
    }
}