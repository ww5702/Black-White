import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MainBox extends JFrame {
	private int num2 = 0, num4 = 0, compare1 = 0, compare2 = 0, i0 = 0, i1 = 0, i2 = 0, finaljw1 = 0, finaljw2 = 0;
	private String cmp1,cmp2,buttonnum,finalcmp1,finalcmp2,finalnum1,finalnum2;


	public MainBox() {
		JFrame frame = new JFrame("���� �߸� ����");
		JFrame frame0 = new JFrame("���� ���� ��ȣ ��ư");
		JFrame frame1 = new JFrame("player 1 console");
		JFrame frame2 = new JFrame("player 2 console");
		
		JFrame useframe1 = new JFrame("player 1 ������");
		JFrame useframe2 = new JFrame("player 2 ������");
		
		JFrame whowin = new JFrame("�¸��� Ȯ�� �������� �̵�!");
		JFrame finalframe = new JFrame("�¸��ڴ�?");

		Container contentPane = frame.getContentPane();
		Container contentPane0 = frame0.getContentPane();
		Container contentPane1 = frame1.getContentPane();
		Container contentPane2 = frame2.getContentPane();
		
		Container usecontentPane1 = useframe1.getContentPane();
		Container usecontentPane2 = useframe2.getContentPane();
		
		Container whowincontentPane = whowin.getContentPane(); 

		frame.setPreferredSize(new Dimension(500, 400));
		frame.setLocation(700, 400);
		frame0.setSize(500, 300);							//���� ���� ��ȣ ��ư ������
		frame0.setLocation(700, 100);
		frame1.setPreferredSize(new Dimension(300, 200));
		frame1.setLocation(100, 350);
		frame2.setPreferredSize(new Dimension(300, 200));
		frame2.setLocation(1500, 350);
		
		useframe1.setPreferredSize(new Dimension(400, 200));
		useframe1.setLocation(50, 150);
		useframe2.setPreferredSize(new Dimension(400, 200));
		useframe2.setLocation(1450, 150);
		
		whowin.setPreferredSize(new Dimension(350,200));
		whowin.setLocation(775, 800);	
		
		JLabel finallabel1 = new JLabel("1.fianl");
		JLabel finallabel2 = new JLabel("2.fianl");
		JLabel finalcheck = new JLabel("���ڴ�?");
		JButton realfinal = new JButton("���Ȯ��");
		JPanel whowinpanel = new JPanel();
		JPanel whowincheck = new JPanel();
		JPanel whowinresult = new JPanel();
		
		whowinpanel.add(finallabel1);
		whowinpanel.add(finallabel2);
		whowincheck.add(realfinal);
		whowinresult.add(finalcheck);
		
		whowincontentPane.add(whowinpanel, BorderLayout.NORTH);
		whowincontentPane.add(whowincheck, BorderLayout.SOUTH);
		whowincontentPane.add(whowinresult, BorderLayout.CENTER);
		
		JButton[] useButton1 = new JButton[10];
		JButton[] useButton2 = new JButton[10];
		
		JButton finalButton1 = new JButton("�������");
		JTextField finaltext1 = new JTextField(5);//�Է¹޴� ���ڰ���
		JButton finalButton2 = new JButton("�������");
		JTextField finaltext2 = new JTextField(5);//�Է¹޴� ���ڰ���
		
		
		finalButton1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				finalnum1 = finaltext1.getText();//�Է¹�����
				finallabel1.setText("1�÷��̾ �������� �Է��Ͽ����ϴ�.");
				finalcmp1 = new String(finalnum1);		//string������ ����
			}
		});
		finalButton2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				finalnum2 = finaltext2.getText();
				finallabel2.setText("2�÷��̾ �������� �Է��Ͽ����ϴ�.");
				finalcmp2 = new String(finalnum2);	
			}
		});
		realfinal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {		
				finaljw1 = Integer.parseInt(finalcmp1);
				finaljw2 = Integer.parseInt(finalcmp2);
				
				frame.dispose();frame1.dispose();
				frame2.dispose();frame0.dispose();
				
				if(finaljw1 > finaljw2) {
					whowincontentPane.setLocation(700, 100);
					finalcheck.setText("1�÷��̾ "+finaljw1+"���� �̰���ϴ�.");
				}
				else if(finaljw1 < finaljw2) {
					whowincontentPane.setLocation(700, 100);
					finalcheck.setText("2�÷��̾ "+finaljw2+"���� �̰���ϴ�.");
				}
				else {
					whowincontentPane.setLocation(700, 100);
					finalcheck.setText("1 , 2�÷��̾ "+finaljw1+"���� �����ϴ�.");
				}
				
			}
		});
		
		Random object = new Random();
		String[] Aobject = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "+", " +", " *", "*" };
		String[] Bobject = new String[14];
		for (int i = 0; i < Aobject.length; i++) {
			int count = 0;
			Bobject[i] = Aobject[object.nextInt(14)];
			for (int j = 0; j < i; j++) {
				if (Bobject[i] == Bobject[j]) {
					count++;
				}
				if (count == 1) {
					count = 0;
					i--;
					continue;
				}
				count = 0;
			}
		}
		JButton[] Cobject = new JButton[14];
		

		JButton button0 = new JButton("��ư");
		JButton button0_1 = new JButton("��� Ȯ��");
		JTextArea textArea = new JTextArea();
		textArea.setColumns(30);
		textArea.setRows(20);
		JLabel label0 = new JLabel("���â     ");
		JLabel label0_1 = new JLabel("     ���â     ");
		JLabel label0_2 = new JLabel("???�� �¸��Ͽ����ϴ�.");
		

		
		// 1���� ���� �÷��̾�1 2���� ���� �÷��̾�2
		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(10);

		JButton button1 = new JButton("�Է�");
		JButton button2 = new JButton("�Է�");

		JLabel label1 = new JLabel("ǥ��â");
		JLabel label1_1 = new JLabel("token = 100");
		JLabel label2 = new JLabel("ǥ��â");
		JLabel label2_1 = new JLabel("token = 100");

		JPanel panel = new JPanel(); // label,button0,start
		JPanel panel_1 = new JPanel(); // textArea
		JPanel panel_2 = new JPanel(); // label0,label0_1,label0_2
		JPanel panel_3 = new JPanel(); // button0_1

		JPanel panel1 = new JPanel(); // label,text1,button1
		JPanel panel1_1 = new JPanel(); // label1 ǥ��â
		JPanel panel1_2 = new JPanel(); // label1_1 ��ūǥ��â

		JPanel panel2 = new JPanel(); // label,text1,button1
		JPanel panel2_1 = new JPanel(); // label2 ǥ��â
		JPanel panel2_2 = new JPanel(); // label2_1 ��ūǥ��â

		panel.add(new JLabel("main console"));
		panel.add(button0);
		panel.add(button0_1);
		
		panel_1.add(textArea);
		panel_2.add(label0);
		panel_2.add(label0_2);
		panel_2.add(label0_1);

		panel1.add(new JLabel("player 1"));
		panel1.add(text1);
		panel1.add(button1);
		panel1_1.add(label1); // ǥ��â
		panel1_2.add(label1_1); // ��ūǥ��â
		
		panel1_2.add(finaltext1);
		panel1_2.add(finalButton1);

		panel2.add(new JLabel("player 2"));
		panel2.add(text2);
		panel2.add(button2);
		panel2_1.add(label2); // ǥ��â
		panel2_2.add(label2_1); // ��ūǥ��â
		
		panel2_2.add(finaltext2);
		panel2_2.add(finalButton2);

		contentPane0.setLayout(new GridLayout(4, 4, 30, 10));
		for (int i = 0; i < Bobject.length; i++) {
			contentPane0.add(Cobject[i] = new JButton(Bobject[i]));
		}

		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(panel_1, BorderLayout.CENTER);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		contentPane1.add(panel1, BorderLayout.SOUTH);
		contentPane1.add(panel1_1, BorderLayout.NORTH);
		contentPane1.add(panel1_2, BorderLayout.CENTER);

		contentPane2.add(panel2, BorderLayout.SOUTH);
		contentPane2.add(panel2_1, BorderLayout.NORTH);
		contentPane2.add(panel2_2, BorderLayout.CENTER);
		
		usecontentPane1.setLayout(new GridLayout(2,5,20,10));
		for(int i = 0; i < 10; i++) {
			usecontentPane1.add(useButton1[i] = new JButton("?"));
		}
		usecontentPane2.setLayout(new GridLayout(2,5,20,10));
		for(int i = 0; i < 10; i++) {
			usecontentPane2.add(useButton2[i] = new JButton("?"));
		}
	
		// button1 ��ư �Է½�
		button1.addActionListener(new ActionListener() {
			String token = "100";
			int count = 100;

			public void actionPerformed(ActionEvent e) {
				String num = text1.getText();
				num2 = Integer.parseInt(num);

				do {
					if (num2 > 9 && num2 <= 21) {
						label2.setText("������� 10�̻��� ���̽��ϴ�.");
						int token2 = Integer.parseInt(token);
						count -= num2;
						token2 -= num2;
						token = String.valueOf(token2);
						label1_1.setText("����� ���� �� :"+ token);
						label0.setText("player1�� �Է��߽��ϴ�.");
						
						cmp1 = new String(num);

					} else if (num2 < 10 && num2 > 0) {
						label2.setText("������� 10���ϸ� ���̽��ϴ�.");
						int token2 = Integer.parseInt(token);
						count -= num2;
						token2 -= num2;
						token = String.valueOf(token2);
						label1_1.setText("����� ���� �� :"+ token);
						label0.setText("player1�� �Է��߽��ϴ�.");
						
						cmp1 = new String(num);
					
					} else
						label2.setText("������� �߸��������ϴ�.");
				} while (count <= 0);
			}
		});

		// button2 ��ư �Է½�
		button2.addActionListener(new ActionListener() {

			String token = "100";
			int count = 100;
		
			public void actionPerformed(ActionEvent e) {
				String num1 = text2.getText();
				num4 = Integer.parseInt(num1);

				if (num4 > 9 && num4 <= 21) {
					label1.setText("������� 10�̻��� ���̽��ϴ�.");
					int token2 = Integer.parseInt(token);
					count -= num4;
					token2 -= num4;
					token = String.valueOf(token2);
					label2_1.setText("����� ���� �� :"+ token);
					label0_1.setText("player2�� �Է��߽��ϴ�.");
					
					cmp2 = new String(num1);

				} else if (num4 < 10 && num4 > 0) {
					label1.setText("������� 10���ϸ� ���̽��ϴ�.");
					int token2 = Integer.parseInt(token);
					count -= num4;
					token2 -= num4;
					token = String.valueOf(token2);
					label2_1.setText("����� ���� �� :"+ token);
					label0_1.setText("player2�� �Է��߽��ϴ�.");
					
					cmp2 = new String(num1);

				} else
					label1.setText("������� �߸��������ϴ�.");
			}
		});
		
		Cobject[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[0]);
				button0.setText(buttonnum);
			}
		});
		Cobject[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[1]);
				button0.setText(buttonnum);
			}
		});
		Cobject[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[2]);
				button0.setText(buttonnum);
			}
		});
		Cobject[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[3]);
				button0.setText(buttonnum);
			}
		});
		Cobject[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[4]);
				button0.setText(buttonnum);
			}
		});
		Cobject[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[5]);
				button0.setText(buttonnum);
			}
		});
		Cobject[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[6]);
				button0.setText(buttonnum);
			}
		});
		Cobject[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[7]);
				button0.setText(buttonnum);
			}
		});
		Cobject[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[8]);
				button0.setText(buttonnum);
			}
		});
		Cobject[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[9]);
				button0.setText(buttonnum);
			}
		});
		Cobject[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[10]);
				button0.setText(buttonnum);
			}
		});
		Cobject[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[11]);
				button0.setText(buttonnum);
			}
		});
		Cobject[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[12]);
				button0.setText(buttonnum);
			}
		});
		Cobject[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonnum = new String(Bobject[13]);
				button0.setText(buttonnum);
			}
		});
		
		
		//���Ȯ�� ��ư �Է½�
		button0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				compare1 = Integer.parseInt(cmp1);
				compare2 = Integer.parseInt(cmp2);
				buttonnum = new String(Bobject[i0]);

				if (compare1 > compare2) {
					label0_2.setText("�÷��̾�1�� �� Ů�ϴ�.");
					useButton1[i1].setText(buttonnum);
					textArea.append("�÷��̾�1�� "+buttonnum+" ��(��) ���������ϴ�."+'\n');
					i1++;
				} else if (compare1 < compare2) {
					label0_2.setText("�÷��̾�2�� �� Ů�ϴ�.");
					useButton2[i2].setText(buttonnum);
					textArea.append("�÷��̾�2�� "+buttonnum+" ��(��) ���������ϴ�."+'\n');
					i2++;
				} else {
					label0_2.setText("�� �÷��̾��� ���� �����ϴ�.");
					useButton1[i1].setText(buttonnum);
					textArea.append("�÷��̾�1�� "+buttonnum+" ��(��) ���������ϴ�."+'\n');
					i1++;
					useButton2[i2].setText(buttonnum);
					textArea.append("�÷��̾�2�� "+buttonnum+" ��(��) ���������ϴ�."+'\n');
					i2++;
				}

				i0++;
				label0.setText("���â     ");
				label0_1.setText("     ���â     ");
			}
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame0.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.pack();
		frame1.setVisible(true);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.pack();
		frame2.setVisible(true);
		useframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		useframe1.pack();
		useframe1.setVisible(true);
		useframe2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		useframe2.pack();
		useframe2.setVisible(true);
		whowin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		whowin.pack();
		whowin.setVisible(true);
		
		//player1 ���� ���
		CalculatorOption c1 = new CalculatorOption();
		c1.setVisible(true);
		c1.setLocation(100,550);
		c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//player2 ���� ���
		CalculatorOption c2 = new CalculatorOption();
		c2.setVisible(true);
		c2.setLocation(1500,550);
		c2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
