import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainForm extends JFrame {
    public MainForm()
    {
        setTitle("Крестики-нолики");
        setIconImage(getImage("tic tac toe"));
        setBounds(300, 300, 455, 525);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MainGameField gameField = MainGameField.getInstance();
        JPanel buttonPanel = new JPanel(new GridLayout());
        add(gameField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnEnd = new JButton("Закончить игру");
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);
        btnEnd.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        btnStart.addActionListener(new ActionListener(){
            @Override

            public void actionPerformed(ActionEvent e)
            {
                System.out.println(btnStart.getText());

                GameSettingsForm gameSettingsForm = new GameSettingsForm();
            }
        });
        setVisible(true);
    }
    private Image getImage(String name){
        ImageIcon icon=new ImageIcon("res/img/"+name+".jpg");
        return icon.getImage();
    }

}