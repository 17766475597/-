package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class CustomerRent extends JFrame implements ActionListener{
	
	String url = "jdbc:sqlserver://localhost:1433; DatabaseName=dpcz";  
    String user = "sa";  
    String password = "123";  
    static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";  
    int flag=1;
    Connection conn;  
    Statement st;  
    // 1����������  
    static {  
        try {  
            Class.forName(driverName);  
        } catch (ClassNotFoundException e) {  
            System.out.println("��������ʧ��");  
        }  
    }  
    // 2���������Ӷ���  
    public  Connection getConnection() throws SQLException{  
        conn=DriverManager.getConnection(url,user,password);  
        return conn;  
    }  
	
	private JLabel l,l1,l2,l3,l4,l5,l6,l7;
	private JTextField t1,t2,t3,t4,t5,t6,t7;
	private JButton b1,b2,b3,b4;
	
	public CustomerRent(){
		super("�˿����");
		l = new JLabel("�˿�������Ϣ");
		Font f = new Font("����",Font.CENTER_BASELINE,30);
		l.setFont(f);
		l.setBounds(140,40,240,30);
		l.setForeground(Color.BLUE);
		add(l);
		
		Font f1 = new Font("����",Font.CENTER_BASELINE,20);
		
		l1 = new JLabel("��Ƭ���:");
		l1.setFont(f1);
		l1.setBounds(100, 90, 120, 23);
		add(l1);
		
		t1 = new JTextField(CustomerOrder.sCD_no);
		t1.setFont(f1);
		t1.setBounds(230, 90, 130, 23);
		t1.setEditable(false);
		add(t1);
		
		l2 = new JLabel("��Ա���:");
		l2.setFont(f1);
		l2.setBounds(100, 140, 120, 23);
		add(l2);
		
		t2 = new JTextField("0");
		t2.setFont(f1);
		t2.setBounds(230, 140, 130, 23);
		t2.setEditable(false);
		add(t2);
		
		l3 = new JLabel("ְ�����:");
		l3.setFont(f1);
		l3.setBounds(100, 190, 120, 23);
		add(l3);
		
		t3 = new JTextField(EmployeeLogin.seno);
		t3.setFont(f1);
		t3.setBounds(230, 190, 130, 23);
		t3.setEditable(false);
		add(t3);
		
		l4 = new JLabel("��������:");
		l4.setFont(f1);
		l4.setBounds(100, 240, 120, 23);
		add(l4);
		
		t4 = new JTextField(CustomerOrder.srentdate);
		t4.setFont(f1);
		t4.setBounds(230, 240, 130, 23);
		add(t4);
		
		l5 = new JLabel("�黹����:");
		l5.setFont(f1);
		l5.setBounds(100, 290, 120, 23);
		add(l5);
		
		t5 = new JTextField(CustomerOrder.sreturndate);
		t5.setFont(f1);
		t5.setBounds(230, 290, 130, 23);
		add(t5);
		
		String s6 = "";
		String sql1 = "select CD_money from CD where CD_no='"+t1.getText()+"'";
		System.out.println(sql1);
		try {
			st = getConnection().createStatement();
			ResultSet rs = st.executeQuery(sql1);
			while(rs.next()) {
				s6 = rs.getString(1);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		l6 = new JLabel("��Ƭ���:");
		l6.setFont(f1);
		l6.setBounds(100, 340, 120, 23);
		add(l6);
		
		t6 = new JTextField(s6);
		t6.setFont(f1);
		t6.setBounds(230, 340, 130, 23);
		t6.setEditable(false);
		add(t6);
		
		l7 = new JLabel("���ޱ�־:");
		l7.setFont(f1);
		l7.setBounds(100,390,120,23);
		add(l7);
		
		t7 = new JTextField("δ��");
		t7.setFont(f1);
		t7.setBounds(230, 390, 130, 23);
		t7.setEditable(false);
		add(t7);
		
		b1 = new JButton("����");
		b1.setBounds(40, 450, 100, 26);
		b1.setFont(f1);
		add(b1);
		
		b2 = new JButton("�ύ");
		b2.setBounds(150, 450, 100, 26);
		b2.setFont(f1);
		add(b2);
		
		b3 = new JButton("����");
		b3.setBounds(260, 450, 100, 26);
		b3.setFont(f1);
		add(b3);
		
		b4 = new JButton("ȡ��");
		b4.setBounds(370, 450, 100, 26);
		b4.setFont(f1);
		add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(500, 600, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,500,600);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setBounds(300,100,500,600);
	}
	
	public void actionPerformed(ActionEvent arg1) {
		if(arg1.getSource()==b1) {
			new JOptionPane().showMessageDialog(null, "��Ա���Ĭ��Ϊ0����˿�\n���ڸ�ʽΪyyyy-mm-dd\n����ɵ�Ƭ���ȷ��");
		}
		if(arg1.getSource()==b3) {
			t1.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
		}
		if(arg1.getSource()==b4) {
			dispose();
		}
		if(arg1.getSource()==b2) {
			String s1,s2,s3,s4,s5,s6,s7;
			s1 = t1.getText();
			s2 = t2.getText();
			s3 = t3.getText();
			s4 = t4.getText();
			s5 = t5.getText();
			s6 = t6.getText();
			s7 = t7.getText();
			
			String sql1 = "select CD_flag,CD_money,CD_time from CD where CD_no='"+s1+"';";
			System.out.println(sql1);
			
			String time = "";
			
			try {
				int flag=1;
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql1);
				while(rs.next()) {
					s6 = rs.getString(2);
					time = rs.getString(3);
					if(rs.getString(1).trim().equals("���")) {
						new JOptionPane().showMessageDialog(null, "�õ�Ƭ�ѽ��!");
						flag=0;
					}
				}
				if(flag==1) {
					rs.close();
					String sql2="insert into Rent values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"')";
					System.out.println(sql2);
					st.executeUpdate(sql2);
					
					int time1 = Integer.parseInt(time);
					time1++;
					time = Integer.toString(time1);
					
					String sql3="update CD set CD_flag='���' ,CD_time='"+time+"' where CD_no='"+s1+"'";
					System.out.println(sql3);
					st.executeUpdate(sql3);
					new JOptionPane().showMessageDialog(null, "���ɹ�!");
				}
			}catch(Exception e) {
				e.printStackTrace();    
			}
		}
	}
}
