package com.yichangkong;

import com.sun.org.apache.xpath.internal.operations.Gte;
import javafx.scene.shape.Circle;

/**
 * @author yichangkong
 * @create 2020-05-31-13:43
 * 任务七-图形面积计算 ：
 * 创建一个三角形对象、一个矩形对象、一个圆形对象，然后将它们存入到一个数组。
 */
public class GraphicsArea {
  public  void func() {
      Shape[] s = new Shape[3];
      s[0] = new Triangle(3, 4);//static类调用非static类
      s[1] = new Rectangle(5, 6);
      s[2] = new Circle(2);
      System.out.println("三角形的面积为" + s[0].calArea());//s[0]便是代表获取了一个Shape的继承子类 再调用其实现的面积计算方法
      System.out.println("矩形的面积是：" + s[1].calArea());
      System.out.println("圆形的面积是：" + s[2].calArea());


    /**
     * static修饰的成员与非static修饰类的成员的区别
     * ① 格式 ：
     * 1》 static修饰的，称为静态成员，非static修饰的，称为非静态成员。
     * ② 内存位置：
     * 1》static修饰的，在方法区的静态区中，非static修饰的，在堆中的对象里。
     * ③ 生命周期：
     * 1》 static修饰的 ，随着类的加载而加载，随着类的消亡而消亡，
     * 非static随着对象的创建而加载，随着对象的消亡而消亡。
     * ④ 调用方式 ：
     * 1》 static修饰的，通过类名.成员来调用 ，非static修饰的，通过对象.成员来调用。
     *
     * 静态的属性和方法在内存中的存放地址与非静态的是不同的，
     * 静态的是存放在static区，它意味着静态方法是没有this的，
     *
     * 所以我们不可以从一个static方法内部发出对非static方法的调用。
     * 但是反之是可以的。
     */
  }

  abstract class Shape {//形状   抽象类
      abstract double calArea(); // 抽象方法

      /*
      抽象类知识点
      1.abstract类中可以有abstract方法
      abstract类中可以有abstract方法，也可以有非abstract方法、非abstract类中不可以有abstract方法

      2.abstract类不能使用new运算符创建对象

      3.abstract类的子类
        如果一个非abstract类是abstract类的子类，它必须重写父类的abstract方法，
        也就是去掉abstract方法的abstract修饰，并给出方法体。

        如果一个abstract类是abstract类的子类，它可以重写父类的abstract方法，
        也可以继承父类的abstract方法。
       */
    }
    class Rectangle extends Shape {//长方形 Rectangle
      private double w, h;
      public Rectangle(double w, double h) {
        this.h = h;
        this.w = w;
      }
    @Override
    /**
     * @Override是伪代码,表示重写。
     * 那么加上@Override 有什么好处呢？
     * 1、可以当注释用,方便阅读；
     *
     * 2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的（这里就是代指 抽象父类Shape中的所有方法）
     *   如果没有则报错 例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，
     *    因为编译器以为这个方法是你的子类中自己增加的方法。
     *
     * 阉割版设计模式（类似于工厂方法、抽象工厂方法）
     */
    double calArea() { // 重写继承计算面积方法
        return w * h;
      }
    }
     class Triangle extends Shape {
      private double a, h;
      public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
      }
      double calArea() {//重写继承计算面积方法
        return a * h / 2;
      }

     Triangle get(){
        return new Triangle(1,1);
      }
    }
    class Circle extends Shape {//Circle 圆
      private double r;
      public Circle(double r) {
        this.r = r;
      }
      double calArea() {//重写继承计算面积方法
        return 3.14 * r * r;
      } }
  }
