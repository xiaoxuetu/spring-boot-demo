package io.github.xiaoxuetu.demo.asnyc;

import org.springframework.boot.task.TaskExecutorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class ThreadPoolProvider {

    /**
     * 通过代码配置注册一个线程池
     * @return 代码配置创建的线程池
     */
    @Bean
    public ThreadPoolTaskExecutor classConfigExecutor() {
        return new TaskExecutorBuilder()
                .threadNamePrefix("clz-config-executor-")
                .build();
    }
}
