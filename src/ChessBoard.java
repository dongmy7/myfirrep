import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class ChessBoard extends JFrame {

	public static void main(String[] args) {
		int ak;
		String str=JOptionPane.showInputDialog("������һ�����������̵Ĵ�С��","8");
		ak=Integer.parseInt(str);
		JFrame f=new ChessBoard();
		f.add(new ChessPanel(ak));
		f.setTitle("���̸�������");
		f.setSize(600,600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
