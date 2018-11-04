package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class CustomerReturn extends JFrame implements ActionListener{
	
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
	
	
	
	private JLabel l,l1,l2,l3;
	private JTextField t1,t2,t3;
	private JButton b1,b2,b3;
	
	public CustomerReturn() {
		super("�˿ͻ���");
		l = new JLabel("�˿͹黹��Ϣ");
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
		
		t1 = new JTextField();
		t1.setFont(f1);
		t1.setBounds(230, 90, 130, 23);
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
		
		b1 = new JButton("ȷ��");
		b1.setFont(f1);
		b1.setBounds(70, 250, 90, 25);
		add(b1);
		
		b2 = new JButton("����");
		b2.setFont(f1);
		b2.setBounds(170, 250, 90, 25);
		add(b2);
		
		b3 = new JButton("ȡ��");
		b3.setFont(f1);
		b3.setBounds(270, 250, 90, 25);
		add(b3);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(500, 400, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,500,400);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setBounds(300,100,500,400);
	}
	
	public void actionPerformed(ActionEvent arg1) {
		if(arg1.getSource()==b3) {
			dispose();
		}
		if(arg1.getSource()==b2) {
			t1.setText("");
		}
		if(arg1.getSource()==b1) {
			int flag=1;
			String s1,s2,s3;
			s1 = t1.getText();
			s2 = t2.getText();
			s3 = t3.getText();
			
			String judge = null;
			String sql = "select * from Rent where vno='0' and CD_no='"+s1+"';";
			try {
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(sql);
				while(rs.next()) {
					judge = rs.getString(1);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(judge==null) {
				new JOptionPane().showMessageDialog(null, "�˵�Ƭ�ǹ˿����� �黹ʧ�ܣ�");
			}
			else {
				String sql1 = "update Rent set rflag='�ѻ�' where CD_no='"+s1+"' and vno='"+s2+"' and eno ='"+s3+"'";
				String sql2 = "update CD set CD_flag='�ɽ�' where CD_no='"+s1+"'";
				
				try {
					st = getConnection().createStatement();
					st.executeUpdate(sql1);
					System.out.println(sql1);
					st.executeUpdate(sql2);
					System.out.println(sql2);
				}catch(Exception e) {
					
					 flag=0;
					e.printStackTrace();
				}
				if(flag==1) {
					new JOptionPane().showMessageDialog(null, "�黹�ɹ���");
				}
			}
		}
	}
}
