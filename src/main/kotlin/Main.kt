//imports
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.SimpleTheme
import com.googlecode.lanterna.gui2.*
import com.googlecode.lanterna.gui2.dialogs.MessageDialog
import com.googlecode.lanterna.screen.Screen
import com.googlecode.lanterna.screen.TerminalScreen
import com.googlecode.lanterna.terminal.DefaultTerminalFactory
import com.googlecode.lanterna.terminal.Terminal

fun main(args: Array<String>) {
    //initializing values
    val board = board().boardList
    val boardTheme = SimpleTheme.makeTheme(false, TextColor.RGB(52, 116, 235), TextColor.RGB(14, 21, 24), TextColor.RGB(14, 21, 24), TextColor.RGB(14, 21, 24), TextColor.RGB( 235, 232, 200 ), TextColor.RGB(14, 21, 24), TextColor.RGB(14, 21, 24))

    //function for printing the board
    fun printBoard() {
        for (boardRow in board) {
            print("╣")
            for (spot in boardRow) {
                print(spot)
            }
            print("╠")
            println()
        }
    }

    //printing board
    printBoard()

    //terminal and screen layers setup
    val terminal: Terminal = DefaultTerminalFactory().createTerminal()
    val screen: Screen = TerminalScreen(terminal)
    screen.startScreen()

    //creating gui
    val gui = MultiWindowTextGUI(screen, DefaultWindowManager(), EmptySpace(TextColor.RGB(16, 22, 24)))

    //creating window
    val window = BasicWindow()
    window.title = "Konne[KT] 4"

    //creating panel
    val panel: Panel = Panel().setLayoutManager(LinearLayout(Direction.VERTICAL))
    window.component = panel


    //creating board panels
    for (boardRow in board) {
        val rowPanel: Panel = Panel().setLayoutManager(LinearLayout(Direction.HORIZONTAL))
        var rowPanelTempString: String = ""
        rowPanel.addComponent(Label(" ╠╢"))
        for (spot in boardRow) {
            rowPanelTempString = rowPanelTempString.plus("[ ]")
        }
        rowPanel.addComponent(Label(rowPanelTempString))
        println(rowPanelTempString)
        rowPanel.addComponent(Label("╟╣ "))
        panel.addComponent(rowPanel)
    }
    panel.addComponent(Label(" ╠╬═══════════════════════╬╣"))
    panel.theme = boardTheme

    //adding label to panel
    //panel.addComponent(Label("testing testing testing!"))

    //adding window to gui
    gui.addWindowAndWait(window)
}