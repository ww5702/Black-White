import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener {
	private static Menu Menu;
	private static MainBox MainBox;
	private static HighScore HighScore;
	//private static Whowin Whowin;
	public final static String BUTTON_MENU = "�޴��� ���ư���";
	public final static String BUTTON_MAINBOX = "���� �����ϱ�";
	public final static String BUTTON_HIGHSCORE = "������";
	//public final static String BUTTON_WHOWIN = "�¸��� Ȯ�� �������� �̵�!";

	public static void main(String[] args) {
		Menu = new Menu();
		Menu.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(BUTTON_MAINBOX)) {
			if (MainBox == null) {
				MainBox = new MainBox();
				MainBox.setVisible(true);
			}
			if (Menu != null) {
				Menu.dispose();
				Menu = null;
			}
		} else if (e.getActionCommand().equals(BUTTON_MENU)) {
			if (Menu == null) {
				Menu = new Menu();
				Menu.setVisible(true);
			}
			if (MainBox != null) {
				MainBox.dispose();
				MainBox = null;
			}
			if (HighScore != null) {
				HighScore.dispose();
				HighScore = null;
			}
		} else if (e.getActionCommand().equals(BUTTON_HIGHSCORE)) {
			if (HighScore == null) {
				HighScore = new HighScore();
				HighScore.setVisible(true);
			}
			if (Menu != null) {
				Menu.dispose();
				Menu = null;
			}
		}
	}
}