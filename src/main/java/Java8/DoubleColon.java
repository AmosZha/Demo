package Java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 双冒号（::）
 * 英文：double colon，双冒号（::）运算符在Java 8中被用作方法引用（method reference），
 * 方法引用是与lambda表达式相关的一个重要特性。它提供了一种不执行方法的方法。
 * 为此，方法引用需要由兼容的函数接口组成的目标类型上下文。
 *
 * 以下是Java 8中方法引用的一些语法：
 * ---------------------------------
 * 静态方法引用（static method）语法：classname::methodname 例如：Person::getAge
 * 对象的实例方法引用语法：instancename::methodname 例如：System.out::println
 * 对象的超类方法引用语法： super::methodname
 * 类构造器引用语法： classname::new 例如：ArrayList::new
 * 数组构造器引用语法： typename[]::new 例如： String[]:new
 **/

@RunWith(SpringJUnit4ClassRunner.class)
public class DoubleColon {

    //*************************一、方法引用*************************
    /**
     * @Description: 对象 :: 实例方法名
     * @return: void
     * @Date: 2023/11/17
     */
    @Test
    public void test1() {
        Consumer<String> con = (x) -> System.out.println(x);
        con.accept("Hello World!");

        PrintStream ps = System.out;// 返回一个PrintStream对象
        // System.out.println(x)在PrintStream的println方法中已经实现,可以使用方法引用
        Consumer<String> con1 = ps::println;
        con1.accept("Hello Lambda!");

        Consumer<String> con2 = System.out::println;//匿名对象方法引用
        con2.accept("Hello Lambda Method!");
    }

    /**
     * @Description: 类 :: 静态方法名
     * @return: void
     * @Date: 2023/11/17
     */
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        com.compare(1, 2);

        // 使用方法引用的方式
        Comparator<Integer> com1 = Integer::compare;
        com1.compare(1, 2);
    }

    /**
     * @Description: 类 :: 实例方法名
     * @Date: 2023/11/17
     */
    //类::实例方法名
    @Test
    public void test4(){
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        boolean bool = bp.test(new String("huang"),"huang");
        System.out.println(bool);

        //前提:第一个参数是实例方法的调用者，第二个参数是实例方法的参数
        //例如 x 是equal方法的调用者，y是实例方法的参数
        BiPredicate<String,String> bp2 = String::equals;
        bool = bp2.test("huang","huang");
        System.out.println(bool);
    }



    //*************************二、构造器引用*************************
    //语法格式：ClassName::new
    @Test
    public void test5(){
        Supplier<User> sup = ()-> new User();
        User emp = sup.get();
        //构造器引用：根据参数列表自动匹配构造器
        Supplier<User> sup2 = User::new;
        emp = sup2.get();
        System.out.println(emp);
    }

    @Test
    public void test6(){
        //Lambda表达式构造对象
        Function<Integer,User> func = x -> new User();
        User empc = func.apply(10);
        System.out.println(empc);

        //1、引用类构造器->Function
        //2、执行apply返回构造对象
        //::的构造器引用
        Function<Integer,User> func1 = User::new;
        User emp1 = func1.apply(10);
        System.out.println(emp1);

        Function<String, User> func2 = User::new;
        User emp2 = func2.apply("jack");
        System.out.println(emp2);

        BiFunction<Integer, String, User> bf = User::new;
        User jack = bf.apply(10, "jack");
        System.out.println(jack.toString());

    }

    //*************************三、数组引用*************************
    public void test7() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        fun.apply(10);

        //1、引用数组构造器->Function
        //2、执行apply返回构造对象
        Function<Integer, String[]> fun1 = String[]::new;
        fun1.apply(20);
    }
}

@Data
@NoArgsConstructor
class User{

    public String name;

    public int age;

    public User(String name){
        this.name = name;
    }

    public User(int age){
        this.age = age;
    }

    public User(int age ,String name){
        this.age = age;
        this.name = name;
    }


}
