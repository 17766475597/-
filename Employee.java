package system;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.*;

public class Employee extends JFrame implements ActionListener{
	private JMenu m1;
	private JMenu m2;
	private JMenu m3;
	private JMenu m4;
	private JMenu m5;
	private JMenu m6;
	private JMenuBar mb;
	private JMenuItem mi1;
	private JMenuItem mi2;
	private JMenuItem mi3;
	private JMenuItem mi4;
	private JMenuItem mi5;
	private JMenuItem mi6;
	private JMenuItem mi7;
	private JMenuItem mi8;
	private JMenuItem mi9;
	private JMenuItem mi10;
	private JMenuItem mi11;
	private JMenuItem mi12;
	private JMenuItem mi13;
	
	public Employee() {
		super("ӪҵԱ���桪����ӭ "+EmployeeLogin.sename.trim()+" ��¼");
		mi1 = new JMenuItem("��Ƭ��ѯ");
		mi13 = new JMenuItem("������Ƭ");
		mi2 = new JMenuItem("��Ա��ѯ");
		mi3 = new JMenuItem("��Ա����");
		mi4 = new JMenuItem("��Աע��");
		mi5 = new JMenuItem("�˿Ͳ�ѯ");
		mi6 = new JMenuItem("�˿͹���");
		mi7 = new JMenuItem("��Ա����");
		mi8 = new JMenuItem("�˿�����");
		mi9 = new JMenuItem("���µ�¼");
		mi10 = new JMenuItem("�˳�ϵͳ");
		mi11 = new JMenuItem("��Ա�黹");
		mi12 = new JMenuItem("�˿͹黹");
		
		m1 = new JMenu("��Ƭ��Ϣ");
		m2 = new JMenu("��Ա��Ϣ");
		m3 = new JMenu("�˿���Ϣ");
		m4 = new JMenu("���޲���");
		m5 = new JMenu("ϵͳ����");
		m6 = new JMenu("�黹����");
		mb = new JMenuBar();
		
		m1.add(mi1);
		m1.add(mi13);
		mb.add(m1);
		
		m2.add(mi2);
		m2.add(mi3);
		m2.add(mi4);
		mb.add(m2);
		
		m3.add(mi5);
		m3.add(mi6);
		mb.add(m3);
		
		m4.add(mi7);
		m4.add(mi8);
		mb.add(m4);
		
		m6.add(mi11);
		m6.add(mi12);
		mb.add(m6);
		
		m5.add(mi9);
		m5.add(mi10);
		mb.add(m5);
		
		Font f1 = new Font("����",Font.CENTER_BASELINE,14);
		m1.setFont(f1);
		m2.setFont(f1);
		m3.setFont(f1);
		m4.setFont(f1);
		m5.setFont(f1);
		m6.setFont(f1);
		mi1.setFont(f1);
		mi2.setFont(f1);
		mi3.setFont(f1);
		mi4.setFont(f1);
		mi5.setFont(f1);
		mi6.setFont(f1);
		mi7.setFont(f1);
		mi8.setFont(f1);
		mi9.setFont(f1);
		mi10.setFont(f1);
		mi11.setFont(f1);
		mi12.setFont(f1);
		mi13.setFont(f1);
		
		setJMenuBar(mb);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);
		mi7.addActionListener(this);
		mi8.addActionListener(this);
		mi9.addActionListener(this);
		mi10.addActionListener(this);
		mi11.addActionListener(this);
		mi12.addActionListener(this);
		mi13.addActionListener(this);
				
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
			SearchVip s2 = new SearchVip();
		}
		if(arg1.getSource()==mi3) {
			VipManagement e = new VipManagement();		
		}
		if(arg1.getSource()==mi4) {
			VipAdd r2 = new VipAdd();
		}
		if(arg1.getSource()==mi5) {
			SearchCustomer s3 = new SearchCustomer();		
		}
		if(arg1.getSource()==mi6) {
			CustomerManagement v = new CustomerManagement();	
		}
		if(arg1.getSource()==mi7) {
			VipOrder r1 = new VipOrder();		
		}
		if(arg1.getSource()==mi8) {
			CustomerOrder r2 = new CustomerOrder();
		}
		if(arg1.getSource()==mi9) {
			dispose();
			Login l = new Login();
		}
		if(arg1.getSource()==mi10) {
			System.exit(0);
		}
		if(arg1.getSource()==mi11) {
			VipReturn cr = new VipReturn();
		}
		if(arg1.getSource()==mi12) {
			CustomerReturn cr = new CustomerReturn();
		}
		if(arg1.getSource()==mi13) {
			TopCD cr = new TopCD();
		}
	}
}

