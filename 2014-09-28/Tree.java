import java.util.Scanner;

/**
 * 
 * @author elelule
 * 
 * 
 * 
 *         这个类提供先序创建一颗二叉树（创建过程中如果是叶子节点则使用-1代替输入），然后按照中序遍历
 *         该二叉树，最后调用函数求得该二叉树中最大值和最小值的差值
 */
class MaxMin {
	int max;
	int min;
	boolean isTrue;

	public MaxMin(int max, int min, boolean isTure) {
		this.max = max;
		this.min = min;
		this.isTrue = isTure;
	}
}

public class Tree {
	Tree left;
	Tree right;
	int data;
	static Scanner in = new Scanner(System.in);

	// 使用先序建立一棵二叉树
	static Tree init() {
		Tree t;
		int temp = in.nextInt();
		if (temp == -1)
			t = null;
		else {
			t = new Tree();
			t.data = temp;
			t.left = init();
			t.right = init();
		}
		return t;
	}

	static void getMaxDistance(Tree t) {
		MaxMin left = getMaxMin(t.left);
		MaxMin right = getMaxMin(t.right);
		int max = left.max > right.max ? left.max : right.max;
		int min = left.min < right.min ? left.min : right.min;
		int maxLess = Math.max(
				Math.max(Math.abs(t.data - min), Math.abs(max - min)),
				Math.abs(t.data - max));
		System.out.println("极差为：" + maxLess);
	}

	static MaxMin getMaxMin(Tree t) {
		if (t == null) {
			return new MaxMin(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
		}
		MaxMin left = getMaxMin(t.left);
		MaxMin right = getMaxMin(t.right);
		if (!left.isTrue && !right.isTrue)
			return new MaxMin(t.data, t.data, true);
		if (!left.isTrue)
			return new MaxMin(t.data > right.max ? t.data : right.max,
					t.data < right.min ? t.data : right.min, true);
		if (!right.isTrue)
			return new MaxMin(t.data > left.max ? t.data : left.max,
					t.data < left.min ? t.data : left.min, true);

		return new MaxMin(Math.max(t.data, Math.max(left.max, right.max)),
				Math.min(t.data, Math.min(left.min, right.min)), true);
	}

	static public void show(Tree t) {
		if (t == null)
			System.out.print(" # ");
		else {
			show(t.left);
			System.out.print(" " + t.data + " ");
			show(t.right);
		}
	}

	public static void main(String[] args) {
		Tree tree = Tree.init();
		// 先序遍历结果
		show(tree);
		// 获取极差
		getMaxDistance(tree);
	}
}
