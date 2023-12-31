package day04.AOP1_java;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class JavaCalc {  // 사칙연산 프로그램 - 덧,뺄,곱,나

    public int add(int x, int y){
        Log log = LogFactory.getLog(this.getClass());

        StopWatch sw = new StopWatch();
        sw.start();  // 시간측정 시작
        log.info("타이머 시작");

        int result = x+y; //중심(관심, 주가되는) 코드
        sw.stop(); // 시간측정 끝
        log.info("타이머 정지");

        log.info("[TimerLOG] Memthod : add");
        log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis() );  // 작업에 걸린 시간

        return result;
    }

    public int mul(int x, int y){
        Log log = LogFactory.getLog(this.getClass());

        StopWatch sw = new StopWatch();
        sw.start();  // 시간측정 시작
        log.info("타이머 시작");

        int result = x*y;  //중심(관심, 주가되는) 코드
        sw.stop(); // 시간측정 끝
        log.info("타이머 정지");

        log.info("[TimerLOG] Memthod : mul");
        log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis() );  // 작업에 걸린 시간

        return result;
    }

    public int mul(int x, int y, int z){
        Log log = LogFactory.getLog(this.getClass());

        StopWatch sw = new StopWatch();
        sw.start();  // 시간측정 시작
        log.info("타이머 시작");

        int result = x*y*z;  //중심(관심, 주가되는) 코드
        sw.stop(); // 시간측정 끝
        log.info("타이머 정지");

        log.info("[TimerLOG] Memthod : mul");
        log.info("[TimerLOG] process Time : " + sw.getTotalTimeMillis() );  // 작업에 걸린 시간

        return result;
    }
}
