package com.skr.im.server.boot;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @author : mengqingwen 
 * create at:  2020-07-12
 * @description:
 * */
public class IMChanelInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        // 得到管道
        System.out.println(Thread.currentThread().getId()+","+this.hashCode());
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("http-codec", new HttpServerCodec());
        pipeline.addLast("http-chunk-aggregator",new HttpObjectAggregator(65535));
        // 增加自定义的分发器handler
        pipeline.addLast("distribute-handler", new HttpTest());
    }
}