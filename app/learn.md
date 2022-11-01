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


LiveData是Google Jetpack库中提供的一种可观察的数据存储器类，是一种可以与任意数据类型一起使用的包装器。
LiveData可以感知生命周期，观察者（Observer）处于Started或Resumed状态时，LiveData认为该观察者处于活跃状态，会将更新通知给活跃观察者，而已注册非活跃状态的观察者不会收到更新。这样当Activity和Fragment生命周期结束时，便可移除观察者而不必担心泄露

链接：https://www.jianshu.com/p/231fe3ce675c

在LiveData的观察者对象中进行与数据状态相关的界面更新操作；
观察者会绑定Lifecycle对象，当与其关联的生命周期结束时进行自我清理；
当activity或fragment由非活跃状态变为活跃状态时，会立即接收最新数据；
设备配置更改时（例如屏幕旋转或中英文切换）而创建新activity或fragment时会接收最新数据;
可使用单例模式扩展LiveData对象并包装成系统服务，以便在应用程序中共享（事件总线LiveDataBus）。
MutableLiveData继承自LiveData；
LiveData可以通知指定的某字段的数据更新，外部需MutableLiveData类才能改变容器内容；
MutableLiveData整个实体类或数据类型变化后才通知，不会细节到字段；
MutableLiveData提供了改变容器内容的接口setValue/postValue；

作者：田田ww
链接：https://www.jianshu.com/p/231fe3ce675c
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。






sprinboot  乱码下的解决方法

package com.jvm123.api.config
/**
 *
 * @author yawn < http://jvm123.com >
 *
 */
@Configuration
@EnableWebMvc
class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new StringHttpMessageConverter(StandardCharsets.UTF_8))
        super.configureMessageConverters(converters)
    }
}


自定义的仪表盘
https://www.jianshu.com/p/f36bb920e6b3

2022111
Retorfit 源码解析
builder 初始化和set方法
 public Builder() {
      //调用Platform.get()
      this(Platform.get());
  }
    public Builder() {
        //调用Platform.get()
        this(Platform.get());
    }
    //Platform.class
    private static final Platform PLATFORM = findPlatform();
    //get方法调用findPlatform返回一个Platform 
    static Platform get() {
      return PLATFORM;
    }
   //可以看到findPlatform方法根据不同平台返回不同的Platform,那我们直接来看
   //new Android()这块
   private static Platform findPlatform() {
      try {
        Class.forName("android.os.Build");
        if (Build.VERSION.SDK_INT != 0) {
          return new Android();
        }
      } catch (ClassNotFoundException ignored) {
      }
      try {
        Class.forName("java.util.Optional");
        return new Java8();
      } catch (ClassNotFoundException ignored) {
      }
      try {
        Class.forName("org.robovm.apple.foundation.NSObject");
        return new IOS();
      } catch (ClassNotFoundException ignored) {
      }
      return new Platform();
    }
   //Android继承自Platform
   
   newBuilder
   static class Android extends Platform {
     //可以当作是用来线程切换的执行器
      @Override public Executor defaultCallbackExecutor() {
        return new MainThreadExecutor();
      }
      //默认的网络发射器，RxJavaCallAdapterFactory就是CallAdapter.Factory的具体工厂，如果外部不提供就用这个默认的，具体ExecutorCallAdapterFactory源码这里不做分析，只分析RxJavaCallAdapterFactory。
      @Override CallAdapter.Factory defaultCallAdapterFactory(Executor callbackExecutor) {
        return new ExecutorCallAdapterFactory(callbackExecutor);
      }
      //回调方法执行器，作用是用来线程切换的。
      static class MainThreadExecutor implements Executor {
        private final Handler handler = new Handler(Looper.getMainLooper());
        //在Retorfit中默认是将okhttp请求的返回的数据切换到主线程中
        @Override public void execute(Runnable r) {
          handler.post(r);
        }
      }
    }
    //最终调用Builder的第二个构造方法，并且添加默认的数据转换器
     Builder(Platform platform) {
        this.platform = platform;
        converterFactories.add(new BuiltInConverters());
      }
      
      看不太懂  懂了20
      https://www.jianshu.com/p/f41b33797de5
      baseUrl() 模块
       public Builder baseUrl(String baseUrl) {
            //检测url合法性
            checkNotNull(baseUrl, "baseUrl == null");
            //外部传进来的String url 转换为Okhttp中认可的HttpUrl
            HttpUrl httpUrl = HttpUrl.parse(baseUrl);
            if (httpUrl == null) {
              throw new IllegalArgumentException("Illegal URL: " + baseUrl);
            }
            return baseUrl(httpUrl);
          }
           public Builder baseUrl(HttpUrl baseUrl) {
                checkNotNull(baseUrl, "baseUrl == null");
                //得到url的分片
                List<String> pathSegments = baseUrl.pathSegments();
                //判断是否以/结尾 不是就抛出异常
                if (!"".equals(pathSegments.get(pathSegments.size() - 1))) {
                  throw new IllegalArgumentException("baseUrl must end in /: " + baseUrl);
                }
                this.baseUrl = baseUrl;
                return this;
              }
              
                //设置okhttpClient
                public Builder client(OkHttpClient client) {
                    return callFactory(checkNotNull(client, "client == null"));
                  }
                 //检查合法性并赋值给 Budiler中  callFactory
                  public Builder callFactory(okhttp3.Call.Factory factory) {
                    this.callFactory = checkNotNull(factory, "factory == null");
                    return this;
                  }
            public Builder addConverterFactory(Converter.Factory factory) {
                converterFactories.add(checkNotNull(factory, "factory == null"));
                return this;
              }
              
              
              设置转换器，可以看到参数需要一个转换工厂，Converter.Factory，我们传进来的是一个GsonConverterFactory具体的工厂，这里Retorfit用到的是工厂方法设计模式，那先来看看Converter.Factory 定义的工厂方法都有哪些。
              
             //将HTTP响应主体转换为? 也就是我们代码中定义的类型
             public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations,
                    Retrofit retrofit) {
                  return null;
                }
               //将代码中请求的类型转换为HTTP请求体
               //主要用于对Part、PartMap、Body注解的处理
                public Converter<?, RequestBody> requestBodyConverter(Type type,
                    Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
                  return null;
                }
                // 这里用于对Field、FieldMap、Header、Path、Query、QueryMap注解的理
                // Retrfofit对于上面的几个注解默认使用的是调用toString方法
                public Converter<?, String> stringConverter(Type type, Annotation[] annotations,
                    Retrofit retrofit) {
                  return null;
                }
                
                
                将RxJavaCallAdapterFactory实例添加到adapterFactories集合中，和添加解析器一样，也是一个工厂方法设计模式，那我们看看CallAdapter.Factory中定义的重要方法
                //根据方法返回类型和方法上定义的注解返回CallAdapter，具体的CallAdapter在RxJavaCallAdapterFactory 中内部类SimpleCallAdapter实现，这里只针对，定义接口中返回Observable<BaseResponse>来说明
                public abstract CallAdapter<?> get(Type returnType, Annotation[] annotations,Retrofit retrofit);
                
  
  
  3.1.1 创建网络发射器
  
  private CallAdapter<?> createCallAdapter() {
        //获取method返回值类型
        Type returnType = method.getGenericReturnType();
        ...省略判断
        //获取method上的注解
        Annotation[] annotations = method.getAnnotations();
        try {
          //调用retrofit中的callAdapter
          return retrofit.callAdapter(returnType, annotations);
        } catch (RuntimeException e) { 
          throw methodError(e, "Unable to create call adapter for %s", returnType);
        }
      }
  
  
  
  
  
  
  
  2platform  总线  platform是一条虚拟总线。设备用platform_device表示，驱动用platform_driver进行注册