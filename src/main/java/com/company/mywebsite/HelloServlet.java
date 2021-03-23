package com.company.mywebsite;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * App entry for Maven project.
 *
 * @author liaoxuefeng
 */
// @Slf4j
// public class Main {
//
//     public static void main(String[] args) throws Exception {
//         System.out.println("In the main of mavenpoc");
//         log.info("In the main of mavenpoc");
//     }
// }


// WebServlet注解表示这是一个Servlet，并映射到地址/:
@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     *
     * 浏览器里请求： http://localhost:8080/mavenpoc/
     * 细心的童鞋可能会问，为啥路径是/hello/而不是/？
     * 因为一个Web服务器允许同时运行多个Web App，而我们的Web App叫 mavenpoc，在 pom.xml 中指定的 finalName 为 mavenpoc
     * 因此，第一级目录/mavenpoc 表示Web App的名字， 后面的 / 才是我们在HelloServlet中映射的路径。
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // 设置响应类型:
        resp.setContentType("text/html");
        // 获取输出流:
        PrintWriter pw = resp.getWriter();
        // 写入响应:
        pw.write("<h1>Hello, world!</h1>");
        // 最后不要忘记flush强制输出:
        pw.flush();
    }
}