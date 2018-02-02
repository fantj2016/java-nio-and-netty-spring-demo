package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Fant.J.
 * 2018/1/26 14:46
 */
public class NIOCLient {
    private static int blockSize = 4096;
    //发送数据缓冲区
    private static ByteBuffer sendbuffer = ByteBuffer.allocate(blockSize);
    //接受数据缓冲区
    private static ByteBuffer receivebuffer = ByteBuffer.allocate(blockSize);
    //采集器
    private static Selector selector;
    //计数
    private static int flag = 1;
    //设置 ip 和 端口
    private final static InetSocketAddress serverAddress = new InetSocketAddress("127.0.0.1",8080);

    public static void main(String[] args) throws IOException {

        int count = 0;
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        //注册连接事件
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        //连接
        socketChannel.connect(serverAddress);
        //遍历
        Set<SelectionKey> selectionKeys;
        Iterator<SelectionKey> iterator;
        SelectionKey selectionKey;
        SocketChannel client;
        String receiveText;
        String sendText;
        //监听事件
        while (true){
            selectionKeys = selector.selectedKeys();
            iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                selectionKey = iterator.next();
                //判断事件种类 ， 如果是可连接类型
                if (selectionKey.isConnectable()){
                    System.out.println("client connect start");
                    client = (SocketChannel) selectionKey.channel();
                    if (client.isConnectionPending()){
                        client.finishConnect();
                        System.out.println("client connect success");
                        sendbuffer.clear();
                        sendbuffer.put("hello , Server".getBytes());
                        sendbuffer.flip();
                        client.write(sendbuffer);
                        client.register(selector,SelectionKey.OP_READ);
                    }
                }
                //判断事件种类 ， 如果是可读类型
                if (selectionKey.isReadable()){
                    client = (SocketChannel) selectionKey.channel();
                    receivebuffer.clear();
                    count = client.read(sendbuffer);
                    if (count > 0){
                        receiveText = new String(receivebuffer.array(),0,count);
                        System.out.println("客户端接收到服务端数据->"+receiveText);
                        client.register(selector,SelectionKey.OP_WRITE);
                    }
                }
                //如果是写事件
                if (selectionKey.isWritable()){
                    sendbuffer.clear();
                    client = (SocketChannel) selectionKey.channel();
                    sendText = "msg: send to server ->"+flag++;
                    sendbuffer.put(sendText.getBytes());
                    sendbuffer.flip();
                    client.write(sendbuffer);
                    System.out.println("客户端发送数据给服务端"+sendText);
                    client.register(selector,SelectionKey.OP_READ);
                }
            }
            //清除
            selectionKeys.clear();
        }

    }
}
