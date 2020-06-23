package DataStructures.tree;

/**
 * @author yichangkong
 * @create 2020-05-18-15:45
 * for+�ݹ�=����
 */
public class BinaryTreeDome {

  public static void main(String[] args) {

    // ����Ҫ����һ�Ŷ�����
    BinaryTree binaryTree = new BinaryTree();
    // ������Ҫ�Ľ��
    HeroNode root = new HeroNode(1, "�ν�");
    HeroNode node2 = new HeroNode(2, "����");
    HeroNode node3 = new HeroNode(3, "¬����");
    HeroNode node4 = new HeroNode(4, "�ֳ�");
    HeroNode node5 = new HeroNode(5, "��ʤ");

    // ˵�����������ֶ������ö���������������ѧϰ�ݹ�ķ�ʽ����������
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

    // ǰ��
    void preorderTraversal() {
      if (this.root != null) {
        this.root.preTrav();
      } else {
        System.out.println("������Ϊ�գ�");
      }
    }
    // ����
    void inOrderTraversal() {
      if (this.root != null) {
        this.root.inordTrav();
      } else {
        System.out.println("������Ϊ�գ�");
      }
    }

    // ����
    void postOrderTraversal() {
      if (this.root != null) {
        this.root.postTrav();
      } else {
        System.out.println("������Ϊ�գ�");
      }
    }
  }

  /** @Description �ӽڵ� @Param no ��� name ���� left ��ڵ� right �ҽڵ� @Date 2020/5/18 @Time 15:49 */
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

    /** @Description preorderTraversal�� ��������ڵ㣬�ٱ����������������� @Param [] @Return void */
    void preTrav() {
      System.out.println(this);
      if (this.left != null) {
        this.left.preTrav();
      }
      if (this.right != null) {
        this.right.preTrav();
      }
    }
    /** @Description inOrderTraversal�� �ȱ�������������������ڵ㣬�ٱ��������� @Param [] @Return void */
    void inordTrav() {
      if (this.left != null) {
        this.left.inordTrav();
      }
      System.out.println(this);
      if (this.right != null) {
        this.right.inordTrav();
      }
    }

    /** @Description postOrderTraversal�� �ȱ������������ٱ��������������������ڵ� @Param [] @Return void */
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
