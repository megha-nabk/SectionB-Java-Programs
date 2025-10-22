package sectionb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Custom annotation to mark methods for execution-time logging.
 */
@Retention(RetentionPolicy.RUNTIME)
@interface LogExecutionTime { }

/**
 * TaskProcessor contains methods annotated with @LogExecutionTime.
 */
class TaskProcessor {

    @LogExecutionTime
    public void processData() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // additional example method
    @LogExecutionTime
    public void quickTask() {
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

/**
 * LogExecutionDemo uses reflection to find annotated methods and log execution time.
 */
public class LogExecutionDemo {
    public static void main(String[] args) throws Exception {
        TaskProcessor processor = new TaskProcessor();
        Method[] methods = TaskProcessor.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.currentTimeMillis();
                method.invoke(processor);
                long end = System.currentTimeMillis();
                System.out.println("Method " + method.getName() + " executed in " + (end - start) + " ms");
            }
        }
    }
}
