package 基础语法.面向对象;

// 继承
public class Animal {
    
}

class Mammal extends Animal {

}

class Dog extends Mammal {
    public static void main(String[] args) {
        Animal a = new Animal();
        Mammal m = new Mammal();
        Dog d = new Dog();
        System.out.println(d instanceof Animal);
        System.out.println(m instanceof Animal);
        System.out.println(d instanceof Mammal);
        
    }
}


// 定义抽象类
abstract class abstractClass{
    // 定义抽象方法
    abstract void abmethod();
}

class abc extends abstractClass {

    @Override
    void abmethod() {
        System.out.println("do it");
        throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        
    }
    
    
}