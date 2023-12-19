package day04.AOP2_java;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogPrintHandlerImpl implements InvocationHandler {
    private Object target;

    public LogPrintHandlerImpl(Object target){  //DI
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { // 보조프로그램 구현
        System.out.println("invoke method start .......");
        // 보조 업무 구현
        Log log = LogFactory.getLog(this.getClass());

        StopWatch sw = new StopWatch();
        sw.start();  // 시간측정 시작
        log.info("타이머 시작");

        ////////////// main 관심 실행 ////////////////////
        int result = (int)method.invoke(target,args);
        /////////////////////////////////////////////////
        sw.stop(); // 시간측정 끝
        log.info("타이머 정지");

        log.info("[TimerLOG] Memthod : " +method.getName()); // method.getName() 해당하는 메서드 이름이 나옴
        log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis() );  // 작업에 걸린 시간

        return result;
    }
}
