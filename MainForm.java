import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame //головна форма гри
{
    public MainForm() {
        setTitle("Crosses-Zeroes game (by Vitalii16)");
        setBounds(300, 300, 455, 525);
        setResizable(false); //користувачам не можна змінювати розмір форми
        setLocationRelativeTo(null); //розташування форми в центрі екрану при запуску
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //закриття програми при клацанні на хрестик
        MainGameField gameField = MainGameField.getInstance();
        // Створюємо панель для кнопок
        JPanel buttonPanel = new JPanel(new GridLayout());
        add(gameField, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        JButton btnStart = new JButton("Start new game");
        btnStart.setBorder(new RoundedBorder(10)); //заокруглення країв кнопки на 10 одиниць
        JButton btnEnd = new JButton("End the game");
        btnEnd.setBorder(new RoundedBorder(10));
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(btnStart.getText());
                GameSettingsForm gameSettingsForm = new GameSettingsForm();
            }
        });
        setVisible(true); //робимо форму видимою
    }
}
