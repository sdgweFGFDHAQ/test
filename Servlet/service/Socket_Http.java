package Servlet.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Socket_Http extends Thread {
    Socket socket;

    public Socket_Http() {
    }

    public Socket_Http(Socket s) {
        this.socket = s;
    }

    public String getContentType(String url) {
        String suffix = url.substring(url.lastIndexOf("."));
        String contentType = "";
        if(suffix.equals(".jpg")) contentType="image/jpeg";
        if(suffix.equals(".html")) contentType="text/html";
        if(suffix.equals(".txt")) contentType="image/plain";
        return contentType;

    }

    public void run() {
        try {
            // 获得输入输出流
            System.out.println("--- 建立连接 开始接受http包头 ---");
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));

            // 读取客户端请求 接收并分析包头信息
            String line=null, url=null, ctype=null;
            while((line=reader.readLine()).length() != 0) {
                System.out.println("接收到的包头: " + line);
                if(line.split(" ")[0].equals("GET")) {
                    url = line.split(" ")[1].split("\\?")[0];
                    System.out.println("接收到get, url= " + url);
                }
            }
            System.out.println("--- 包头接收完成 ---");

            // 解析本地文件地址，并且试图获得文件的对象
            url = "E:\\桌面\\testwhat\\learnforJavaWeb-master\\01_html_css\\html" + url;
            File fi = new File(url);

            System.out.println("--- 发送响应头 ---");
            if(fi.exists()) {
                FileInputStream fis = new FileInputStream(fi);
                String contentType = getContentType(url);
                // 如果文件存在 返回文件内容
                os.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                os.write(new String("Content-Type: " + contentType + "\r\n").getBytes());
                os.write(new String("Content-Length: " + String.valueOf(fi.length()) + "\r\n").getBytes());
                os.write(new String("Accept-Ranges: bytes\r\n").getBytes());
                os.write(new String("Connection: close\r\n\r\n").getBytes());

                System.out.print("HTTP/1.1 200 OK\r\n");
                System.out.print("Content-Type: " + contentType + "\r\n");
                System.out.print("Content-Length: " + String.valueOf(fi.length()) + "\r\n");
                System.out.print("Accept-Ranges: bytes\r\n");
                System.out.print("Connection: close\r\n");
                System.out.println("--- 响应头发送完成 ---");
                System.out.println("--- 开始传输文件字节流 ---");
                byte[] buf = new byte[1024];
                int len;
                while((len=fis.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                os.close();
                System.out.println("--- 传输完成 ---\n");
            } else {
                // 如果文件不存在 返回404 not found 页面
                System.out.println("--- 文件不存在 发送404页面 ---\n");
                String ep = "E:\\桌面\\testwhat\\learnforJavaWeb-master\\01_html_css\\html\\9.列表.html";
                FileInputStream fis = new FileInputStream(ep);
                os.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                os.write(new String("Content-Type: text/html\r\n").getBytes());
                os.write(new String("Content-Length: 300\r\n").getBytes());
                os.write(new String("Accept-Ranges: bytes\r\n").getBytes());
                os.write(new String("Connection: close\r\n\r\n").getBytes());
                byte[] buf = new byte[1024];
                int len;
                while((len=fis.read(buf)) != -1) {
                    os.write(buf, 0, len);
                }
                os.close();
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(801);
        ExecutorService pool = Executors.newCachedThreadPool();
        // localhost:54321
        // localhost:54321/imgs/1.jpg
        // localhost:54321/texts/1.txt
        // localhost:54321/htmls/1.html
        // localhost:54321/htmls/1.html?name=123&number=456
        // localhost:54321/imgs/12345.html	// not found url
        while(true) {
            Socket socket = server.accept();
            Socket_Http st = new Socket_Http(socket);
            pool.submit(st);
        }
    }

}
