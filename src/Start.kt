import controllers.ViewController
import guiModel.View
import model.FacultyName
import model.Student
import model.University

fun main() {
    start()
}

fun start() {
    val university = University("РЭУ")
    val list: MutableList<Student> = mutableListOf(
        Student("владимир", "путин", 3, FacultyName.MATH),
        Student("эдуард", "умнич", 2, FacultyName.MATH),
        Student("ярослав", "смородьев", 3, FacultyName.INFORMATICS),
        Student("михаил", "михайлович", 1, FacultyName.ECONOMY),
        Student("анастасия", "нерабочийтестова", 1, FacultyName.MATH),
        Student("маргарита", "жигулева", 3, FacultyName.MATH),
        Student("сергей", "портянин", 3, FacultyName.INFORMATICS),
        Student("иван", "майданов", 3, FacultyName.ECONOMY),
        Student("сергей", "ломоносов", 3, FacultyName.INFORMATICS),
        Student("данил", "самсонов", 3, FacultyName.INFORMATICS),
        Student("виктория", "секретова", 4, FacultyName.INFORMATICS),
        Student("рамзан", "паскалович", 4, FacultyName.INFORMATICS),
        Student("александр", "математиков", 2, FacultyName.MATH)
    )

    val view = View()
    val controller = ViewController(university, view)
    list.map {
        controller.addReadyStudent(it)
    }
}