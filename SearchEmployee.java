package system;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class SearchEmployee extends JFrame implements ActionListener{
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
	
	private JTable table;
	private JLabel l1;
	private String[] name = {"","ְ������","ְ������","ְ���绰","ְ���Ա�","ȫ��ְ��"};
	private String[] columnname = {"ְ�����","ְ������","ְ������","ְ������","ְ���绰","ְ���Ա�"};
	private String [][] r = {};
	private JTextField t1;
	private JComboBox c1;
	private JButton b1;
	private Object[][] obj = new Object[20][6]; 
	DefaultTableModel model=new DefaultTableModel(columnname,20);
	
	public SearchEmployee() {
		super("ӪҵԱ��ѯ");
		
		l1 = new JLabel("��ѯ���ݣ�");
		t1 = new JTextField(10);
		b1 = new JButton("��ѯ");
		c1 = new JComboBox(name);
		c1.setMaximumRowCount(6);
		Container container = getContentPane();
		container.setLayout(null);
		
		l1.setBounds(30, 20, 130, 20);
		Font font1 = new Font("����",Font.BOLD,21);
		l1.setFont(font1);
		add(l1);
		t1.setBounds(155, 18, 120, 24);
		Font font2 = new Font("����",Font.PLAIN,18);
		t1.setFont(font2);
		add(t1);
		
		c1.setBounds(300, 17, 90, 26);
		add(c1);
		
		Font font3 = new Font("����",Font.BOLD,18);
		b1.setFont(font3);
		b1.setBounds(410, 18, 80, 24);
		add(b1);

		
		table = new JTable(r,columnname);
		table.setBounds(40,80,600,400);
		table.setRowHeight(23);
		table.setModel(model);
		table.setEnabled(false);
		JScrollPane scrollpane=new JScrollPane(table);
		scrollpane.setBounds(40,80,600,400);
		add(scrollpane);
		
		b1.addActionListener(this);
		
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(700, 550, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,700,550);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
		
		this.setLayout(null);
        this.setVisible(true);
        this.setBounds(300,100,700,550);
	}
	
	public void actionPerformed(ActionEvent arg1) {
	
		if(arg1.getSource()==b1) {

				for(int i=0;i<20;i++) {
					for(int j=0;j<6;j++) {
						model.setValueAt(null,i,j);
					}
				}
			
			int flag = 0;
			String sitem = (String) c1.getSelectedItem();
			String stext = t1.getText().trim();
			
			if(sitem.equals("ְ������")) {
				sitem = "ename";
			}
			else if(sitem.equals("ְ������")) {
				sitem = "eage";
			}else if(sitem.equals("ְ���绰")){
				sitem = "ephone";
			}else if(sitem.equals("ְ���Ա�")){
				sitem = "esex";
			}else if(sitem.equals("ȫ��ְ��")){
				flag = 1;
			}else {
				new JOptionPane().showMessageDialog(null, "��ѡ���ѯ���");
			}
			
			String sql = "";
			if(flag==1) {
				sql = "select * from Employee;";
			}
			else {
				sql = "select * from Employee where "+sitem+"='"+stext+"';";
				System.out.println(sql);
			}
			
			try {
				st = getConnection().createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				int k=0;
				while(rs.next()) {
					for(int i=0;i<6;i++) {
						obj[k][i]=rs.getString(i+1).trim();	
						model.setValueAt(rs.getString(i+1).trim(), k, i);
					}
					k++;
				}
				
				if(obj[0][0]==null) {
					new JOptionPane().showMessageDialog(null, "��ѯ���Ϊ�գ�");
				}
				
				/*System.out.println(obj[0][0]);
				System.out.println(obj[0][1]);
				System.out.println(obj[0][2]);
				System.out.println(obj[0][3]);*/
			
				DefaultTableCellRenderer r = new DefaultTableCellRenderer();   
				r.setHorizontalAlignment(JLabel.CENTER);   
				table.setDefaultRenderer(Object.class, r);
				table.setModel(model);
				table.setRowHeight(23);
				table.setEnabled(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
