package DataStructures.hashTable;

/**
 * @author yichangkong
 * @create 2020-05-06-14:53
 */
class HashTableDome {
  public static void main(String[] args) {

    HashTable hashTable = new HashTable(10);
    Emp emp3 = new Emp("ts3", 3);
    Emp emp2 = new Emp("ts2", 2);
    Emp emp1 = new Emp("ts1", 1);

    hashTable.add(emp3);
    hashTable.add(emp2);
    hashTable.add(emp1);
    hashTable.getlist();
    hashTable.fundEmpById(4);
  }
}

class HashTable {
  private EmpLinkedList[] empLinkedListsArray;

  private int size;

  public HashTable(int size) {
    this.size = size;
    empLinkedListsArray = new EmpLinkedList[size];

    // 初始化哈希表
    for (int i = 0; i < size; i++) {
      empLinkedListsArray[i] = new EmpLinkedList();
    }
  }

  public void add(Emp emp) {
    int hashIndex = hashFun(emp.id);
    empLinkedListsArray[hashIndex].add(emp);
  }

  private int hashFun(int id) {

    int hashIndex = id % size;

    if (hashIndex < size) {
      return hashIndex;
    } else {
      System.out.println("hashTable‘s function  hashFun is error");
      return -1;
    }
  }

   void getlist() {
    for (int i = 0; i < size; i++) {
      empLinkedListsArray[i].getlist();
    }
  }

   void fundEmpById(int id) {
    int hashIndex = hashFun(id);
    Emp emps = empLinkedListsArray[hashIndex].fundEmpById(id);
    System.out.println(emps);
  }
}

/** @Description 表示一个链表雇员，对象 @Param id name next 默认为空 @Return @Date 2020/5/18 @Time 11:47 */
class Emp {
  int id;
  String name;
  Emp next;

  Emp(String name, int id) {
    super();
    this.name = name;
    this.id = id;
  }

  @Override
  public String toString() {
    return "Emp{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}

class EmpLinkedList {

  Emp head;

  /** @Description 添加方法 @Param [emp] @Return void @Date 2020/5/6 @Time 15:12 */
  public void add(Emp emp) {
    // 因为默认为空
    if (head == null) {
      head = emp;
      return;
    }
    Emp temEmp = head;
    // 遍历循环到链表的最后一个值
    while (true) {
      if (temEmp.next == null) {
        break;
      }
      temEmp = temEmp.next;
    }
    // 添加到这个链表又如何和head链表产生关系呢？
    temEmp.next = emp;
  }

  /** @Description 打印链表 @Param [] @Return void @Date 2020/5/6 @Time 15:15 */
   void getlist() {

    if (head == null) {
      System.out.println("此链表并没有数据");
      return;
    }
    Emp tempEmp = head;
    while (true) {
      System.out.printf("=> id=%d name=%s\t", tempEmp.id, tempEmp.name);
      if (tempEmp.next == null) {
        break;
      }
      tempEmp = tempEmp.next;
    }
    System.out.println();
  }
  /**
   * @Description 单链表里查询雇员信息 @Param [id] @Return DataStructures.hashTable.Emp @Date 2020/5/6 @Time
   * 17:10
   */
  Emp fundEmpById(int id) {
    if (head == null) {
      return null;
    }
    Emp tempEmp = head;
    while (true) {
      if (tempEmp.id == id) {
        return tempEmp;
      }
      if (tempEmp.next == null) {
        return null;
      }
      tempEmp = tempEmp.next;
    }
  }
}
