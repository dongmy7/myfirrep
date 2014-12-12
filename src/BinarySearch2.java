import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * 名称:BinarySearch 功能:实现了折半查找(二分查找)的递归和非递归算法. 说明:
 * 1、要求所查找的数组已有序,并且其中元素已实现Comparable<T>接口,如Integer、String等.
 * 2、非递归查找使用search();,递归查找使用searchRecursively();
 */

public class BinarySearch2<T extends Comparable<T>> {
	private T[] data;// 要排序的数据

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
		String s = JOptionPane.showInputDialog("这是二分查找（递归）的测试程序." + "\n"
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

		BinarySearch2<Integer> binSearch = new BinarySearch2<Integer>(data);
		if (binSearch.searchRecursively(key) != -1) {
			JOptionPane.showMessageDialog(
					null,
					"你输入的数组为：" + Arrays.toString(data) + "\n" + "你要查找的数据为"
							+ key + "\n" + "该数据位于您所定义的数组的第"
							+ (binSearch.searchRecursively(key) + 1) + "位");
		} else {
			JOptionPane.showMessageDialog(null,
					"你输入的数组为：" + Arrays.toString(data) + "\n" + "你要查找的数据为"
							+ key + "\n" + "该数据不存在于您所定义的数组中！");
		}


	}
}
