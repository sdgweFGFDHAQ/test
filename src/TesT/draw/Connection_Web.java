package TesT.draw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Connection_Web {
    public Connection_Web(){

    }
    public void CW(){
        JFrame jFrame=new JFrame();
        JButton jButton=new JButton();
        jButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(){
                    @Override
                    public void run() {
                        super.run();
                        String open_cmd="cmd.exe /c start";
                        String url_file="\"F:\\360brown\\360Chrome\\Chrome\\Application\\360chrome.exe\" E:\\桌面\\testwhat\\learnforJavaWeb-master\\01_html_css\\hello.html";
                        try {
                            //执行操作
                            Runtime.getRuntime().exec(open_cmd + url_file);
                        } catch (IOException e) {
                            //打印异常
                            e.printStackTrace();
                        }

                    }
                }.start();
            }
        });

        jButton.setSize(100,100);
        jFrame.getContentPane().add(jButton);
        jFrame.setAlwaysOnTop(true);
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.setSize(200,200);
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        new Connection_Web().CW();
    }
}
