package system;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class About extends JFrame{
	JLabel label = new JLabel("���л�����Windows 10�콢��");//������ǩ��ʵ����
	JLabel labe2 = new JLabel("�������ԣ�JAVA");//������ǩ��ʵ����
	JLabel labe3 = new JLabel("���ݿ����ͣ�Sql Server 2017");//������ǩ��ʵ����
	JLabel labe4 = new JLabel("������Ա������������ѧԺ�ƿ�1604������");//������ǩ��ʵ����
	public About(){//���췽��
        setTitle("����");//���ñ���
 	    Container con=getContentPane();
        con.setLayout(new GridLayout(4,1));//�������񲼾�
        con.add(label);//��ӱ�ǩ
        con.add(labe2);//��ӱ�ǩ
        con.add(labe3);//��ӱ�ǩ
        con.add(labe4);//��ӱ�ǩ
        
		ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\116.jpg"); 
	    Image img = icon.getImage().getScaledInstance(400, 300, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,400,300);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);

 	    setResizable(false);//���ɸ��Ĵ�С
 	    setBounds(300,100,400,300);//���ô�С
 	    setVisible(true);//�ɼ�
	}
}
