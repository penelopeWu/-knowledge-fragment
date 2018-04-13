# URL中“#” “？” &“”号的作用

# #

一、#的意思/作用**　　#代表网页中的一个位置。类似于PPT里面的页内超链接。#右面的字符，就是该位置的标识符（即 这个位置的标记）。比如，http://www.XXX.com/index.html#location就代表www.xxx.com这个网站index.html这个网页的location位置。我想这个例子应该很清楚了。浏览器读取这个URL后，会自动将‘location’位置滚动至可视区域。
　　为网页位置指定标识符，有两个方法。一是使用锚点，比如<a name="location"></a>，二是使用id属性，比如<div id="location">。

**二、HTTP请求不包括#**　　#是用来指导浏览器产生行为的，对服务器端完全没用。我的理解是帮助你锁定/定位这个页面的某个位置的。所以，HTTP请求中不包括#。
比如，访问下面的网址，[http://www.XXX.com/index.html#location](http://www.example.com/index.html#print)，浏览器实际发出的请求是这样的：

```html
GET /index.html HTTP/1.1
Host: www.XXX.com
```

**三、#后的字符**
　　在第一个#后面出现的任何字符，都会被浏览器解读为位置标识符。这意味着，这些字符都不会被发送到服务器端。
比如，下面URL的原意是指定一个颜色值：[http://www.XXX.com/?color=#fff](http://www.example.com/?color=#fff)，但是，浏览器实际发出的请求是：

```
GET /?color= HTTP/1.1
Host: www.XXX.com
```

 　　

**四、改变#不触发网页重载**
　　单单改变#后的部分，浏览器只会滚动到相应位置，不会重新加载网页。所以不要看页面有个跳的动作，就以为页面跳转或者服务器端有所响应，其实没有。
比如，从http://www.XXX.com/index.html#location1改成http://www.XXX.com/index.html#location2，浏览器不会重新向服务器请求index.html。

**五、改变#会改变浏览器的访问历史**
　　每一次改变#后的部分，都会在浏览器的访问历史中增加一个记录，使用"后退"按钮，就可以回到上一个位置。这对于**ajax**应用程序特别有用，可以用不同的#值，表示不同的访问状态，然后向用户给出可以访问某个状态的链接。值得注意的是，上述规则对IE 6和IE 7不成立，它们不会因为#的改变而增加历史记录。

**八、Google抓取#的机制**
　　默认情况下，Google的网络蜘蛛**忽视**URL的#部分。
　　但是，Google还规定，如果你希望Ajax生成的内容被浏览引擎读取，那么URL中可以使用"#!"，Google会自动将其后面的内容转成查询字符串_escaped_fragment_的值。
　　比如，Google发现新版twitter的URL：<http://twitter.com/#!/username>
　　就会自动抓取另一个URL：<http://twitter.com/?_escaped_fragment_=/username>
　　通过这种机制，Google就可以索引动态的Ajax内容。



# ？

1）连接作用：比如

```
http://www.xxx.com/Show.asp?id=77&nameid=2905210001&page=1
```

2）清除缓存：比如

```
http://www.xxxxx.com/index.html 
http://www.xxxxx.com/index.html?test123123
```

# &

不同参数的间隔符