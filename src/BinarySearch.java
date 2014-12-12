import java.util.Arrays;
import javax.swing.JOptionPane;
public class BinarySearch<T extends Comparable<T>> {
	private T[] data;// 要排序的数据
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
		String s = JOptionPane.showInputDialog("这是二分查找（非递归）的测试程序." + "\n"
				+ "你需要首先输入一组数据，然后再输入你要查找的数据。" + "\n"
				+ "现在请你定义这组数据的个数（请输入大于零的正整数）：");
		int size = Integer.parseInt(s);
		Integer[] data = new Integer[size];
		for (int i = 0; i < size; i++) {
			String e = JOptionPane.showInputDialog("请输入这组数据的第" + (i + 1) + "个数"
					+ "\n" + "" + "（若不是第一次输入则必须大于前一个数）：");
			data[i] = Integer.parseInt(e);
		}
		String k = JOptionPane.showInputDialog("请输入你要查找的数据：");
		int key = Integer.parseInt(k);

		BinarySearch<Integer> binSearch = new BinarySearch<Integer>(data);
		if (binSearch.search(key) != -1) {
			JOptionPane.showMessageDialog(
					null,
					"你输入的数组为：" + Arrays.toString(data) + "\n" + "你要查找的数据为"
							+ key + "\n" + "该数据位于您所定义的数组的第"
							+ (binSearch.search(key) + 1) + "位");
		} else {
			JOptionPane.showMessageDialog(null,
					"你输入的数组为：" + Arrays.toString(data) + "\n" + "你要查找的数据为"
							+ key + "\n" + "该数据不存在于您所定义的数组中！");
		}
	}
}
