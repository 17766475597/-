package system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Customer extends JFrame implements ActionListener{
	private JMenu m1,m2,m3;
	private JMenuBar mb;
	private JMenuItem mi1,mi2,mi3,mi4,mi5;
	
	public Customer() {
		super("�˿ͽ��桪��ӭ����¼ϵͳ");
		Font f1 = new Font("����",Font.CENTER_BASELINE,14);
		mi1 = new JMenuItem("��Ƭ��ѯ");
		m1 = new JMenu("��Ƭ��Ϣ");
		mb = new JMenuBar();
		mi1.setFont(f1);
		m1.setFont(f1);
		m1.add(mi1);
		mi5 = new JMenuItem("������Ƭ");
		mi5.setFont(f1);
		m1.add(mi5);
		mb.add(m1);
		
		mi2 = new JMenuItem("��Ա����");
		m2 = new JMenu("������Ϣ");
		mi2.setFont(f1);
		m2.setFont(f1);
		m2.add(mi2);
		mb.add(m2);
		
		mi3 = new JMenuItem("���µ�¼");
		mi4 = new JMenuItem("�˳�ϵͳ");
		m3 = new JMenu("ϵͳ����");
		mi3.setFont(f1);
		mi4.setFont(f1);
		m3.setFont(f1);
		m3.add(mi3);
		m3.add(mi4);
		mb.add(m3);
		
		setJMenuBar(mb);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\115.jpg"); 
	    Image img = icon.getImage().getScaledInstance(1200, 800, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,1200,800);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
				
	    this.setResizable(false);
		this.setLayout(null);
        this.setVisible(true);
        this.setBounds(300,100,1200,800);  
	}
	
	public void actionPerformed(ActionEvent arg1){  
		if(arg1.getSource()==mi1) {
			SearchCD s1 = new SearchCD();
		}
		if(arg1.getSource()==mi2) {
			VipInfo vf = new VipInfo();
		}
		if(arg1.getSource()==mi3) {
			dispose();
			Login l = new Login();
		}
		if(arg1.getSource()==mi4) {
			System.exit(0);
		}
		if(arg1.getSource()==mi5) {
			TopCD t = new TopCD();
		}
	}
}
