package com.skr.im.access.boot;

import com.skr.im.access.utils.NamedThreadFactory;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * @author : mengqingwen 
 * create at:  2020-07-12
 * @description:
 * */
@Component
@Slf4j
public class NettyServerBoot {

    private static final ExecutorService POOL =
            new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(),new NamedThreadFactory("nettyServerBoot-pool"));

    @Value("${server.port}")
    private Integer port;

    @Autowired
    IMChanelInitializer initializer;


    @PostConstruct
    public void run(){
        POOL.submit(() -> {
            EventLoopGroup boss = new NioEventLoopGroup();
            EventLoopGroup worker = new NioEventLoopGroup(3);
            log.info("NettyServerBoot begin start at port : {}",port);
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.group(boss,worker)
                        .option(ChannelOption.SO_BACKLOG, 128)
                        .childOption(ChannelOption.SO_KEEPALIVE, true)
                        .childOption(ChannelOption.TCP_NODELAY, true)
                        .channel(NioServerSocketChannel.class)
                        .childHandler(initializer);

                bootstrap.bind(port).sync().channel().closeFuture().sync();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                boss.shutdownGracefully();
                worker.shutdownGracefully();
            }
            log.info("NettyServerBoot over start at port : {}",port);
        });

    }

}