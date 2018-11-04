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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class ManagerManagement extends JFrame implements ActionListener{
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
	private JLabel l,l1,l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3,t4,t5;
	private JComboBox c6;
	private JButton b1,b2,b3,b4;
	public ManagerManagement() {
		super("����Ա����ҳ��");
		l = new JLabel("����Ա������Ϣ");
		Font f = new Font("����",Font.CENTER_BASELINE,32);
		l.setFont(f);
		l.setBounds(180,20,240,30);
		l.setForeground(Color.BLUE);
		add(l);
		
		Font f1 = new Font("����",Font.CENTER_BASELINE,18);
		l1 = new JLabel("����Ա���:");
		l1.setFont(f1);
		l1.setBounds(60, 73, 110, 23);
		add(l1);
			
		t1 = new JTextField("1",10);
		t1.setBounds(175, 73, 90, 23);
		t1.setFont(f1);
		t1.setEditable(false);
		add(t1);
		
		l2 = new JLabel("����Ա����:");
		l2.setFont(f1);
		l2.setBounds(290, 73, 110, 23);
		add(l2);
		
		t2 = new JTextField(10);
		t2.setBounds(405, 73, 90, 23);
		t2.setFont(f1);
		add(t2);
		
		l3 = new JLabel("����Ա����:");
		l3.setFont(f1);
		l3.setBounds(60, 123, 110, 23);
		add(l3);
		
		t3 = new JTextField(10);
		t3.setFont(f1);
		t3.setBounds(175, 123, 90, 23);
		add(t3);
		
		l4 = new JLabel("����Ա����:");
		l4.setFont(f1);
		l4.setBounds(290,123,110,23);
		add(l4);
		
		t4 = new JTextField(10);
		t4.setBounds(405, 123, 90, 23);
		t4.setFont(f1);
		add(t4);
		
		l5 = new JLabel("����Ա�绰:");
		l5.setFont(f1);
		l5.setBounds(80,173,110,23);
		add(l5);	
		
		t5 = new JTextField(10);
		t5.setBounds(195, 173, 110, 23);
		t5.setFont(f1);
		add(t5);
		
		l6 = new JLabel("����Ա�Ա�:");
		l6.setFont(f1);
		l6.setBounds(80,223,110,23);
		add(l6);
		
		c6= new JComboBox(sex);
		c6.setMaximumRowCount(3);
		c6.setBounds(195, 223, 110, 23);
		add(c6);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(600, 400, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,600,400);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		setLayout(null);
		setResizable(false);
		setVisible(true);
		setBounds(300,100,600,400);
		
		b1 = new JButton("����");
		b2 = new JButton("�޸�");
		b3 = new JButton("ȡ��");
		b4 = new JButton("��ѯ");

		b4.setFont(f1);
		b3.setFont(f1);
		b2.setFont(f1);
		b1.setFont(f1);
		
		b1.setBounds(150, 280, 80, 27);
		b2.setBounds(240, 280, 80, 27);
		b3.setBounds(330, 280, 80, 27);
		b4.setBounds(345, 198, 80, 27);
		
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent arg1) {
		if(arg1.getSource()==b1) {
			new JOptionPane().showMessageDialog(null, "����Ա��Ϣֻ�ܽ����޸�");
		}
		
		if(arg1.getSource()==b3) {
			dispose();
		}
		
		if(arg1.getSource()==b2) {
			String s1,s2,s3,s4,s5,s6;
			s1 = t1.getText().trim();
			s2 = t2.getText();
			s3 = t3.getText();
			s4 = t4.getText();
			s5 = t5.getText();
			s6 = (String) c6.getSelectedItem();
			String sql1="update Management set mpassword='"+s2+"' ,mname='"+s3+"' ,mage='"+s4+"' ,mphone='"+s5+"' ,msex='"+s6+"' where mno='"+s1+"'";
		
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
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
		}
		if(arg1.getSource()==b4) {
			String sql = "select * from Management where mno='1';";
			try {
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql);
				while(rs.next()) {
					t2.setText(rs.getString(2).trim());
					t3.setText(rs.getString(3).trim());
					t4.setText(rs.getString(4).trim());
					t5.setText(rs.getString(5).trim());
					c6.setSelectedItem(rs.getString(6).trim());
					
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}
	
}
