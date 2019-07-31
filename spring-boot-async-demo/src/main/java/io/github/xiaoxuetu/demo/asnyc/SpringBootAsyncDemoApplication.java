package io.github.xiaoxuetu.demo.asnyc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@EnableAsync
@SpringBootApplication
public class SpringBootAsyncDemoApplication {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootAsyncDemoApplication.class, args);

        // 获取异步任务
        AsyncTask asyncTask = context.getBean(AsyncTask.class);

        log.info("Now begin to execute async task ...");

        // 执行异步输出任务
        asyncTask.asyncPrint("xiaoxuetu");

        // 执行异步输出任务并等待任务完成
        Future<String> future = asyncTask.asyncAppendName("xiaoxuetu by return");

        log.info("Waiting for the result of future");
        log.info(future.get());

        // 使用代码配置的线程池异步输出
        asyncTask.asyncPrintByClassConfigExecutor();

        // 使用开源库根据配置动态创建的线程池输出
        asyncTask.asyncPrintByMultiThreadPools();
    }

}
