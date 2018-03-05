package www.hailong.classload;

/**
 * 具体的classload的测试的方法如下
 */
public class ClassLoaderDemo {

    static {
        System.out.println("执行静态代码块:"+System.currentTimeMillis());
    }

    public ClassLoaderDemo() {
        System.out.println("ClassLoader执行吧");
    }

    private String value="tomcat3";

    public String getValue() {
        return value;
    }


}
