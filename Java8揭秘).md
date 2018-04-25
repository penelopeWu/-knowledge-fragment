[Java 8 Revealed:Lambdas,Default Methods and BulkData Operations](http://zeroturnaround.com/rebellabs/java-8-revealed-lambdas-default-methods-and-bulk-data-operations/)

## [Java8揭秘(一)](https://blog.csdn.net/wwwsssaaaddd/article/details/24211475)

> java8中新增的三个特性：Lambda表达式，default方法（或称之为defender方法）和批量数据操作（bulk data operations）。

`@since 1.8`

`java.util.Collection`接口中，新增了4个default方法：

`default boolean removeIf(Predicate<? super E> filter){...}`

`default Spliterator<E> spliterator(){...}`

`default Stream<E> stream(){...}`

`default Stream<E> parallelStream(){...}`



`java.lang.Iterable`接口中，新增了2个default方法：

`default void forEach(Consumer<? super T> action) {}`

`default Spliterator<T> spliterator(){...}`



`java.util.List`接口中新增3个default方法：

`default void replaceAll(UnaryOperator<E> operator){...}`

`default void sort(Comparator<? super E> c) {...}`

`@Override default Spliterator<E> spliterator(){...}`





`java.util.stream`接口中定义的方法，参数都和函数接口接口有关，为了强调接口是函数接口，可以使用新注释[@FunctionalInterface](http://download.java.net/jdk8/docs/api/java/lang/FunctionalInterface.html)，来防止你的团队成员往这个接口里增加方法。这个注释除了在运行时使用，还给javac用来验证该接口是否真是函数接口，其内部的抽象方法是否不多于一个。JDK8中新增了一个包，java.util.function，这个包里有一些专门给新增的API使用的函数接口。

```java
Consumer<T> – 在T上执行一个操作，无返回结果
Supplier<T> –无输入参数，返回T的实例
Predicate<T> –输入参数为T的实例，返回boolean值
Function<T,R> –输入参数为T的实例，返回R的实例
```



> **函数接口（Functional Interface）：**只包含一个抽象方法的接口，所以也称为SAM（Single Abstract Method）类型的接口。例如我们比较熟悉的Runnable接口，只定义了唯一的一个抽象方法run()，就是函数接口。

> **Lambda表达式**：实现函数接口，并返回该接口的一个匿名实现类对象的一种简明表达方式。特别强调两点：
>
> -   Lambda表达式返回值是一个对象（至少目前还是）；
> -   该返回对象往往是某个函数接口的匿名实现。

> **方法引用（Method Reference）**： Lambda表达式的一种特殊形式。当一个lambda表达式body中仅仅是调用某个方法，这种情况下，使用方法引用替代lambda表达式，从形式上直接引用这个方法，这就比在lambda表达式body中引用在形式上更简洁一些。

> Default方法可以认为是Lambda表达式和JDK类库之间的桥梁。引入Default方法的主要目的是为了升级标准JDK接口，另外也是为了我们最终能在Java8中顺畅使用Lambda表达式。



## [第一章：Java 8中的 Lambda表达式](https://blog.csdn.net/wwwsssaaaddd/article/details/24212693)

### 入门

`Runnable r = ()->System.out.println("hello lambda");`

`new Thread(r); `

()	- 参数

{}	- body

java 8之前的方式：

```
new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println("new thread by annoy");
    }
}).start();
```

把经典风格java语法转变为Lambda表达式语法时，我们主要关注接口方法的参数和功能逻辑。



### Lambda表达式作为参数

Lambda表达式在运行期表示为一个函数接口。



### Lambda表达式作为返回值

函数接口的用法并不限于当参数，函数接口还可以用作方法的返回值。也就是说我们可以从方法返回一个Lambda表达式。



### 序列号Lambda表达式

默认情况下，Lambda表达式不能序列化。为了能序列化，java8引入了所谓的类型关联（TypeIntersection）。

```
public class ComparatorFactory{
    public Comparator makeComparator(){
        return(Comparator&Serializable)Integer::compareUnsigned;
    }
}
```

Serializable接口一般认为是标记性的接口，该接口中没有声明任何方法，因此Serializable接口也可以称作ZAM类型（ZAM即Zero Abstract Methods）。

使用类型关联的一般规则如下：

SAM & ZAM1 & ZAM2 & ZAM3

也就是说，如果返回结果是SAM类型的，那么我们可以用SAM类型和一个甚至多个ZAM类型“相关联”。我们现在事实上认为作为返回结果的Comparator 实例对象也是Serializable类型的。

经过上面对返回结果强制转换类型后，编译器在编译后的class文件中多生成了一个方法，如下所示：

`private  static  java.lang.Object  $deserializeLambda$(java.lang.invoke.SerializedLambda);`

### 反编译Lambda表达式

```java
/**
 * @author penelopeWu
 * @version 1.0
 * @date 2018-04-23 17:32
 */
@FunctionalInterface
public interface Action {
    void run(String s);
}


public class Main {
    public void action(Action action){
        action.run("Hello！");
    }

    public static void main(String[] args) {
        new Main().action((s)->System.out.println("*" + s + "*"));
    }
}
```

编译后产生两个类文件：Main.class和Main$Action.class，但并没有生成带编号的类，带编号的类通常在匿名类编译后产生。这样在Main.class中一定有什么东西，实现了我们在main方法中定义的Lambda表达式。（我们反编译下Main.class看看究竟）

```java
$javap -p Main

Compiled from "Main.java"
public class com.shekhargulati.wjj.Main {
  	public com.shekhargulati.wjj.Main();
  	public void action(com.shekhargulati.wjj.Action);
  	public static void main(java.lang.String[]);
  	private static void lambda$main$0(java.lang.String);
}
```

## [Java8揭秘(三)Default 方法](https://blog.csdn.net/wwwsssaaaddd/article/details/24213525)

Default方法加入到java中，这是引人关注的事情。Default方法可以认为是Lambda表达式和JDK类库之间的桥梁。引入Default方法的主要目的是为了升级标准JDK接口，另外也是为了我们最终能在Java8中顺畅使用Lambda表达式。



# [Java8揭秘(四)Java集合类库的批量数据操作](https://blog.csdn.net/wwwsssaaaddd/article/details/24214219)

引入批量数据操作的目的是应用lambda函数来实现包含并行操作在内的多种数据处理功能，而支持并行数据操作是其关键内容。这个并行操作是在Java7 java.util.concurrency的Fork/Join机制上实现的。



引入批量操作接口的目的是：

给Java集合类库增加批量操作数据的支持。通常称这种批量数据操作为 “Java中的filter/map/reduce”。批量数据操作有串行（在当前线程上）和并行（使用多线程）两种操作模式。一般用Lambda函数来定义对数据的操作。

​       由于Lambda表达式已经应用到Java语言和新集合API中，因此我们可以更加高效地利用底层平台的并行特性。

