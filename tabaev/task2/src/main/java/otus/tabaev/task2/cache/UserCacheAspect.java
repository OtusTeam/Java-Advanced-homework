package otus.tabaev.task2.cache;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import otus.tabaev.task2.controller.dto.CreateUserRequest;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class UserCacheAspect {

    private Cache<Object, Object> userCache = Caffeine
            .newBuilder()
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .maximumSize(1000)
            .build();

//    ConcurrentHashMap<Object, Object> userCache = new ConcurrentHashMap<>();

    @Pointcut("@annotation(otus.tabaev.task2.cache.MyCache)")
    public void myCache() {

    }

    @Around("myCache()")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint) {
        Object[] args = proceedingJoinPoint.getArgs();

        Object key = args[0];

        Object result = userCache.getIfPresent(key);

        if (result == null) {
            try {
                result = proceedingJoinPoint.proceed(args);
                userCache.put(key, result);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
}
