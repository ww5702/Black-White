import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HighScore extends JFrame {
	private JPanel contentPane;

	public HighScore() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel label1 = new JLabel("HighScore");
		contentPane.add(label1, BorderLayout.NORTH);

		JButton btnCallMenu = new JButton(MainGUI.BUTTON_MENU);
		btnCallMenu.addActionListener(new MainGUI());
		contentPane.add(btnCallMenu, BorderLayout.SOUTH);

	}
}