# Vue.js学习笔记

Vue应用是通过`Vue`函数创建新的Vue实例：

```vue
var vm = new Vue({
	//Vue的设计受到MVVM模型的启发，所以经常使用vm（ViewModel）这个变量名表示Vue实例
)}
```

| 全局配置              | 类型                    | 默认值    | 用法                                         |
| --------------------- | ----------------------- | --------- | -------------------------------------------- |
| silent                | boolean                 | false     | Vue.config.silent = true                     |
| optionMergeStrategies | {[key:string]:Function} | {}        | 自定义合并策略的选项                         |
| devtools              | boolean                 | true      | 是否允许vue-devtools检查代码                 |
| errorHandler          | Function                | undefined | 指定组件的渲染和观察期间未捕获错误的处理函数 |
| warnHandler           |                         |           |                                              |
| ignoredElements       |                         |           |                                              |
| keyCodes              |                         |           |                                              |
| performance           |                         |           |                                              |
| productionTip         |                         |           |                                              |

| 全局API       |                                                 |      |      |
| ------------- | ----------------------------------------------- | ---- | ---- |
| Vue.extend    | 使用基础Vue构造器，创建一个子类                 |      |      |
| Vue.nextTick  | 在下次DOM更新循环结束之后执行延迟回调           |      |      |
| Vue.set       | 设置对象的属性                                  |      |      |
| Vue.delete    | 删除对象的属性                                  |      |      |
| Vue.directive | 注册或获取全局指令                              |      |      |
| Vue.filter    | 注册或获取全局过滤器                            |      |      |
| Vue.component | 注册或获取全局组件                              |      |      |
| Vue.use       | 安装Vue.js插件                                  |      |      |
| Vue.mixin     | 注册一个混入，影响注册之后所有创建的每个Vue实例 |      |      |
| Vue.compile   | 在render函数中编译模板字符串                    |      |      |
| Vue.version   |                                                 |      |      |
|               |                                                 |      |      |

| 选项/数据 |        类型        |           限制           |         描述         |
| :-------- | :----------------: | :----------------------: | :------------------: |
| data      | Object \| Function | 组件的定义只接受function | Vue 实例的数据对象。 |
| props     |                    |                          |                      |
| propsData |                    |                          |                      |
| computed  |                    |                          |                      |
| methods   |                    |                          |                      |
| watch     |                    |                          |                      |

| 选项/DOM    |      |      |      |
| :---------- | ---- | ---- | ---- |
| el          |      |      |      |
| template    |      |      |      |
| render      |      |      |      |
| renderError |      |      |      |

| 选项/生命周期钩子 |      |      |      |
| ----------------- | ---- | ---- | ---- |
| beforeCreate      |      |      |      |
| created           |      |      |      |
| beforeMount       |      |      |      |
| mounted           | 挂载 |      |      |
| beforeUpdate      |      |      |      |
| updated           |      |      |      |
| activated         |      |      |      |
| deactivated       |      |      |      |
| beforeDestory     |      |      |      |
| destoryed         |      |      |      |
| errorCaptured     |      |      |      |

| 选项/资源  |      |      |      |
| ---------- | ---- | ---- | ---- |
| directives |      |      |      |
| filters    |      |      |      |
| components |      |      |      |

| 选项/组合      |      |      |      |
| -------------- | ---- | ---- | ---- |
| parent         |      |      |      |
| mixins         |      |      |      |
| extends        |      |      |      |
| provide/inject |      |      |      |

| 选项/其它    |      |      |      |
| ------------ | ---- | ---- | ---- |
| name         |      |      |      |
| delimiters   |      |      |      |
| functional   |      |      |      |
| model        |      |      |      |
| inheritAttrs |      |      |      |
| comments     |      |      |      |

| 实例属性        |      |      |      |
| --------------- | ---- | ---- | ---- |
| vm.$data        |      |      |      |
| vm.$props       |      |      |      |
| vm.$el          |      |      |      |
| vm.$options     |      |      |      |
| vm.$parent      |      |      |      |
| vm.$root        |      |      |      |
| vm.$children    |      |      |      |
| vm.$slots       |      |      |      |
| vm.$scopedSlots |      |      |      |
| vm.$refs        |      |      |      |
| vm.$isServer    |      |      |      |
| vm.$attrs       |      |      |      |
| vm.$listeners   |      |      |      |

| 实例方法/数据 |      |      |      |
| ------------- | ---- | ---- | ---- |
| vm.$watch     |      |      |      |
| vm.$set       |      |      |      |
| vm.$delete    |      |      |      |

| 实例方法/事件 |      |      |      |
| ------------- | ---- | ---- | ---- |
| vm.$on        |      |      |      |
| vm.$once      |      |      |      |
| vm.$off       |      |      |      |
| vm.$emit      |      |      |      |

| 实例方法/生命周期 |      |      |      |
| ----------------- | ---- | ---- | ---- |
| vm.$mount         |      |      |      |
| vm.$forceUpdate   |      |      |      |
| vm.$nextTick      |      |      |      |
| vm.$destroy       |      |      |      |

| 指令      |      |      |      |
| --------- | ---- | ---- | ---- |
| v-text    |      |      |      |
| v-html    |      |      |      |
| v-show    |      |      |      |
| v-if      |      |      |      |
| v-else    |      |      |      |
| v-else-if |      |      |      |
| v-for     |      |      |      |
| v-on      |      |      |      |
| v-bind    |      |      |      |
| v-model   |      |      |      |
| v-pre     |      |      |      |
| v-cloak   |      |      |      |
| v-once    |      |      |      |

| 特殊特性   |      |      |      |
| ---------- | ---- | ---- | ---- |
| key        |      |      |      |
| ref        |      |      |      |
| slot       |      |      |      |
| slot-scope |      |      |      |
| scope      |      |      |      |
| is         |      |      |      |

| 内置的组件       |      |      |      |
| ---------------- | ---- | ---- | ---- |
| component        |      |      |      |
| transition       |      |      |      |
| transition-group |      |      |      |
| keep-alive       |      |      |      |
| slot             |      |      |      |



![](https://vuejs.bootcss.com/images/lifecycle.png)

