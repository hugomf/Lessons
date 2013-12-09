import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class ThreadSample extends JFrame implements ActionListener,Runnable {

	//������� ����������� � ������������ ��������
	ThreadSample () {
		//������
		JButton btn = new JButton("Kill him!");
		btn.addActionListener(this);
		//����
		JTextField fl = new JTextField("Insert your number");
		//������������� ������ � ��������� ��������
		this.getContentPane().setLayout(new GridLayout(2, 1));
		this.getContentPane().add(btn);
		this.getContentPane().add(fl);
		
	}
	

	public static void main(String[] args) {
		ThreadSample frame = new ThreadSample();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 150, 150);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		for(int i = 0; i < 300000; i++) {
			this.setTitle("i =" + i);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Thread worker = new Thread(this);
		worker.start(); // - �������� ����� run 
		
		
	
	
	
	}

}

