package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import com.sun.awt.AWTUtilities;

import Methods.JudgeLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;


public class LogInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
					//JFrame.setDefaultLookAndFeelDecorated(true);
					LogInterface frame = new LogInterface();

					/*frame.setUndecorated(true);
					AWTUtilities.setWindowShape(frame, new RoundRectangle2D.Double(
							0.0D, 0.0D, frame.getWidth(), frame.getHeight(), 26.0D,
							26.0D));*/
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public String getid(){
		return textField.getText();
	}
	public String getPassword(){
		String password=new String(passwordField.getPassword());
		return password;
	}
	public LogInterface() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 577, 416);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登录界面");
		lblNewLabel.setFont(new Font("华文新魏", Font.BOLD, 28));
		lblNewLabel.setBounds(228, 13, 140, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("账号");
		lblNewLabel_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(104, 107, 72, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("密码");
		lblNewLabel_2.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(104, 180, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 20));
		textField.setBounds(190, 107, 209, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Calibri", Font.PLAIN, 20));
		passwordField.setBounds(190, 175, 209, 29);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("华文楷体", Font.BOLD, 18));
		lblNewLabel_3.setBounds(190, 227, 169, 24);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("华文楷体", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JudgeLogin B =new JudgeLogin();
				int judge=B.Judge(getid(), getPassword());
				if(judge==1){
					lblNewLabel_3.setText("登陆成功");
					String []args =new String[1];
					Interface.main(args);
					setVisible(false);
				}
				else{
					lblNewLabel_3.setText("账号或密码错误！");
				}
			}
		});
		btnNewButton.setBounds(115, 264, 113, 50);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				passwordField.setText("");
				lblNewLabel_3.setText("");
			}
		});
		btnNewButton_1.setBounds(321, 264, 113, 50);
		contentPane.add(btnNewButton_1);
		
		//ImageIcon image=new ImageIcon("E:\\background2.jpg");
		JLabel lblNewLabel_4 = new JLabel(new ImageIcon("E:\\background1.jpg"));
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 20));
		lblNewLabel_4.setBounds(0, 0, 559, 369);
		contentPane = (JPanel)this.getContentPane();
		contentPane.add(lblNewLabel_4);
		
	}
}
