github 项目地址
https://github.com/huanglinqing123/MvvmNews.git


1
androidx 的  MutableLive
Android中MutableLiveData的使用：   观察者中
有用到生命周期感知型组件 MutableLiveData，它是 LiveData 的子类，
这里主要介绍 MutableLiveData 在项目中的简单使用。


2 getApplicationContext(), getBaseContext(), getApplication(), getParent()区别以及context的最终解析
https://blog.csdn.net/self_study/article/details/14162929
BottomNavigationView 是什么？
https://www.jianshu.com/p/aa499cc64f72



mvp
https://github.com/KunMinX/Jetpack-MVVM-Best-Practice


https://github.com/KunMinX/Jetpack-MVVM-Best-Practice/tree/master/app
、



使用缓存框架
https://blog.csdn.net/ModestLearners/article/details/78191304?spm=1001.2101.3001.6661.1&utm_medium=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-78191304-blog-109378125.pc_relevant_multi_platform_whitelistv1_mlttest2&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-1-78191304-blog-109378125.pc_relevant_multi_platform_whitelistv1_mlttest2&utm_relevant_index=1
LruCache(Android的内存缓存)
1.概念

      内存缓存相对于磁盘缓存而言，速度要来的快很多，但缺点容量较小且会被系统回收，这里的实现我用到了LruCache。
LruCache这个类是Android3.1版本中提供的，如果你是在更早的Android版本中开发，则需要导入android-support-v4的jar包

Lru: 是Least Recently Used 的简称 ，近期最少使用的
原理：把近期最少使用的数据从缓存中移除，保留使用最频繁的数据
          LruCache是基于Lru算法实现的一种缓存机制
          Lru算法的原理是所近期最少使用的数据给移除掉，当然前提是当前数据量大于设定的最大值
          LruCache没有真正释放内存，只是从Map中移除数据，真正释放内存还是要用户手动释放

底部使用的是LinkedHashMap<k,p>（需要排序） 

LruCache的关键字段有 总容量  已使用容量 linkedHashMap
     //核心数据结构
  private final LinkedHashMap map;
  // 当前缓存数据所占的大小
  private int size;
  //缓存空间总容量
  private int maxSize;

需要注意的是size字段，因为map中可以存放各种类型的数据，这些数据的大小测量方式也是不一样的，需要自己定义数据的测量方式


2.关键代码如下

1.初使化，需要指定缓存区空间的大小
————————————————
版权声明：本文为CSDN博主「Jane.zhj」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/ModestLearners/article/details/78191304


2022.10.19  不知道这个项目想干啥

书写一个mvvM 的项目
https://camo.githubusercontent.com/
c4b6fd5aa66b1f3602815fb1b11bb97dbe48206c1084b198524c6c6ef5d1bd3b/
68747470733a2f2f696d616765732e7869616f7a6875616e6c616e2e636f6d2f70686f746f2f3230323
22f33323534333139633439376262333964363338363637636235383962343863372e706e67


android  的蓝牙
https://huanglinqing.blog.csdn.net/



各种   导入依赖包
https://www.imgeek.org/article/825358829