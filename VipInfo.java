package system;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class VipInfo extends JFrame{
	public VipInfo() {
		super("��Ա����");
     	ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Desktop\\113.png"); 
	    Image img = icon.getImage().getScaledInstance(600,550, Image.SCALE_FAST); // ͼ������Ϊ�ʺ�Frame��С
	    JLabel jlabel = new JLabel(new ImageIcon(img));
	    jlabel.setBounds(0, 0,600, 550);
	    getLayeredPane().add(jlabel, new Integer(Integer.MIN_VALUE));
	    JPanel jp = (JPanel) getContentPane();
	    JRootPane jp1 = (JRootPane) getRootPane();
	    jp.setOpaque(false);
	    jp1.setOpaque(false);
	     
	    setLayout(null);
		setResizable(false);
		setVisible(true);
		setBounds(300,100,600,550);
	}
}
