# Maven Dependency Scope

Dependency scope 是用来限制Dependency的作用范围的，影响maven项目在各个生命周期时导入的package的状态。

- compile

  默认的scope，表示dependency都可以在生命周期中使用。而且这些dependencies会传递到依赖的项目中。

- provided

  dependency由JDK或者容器提供，例如servlet API和一些Java EE APIs。scope声明为provided的dependencies 只能作用在编译和测试时，同时没有传递性。使用provided时，不会将包打入项目中，只是依赖过来。使用默认或其他scope，会将依赖的项目打成jar包，放入本项目的Lib里

- runtime

  表示dependency不作用在编译时，但会作用在运行和测试时。

- test

  表示dependency作用在测试时，不作用在运行时。

- system

  跟provided类似，但是在系统中药以外部jar包的形式提供，maven不会在repository查找它。

- import

  它只使用在<dependencyManagement>中，表示从其他的pom中导入dependency的配置。

