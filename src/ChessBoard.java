import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class ChessBoard extends JFrame {

	public static void main(String[] args) {
		int ak;
		String str=JOptionPane.showInputDialog("请输入一个数定义棋盘的大小：","8");
		ak=Integer.parseInt(str);
		JFrame f=new ChessBoard();
		f.add(new ChessPanel(ak));
		f.setTitle("棋盘覆盖问题");
		f.setSize(600,600);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}
}
