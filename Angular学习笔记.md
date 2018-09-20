# 前台框架学习

## 先了解AngularJS概念和基础语法。

### AngularJS表达式

写在双大括号`{{}}`内，作用是把数据绑定到HTML。

### AngularJS指令

扩展的HTML属性，分为内置指令和自定义指令，指令样式`ng-`开头。

例如：

`ng-app`：初始化一个AngularJS应用程序 ，标记了AngularJS脚本的作用域。

`ng-init` ：初始化应用程序数据

`ng-model`：把元素值绑定到应用程序

`ng-bind`：绑定HTML元素到应用程序数据

### AngularJS模型

`ng-model`指令用于将应用程序数据绑定到HTML元素上。

#### 双向绑定

`ng-model`指令可以将输入域的值域Ang创建的变量绑定，在修改输入域的值时，Ang属性的值也将修改。

### Scope作用域

`scope`是一个JavaScript对象，带有属性和方法。这些属性可以在视图和控制器中使用。

`$scope`是一个POJO

`$scope`提供了一些工具方法`$watch` `$apply`

`$scope`是表达式的执行环境（或者叫做作用域）

`$scope`是一个树形结构，与DOM标签平行。

子`$scope`对象会继承父`$scope`上的属性和方法

每个AngularJS应用只有一个跟`$scope`对象，一般位于`ng-app`上.

`$scope`可以传播事件，类似DOM事件，可以向上也可以向下。

`$scope`不仅是MVC的基础，也是实现双向数据绑定的基础。

### AngularJS应用程序

前端MVC：为了模块化和复用。

`view`：即HTML

`Model`：当前视图中可用的数据

`Controller`：即JavaScript函数，可以添加和修改属性



创建AngularJS控制器时，可以将`$scope`对象当作一个参数。AngularJS的MVC是借助`$scope`实现的。

### AngularJS控制器

`ng-controller`指令定义了控制器，控制器控制AngularJS应用程序。

AngularJS使用`$scope`对象来调用控制器。控制器的`$scope`用来保存AngularJS Model。

一个控制器一般只负责一小块视图。

### AngularJS Service

封装可重用的业务逻辑

可以使用内建服务，也可以自定义服务。

### 路由

使用`ngRoute`进行视图之间的路由。

### 模块

`Modules are Container。`

模块实际上是一个集合，又模型、视图、控制器、过滤器、服务等组合在一起，实现了某一个功能。

模块之间的依赖是通过依赖注入实现的。

## 后台功能模块开发

项目中只有一个`indexApp`，定义在`indexConfig.js`中。

`indexConfig.js`中，启动AngularJS应用之前，获取路由信息和权限信息，然后手动启动`indexApp`.

在`(function () { ... }());`中进行AngularJS的相关配置

主模块：indexApp

自定义服务：permissions，routers

手动启动AngularJS之前，获取路由和权限信息，然后通过`run方法`设置全局路由信息和权限信息。在AngularJS模块加载之前进行配置config()

ng的运行机制
config阶段是给了ng上下文一个针对constant与provider修改其内部属性的一个阶段
而run阶段是在config之后的在运行独立的代码块，通常写法runBlock
简单的说一下就是ng启动阶段是 config-->run-->compile/link

| 服务/阶段  | provider | factory | service | value | constant |
| ---------- | -------- | ------- | ------- | ----- | -------- |
| config阶段 | Yes      | No      | No      | No    | Yes      |
| run 阶段   | Yes      | Yes     | Yes     | Yes   | Yes      |

## 功能模块开发

以课程模块为例：

course.html

```
<div ng-cloak class="ng-cloak" ng-controller="courseCtrl as course">
...
</div>
```

course.js

```
angular.module("indexApp").controller("courseCtrl", ['$http', '$scope', function ($http, $scope) {
	var course = this;
}
```

增删改查的方法基本按照模板修改即可。

以上完成之后，在`index.js`中追加`require('./xiyou/course');`

最后，登录到后台管理，添加模块相关的菜单，并给角色添加相关权限。

## 自定义指令

hasPermission

## 前后端分离

在`webpack.config.js`中，调用接口的地址配置在这里。



