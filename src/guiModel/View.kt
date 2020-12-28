package guiModel

import model.FacultyName
import java.awt.Color
import javax.swing.*
import javax.swing.WindowConstants.EXIT_ON_CLOSE

class View {
    val frame = JFrame("lr20")
    val textInfo = JTextPane()
    val scroll = JScrollPane(textInfo)

    val nameLable = JLabel("Имя: ")
    val surnameLable = JLabel("Фамилия: ")
    val courseLable = JLabel("Курс: ")
    val facultyLable = JLabel("Факультет: ")

    val nameField = JTextField()
    val surnameField = JTextField()

    val courseChoice: JComboBox<Int> = JComboBox()
    val facultyChoice: JComboBox<FacultyName> = JComboBox()

    val addButton = JButton("Добавить")
    val removeButton = JButton("Удалить")
    val printButton = JButton("Вывести список")

    fun createForm() {
        textInfo.apply {
            isVisible = true
            isEditable = false
            // поменять шрифт на убунту и поднять размер
            setSize(440, 540)
            setLocation(10, 10)
        }

        scroll.apply {
            isVisible = true
            setSize(440, 540)
            setLocation(10, 10)
            verticalScrollBarPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS
        }

        nameLable.apply {
            isVisible = true
            setSize(70, 20)
            setLocation(470, 10)
        }

        nameField.apply {
            isVisible = true
            isEditable = true
            setSize(200, 20)
            setLocation(470, 30)
        }

        surnameLable.apply {
            isVisible = true
            setSize(70, 20)
            setLocation(470, 60)
        }

        surnameField.apply {
            isVisible = true
            isEditable = true
            setSize(200, 20)
            setLocation(470, 80)
        }

        courseLable.apply {
            isVisible = true
            setSize(70, 20)
            setLocation(470, 140)
        }

        courseChoice.apply {
            isVisible = true
            setSize(45, 20)
            setLocation(550, 140)
        }

        facultyLable.apply {
            isVisible = true
            setSize(100, 20)
            setLocation(470, 170)
        }

        facultyChoice.apply {
            isVisible = true
            setSize(100, 20)
            setLocation(550, 170)
        }

        addButton.apply {
            isVisible = true
            setSize(200, 35)
            setLocation(470, 300)
            //background = Color.GREEN
        }

        removeButton.apply {
            isVisible = true
            setSize(200, 35)
            setLocation(470, 350)
            //background = Color.RED
        }

        printButton.apply {
            isVisible = true
            setSize(200, 35)
            setLocation(470, 400)
            //background = Color.YELLOW
        }

        frame.apply {
            //background = Color.getColor("#912857")
            background = Color.GREEN
            defaultCloseOperation = EXIT_ON_CLOSE
            setSize(700, 600)
            isVisible = true
            isResizable = false

            setLocationRelativeTo(null)
            layout = null

            add(scroll)
            add(nameLable)
            add(nameField)
            add(surnameLable)
            add(surnameField)
            add(courseLable)
            add(courseChoice)
            add(facultyLable)
            add(facultyChoice)
            add(addButton)
            add(removeButton)
            add(printButton)
        }
    }

}