package com.skr.im.access.boot.factory;

import com.skr.im.access.boot.IMMsgAccessWSHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.Reactor;

/**
 * @author mqw
 * @create 2020-07-24-17:51
 */
@Component
public class IMHandlerFactory implements FactoryBean<IMMsgAccessWSHandler> {

    @Autowired
    Reactor reactor;

    @Override
    public IMMsgAccessWSHandler getObject() {
        return new IMMsgAccessWSHandler(false,reactor);
    }

    @Override
    public Class<?> getObjectType() {
        return this.getClass();
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}