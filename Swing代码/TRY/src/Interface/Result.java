package Interface;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.io.File;
import java.io.IOException;


public class Result extends JFrame {

	private JPanel contentPane;
	static String Result;
	static String Path;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public static void setResult(String result){    //获取鉴别结果
		Result=result;
	}
	public static void setPath(String path){    //获取鉴别结果
		Path=path;
	}
	public Result() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 606, 387);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		if(Path!=null){
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(109, 23, 366, 203);
			contentPane.add(lblNewLabel);
			try {
				//为了显示BMP格式图片而加的内容
	        	File file = new File(Path);
				Image image = ImageIO.read(file);
				lblNewLabel.setIcon(new ImageIcon(image));
				lblNewLabel.setToolTipText(Result);
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		
		JLabel lblNewLabel_1 = new JLabel("鉴定结果为");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(151, 268, 118, 28);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setText(Result);
		lblNewLabel_2.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel_2.setBounds(309, 268, 118, 26);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("E:\\background1.jpg"));
		lblNewLabel_3.setBounds(0, 0, 588, 340);
		contentPane.add(lblNewLabel_3);
	}
}
