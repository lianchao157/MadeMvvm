//package com.e.mademvvm.domain.message;
//
//
//import com.e.mademvvm.domain.event.Messages;
//
///***
// * 亲爱的 MVI-Dispatcher，你已是个成熟的 '唯一可信源'，该学会自己去完成以下几点：. 1. 可彻底消除 mutable 样板代码 ，一行不必写. 2. 可连续发送多事件 ，解决 MVI 场景 LiveData 事件覆盖. 3. 高性能定长队列，随取随用，用完即走，绝不丢失事件. 4. 可杜绝团队新手 ... 展开
// */
//public class PageMessenger extends MviDispatcher<Messages> {
//    @Override
//    protected void  onHandle(Messages event){
//        sendResult(event);
//    }
//
//}
