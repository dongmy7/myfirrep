import java.awt.*;
import java.util.Random;
import javax.swing.*;
public class ChessPanel extends JPanel {
	private int num = 2;
	private JLabel board[][];
	private int dx = 0, dy = 0;
	private Color[] lp_type = { Color.blue, Color.gray, Color.green,
			Color.yellow, Color.red, Color.cyan, Color.magenta };
	private int title = 0;

	public ChessPanel(int num) {
		this.num = num;
		this.setLayout(new GridLayout(num, num));
		this.addLabels();
		Random ran = new Random();
		dx = ran.nextInt(num);
		dy = ran.nextInt(num);
		board[dx][dy].setBackground(Color.black);
		chessBoard(0, 0, dx, dy, num);
	}
	public void addLabels() {
		board = new JLabel[num][num];
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				board[i][j] = new JLabel(i + "," + j);
				board[i][j].setForeground(Color.white);
				board[i][j].setBorder(BorderFactory
						.createLineBorder(Color.black));
				board[i][j].setOpaque(true);
				this.add(board[i][j]);
			}
		}
	}
	public void chessBoard(int tr, int tc, int dr, int dc, int size) {
		if (size == 1)
			return;
		int s = size / 2;
		int t = (title++) % lp_type.length;
		if (dr < tr + s && dc < tc + s)
			chessBoard(tr, tc, dr, dc, s);
		else {
			board[tr + s - 1][tc + s - 1].setBackground(lp_type[t]);
			chessBoard(tr, tc, tr + s - 1, tr + s - 1, s);
		}
		if (dr < tr + s && dc >= tc + s)
			chessBoard(tr, tc + s, dr, dc, s);
		else {
			board[tr + s - 1][tc + s].setBackground(lp_type[t]);
			chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
		}
		if (dr >= tr + s && dc < tc + s)
			chessBoard(tr + s, tc, dr, dc, s);
		else {
			board[tr + s][tc + s - 1].setBackground(lp_type[t]);
			chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
		}
		if (dr >= tr + s && dc >= tc + s)
			chessBoard(tr + s, tc + s, dr, dc, s);
		else {
			board[tr + s][tc + s].setBackground(lp_type[t]);
			chessBoard(tr + s, tc + s, tr + s, tc + s, s);
		}
	}
}
