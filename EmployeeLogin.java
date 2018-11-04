package system;

import java.awt.Container;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;

public class EmployeeLogin extends JFrame implements ActionListener{
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
	
	static String seno = new String("");
	static String sename = new String("");
    
	JTextField textName=new JTextField("");
	JPasswordField textPassword=new JPasswordField("");
	JLabel label = new JLabel("ӪҵԱ��¼");
	JLabel labelName=new JLabel("�û�����");
	JLabel labelPassword=new JLabel("���룺");

	JButton buttonEnter=new JButton("��¼");
	JButton buttonCancel=new JButton("ȡ��");
	public EmployeeLogin() {
	    super("ӪҵԱ��¼");
	    Font f = new Font("����",Font.CENTER_BASELINE,25);
		Container container = getContentPane();
		container.setLayout(null);
		label.setBounds(120,20,200,30);
		label.setFont(f);
		container.add(label);
		
		labelName.setBounds(80, 68, 60, 40);
		container.add(labelName);
		textName.setBounds(150, 75, 120, 23);
		container.add(textName);
		
		labelPassword.setBounds(80, 118, 60 , 40);
		container.add(labelPassword);
		textPassword.setBounds(150, 125, 120, 23);
		container.add(textPassword);
		
		buttonEnter.setBounds(100, 178, 60, 20);
		buttonCancel.setBounds(200, 178, 60, 20);
		add(buttonEnter);
		add(buttonCancel);
		
		buttonEnter.addActionListener(this);
		buttonCancel.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\114.jpg"); 
	    Image img = icon.getImage().getScaledInstance(400, 280, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,400,280);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		setResizable(false);
		setVisible(true);
		setBounds(300,100,400,280);
	}

	public void actionPerformed(ActionEvent arg1){ 
		if(arg1.getSource()==buttonEnter) {
			 String sql = "select * from Employee where eno="+textName.getText().trim()+";";   //Ҫִ�е�SQL
			 
			 try {
				 st=getConnection().createStatement();  
				
				 ResultSet rs = st.executeQuery(sql);//�������ݶ���
				 String s = new String(textPassword.getPassword()).trim();
				 int flag=0;    //��¼�Ƿ�鵽�û���
				 while (rs.next()){
					 if(s.equals(rs.getString(2).trim())) {
						 new JOptionPane().showMessageDialog(null, "��¼�ɹ�");
						 seno = textName.getText();
						 sename = rs.getString(3);
						 flag=1;
						 Employee m = new Employee();
						 dispose();
					 }
					 else {
						 new JOptionPane().showMessageDialog(null, "������󣬵�¼ʧ�ܣ�");
						 flag=1;
					 }
				 }
				 if(flag==0) {
					 new JOptionPane().showMessageDialog(null, "�˺Ŵ��󣬵�¼ʧ�ܣ�");
				 }
				 rs.close();
	             st.close();
	             conn.close();
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		}
		
		if(arg1.getSource()==buttonCancel) {
			dispose();
		}
	}
}
