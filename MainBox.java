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
		JFrame frame = new JFrame("숫자 추리 게임");
		JFrame frame0 = new JFrame("랜덤 숫자 기호 버튼");
		JFrame frame1 = new JFrame("player 1 console");
		JFrame frame2 = new JFrame("player 2 console");
		
		JFrame useframe1 = new JFrame("player 1 보관함");
		JFrame useframe2 = new JFrame("player 2 보관함");
		
		JFrame whowin = new JFrame("승리자 확인 페이지로 이동!");
		JFrame finalframe = new JFrame("승리자는?");

		Container contentPane = frame.getContentPane();
		Container contentPane0 = frame0.getContentPane();
		Container contentPane1 = frame1.getContentPane();
		Container contentPane2 = frame2.getContentPane();
		
		Container usecontentPane1 = useframe1.getContentPane();
		Container usecontentPane2 = useframe2.getContentPane();
		
		Container whowincontentPane = whowin.getContentPane(); 

		frame.setPreferredSize(new Dimension(500, 400));
		frame.setLocation(700, 400);
		frame0.setSize(500, 300);							//랜덤 숫자 기호 버튼 프레임
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
		JLabel finalcheck = new JLabel("승자는?");
		JButton realfinal = new JButton("결과확인");
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
		
		JButton finalButton1 = new JButton("최종결과");
		JTextField finaltext1 = new JTextField(5);//입력받는 문자공간
		JButton finalButton2 = new JButton("최종결과");
		JTextField finaltext2 = new JTextField(5);//입력받는 문자공간
		
		
		finalButton1.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				finalnum1 = finaltext1.getText();//입력받은값
				finallabel1.setText("1플레이어가 최종값을 입력하였습니다.");
				finalcmp1 = new String(finalnum1);		//string값으로 변경
			}
		});
		finalButton2.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				finalnum2 = finaltext2.getText();
				finallabel2.setText("2플레이어가 최종값을 입력하였습니다.");
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
					finalcheck.setText("1플레이어가 "+finaljw1+"으로 이겼습니다.");
				}
				else if(finaljw1 < finaljw2) {
					whowincontentPane.setLocation(700, 100);
					finalcheck.setText("2플레이어가 "+finaljw2+"으로 이겼습니다.");
				}
				else {
					whowincontentPane.setLocation(700, 100);
					finalcheck.setText("1 , 2플레이어가 "+finaljw1+"으로 비겼습니다.");
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
		

		JButton button0 = new JButton("버튼");
		JButton button0_1 = new JButton("결과 확인");
		JTextArea textArea = new JTextArea();
		textArea.setColumns(30);
		textArea.setRows(20);
		JLabel label0 = new JLabel("대기창     ");
		JLabel label0_1 = new JLabel("     대기창     ");
		JLabel label0_2 = new JLabel("???가 승리하였습니다.");
		

		
		// 1번은 전부 플레이어1 2번은 전부 플레이어2
		JTextField text1 = new JTextField(10);
		JTextField text2 = new JTextField(10);

		JButton button1 = new JButton("입력");
		JButton button2 = new JButton("입력");

		JLabel label1 = new JLabel("표시창");
		JLabel label1_1 = new JLabel("token = 100");
		JLabel label2 = new JLabel("표시창");
		JLabel label2_1 = new JLabel("token = 100");

		JPanel panel = new JPanel(); // label,button0,start
		JPanel panel_1 = new JPanel(); // textArea
		JPanel panel_2 = new JPanel(); // label0,label0_1,label0_2
		JPanel panel_3 = new JPanel(); // button0_1

		JPanel panel1 = new JPanel(); // label,text1,button1
		JPanel panel1_1 = new JPanel(); // label1 표시창
		JPanel panel1_2 = new JPanel(); // label1_1 토큰표시창

		JPanel panel2 = new JPanel(); // label,text1,button1
		JPanel panel2_1 = new JPanel(); // label2 표시창
		JPanel panel2_2 = new JPanel(); // label2_1 토큰표시창

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
		panel1_1.add(label1); // 표시창
		panel1_2.add(label1_1); // 토큰표시창
		
		panel1_2.add(finaltext1);
		panel1_2.add(finalButton1);

		panel2.add(new JLabel("player 2"));
		panel2.add(text2);
		panel2.add(button2);
		panel2_1.add(label2); // 표시창
		panel2_2.add(label2_1); // 토큰표시창
		
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
	
		// button1 버튼 입력시
		button1.addActionListener(new ActionListener() {
			String token = "100";
			int count = 100;

			public void actionPerformed(ActionEvent e) {
				String num = text1.getText();
				num2 = Integer.parseInt(num);

				do {
					if (num2 > 9 && num2 <= 21) {
						label2.setText("상대편이 10이상을 쓰셨습니다.");
						int token2 = Integer.parseInt(token);
						count -= num2;
						token2 -= num2;
						token = String.valueOf(token2);
						label1_1.setText("당신의 남은 돈 :"+ token);
						label0.setText("player1이 입력했습니다.");
						
						cmp1 = new String(num);

					} else if (num2 < 10 && num2 > 0) {
						label2.setText("상대편이 10이하를 쓰셨습니다.");
						int token2 = Integer.parseInt(token);
						count -= num2;
						token2 -= num2;
						token = String.valueOf(token2);
						label1_1.setText("당신의 남은 돈 :"+ token);
						label0.setText("player1이 입력했습니다.");
						
						cmp1 = new String(num);
					
					} else
						label2.setText("상대편이 잘못눌렀습니다.");
				} while (count <= 0);
			}
		});

		// button2 버튼 입력시
		button2.addActionListener(new ActionListener() {

			String token = "100";
			int count = 100;
		
			public void actionPerformed(ActionEvent e) {
				String num1 = text2.getText();
				num4 = Integer.parseInt(num1);

				if (num4 > 9 && num4 <= 21) {
					label1.setText("상대편이 10이상을 쓰셨습니다.");
					int token2 = Integer.parseInt(token);
					count -= num4;
					token2 -= num4;
					token = String.valueOf(token2);
					label2_1.setText("당신의 남은 돈 :"+ token);
					label0_1.setText("player2가 입력했습니다.");
					
					cmp2 = new String(num1);

				} else if (num4 < 10 && num4 > 0) {
					label1.setText("상대편이 10이하를 쓰셨습니다.");
					int token2 = Integer.parseInt(token);
					count -= num4;
					token2 -= num4;
					token = String.valueOf(token2);
					label2_1.setText("당신의 남은 돈 :"+ token);
					label0_1.setText("player2가 입력했습니다.");
					
					cmp2 = new String(num1);

				} else
					label1.setText("상대편이 잘못눌렀습니다.");
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
		
		
		//결과확인 버튼 입력시
		button0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				compare1 = Integer.parseInt(cmp1);
				compare2 = Integer.parseInt(cmp2);
				buttonnum = new String(Bobject[i0]);

				if (compare1 > compare2) {
					label0_2.setText("플레이어1이 더 큽니다.");
					useButton1[i1].setText(buttonnum);
					textArea.append("플레이어1이 "+buttonnum+" 을(를) 가져갔습니다."+'\n');
					i1++;
				} else if (compare1 < compare2) {
					label0_2.setText("플레이어2가 더 큽니다.");
					useButton2[i2].setText(buttonnum);
					textArea.append("플레이어2가 "+buttonnum+" 을(를) 가져갔습니다."+'\n');
					i2++;
				} else {
					label0_2.setText("두 플레이어의 값이 같습니다.");
					useButton1[i1].setText(buttonnum);
					textArea.append("플레이어1이 "+buttonnum+" 을(를) 가져갔습니다."+'\n');
					i1++;
					useButton2[i2].setText(buttonnum);
					textArea.append("플레이어2가 "+buttonnum+" 을(를) 가져갔습니다."+'\n');
					i2++;
				}

				i0++;
				label0.setText("대기창     ");
				label0_1.setText("     대기창     ");
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
		
		//player1 계산기 출력
		CalculatorOption c1 = new CalculatorOption();
		c1.setVisible(true);
		c1.setLocation(100,550);
		c1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//player2 계산기 출력
		CalculatorOption c2 = new CalculatorOption();
		c2.setVisible(true);
		c2.setLocation(1500,550);
		c2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
