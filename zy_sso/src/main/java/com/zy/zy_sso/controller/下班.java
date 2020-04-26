package com.zy.zy_sso.controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * @program: SpringCloud
 * @description: 下班
 * @author: zhang yi
 * @create: 2019-10-29 15:11
 */
public class 下班  extends JFrame{
    {
        try {
            Dimension   screensize   =   Toolkit.getDefaultToolkit().getScreenSize();
            int width = (int)screensize.getWidth();
            //int height = (int)screensize.getHeight();
            this.setBounds(width/2-300,0,580,30);

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            this.setTitle("下班倒计时程序");
            this.setType(JFrame.Type.UTILITY);
            this.setUndecorated(true);
            this.setOpacity(0.6f);
            this.setResizable(false);
            //this.setAlwaysOnTop(true);
            this.setFocusable(false);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE); //设置关闭方式 如果不设置的话 似乎关闭窗口之后不会退出程序
            JPanel jPanel = new JPanel();//得到窗口的容器
            jPanel.setLayout(null);
            jPanel.setSize(650,30);
            JLabel l1 = new JLabel();    //创建一个标签 并设置初始内容
            l1.setForeground(Color.blue);
            Font font = new Font(null, Font.BOLD, 30);
            l1.setFont(font);
            l1.setBounds(15,0,580,30);
            JButton b1 = new JButton("×");
            b1.setBounds(580,0,50,30);
            b1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.exit(-1);
                }
            });
            jPanel.add(l1);
            jPanel.add(b1);
            this.add(jPanel);
            this.setVisible(true);//设置窗口可见



            Calendar 日历 = Calendar.getInstance();
            日历.set(Calendar.HOUR_OF_DAY, 17);
            日历.set(Calendar.MINUTE, 30);
            日历.set(Calendar.SECOND, 0);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String 下班时间 = sdf.format(日历.getTime());
            SimpleDateFormat 格式化 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date 下班时间新格式 = 格式化.parse(下班时间);
            while (true) {
                Thread.sleep(1000);
                Date 当前时间 = new Date();
                long 相差的时间 = (下班时间新格式.getTime() - 当前时间.getTime()) / 1000;
                if (相差的时间 > 0) {
                    long 时 = 相差的时间 / 60 / 60;
                    long 分 = (相差的时间 - 时 * 60 * 60) / 60;
                    long 秒 = 相差的时间 - 时 * 60 * 60 - 分 * 60;
                    //会打印出相差3秒
                    l1.setText("下班倒计时: " + 时 + "时" + 分 + "分" + 秒 + "秒" + "  共计" + 相差的时间 + "秒");
                    //System.out.println("倒计时:" + 时 + "时" + 分 + "分" + 秒 + "秒。" + "离下班还差" + 相差的时间 + "秒");

                }else {
                    Runtime.getRuntime().exec("cmd.exe /C start shutdown -s -t 20");
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        new 下班();
//        Runtime.getRuntime().exec("cmd.exe /C start shutdown -s -t 1000");
    }
}
