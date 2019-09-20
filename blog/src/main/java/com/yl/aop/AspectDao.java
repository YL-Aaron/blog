package com.yl.aop;

import com.yl.bean.Base;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 保存信息的切面
 *
 * @author YL
 * @date 17:47 2019/9/16
 */
@Component
@Aspect
public class AspectDao {

    /**
     * 配置添加数据的切点
     * @author YL
     * @date 2019/9/20 10:27
     * @param
     * @return void
     */
    @Pointcut("execution(public * com.yl.dao.*.insert*(..))")
    public void savePointCut() {
    }

    /**
     * 配置修改数据的切点
     * @author YL
     * @date 2019/9/20 10:27
     * @param
     * @return void
     */
    @Pointcut("execution(public * com.yl.dao.*.update*(..))")
    public void updatePointCut() {
    }

    /**
     * 添加的环绕通知
     * @author YL
     * @date 2019/9/20 10:28
     * @param joinPoint
     * @param base
     * @return java.lang.Object
     */
    @Around("savePointCut() && args(base,..)")
    public Object saveAround(ProceedingJoinPoint joinPoint, Base base) throws Throwable {
        Date now=new Date();
        base.setCreateTime(now);
        base.setUpdateTime(now);
        return joinPoint.proceed();
    }

    /**
     * 修改的环绕通知
     * @author YL
     * @date 2019/9/20 10:28
     * @param joinPoint
     * @param base
     * @return java.lang.Object
     */
    @Around("updatePointCut() && args(base,..)")
    public Object updateAround(ProceedingJoinPoint joinPoint, Base base) throws Throwable {
        Date now=new Date();
        base.setUpdateTime(now);
        return joinPoint.proceed();
    }
}
