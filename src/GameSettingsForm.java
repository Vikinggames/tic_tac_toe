import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GameSettingsForm extends JFrame {
    GameSettingsForm gameSettingsForm = this;
    public GameSettingsForm() {
        setTitle("Настройки игры");
        setBounds(450, 450, 240, 190);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JRadioButton radioButtonModeTwoPlayers = new JRadioButton("Игрок против игрока");
        add(radioButtonModeTwoPlayers);
        radioButtonModeTwoPlayers.setSelected(true);
        JSlider jSlider = new JSlider(0,2,0);
        add(jSlider);
        jSlider.setAlignmentX(LEFT_ALIGNMENT);
        jSlider.setVisible(false);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonModeTwoPlayers);
        JLabel jLabelLinesCount = new JLabel("Размер поля (по умолчанию 3 на 3): ");
        add(jLabelLinesCount);
        JTextField jTextFieldLinesCount = new JTextField();
        jTextFieldLinesCount.setMaximumSize(new Dimension(100, 20));
        add(jTextFieldLinesCount);
        JButton jButtonSetSettings = new JButton("Начать игру!");
        add(jButtonSetSettings);
        setVisible(true);
        jButtonSetSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGameField gameField = MainGameField.getInstance();
                if (jTextFieldLinesCount.getText().isEmpty()) {
                    gameField.linesCount = 3;
                }
                else {
                    try {
                        gameField.linesCount = Integer.parseInt(jTextFieldLinesCount.getText());
                    }
                    catch (NumberFormatException ex) {
                        System.out.println("Необходимо ввести целое число!");
                    }
                }
                gameField.startNewGame();
                gameSettingsForm.setVisible(false);
            }
        });
    }
}