package co.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import co.gui.MailScreen.MyActionListener;

public class SmsScreen extends JFrame{
	
	Dimension lbl1 = new Dimension(100, 15);
	Dimension lbl2 = new Dimension(50, 15);
	
	JPanel center, bottom;
	JLabel fromLbl, toLbl, contentLbl;
	JTextField fromTxt, toTxt;
	JTextArea contentTxt;
	JButton send, cancel;
	
	SmsApp app = new SmsApp();
	
	public SmsScreen() {
		setTitle("SMS 보내기 UI");
		setSize(400, 300);
		setLayout(new BorderLayout());
		
		center = new JPanel();
		bottom = new JPanel();
		
		//라벨
		toLbl = new JLabel("받는사람");
		fromLbl = new JLabel("보내는사람");
		contentLbl = new JLabel("내용");
		toLbl.setPreferredSize(lbl1);
		fromLbl.setPreferredSize(lbl1);
		contentLbl.setPreferredSize(lbl2);
		
		//텍스트필드
		toTxt = new JTextField(20);
		fromTxt = new JTextField(20);
		contentTxt = new JTextArea(10, 25);
		
		//버튼
		send = new JButton("전송");
		send.addActionListener(new MyActionListener());
		cancel = new JButton("취소");
		cancel.addActionListener(new MyActionListener());
		
		center.add(toLbl);
		center.add(toTxt);
		center.add(fromLbl);
		center.add(fromTxt);
		center.add(contentLbl);
		center.add(contentTxt);
		
		bottom.add(send);
		bottom.add(cancel);
		
		add("Center", center);
		add("South", bottom);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Object src = e.getSource();
			
			if(src == send) {
				System.out.println("보내기버튼 성공");
				String from = fromTxt.getText();
				String to = toTxt.getText();
				String content = contentTxt.getText();
				if(app.SendSms(to, from, content).equals("Success")) {
					//콘솔에 "성공"; -> 값을 지워주도록
					JOptionPane.showMessageDialog(null, "발송성공", "전송결과",JOptionPane.DEFAULT_OPTION);
			}else {
				//콘솔에 "실패";
				JOptionPane.showMessageDialog(null, "발송실패", "에러",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
		
	}
	public static void main(String[] args) {
		new SmsScreen();
	}
}
