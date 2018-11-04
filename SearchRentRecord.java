package system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SearchRentRecord extends JFrame implements ActionListener{
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
	
	private JLabel l,l1;
	private JTextField t1;
	private JButton b1;
	private JTable table;
	private JComboBox c1;
	private String[] type = {"","��ݲ�ѯ","�·ݲ�ѯ","��Ƭ����","���е���","ȫ����¼"};
	private String[] columnname = {"��Ƭ����","ְ������","��Ա����","�������","�黹����","���޽��","����־"};
	private String[][] r = {};
	private Object[][] obj = new Object[20][7]; 
	DefaultTableModel model=new DefaultTableModel(columnname,20);
	
	public SearchRentRecord(){
		super("��Ŀ��ѯ");
		Font f = new Font("����",Font.CENTER_BASELINE,32);
		Font f1 = new Font("����",Font.CENTER_BASELINE,20);
		Font f2 = new Font("����",Font.CENTER_BASELINE,18);
		
		l = new JLabel("��Ŀ��¼��ѯ");
		l.setFont(f);
		l.setBounds(180,20,240,30);
		l.setForeground(Color.BLUE);
		add(l);
		
		l1 = new JLabel("��ѯ����:");
		l1.setFont(f1);
		l1.setBounds(40, 70,100, 23);
		add(l1);
		
		t1 = new JTextField();
		t1.setFont(f1);
		t1.setBounds(145, 70, 100, 23);
		add(t1);
		
		c1 = new JComboBox(type);
		c1.setFont(f2);
		c1.setBounds(260, 70, 120, 23);
		add(c1);
		
		b1 = new JButton("��ѯ");
		b1.setFont(f1);
		b1.setBounds(400, 70, 80, 23);
		add(b1);

		
		table = new JTable(r,columnname);
		table.setBounds(40,120,600,400);
		table.setRowHeight(23);
		table.setModel(model);
		table.setEnabled(false);
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setBounds(40,120,600,400);
		add(scrollpane);
		
		b1.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(700, 630, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,700,630);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		this.setLayout(null);
        this.setVisible(true);
        this.setBounds(300,100,700,630);
	}
	
	public void actionPerformed(ActionEvent arg1) {
		
		if(arg1.getSource()==b1) {
			for(int i=0;i<20;i++) {
				for(int j=0;j<7;j++) {
					model.setValueAt(null,i,j);
				}
			}
			obj[0][0]=null;
			String s1 = t1.getText().trim();
			String sitem = (String) c1.getSelectedItem();
			String sql2 = "";
			try {
					st = getConnection().createStatement();
					if(sitem.equals("��Ƭ����")) {
						sql2 = "select CD_name,ename,vname,rentdate,returndate,rmoney,rflag from CD,Employee,Vip,Rent where CD_type='"+s1+"' and Rent.vno=Vip.vno and Rent.CD_no=CD.CD_no and Rent.eno=Employee.eno;";
					}else if(sitem.equals("���е���")) {
						sql2 = "select CD_name,ename,vname,rentdate,returndate,rmoney,rflag from CD,Employee,Vip,Rent where CD_area='"+s1+"' and Rent.vno=Vip.vno and Rent.CD_no=CD.CD_no and Rent.eno=Employee.eno;";
					}else if(sitem.equals("��ݲ�ѯ")) {
						String sy = s1.substring(0, 4);
						sql2 = "select CD_name,ename,vname,rentdate,returndate,rmoney,rflag from CD,Employee,Vip,Rent where Rent.rentdate like '"+sy+"%' and Rent.vno=Vip.vno and Rent.CD_no=CD.CD_no and Rent.eno=Employee.eno;";
					}else if(sitem.equals("�·ݲ�ѯ")) {
						String sy = s1.substring(0, 7);
						sql2 = "select CD_name,ename,vname,rentdate,returndate,rmoney,rflag from CD,Employee,Vip,Rent where Rent.rentdate like '"+sy+"%' and Rent.vno=Vip.vno and Rent.CD_no=CD.CD_no and Rent.eno=Employee.eno;";
					}else if(sitem.equals("ȫ����¼")){
						sql2 = "select CD_name,ename,vname,rentdate,returndate,rmoney,rflag from CD,Employee,Vip,Rent where Rent.vno=Vip.vno and Rent.CD_no=CD.CD_no and Rent.eno=Employee.eno";
					}else {
						new JOptionPane().showMessageDialog(null, "��ѡ���ѯ���");
					}
					
					System.out.println(sql2);
					 ResultSet rs2 = st.executeQuery(sql2);
					 
					 int k=0;
					 while(rs2.next()) {
						for(int i=0;i<7;i++) {
							obj[k][i]=rs2.getString(i+1).trim();	
							model.setValueAt(rs2.getString(i+1).trim(), k, i);
						}
						k++;
					}
					 
					if(obj[0][0]==null) {
						new JOptionPane().showMessageDialog(null, "��ѯ���Ϊ�գ�");
					}
					 
					 
					 DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
						r.setHorizontalAlignment(JLabel.CENTER);   
						table.setDefaultRenderer(Object.class, r);;
						table.setModel(model);
						table.setRowHeight(23);
				 
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
