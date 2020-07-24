package com.skr.im.access.factory;

import com.skr.im.access.boot.IMTextAccessHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.Reactor;

/**
 * @author mqw
 * @create 2020-07-24-17:51
 */
@Component
public class IMHandlerFactory implements FactoryBean<IMTextAccessHandler> {

    @Autowired
    Reactor reactor;

    @Override
    public IMTextAccessHandler getObject() {
        return new IMTextAccessHandler(false,reactor);
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}