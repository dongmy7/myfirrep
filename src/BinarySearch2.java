import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * ����:BinarySearch ����:ʵ�����۰����(���ֲ���)�ĵݹ�ͷǵݹ��㷨. ˵��:
 * 1��Ҫ�������ҵ�����������,��������Ԫ����ʵ��Comparable<T>�ӿ�,��Integer��String��.
 * 2���ǵݹ����ʹ��search();,�ݹ����ʹ��searchRecursively();
 */

public class BinarySearch2<T extends Comparable<T>> {
	private T[] data;// Ҫ���������

	public BinarySearch2(T[] data) {
		this.data = data;
	}

	private int doSearchRecursively(int low, int high, T key) {
		int mid;
		int result;

		if (low <= high) {
			mid = (low + high) / 2;
			result = key.compareTo(data[mid]);
			// System.out.println("mid " + mid + " mid value:" + data[mid]);///
			if (result < 0) {
				return doSearchRecursively(low, mid - 1, key);
			} else if (result > 0) {
				return doSearchRecursively(mid + 1, high, key);
			} else if (result == 0) {
				return mid;
			}
		}

		return -1;
	}

	public int searchRecursively(T key) {
		if (data == null)
			return -1;
		return doSearchRecursively(0, data.length - 1, key);
	}

	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("���Ƕ��ֲ��ң��ݹ飩�Ĳ��Գ���." + "\n"
				+ "����Ҫ��������һ�����ݣ�Ȼ����������Ҫ���ҵ����ݡ�" + "\n"
				+ "�������㶨���������ݵĸ���������������������������");
		int size = Integer.parseInt(s);
		Integer[] data = new Integer[size];
		for (int i = 0; i < size; i++) {
			String e = JOptionPane.showInputDialog("�������������ݵĵ�" + (i + 1) + "����"
					+ "\n" + "" + "�������ǵ�һ��������������ǰһ��������");
			data[i] = Integer.parseInt(e);
		}
		String k = JOptionPane.showInputDialog("��������Ҫ���ҵ����ݣ�");
		int key = Integer.parseInt(k);

		BinarySearch2<Integer> binSearch = new BinarySearch2<Integer>(data);
		if (binSearch.searchRecursively(key) != -1) {
			JOptionPane.showMessageDialog(
					null,
					"�����������Ϊ��" + Arrays.toString(data) + "\n" + "��Ҫ���ҵ�����Ϊ"
							+ key + "\n" + "������λ���������������ĵ�"
							+ (binSearch.searchRecursively(key) + 1) + "λ");
		} else {
			JOptionPane.showMessageDialog(null,
					"�����������Ϊ��" + Arrays.toString(data) + "\n" + "��Ҫ���ҵ�����Ϊ"
							+ key + "\n" + "�����ݲ���������������������У�");
		}


	}
}
