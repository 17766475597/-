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

public class CDManagement extends JFrame implements ActionListener{
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
	
	private String[] area= {"","ŷ��","�պ�","��½","��̨"};
	private String[] type= {"","����","����","�ƻ�","�ഺ","���","����"};
	private String[] flagg= {"","�ɽ�","���"};
	private JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
	private JTextField t1,t2,t4,t7,t8;
	private JComboBox c3,c5,c6;
	private JButton b1,b2,b3,b4,b5,b6;
	public CDManagement() {
		super("��Ƭ����ҳ��");
		l = new JLabel("��Ƭ������Ϣ");
		Font f = new Font("����",Font.CENTER_BASELINE,32);
		l.setFont(f);
		l.setBounds(180,20,240,30);
		l.setForeground(Color.BLUE);
		add(l);
		
		Font f1 = new Font("����",Font.CENTER_BASELINE,20);
		l1 = new JLabel("��Ƭ���:");
		l1.setFont(f1);
		l1.setBounds(60, 73, 110, 23);
		add(l1);
			
		t1 = new JTextField(10);
		t1.setBounds(175, 73, 90, 23);
		t1.setFont(f1);
		add(t1);
		
		l2 = new JLabel("��Ƭ����:");
		l2.setFont(f1);
		l2.setBounds(290, 73, 110, 23);
		add(l2);
		
		t2 = new JTextField(10);
		t2.setBounds(405, 73, 90, 23);
		t2.setFont(f1);
		add(t2);
		
		l3 = new JLabel("��Ƭ����:");
		l3.setFont(f1);
		l3.setBounds(60, 120, 110, 23);
		add(l3);
		
		c3 = new JComboBox(type);
		c3.setMaximumRowCount(7);
		c3.setBounds(175, 120, 90, 23);
		add(c3);
		
		l4 = new JLabel("��Ƭ���:");
		l4.setFont(f1);
		l4.setBounds(290,120,110,23);
		add(l4);
		
		t4 = new JTextField(10);
		t4.setBounds(405, 120, 90, 23);
		t4.setFont(f1);
		add(t4);
		
		l5 = new JLabel("����־:");
		l5.setFont(f1);
		l5.setBounds(60,167,110,23);
		add(l5);
		
		c5= new JComboBox(flagg);
		c5.setMaximumRowCount(3);
		c5.setBounds(175, 167, 90, 23);
		add(c5);
		
		l6 = new JLabel("���е���:");
		l6.setFont(f1);
		l6.setBounds(290,167,110,23);
		add(l6);
		
		c6= new JComboBox(area);
		c6.setMaximumRowCount(5);
		c6.setBounds(405, 167, 90, 23);
		add(c6);
		
		l7 = new JLabel("��Ƭ��ע:");
		l7.setFont(f1);
		l7.setBounds(110,214,110,23);
		add(l7);
		
		t7 = new JTextField(10);
		t7.setBounds(235, 214, 130, 23);
		t7.setFont(f1);
		add(t7);
		
		l8 = new JLabel("���޴���:");
		l8.setFont(f1);
		l8.setBounds(110,261,110,23);
		add(l8);
		
		t8 = new JTextField("0");
		t8.setBounds(235, 261, 130, 23);
		t8.setFont(f1);
		t8.setEditable(false);
		add(t8);
		
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
		
		b5 = new JButton("����");
		b1 = new JButton("���");
		b2 = new JButton("�޸�");
		b3 = new JButton("ɾ��");
		b4 = new JButton("ȡ��");
		b6 = new JButton("��ѯ");
		
		b5.setFont(f1);
		b4.setFont(f1);
		b3.setFont(f1);
		b2.setFont(f1);
		b1.setFont(f1);
		b6.setFont(f1);
		
		b5.setBounds(60, 310, 80, 27);
		b1.setBounds(150, 310, 80, 27);
		b2.setBounds(240, 310, 80, 27);
		b3.setBounds(330, 310, 80, 27);
		b4.setBounds(420, 310, 80, 27);
		b6.setBounds(400, 228, 80, 27);
		
		add(b5);
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b6);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent arg1) {
		if(arg1.getSource()==b5) {
			new JOptionPane().showMessageDialog(null, "�����Ϣʱ����Ҫ�����Ƭ���"+"\n"+"ɾ�����޸���Ϣʱ�Ե�Ƭ���Ϊ׼");
		}
		
		if(arg1.getSource()==b4) {
			dispose();
		}
		
		if(arg1.getSource()==b1) {
			String s2,s3,s4,s5,s6,s7,s8;
			s2 = t2.getText();
			s3 = (String) c3.getSelectedItem();
			s4 = t4.getText();
			s5 = (String) c5.getSelectedItem();
			s6 = (String) c6.getSelectedItem();
			s7 = t7.getText();
			s8 = t8.getText();
			String sql1="insert into CD(CD_name,CD_type,CD_money,CD_flag,CD_area,CD_note,CD_time) values('"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
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
				 e.printStackTrace();
			 }
			 if(flag==1) {
				 new JOptionPane().showMessageDialog(null, "��ӳɹ�");
			 }
				t1.setText("");
				t2.setText("");
				t4.setText("");
				t7.setText("");
				t8.setText("");
		}
		
		if(arg1.getSource()==b2) {
			flag=1;
			String s1,s2,s3,s4,s5,s6,s7,s8;
			s1 = t1.getText().trim();
			s2 = t2.getText();
			s3 = (String) c3.getSelectedItem();
			s4 = t4.getText();
			s5 = (String) c5.getSelectedItem();
			s6 = (String) c6.getSelectedItem();
			s7 = t7.getText();
			
			String sql1="update CD set CD_name='"+s2+"' ,CD_type='"+s3+"' ,CD_money='"+s4+"' ,CD_flag='"+s5+"' ,CD_area='"+s6+"' ,CD_note='"+s7+"' where CD_no='"+s1+"'";
		
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
				t1.setText("");
				t2.setText("");
				t4.setText("");
				t7.setText("");
				t8.setText("");
		}
		
		if(arg1.getSource()==b3) {
			flag=1;
			String s1;
			s1 = t1.getText().trim();
			
			String sql1="delete from CD where CD_no='"+s1+"'";
		
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
				t1.setText("");
				t2.setText("");
				t4.setText("");
				t7.setText("");
				t8.setText("");
		}
		if(arg1.getSource()==b6) {
			String s1;
			s1 = t1.getText().trim();
			
			String sql1="select * from CD where CD_no='"+s1+"'";
			System.out.println(sql1);
			
			try {
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql1);
				while(rs.next()) {
					t2.setText(rs.getString(2).trim());
					c3.setSelectedItem(rs.getString(3).trim());
					t4.setText(rs.getString(4).trim());
					c5.setSelectedItem(rs.getString(5).trim());
					c6.setSelectedItem(rs.getString(6).trim());
					t7.setText(rs.getString(7).trim());
					t8.setText(rs.getString(8).trim());
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}				
		}
	}
}
