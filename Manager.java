package system;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class Manager extends JFrame implements ActionListener{
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
	private JMenuItem mi14;
	
	public Manager() {
		super("����Ա���桪����ӭ "+ManagerLogin.smname.trim()+" ��¼");
		mi1 = new JMenuItem("��Ŀ��ѯ");
		mi13 = new JMenuItem("�����ѯ");
		mi14 =  new JMenuItem("ְ��ҵ��");
		mi2 = new JMenuItem("��Ƭ��ѯ");
		mi3 = new JMenuItem("��Ƭ����");
		mi12 = new JMenuItem("������Ƭ");
		mi4 = new JMenuItem("��Ա��ѯ");
		mi5 = new JMenuItem("��Ա����");
		mi6 = new JMenuItem("��Աע��");
		mi7 = new JMenuItem("ӪҵԱ��ѯ");
		mi8 = new JMenuItem("ӪҵԱ����");
		mi9 = new JMenuItem("����Ա����");
		mi10 = new JMenuItem("���µ�¼");
		mi11 = new JMenuItem("�˳�ϵͳ");
		
		m1 = new JMenu("��Ŀ��Ϣ");
		m2 = new JMenu("��Ƭ��Ϣ");
		m3 = new JMenu("��Ա��Ϣ");
		m4 = new JMenu("ӪҵԱ��Ϣ");
		m5 = new JMenu("������Ϣ");
		m6 = new JMenu("ϵͳ����");
		mb = new JMenuBar();
		
		m1.add(mi1);
		m1.add(mi13);
		m1.add(mi14);
		mb.add(m1);
		
		m2.add(mi2);
		m2.add(mi3);
		m2.add(mi12);
		mb.add(m2);
		
		m3.add(mi4);
		m3.add(mi5);
		m3.add(mi6);
		mb.add(m3);
		
		m4.add(mi7);
		m4.add(mi8);
		mb.add(m4);
		
		m5.add(mi9);
		mb.add(m5);
		
		m6.add(mi10);
		m6.add(mi11);
		mb.add(m6);
		
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
		mi14.addActionListener(this);
				
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
			SearchRentRecord sr = new SearchRentRecord();
		}
		if(arg1.getSource()==mi2) {
			SearchCD s1 = new SearchCD();
		}
		if(arg1.getSource()==mi3) {
			CDManagement c = new CDManagement();
		}
		if(arg1.getSource()==mi4) {
			SearchVip v = new SearchVip();		
		}
		if(arg1.getSource()==mi5) {
			VipManagement v = new VipManagement();
		}
		if(arg1.getSource()==mi6) {
			VipAdd vd = new VipAdd();		
		}
		if(arg1.getSource()==mi7) {
			SearchEmployee s1 = new SearchEmployee();
		}
		if(arg1.getSource()==mi8) {
			EmployeeManagement e = new EmployeeManagement();		
		}
		if(arg1.getSource()==mi9) {
			ManagerManagement m = new ManagerManagement();
		}
		if(arg1.getSource()==mi10) {
			dispose();
			Login l = new Login();
		}
		if(arg1.getSource()==mi11) {
			System.exit(0);
		}
		if(arg1.getSource()==mi12) {
			TopCD t = new TopCD();
		}
		if(arg1.getSource()==mi13) {
			Profit p = new Profit();
		}
		if(arg1.getSource()==mi14) {
			EmployeeRevenue er = new EmployeeRevenue();
		}
	}
}
