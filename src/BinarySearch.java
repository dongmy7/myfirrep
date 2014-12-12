import java.util.Arrays;
import javax.swing.JOptionPane;
public class BinarySearch<T extends Comparable<T>> {
	private T[] data;// Ҫ���������
	public BinarySearch(T[] data) {
		this.data = data;
	}
	public int search(T key) {
		int low = 0;
		int high;
		int mid;
		if (data == null)
			return -1;
		high = data.length - 1;
		while (low <= high) {
			mid = (low + high) / 2;
			// System.out.println("mid " + mid + " mid value:" + data[mid]);
			if (key.compareTo(data[mid]) < 0) {
				high = mid - 1;
			} else if (key.compareTo(data[mid]) > 0) {
				low = mid + 1;
			} else if (key.compareTo(data[mid]) == 0) {
				return mid;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		String s = JOptionPane.showInputDialog("���Ƕ��ֲ��ң��ǵݹ飩�Ĳ��Գ���." + "\n"
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

		BinarySearch<Integer> binSearch = new BinarySearch<Integer>(data);
		if (binSearch.search(key) != -1) {
			JOptionPane.showMessageDialog(
					null,
					"�����������Ϊ��" + Arrays.toString(data) + "\n" + "��Ҫ���ҵ�����Ϊ"
							+ key + "\n" + "������λ���������������ĵ�"
							+ (binSearch.search(key) + 1) + "λ");
		} else {
			JOptionPane.showMessageDialog(null,
					"�����������Ϊ��" + Arrays.toString(data) + "\n" + "��Ҫ���ҵ�����Ϊ"
							+ key + "\n" + "�����ݲ���������������������У�");
		}
	}
}
