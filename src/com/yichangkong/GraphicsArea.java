package com.yichangkong;

import com.sun.org.apache.xpath.internal.operations.Gte;
import javafx.scene.shape.Circle;

/**
 * @author yichangkong
 * @create 2020-05-31-13:43
 * ������-ͼ��������� ��
 * ����һ�������ζ���һ�����ζ���һ��Բ�ζ���Ȼ�����Ǵ��뵽һ�����顣
 */
public class GraphicsArea {
  public  void func() {
      Shape[] s = new Shape[3];
      s[0] = new Triangle(3, 4);//static����÷�static��
      s[1] = new Rectangle(5, 6);
      s[2] = new Circle(2);
      System.out.println("�����ε����Ϊ" + s[0].calArea());//s[0]���Ǵ����ȡ��һ��Shape�ļ̳����� �ٵ�����ʵ�ֵ�������㷽��
      System.out.println("���ε�����ǣ�" + s[1].calArea());
      System.out.println("Բ�ε�����ǣ�" + s[2].calArea());


    /**
     * static���εĳ�Ա���static������ĳ�Ա������
     * �� ��ʽ ��
     * 1�� static���εģ���Ϊ��̬��Ա����static���εģ���Ϊ�Ǿ�̬��Ա��
     * �� �ڴ�λ�ã�
     * 1��static���εģ��ڷ������ľ�̬���У���static���εģ��ڶ��еĶ����
     * �� �������ڣ�
     * 1�� static���ε� ��������ļ��ض����أ��������������������
     * ��static���Ŷ���Ĵ��������أ����Ŷ����������������
     * �� ���÷�ʽ ��
     * 1�� static���εģ�ͨ������.��Ա������ ����static���εģ�ͨ������.��Ա�����á�
     *
     * ��̬�����Ժͷ������ڴ��еĴ�ŵ�ַ��Ǿ�̬���ǲ�ͬ�ģ�
     * ��̬���Ǵ����static��������ζ�ž�̬������û��this�ģ�
     *
     * �������ǲ����Դ�һ��static�����ڲ������Է�static�����ĵ��á�
     * ���Ƿ�֮�ǿ��Եġ�
     */
  }

  abstract class Shape {//��״   ������
      abstract double calArea(); // ���󷽷�

      /*
      ������֪ʶ��
      1.abstract���п�����abstract����
      abstract���п�����abstract������Ҳ�����з�abstract��������abstract���в�������abstract����

      2.abstract�಻��ʹ��new�������������

      3.abstract�������
        ���һ����abstract����abstract������࣬��������д�����abstract������
        Ҳ����ȥ��abstract������abstract���Σ������������塣

        ���һ��abstract����abstract������࣬��������д�����abstract������
        Ҳ���Լ̳и����abstract������
       */
    }
    class Rectangle extends Shape {//������ Rectangle
      private double w, h;
      public Rectangle(double w, double h) {
        this.h = h;
        this.w = w;
      }
    @Override
    /**
     * @Override��α����,��ʾ��д��
     * ��ô����@Override ��ʲô�ô��أ�
     * 1�����Ե�ע����,�����Ķ���
     *
     * 2�����������Ը�����֤@Override����ķ������Ƿ����㸸�������еģ�������Ǵ�ָ ������Shape�е����з�����
     *   ���û���򱨴� ���磬�����ûд@Override����������ķ�������д���ˣ���ʱ��ı������ǿ��Ա���ͨ���ģ�
     *    ��Ϊ��������Ϊ�������������������Լ����ӵķ�����
     *
     * �˸�����ģʽ�������ڹ������������󹤳�������
     */
    double calArea() { // ��д�̳м����������
        return w * h;
      }
    }
     class Triangle extends Shape {
      private double a, h;
      public Triangle(double a, double h) {
        this.a = a;
        this.h = h;
      }
      double calArea() {//��д�̳м����������
        return a * h / 2;
      }

     Triangle get(){
        return new Triangle(1,1);
      }
    }
    class Circle extends Shape {//Circle Բ
      private double r;
      public Circle(double r) {
        this.r = r;
      }
      double calArea() {//��д�̳м����������
        return 3.14 * r * r;
      } }
  }
