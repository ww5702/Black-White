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

	resultReturn c = new resultReturn(); // ��� ��ü
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
			c.cal(calculate.getText());	//resultReturn ���� cal�Լ� ȣ��
			double result = c.cal(calculate.getText());	//result�� calculate���� ���� ���̴�.
			
			//space�� calculate�� reuslt���� ���
			space.setText((int) result + "");// setText�ȿ��� ���ڿ��� ���ϱ�
			calculate.setText((int) result + "");
			break;
		}
	
	}
	//calculate = �� ��� ���� 			space = ������ �������� ǥ��â
	JTextField calculate, space;
	String[] str = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "+", "-", "*", "=", "Clear" };
	JButton[] b = new JButton[15];
	JButton clear;
	Font resultspacefont = new Font("arian", Font.BOLD, 40);// ���â��Ʈ ����
	Font buttonfont = new Font("arian", Font.BOLD, 20);// ��ư��Ʈ ����

	CalculatorOption() {
		setTitle("����"); // �̸�
		setSize(300, 300); // ũ��
		setLayout(new BorderLayout());

		// ù��° �г� �����
		Panel TextField = new Panel();
		TextField.setLayout(new GridLayout(2, 1));
		calculate = new JTextField(getWidth());
		space = new JTextField(getWidth());
		space.setFont(resultspacefont);
		
		
		calculate.setHorizontalAlignment(JTextField.RIGHT);// ������ �����ʺ��� ����
		space.setHorizontalAlignment(JTextField.RIGHT);// �Ʒ����� �����ʺ��� ����
		space.setEditable(false);
		TextField.add(calculate);
		TextField.add(space);

		// ����+��ȣ ��ư
		Panel button = new Panel();
		button.setLayout(new GridLayout(5, 4));
		for (int i = 0; i < 15; i++) {
			b[i] = new JButton(str[i]);	//str ����
			b[i].addActionListener(this);
			b[i].setFont(buttonfont);
			button.add(b[i]);	//��ư�� b[i]����
		}
		add(BorderLayout.NORTH, TextField); // TextField panel�� Frame�� ���̱�
		add(BorderLayout.CENTER, button); // ��ư panel�� Frame�� ���̱�
	}
	// ���� ���� �Ǻ�
		public void checknum(String n1) {
			if (check == 0) {
				calculate.setText(calculate.getText() + n1);
				space.setText("" + n1);
				check = -1;
			} else {
				//���� �Է½� ���� ���� space�� calculate�� �Է�
				space.setText(space.getText() + n1);
				calculate.setText(calculate.getText() + n1);
			}

		}
}
