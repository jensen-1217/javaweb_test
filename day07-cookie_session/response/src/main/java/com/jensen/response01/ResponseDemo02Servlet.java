package com.jensen.response01;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/responseDemo02Servlet")
public class ResponseDemo02Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.创建字节输入流关联本地文件
        FileInputStream fis = new FileInputStream("D:\\Document\\Downloads\\验证码.bmp");
        //2.用response调用方法获取关联浏览器的字节输出流对象
        ServletOutputStream os = response.getOutputStream();
        //3.将数据读到内存中
        byte[] buf = new byte[1024];//保存每次读取的字节数据
        int len=0;//每次读取的字节个数
        while ((len=fis.read(buf))!=-1){
            //4.将内存中的数据写到浏览器端
            os.write(buf,0,len);
        }
        //5.释放资源
        fis.close();
    }
}
