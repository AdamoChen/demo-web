package com.chen.demoweb.testExecutor;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author chenchonggui
 * @version 1.0
 * @date_time 2020/6/30 16:03
 */
@ConfigurationProperties(prefix = "test.executor")
@Configuration
@EnableAsync
@Data
public class ExecutorConfiger {

    private Task task;

    @Data
    public static class Task {
        private int coreSize;
        private int maxSize;
        private int queueCapacity;
        private int keepAliveSeconds;
        private String threadNamePrefix;
        private int awaitTerminationSeconds;
        private boolean waitForTasksToCompleteOnShutdown;
    }

    /**
     * @return
     */
    @Bean("testExeCutor")
    @ConditionalOnBean(ExecutorConfiger.class)
    public ThreadPoolTaskExecutor testExecutor() {
        return buildTask(this.getTask());
    }

    private ThreadPoolTaskExecutor buildTask(ExecutorConfiger.Task task) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(task.getCoreSize());
        executor.setMaxPoolSize(task.getMaxSize());
        executor.setQueueCapacity(task.getQueueCapacity());
        executor.setKeepAliveSeconds(task.getKeepAliveSeconds());
        executor.setThreadNamePrefix(task.getThreadNamePrefix());
        //executor.setWaitForTasksToCompleteOnShutdown(task.isWaitForTasksToCompleteOnShutdown());
        // executor.setAwaitTerminationSeconds(task.getAwaitTerminationSeconds());
        /**
         * windows debug 启动
         *
         *  存在于静态方法中 有调用 sleep方法
         *
         * false 5秒     bean直接销毁 每个线程且马上抛java.lang.InterruptedException: sleep interrupted
         * true 5秒      时间到后 bean销毁 时间到后任务没有执行完也会停止。不抛异常。
         * false        bean直接销毁 每个线程且马上抛java.lang.InterruptedException: sleep interrupted
         * true         bean 直接销毁 不抛异常
         *
         *  存在于静态方法中 仅仅是无限循环
         *
         * false 5秒     时间到后 bean销毁 时间到后任务没有执行完也会停止。
         * true 5秒      时间到后 bean销毁 时间到后任务没有执行完也会停止。
         * false        bean直接销毁
         * true         bean直接销毁
         *
         */
         executor.setWaitForTasksToCompleteOnShutdown(true);
         executor.setAwaitTerminationSeconds(5);
         executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}