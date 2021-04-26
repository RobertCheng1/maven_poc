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
     * 仅仅是 Web开发--Servlet入门：
     * JavaEE并不是一个软件产品，它更多的是一种软件架构和设计思想。
     * 我们可以把JavaEE看作是在JavaSE的基础上，开发的一系列基于服务器的组件、API标准和通用架构。
     * JavaEE最核心的组件就是基于Servlet标准的Web服务器，开发者编写的应用程序是基于Servlet API并运行在Web服务器内部的：
     *      ┌─────────────┐
     *      │┌───────────┐│
     *      ││ User App  ││
     *      │├───────────┤│
     *      ││Servlet API││
     *      │└───────────┘│
     *      │ Web Server  │
     *      ├─────────────┤
     *      │   JavaSE    │
     *      └─────────────┘
     * 目前流行的基于Spring的轻量级JavaEE开发架构，使用最广泛的是Servlet和JMS，以及一系列开源组件。
     *
     * Maven 的 pom 文件：
     * <scope>指定为provided，表示编译时使用，但不会打包到.war文件中，因为运行期Web服务器本身已经提供了Servlet API相关的jar包。
     * 注意到这个 pom.xml与前面我们讲到的普通Java程序有个区别，打包类型不是jar，而是war，表示Java Web Application Archive
     * 我们应该如何运行这个war文件？
     * 普通的Java程序是通过启动JVM，然后执行main()方法开始运行。但是Web应用程序有所不同，我们无法直接运行war文件，
     * 必须先启动Web服务器，再由Web服务器加载我们编写的 HelloServlet，这样就可以让HelloServlet处理浏览器发送的请求。
     *
     * 首先要下载Tomcat服务器，解压后，把 mavenpoc.war复制到Tomcat的webapps目录下，然后切换到 bin目录，
     * 执行startup.sh或startup.bat启动Tomcat服务器：
     * 浏览器里请求： http://localhost:8080/mavenpoc/
     * 
     * 细心的童鞋可能会问，为啥路径是/mavenpoc/ 而不是/？
     * 因为一个Web服务器允许同时运行多个Web App，而我们的Web App叫 mavenpoc (在 pom.xml 中指定的 finalName 为 mavenpoc)
     * 因此，第一级目录/mavenpoc 表示Web App的名字， 后面的 / 才是我们在HelloServlet中映射的路径。
     * 实际上，类似Tomcat这样的服务器也是Java编写的，启动Tomcat服务器实际上是启动Java虚拟机，执行Tomcat的main()方法，
     * 然后由Tomcat负责加载我们的.war文件，并创建一个HelloServlet实例，最后以多线程的模式来处理HTTP请求。
     * 如果Tomcat服务器收到的请求路径是 /（假定部署文件为ROOT.war），就转发到HelloServlet并传入 HttpServletRequest和 HttpServletResponse两个对象。
     * 因为我们编写的Servlet并不是直接运行，而是由Web服务器加载后创建实例运行，所以，类似Tomcat这样的Web服务器也称为Servlet容器。===术语===
     * 在Servlet容器中运行的Servlet具有如下特点：
     *      1.无法在代码中直接通过new创建Servlet实例，必须由Servlet容器自动创建Servlet实例；===联想反射中提到的Class的实例只能由JVM创建===
     *      2.Servlet容器只会给每个Servlet类创建唯一实例；
     *      3.Servlet容器会使用多线程执行doGet()或doPost()方法。
     * 复习一下 Java 多线程的内容，我们可以得出结论：
     *      1.在 Servlet 中定义的实例变量会被多个线程同时访问，要注意线程安全；
     *      2.HttpServletRequest和 HttpServletResponse实例是由 Servlet 容器传入的局部变量，它们只能被当前线程访问，不存在多个线程访问的问题；
     *      3.在doGet()或doPost()方法中，如果使用了ThreadLocal，但没有清理，那么它的状态很可能会影响到下次的某个请求，因为Servlet容器很可能用线程池实现线程复用。
     * 因此，正确编写Servlet，要清晰理解Java的多线程模型，需要同步访问的必须同步。 from: Web开发--Servlet入门
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