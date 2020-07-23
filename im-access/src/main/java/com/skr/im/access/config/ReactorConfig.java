package com.skr.im.access.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;



/**
 * @author mqw
 * @create 2020-07-23-15:02
 */

@Configuration
public class ReactorConfig {


    @Bean
    Environment env() {
        return new Environment();
    }

    @Bean
    Reactor reactor(Environment env) {
        return Reactors.reactor()
                .env(env)
                .dispatcher(Environment.RING_BUFFER)
                .get();
    }


}