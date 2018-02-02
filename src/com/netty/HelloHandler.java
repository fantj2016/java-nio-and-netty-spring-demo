package com.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.*;

/**
 * 接受消息
 * Created by Fant.J.
 * 2018/2/2 22:54
 */
public class HelloHandler extends SimpleChannelHandler{
    /**
     * Invoked when a message object (e.g: {@link ChannelBuffer}) was received
     * from a remote peer.
     * 接受消息
     * @param ctx
     * @param e
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
//        int i = 1/0;
//        System.out.println("messageReceived()");
//        ChannelBuffer message = (ChannelBuffer) e.getMessage();
//        String s = new String(message.array());
        System.out.println(e.getMessage());
//        System.out.println(s);

        //回复数据
        ChannelBuffer channelBuffer = ChannelBuffers.copiedBuffer("hi".getBytes());
        ctx.getChannel().write(channelBuffer);
        super.messageReceived(ctx, e);
    }

    /**
     * Invoked when an exception was raised by an I/O thread or a
     * {@link ChannelHandler}.
     * 捕获异常
     * @param ctx
     * @param e
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        System.out.println("exceptionCaught()");
        super.exceptionCaught(ctx, e);
    }

    /**
     * Invoked when a {@link Channel} is open, bound to a local address, and
     * connected to a remote address.
     * 建立连接
     * @param ctx
     * @param e
     */
    @Override
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelConnected() ");
        super.channelConnected(ctx, e);
    }

    /**
     * Invoked when a {@link Channel} was disconnected from its remote peer.
     * 断开连接：必须是连接已经建立，关闭通道的时候才会触发。
     * @param ctx
     * @param e
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelDisconnected()");
        super.channelDisconnected(ctx, e);
    }

    /**
     * Invoked when a {@link Channel} was closed and all its related resources
     * were released.
     * 关闭通道
     * @param ctx
     * @param e
     */
    @Override
    public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        System.out.println("channelClosed()");
        super.channelClosed(ctx, e);
    }
}
