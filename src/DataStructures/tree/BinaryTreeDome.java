package DataStructures.tree;

/**
 * @author yichangkong
 * @create 2020-05-18-15:45
 * for+递归=回溯
 */
public class BinaryTreeDome {

  public static void main(String[] args) {

    // 先需要创建一颗二叉树
    BinaryTree binaryTree = new BinaryTree();
    // 创建需要的结点
    HeroNode root = new HeroNode(1, "宋江");
    HeroNode node2 = new HeroNode(2, "吴用");
    HeroNode node3 = new HeroNode(3, "卢俊义");
    HeroNode node4 = new HeroNode(4, "林冲");
    HeroNode node5 = new HeroNode(5, "关胜");

    // 说明，我们先手动创建该二叉树，后面我们学习递归的方式创建二叉树
    root.setLeft(node2);
    root.setRight(node3);
    node3.setRight(node4);
    node3.setLeft(node5);
    binaryTree.setRoot(root);

    binaryTree.preorderTraversal();
  }

  static class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
      this.root = root;
    }

    // 前序
    void preorderTraversal() {
      if (this.root != null) {
        this.root.preTrav();
      } else {
        System.out.println("二叉树为空！");
      }
    }
    // 中序
    void inOrderTraversal() {
      if (this.root != null) {
        this.root.inordTrav();
      } else {
        System.out.println("二叉树为空！");
      }
    }

    // 后序
    void postOrderTraversal() {
      if (this.root != null) {
        this.root.postTrav();
      } else {
        System.out.println("二叉树为空！");
      }
    }
  }

  /** @Description 子节点 @Param no 编号 name 姓名 left 左节点 right 右节点 @Date 2020/5/18 @Time 15:49 */
  static class HeroNode {
    int no;
    String name;
    HeroNode left;
    HeroNode right;

    public HeroNode(int no, String name) {
      super();
      this.no = no;
      this.name = name;
    }

    public int getNo() {
      return no;
    }

    public void setNo(int no) {
      this.no = no;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public HeroNode getLeft() {
      return left;
    }

    public void setLeft(HeroNode left) {
      this.left = left;
    }

    public HeroNode getRight() {
      return right;
    }

    public void setRight(HeroNode right) {
      this.right = right;
    }

    @Override
    public String toString() {
      return "HordNote{" + "no=" + no + ", name='" + name + '\'' + '}';
    }

    /** @Description preorderTraversal： 先输出父节点，再遍历左子树和右子树 @Param [] @Return void */
    void preTrav() {
      System.out.println(this);
      if (this.left != null) {
        this.left.preTrav();
      }
      if (this.right != null) {
        this.right.preTrav();
      }
    }
    /** @Description inOrderTraversal： 先遍历左子树，再输出父节点，再遍历右子树 @Param [] @Return void */
    void inordTrav() {
      if (this.left != null) {
        this.left.inordTrav();
      }
      System.out.println(this);
      if (this.right != null) {
        this.right.inordTrav();
      }
    }

    /** @Description postOrderTraversal： 先遍历左子树，再遍历右子树，最后输出父节点 @Param [] @Return void */
    void postTrav() {
      if (this.left != null) {
        this.left.inordTrav();
      }
      if (this.right != null) {
        this.right.inordTrav();
      }
      System.out.println(this);
    }
  }
}
