package io.github.xiaoxuetu.demo.asnyc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Slf4j
@Component
public class AsyncTask {

    /**
     * 异步输出
     * @param name 需要输出的名字
     */
    @Async
    public void asyncPrint(String name) {
        log.info("Hello, {} !", name);
    }

    /**
     * 异步拼接并返回Future
     * @param name 需要拼接的名字
     */
    @Async
    public Future<String> asyncAppendName(String name) {
        log.info("Begin to append name ...");
        String content = String.format("Hello, %s !", name);
        return new AsyncResult<>(content);
    }

    /**
     * 使用代码配置的线程池进行内容异步输出
     */
    @Async("classConfigExecutor")
    public void asyncPrintByClassConfigExecutor() {
        log.info("Current thread name is {} !", Thread.currentThread().getName());
    }

    /**
     * 使用 开源代码库中，通过配置动态创建线程池进行内容异步输出
     */
    @Async("xiaoxuetu-design")
    public void asyncPrintByMultiThreadPools() {
        log.info("Current thread name is {} !", Thread.currentThread().getName());
    }
}
