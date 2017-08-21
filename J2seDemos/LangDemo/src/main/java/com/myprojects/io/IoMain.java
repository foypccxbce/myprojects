package com.myprojects.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Package: com.myprojects.io
 * @Author: tangkj
 * @Daet: 2017/8/8 14:04
 * @Email: none@mail.com
 * @Desc:
 */
public class IoMain {
    private static byte[] request = null;

    static {
        StringBuffer temp = new StringBuffer();
        temp.append("GET http://www.baidu.com/index.html HTTP/1.1\r\n");
        temp.append("Host: www.baidu.com:80\r\n");
        temp.append("Connection: keep-alive\r\n");
        temp.append("Cache-Control: max-age=0\r\n");
        temp
                .append("User-Agent: Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.47 Safari/536.11\r\n");
        temp
                .append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n");
        temp.append("Accept-Encoding: gzip,deflate,sdch\r\n");
        temp.append("Accept-Language: zh-CN,zh;q=0.8\r\n");
        temp.append("Accept-Charset: UTF-8,utf-8;q=0.7,*;q=0.3\r\n");
        temp.append("\r\n");
        request = temp.toString().getBytes();
    }

    public static void main(String[] args) {
        socketChannelTest();
    }

    public static void fileChannelTest() {
        try {
            RandomAccessFile rsf = new RandomAccessFile("pom.xml", "rw");
            FileChannel channel = rsf.getChannel();

            ByteBuffer buffer = ByteBuffer.allocate(10);

            int readSize = channel.read(buffer);
            while (readSize != -1) {
                buffer.flip();

                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                buffer.clear();
                readSize = channel.read(buffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void socketChannelTest() {
        try {
            SocketChannel channel = SocketChannel.open();
            Charset charset = Charset.forName("UTF-8");
            channel.connect(new InetSocketAddress("www.baidu.com", 80));

            channel.write(ByteBuffer.wrap(request));
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int ret = channel.read(buffer);
            while (ret != -1) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print(charset.decode(buffer));
                }
                buffer.clear();
                ret = channel.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
