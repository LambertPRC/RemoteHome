package Methods;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
public class ChooseImage {
	public static String fileChooser() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"JPG & GIF Images", "jpg", "gif");
		//设置文件类型
		chooser.setFileFilter(filter);
		//打开选择器面板
		int returnVal = chooser.showOpenDialog(new JPanel());
		//保存文件从这里入手，输出的是文件名
		if(returnVal == JFileChooser.APPROVE_OPTION) {   //点击确认或保存  JFileChooser.CANCEL_OPTION: 点击了取消或关闭 ；
			System.out.println("你打开的文件是: " +
			chooser.getSelectedFile().getName());
			System.out.println("你打开的文件路径是: " +
					chooser.getSelectedFile().getPath());
			return chooser.getSelectedFile().getPath();
		}
		return null;	//当选择不是确认时，返回空
	}
	public static void main(String[] args) {
		fileChooser();
	}
}