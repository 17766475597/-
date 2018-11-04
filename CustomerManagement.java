package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class CustomerManagement extends JFrame implements ActionListener{
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
	
	
	private String[] sex= {"","��","Ů"};
	private JLabel l,l1,l2,l3,l4;
	private JTextField t1,t2,t4;
	private JComboBox c3;
	private JButton b1,b2,b3,b4,b5;
	public CustomerManagement() {
		super("�˿Ͳ���ҳ��");
		l = new JLabel("�˿ͻ�����Ϣ");
		Font f = new Font("����",Font.CENTER_BASELINE,32);
		l.setFont(f);
		l.setBounds(180,20,240,30);
		l.setForeground(Color.BLUE);
		add(l);
		
		Font f1 = new Font("����",Font.CENTER_BASELINE,20);
		l1 = new JLabel("�˿ͱ��:");
		l1.setFont(f1);
		l1.setBounds(60, 73, 110, 23);
		add(l1);
			
		t1 = new JTextField(10);
		t1.setBounds(175, 73, 90, 23);
		t1.setFont(f1);
		add(t1);
		
		l2 = new JLabel("�˿�����:");
		l2.setFont(f1);
		l2.setBounds(290, 73, 110, 23);
		add(l2);
		
		t2 = new JTextField(10);
		t2.setBounds(405, 73, 90, 23);
		t2.setFont(f1);
		add(t2);
		
		l3 = new JLabel("�˿��Ա�:");
		l3.setFont(f1);
		l3.setBounds(60, 123, 110, 23);
		add(l3);
			
		c3= new JComboBox(sex);
		c3.setMaximumRowCount(3);
		c3.setBounds(175, 123, 90, 23);
		add(c3);
		
		l4 = new JLabel("�˿͵绰:");
		l4.setFont(f1);
		l4.setBounds(290,123,110,23);
		add(l4);
		
		t4 = new JTextField(10);
		t4.setBounds(405, 123, 90, 23);
		t4.setFont(f1);
		add(t4);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(600, 370, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,600,370);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setBounds(300,100,600,370);
		
		b5 = new JButton("����");
		b1 = new JButton("���");
		b2 = new JButton("�޸�");
		b3 = new JButton("ɾ��");
		b4 = new JButton("ȡ��");
		
		b5.setFont(f1);
		b4.setFont(f1);
		b3.setFont(f1);
		b2.setFont(f1);
		b1.setFont(f1);
		
		b5.setBounds(60, 240, 80, 27);
		b1.setBounds(150, 240, 80, 27);
		b2.setBounds(240, 240, 80, 27);
		b3.setBounds(330, 240, 80, 27);
		b4.setBounds(420, 240, 80, 27);
		
		add(b5);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this); 
		
	}
	
	public void actionPerformed(ActionEvent arg1) {
		if(arg1.getSource()==b5) {
			new JOptionPane().showMessageDialog(null, "�����Ϣʱ����Ҫ����ְ�����"+"\n"+"ɾ�����޸���Ϣʱ����Ϣ���Ϊ׼");
		}
		
		if(arg1.getSource()==b4) {
			dispose();
		}
		
		if(arg1.getSource()==b1) {
			String s2,s3,s4;
			s2 = t2.getText();
			s3 = (String) c3.getSelectedItem();
			s4 = t4.getText();
			String sql1="insert into Customer(cname,csex,cphone) values('"+s2+"','"+s3+"','"+s4+"')";
			try {
				st=getConnection().createStatement();
				st.executeUpdate(sql1);
			}catch(Exception ex) {
				 flag=0;
				 new JOptionPane().showMessageDialog(null, "���ʧ��");
			 }
			try {
				 st.close();  
			     getConnection().close();  
			 }catch(Exception e) {
				 
			 }
			 if(flag==1) {
				 new JOptionPane().showMessageDialog(null, "��ӳɹ�");
			 }
		}
		
		if(arg1.getSource()==b2) {
			String s1,s2,s3,s4;
			s1 = t1.getText().trim();
			s2 = t2.getText();
			s3 = (String) c3.getSelectedItem();
			s4 = t4.getText();

			String sql1="update Customer set cname='"+s2+"' ,csex='"+s3+"' ,cphone='"+s4+"' where cno='"+s1+"'";
		
			System.out.println(sql1);
			
			try {
				 st=getConnection().createStatement();  
				 st.executeUpdate(sql1);
			 }catch(Exception ex) {
				 ex.printStackTrace();
				 flag=0;
				 new JOptionPane().showMessageDialog(null, "�޸�ʧ��");
			 }
			 try {
				 st.close();  
			     getConnection().close();  
			 }catch(Exception e) {
				 
			 }
			 if(flag==1) {
				 new JOptionPane().showMessageDialog(null, "�޸ĳɹ�");
			 }
		}
		
		if(arg1.getSource()==b3) {
			String s1;
			s1 = t1.getText().trim();
			
			String sql1="delete from Customer where cno='"+s1+"'";
		
			System.out.println(sql1);
			
			try {
				 st=getConnection().createStatement();  
				 st.executeUpdate(sql1);
			 }catch(Exception ex) {
				 ex.printStackTrace();
				 flag=0;
				 new JOptionPane().showMessageDialog(null, "ɾ��ʧ��");
			 }
			 try {
				 st.close();  
			     getConnection().close();  
			 }catch(Exception e) {
				 
			 }
			 if(flag==1) {
				 new JOptionPane().showMessageDialog(null, "ɾ���ɹ�");
			 }
		}
		t1.setText("");
		t2.setText("");
		t4.setText("");
	}
}
