package DataStructures.tree;

/**
 * @author yichangkong
 * @create 2020-05-18-15:45 for+ 递归 = 回溯
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
    node3.setLeft(node4);
    node3.setRight(node5);
    binaryTree.setRoot(root);

    System.out.println("——PreOrder——");
    binaryTree.preorderTraversal();
    System.out.println("——InOrder——");
    binaryTree.inOrderTraversal();
    System.out.println("——Postoder——");
    binaryTree.postOrderTraversal();
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

    /** 如果删除的节点是叶子节点，则删除该节点 如果删除的节点是非叶子节点，则删除该子树. 测试，删除掉 5号叶子节点 和 3号子树. */
    void delete() {}

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

    /**
     * 前序查找
     * @param no
     * @return 如果找到就返回该node 如果没有找到返回null
     */
    public HeroNode proOrderSearch(int no) {

      if (this.no == no) {//比较当前节点是不是
        return this;
      }
      //1. 则判断当前的节点的左子节点是不是为空，如果不是空，则递归前序查找
      //2. 如果左递归前序查找，找到节点，则返回
      HeroNode node =null;
      if(this.left!=null){
        return node =this.left.proOrderSearch(no);
      }
      if (node!=null){//说明我们已经左子树找到
        return node;
      }
      //1. 左递归前序查找，找到节点，则返回，否则继续判断
      if(this.right!=null){
         node= this.right.proOrderSearch(no);
       }
      return node;
    }
    public HeroNode infixOrderSearch(){

    }
  }
}
