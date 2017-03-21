
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wushang on 17/3/19.
 */
public class BinaryTree {
	ConcurrentHashMap<TreeNode, Object> collection = new ConcurrentHashMap<>();

	public void isChooseNode (TreeNode node) {
		if(node == null)
			return;
		if(node.left != null && collection.containsKey(node.left)) {
			collection.remove(node.left);
			isChooseNode(node.left);
		}
		if(node.right != null && collection.containsKey(node.right)) {
			collection.remove(node.right);
			isChooseNode(node.right);
		}
	}


	public void createBinTree() {
		//创建二叉树
		TreeNode nodeA = new TreeNode();
		TreeNode nodeB = new TreeNode();
		TreeNode nodeC = new TreeNode();
		TreeNode nodeD = new TreeNode();
		TreeNode nodeE = new TreeNode();
		TreeNode nodeF = new TreeNode();
		nodeA.left = nodeB;
		nodeA.right = nodeC;
		nodeB.left = nodeD;
		nodeB.right = nodeE;
		nodeC.right =  nodeF;

		//选定的3个节点放入集合中
//		collection.put(nodeC, 1);
		collection.put(nodeB, 1);
		collection.put(nodeE,1);
		collection.put(nodeD,1);
		System.out.println(collection.containsKey(nodeE));
		//遍历选定的节点,查看它的左右子树是不是在集合中;如果在集合中,则从集合中删掉;如果不在集合中,则终止.
		//最终,如果集合中只剩一个子树的根节点,则节点是连接的;否则,节点不是连接的.
		for(TreeNode node : collection.keySet()) {
			isChooseNode(node);
		}

		System.out.println(collection.size());
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinTree();
	}
}


class TreeNode {
	public TreeNode left;
	public TreeNode right;

}