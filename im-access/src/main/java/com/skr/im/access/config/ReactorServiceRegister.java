package com.skr.im.access.config;

import com.skr.im.access.listener.IMEventReactionListener;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.Reactor;
import reactor.function.Consumer;

import static reactor.event.selector.Selectors.$;

/**
 * @author mqw
 * @create 2020-07-23-16:31
 */
@Component
public class ReactorServiceRegister implements InitializingBean {

    @Autowired
  	private Reactor reactor;

    @Autowired
  	private IMEventReactionListener imEventReactionListener;

    @Override
    public void afterPropertiesSet() {
        Consumer consumer = this.imEventReactionListener;
        reactor.on($("imEventReactionListener"), consumer);
    }

}