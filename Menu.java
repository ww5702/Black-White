import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
	private JPanel contentPane;
	ImageIcon icon;
	private Font font1 = new Font("Serif", Font.BOLD, 20);
	private Font font2 = new Font("Serif", Font.BOLD, 80);

	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 700, 500);
		icon = new ImageIcon("back3.jpg");
		
		contentPane = new JPanel() {
			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 2: Scale image to size of component
				// Dimension d = getSize();
				// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
				// Approach 3: Fix the image position in the scroll pane
				// Point p = scrollPane.getViewport().getViewPosition();
				// g.drawImage(icon.getImage(), p.x, p.y, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(50, 50));

		setContentPane(contentPane);
		JLabel label1 = new JLabel("베팅게임");
		label1.setFont(font2);

		contentPane.add(label1, BorderLayout.NORTH);
		JButton btnCallMainBox = new JButton(MainGUI.BUTTON_MAINBOX);
		btnCallMainBox.addActionListener(new MainGUI());
		btnCallMainBox.setBorderPainted(false); // 외곽선 삭제
		btnCallMainBox.setContentAreaFilled(false); // 내용역역 채우지 않기
		btnCallMainBox.setOpaque(false); // 투명하게
		btnCallMainBox.setFont(font1);
		// btnCallMainBox.setBackground(new Color(255,128,0));

		JButton btnCallHighScore = new JButton(MainGUI.BUTTON_HIGHSCORE);
		btnCallHighScore.addActionListener(new MainGUI());
		btnCallHighScore.setBorderPainted(false); // 외곽선 삭제
		btnCallHighScore.setContentAreaFilled(false); // 내용역역 채우지 않기
		btnCallHighScore.setOpaque(false); // 투명하게
		btnCallHighScore.setFont(font1);
		// btnCallHighScore.setBackground(new Color(15,223,0));

		contentPane.add(btnCallMainBox, BorderLayout.CENTER);
		contentPane.add(btnCallHighScore, BorderLayout.SOUTH);
		setVisible(true);
	}

}
