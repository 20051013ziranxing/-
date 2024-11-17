美团外卖仿写项目：

# 登录注册界面

![2462f96ece4a83cbcd00db3f08341aa](C:\Users\rog\Desktop\2462f96ece4a83cbcd00db3f08341aa.jpg)

![33f6a198f35d0631841694c7f8e24cf](C:\Users\rog\Desktop\33f6a198f35d0631841694c7f8e24cf.jpg)

写了美团的登录与注册界面，界面布局很简单，是为了进行MVP框架的练习，写了数据库的相关操作。

# 主要框架以及知识点

## 前期准备知识

1. 对于约束布局的使用
2. 对于ViewPager2的使用以及与ViewPager的区别
3. 对于MVP框架的学习与使用
4. 对于轮播图的学习与使用

## 整体大致框架以及遇到的问题

1. 对于主要页面都采用约束布局的布局方式
2. 一开始对于页面滑动会有控件变化的情况不知道如何实现，这个情况是因为随着滑动对页面进行监听，改变控件的可见性来实现，使用NestedScrollView使布局能够进行滑动的监听

# 首页面

![8e7cfea0e3b3e167516b1f9844cfa06](C:\Users\rog\Desktop\8e7cfea0e3b3e167516b1f9844cfa06.jpg)

1. 中间选择的改变放置的为图片，想要达到不同大小的目的，使用了ViewPager放置图片以及用碎片包围都不行，在一开始就会计算出大致距离，不会发生改变，达不到想要的效果，在搜索之后发现实现要自己写ViewPager才可以，这里没有进行重写~~~
2. 现在只展示了一个图片，可以下载demo进行测试，中间的筛选标签要呈现出吸顶的效果，我们使用RecyclerView，但要将两个联动调试了很久，放置的是一个选择按钮，对于按钮的选择要让两个都变化实现了很久，逻辑不难，但是联动有问题，现在好了，我用的办法是将按钮有没有被选择以及按钮上的标签写为一个类，类中存放是否被选择，从而通过点击改变状态，从而改变按钮的选择状态

# 会员页面

只做展示了，因为了解这个页面不属于Android，好吧我也实现不出来，只设置了滑动监听可以回到顶端。

![c2091b679324190a88b95fe9fb150cb](C:\Users\rog\Desktop\c2091b679324190a88b95fe9fb150cb.jpg)

# 订单页面

都是RecyclerView就不做过多的阐述了，还有就是滑动监听

# 我的页面

上面提到的这个界面几乎用到了，无非就是复习图片的圆形裁剪，没有什么亮点

![f3a8521cc9224869d6c875ac5ea2775](C:\Users\rog\Desktop\f3a8521cc9224869d6c875ac5ea2775.jpg)

# 选购物品界面

这个界面倒是写了很久，也出现了很多的问题

之前提到的全部都有，本界面嵌套很多，改了最大的地方就是底下选择商品部分，左边是RecyclerView，右边也是RecyclerView，想要实现按左边右边滚动到相应的位置，一开始右边嵌套了双层的RecyclerView，之后改为了单层的RecyclerView，布局的嵌套倒是少了一层，但是想要实现的地方还是没有实现，还没有改好。

![14c1c14b9db94a13018b43ff8988d45](C:\Users\rog\Desktop\14c1c14b9db94a13018b43ff8988d45.jpg)

本项目主要是UI的仿写以及MVP框架的小实践，因此对于购买商品的历史部分的数据库并没有写，但是对于历史的数据由MVP框架从Model层获取，省略了Model从数据库获取，而是直接写死的数据。登录注册界面信息较少写了数据库使用MVP框架进行连接。