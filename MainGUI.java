import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI implements ActionListener {
	private static Menu Menu;
	private static MainBox MainBox;
	private static HighScore HighScore;
	//private static Whowin Whowin;
	public final static String BUTTON_MENU = "메뉴로 돌아가기";
	public final static String BUTTON_MAINBOX = "게임 시작하기";
	public final static String BUTTON_HIGHSCORE = "점수판";
	//public final static String BUTTON_WHOWIN = "승리자 확인 페이지로 이동!";

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