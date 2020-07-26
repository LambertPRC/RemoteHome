package Methods;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
public class ChooseImage {
	public static String fileChooser() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		"JPG & GIF Images", "jpg", "gif");
		//�����ļ�����
		chooser.setFileFilter(filter);
		//��ѡ�������
		int returnVal = chooser.showOpenDialog(new JPanel());
		//�����ļ����������֣���������ļ���
		if(returnVal == JFileChooser.APPROVE_OPTION) {   //���ȷ�ϻ򱣴�  JFileChooser.CANCEL_OPTION: �����ȡ����ر� ��
			System.out.println("��򿪵��ļ���: " +
			chooser.getSelectedFile().getName());
			System.out.println("��򿪵��ļ�·����: " +
					chooser.getSelectedFile().getPath());
			return chooser.getSelectedFile().getPath();
		}
		return null;	//��ѡ����ȷ��ʱ�����ؿ�
	}
	public static void main(String[] args) {
		fileChooser();
	}
}