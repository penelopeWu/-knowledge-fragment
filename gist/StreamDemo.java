package com.penelope.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * java.util.stream.Stream接口是批量数据操作的入口
 * 我们拿到流式接口的引用之后，就可以使用集合类库做些有趣的事情了。
 * <p>
 * 关于数据流API要特别注意一点，就是在数据处理过程中不会改动源数据。
 * 这是考虑到数据源可能根本不存在，或者是由于原始数据还要在代码的其它地方使用。
 * <p>
 * 数据流接口可以使用多种数据源来处理数据，
 * 使用这些流式方法扩展标准JDK类库，可以获得更好的数据处理体验。
 *
 * @author penelopeWu
 * @version 1.0
 * @date 2018-04-25 13:44
 */
public class StreamDemo {
    public static void main(String[] args) {
        //首选的用于流式操作的数据源是集合（collections）
        List list = null;
        Stream stream = list.stream();

        //还有一种有趣的数据源是所谓的生成器（generators）
        Random random = new Random();
        Stream randomNumbers = Stream.generate(random::nextInt);

        //有几种工具方法可以设置操作多大范围的数据：
        IntStream range = IntStream.range(0, 50);
        range.forEach(System.out::println);

        //标准类库中也已经存在一些类可以充当数据源。
        // 例如， Random类已经扩展了一些有用的方法，如下所示：
        new Random().ints().limit(10).forEach(System.out::println);

        /**
         * 中间操作
         *
         * 中间操作用来描述在数据流之上执行的转换操作（可以理解为一种映射操作）
         *
         * 以下是一些有用的中间操作：
         *
         * filter    排除所有不满足条件的元素，具体条件通过Predicate接口来定义；
         * map       执行元素的映射转换，具体的映射方式使用Function接口定义；
         * flatMap   通过另外一种 Stream接口将每个流元素转换成零个或者更多流元素
         * peek      对遇到的每个流元素执行一些操作。
         * distinct  根据流元素的equals(..)结果排除所有重复的元素
         * sorted    使后续操作中的流元素强制按Comparator定义的比较逻辑排列。
         * limit     使后续操作只能看到有限数量的元素。
         * substream 使后续操作只能看到某个范围内的元素（使用索引）。
         *
         * 中间操作中的一些，如sorted, distinct 和 limit等是有状态的，有状态的意思是这些操作返回的数据流结果依赖之前进行的操作的结果。另外，正如Javadoc上讲的，
         * 所有中间操作是“延迟执行（lazy）”的。接下来让我们更详细的了解一些中间操作。
         *
         */

        //Filter
        List<Person> persons = Arrays.asList(new Person("ppie", 29), new Person("jack", 26), new Person("mary", 19), new Person("penelope", 24));
        Stream personsOver18 = persons.stream().filter(p -> p.getAge() > 18);

        //Map
        Stream map = persons.stream().filter(p->p.getAge()>18).map(Student::new);



        /**
         * 终结操作
         *
         * 数据流处理过程通常包含下面几个步骤：
         *
         * 1.  从某个数据源头获取到数据流；
         *
         * 2.  执行像filter,map等等这样的一个或者多个中间操作；
         *
         * 3.   执行一个终结操作.
         *
         * 终结操作必须是最后一个在数据流上执行的操作。一旦执行了终结操作，数据流就“消耗完了”，不可再用了。
         *
         * 现有如下一些可用的终结操作类型：
         *
         * reducers ，   如reduce(..), count(..), findAny(..), findFirst(..)，可以终结数据流处理过程。根据意图,终结操作可以是“短路”操作（不用完整的遍历所有数据流）。例如，findFirst(..)在一遇到匹配的元素就会马上终结数据流的处理过程。
         * collectors,  就像其名字表示的,用来把处理过的元素收集到一个结果集中。
         * forEach      对数据流中的每一个元素执行某个操作。
         * iterators ，  如果上面的操作都不能满足我们的需求，那么还是采用iterators这种传统的集合操作方式。
         * 其中最有趣的终结操作类型是所谓的“收集器（collectors）”：
         */


        //收集器

        List student = persons.stream()
                .filter(p->p.getAge()>18)
                .map(Student::new)
                //.collect(Collectors.toList());
                .collect(Collectors.toCollection(ArrayList::new));

        /**
         * 数据处理流程中的并发操作会自治地管理自身，不需要我们来处理并发问题，这简直太酷了。
         */
    }


}
