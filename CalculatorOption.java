import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class CalculatorOption extends JFrame implements ActionListener {

	resultReturn c = new resultReturn(); // 계산 객체
	int check = -1, soch = 0;	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "0":
			checknum("0");
			break;
		case "1":
			checknum("1");
			break;
		case "2":
			checknum("2");
			break;
		case "3":
			checknum("3");
			break;
		case "4":
			checknum("4");
			break;
		case "5":
			checknum("5");
			break;
		case "6":
			checknum("6");
			break;
		case "7":
			checknum("7");
			break;
		case "8":
			checknum("8");
			break;
		case "9":
			checknum("9");
			break;
		case "Clear":
			space.setText("");
			calculate.setText("");
			break;
		case "+":
			space.setText("");
			calculate.setText(calculate.getText() + "+");
			//System.out.println("" + calculate.getText() + "+");
			break;
		case "-":
			space.setText("");
			calculate.setText(calculate.getText() + "-");
			break;
		case "*":
			space.setText("");
			calculate.setText(calculate.getText() + "*");
			break;
		case "=":
			c.cal(calculate.getText());	//resultReturn 내의 cal함수 호출
			double result = c.cal(calculate.getText());	//result는 calculate에서 계산된 값이다.
			
			//space와 calculate에 reuslt값을 출력
			space.setText((int) result + "");// setText안에는 문자열이 들어가니까
			calculate.setText((int) result + "");
			break;
		}
	
	}
	//calculate = 윗 계산 공간 			space = 무엇을 눌렀는지 표시창
	JTextField calculate, space;
	String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "=", "Clear" };
	JButton[] b = new JButton[15];
	JButton clear;
	Font resultspacefont = new Font("arian", Font.BOLD, 40);// 결과창폰트 설정
	Font buttonfont = new Font("arian", Font.BOLD, 20);// 버튼폰트 설정

	CalculatorOption() {
		setTitle("계산기"); // 이름
		setSize(300, 300); // 크기
		setLayout(new BorderLayout());

		// 첫번째 패널 만들기
		Panel TextField = new Panel();
		TextField.setLayout(new GridLayout(2, 1));
		calculate = new JTextField(getWidth());
		space = new JTextField(getWidth());
		space.setFont(resultspacefont);
		
		
		calculate.setHorizontalAlignment(JTextField.RIGHT);// 윗공간 오른쪽부터 정렬
		space.setHorizontalAlignment(JTextField.RIGHT);// 아래공간 오른쪽부터 정렬
		space.setEditable(false);
		TextField.add(calculate);
		TextField.add(space);

		// 숫자+기호 버튼
		Panel button = new Panel();
		button.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < 15; i++) {
			b[i] = new JButton(str[i]);	//str 대입
			b[i].addActionListener(this);
			b[i].setFont(buttonfont);
			button.add(b[i]);	//버튼에 b[i]대입
		}
		add(BorderLayout.NORTH, TextField); // TextField panel을 Frame에 붙이기
		add(BorderLayout.CENTER, button); // 버튼 panel을 Frame에 붙이기
	}
	// 숫자 순서 판별
		public void checknum(String n1) {
			if (check == 0) {
				calculate.setText(calculate.getText() + n1);
				space.setText("" + n1);
				check = -1;
			} else {
				//숫자 입력시 누른 숫자 space와 calculate에 입력
				space.setText(space.getText() + n1);
				calculate.setText(calculate.getText() + n1);
			}

		}
}
