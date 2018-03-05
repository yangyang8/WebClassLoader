package www.hailong.classload;

/**
 * 下面的这些类是我用来进行操作我们的java的类加载机制的一些测试的操作的
 */
public class MyClassLoader {
    /**
     * psvm会自动写出我们的main的方法
     * sout会把我们的输出打印语句给写出来
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //System.out.println();
        //System.out.println("args = [" + args + "]");
        MyCoustomClassLoader m=new MyCoustomClassLoader();
        Class clz=m.loadClass("ClassLoaderDemo");
        System.out.println(clz.getClassLoader());
        System.out.println(clz.getClassLoader().getParent());
        //执行构造方法
        Object obj= clz.newInstance();
        ClassLoaderDemo obj1=new ClassLoaderDemo();
        //不同人类加载器进行加载人对象就否相同
        System.out.println(obj==obj1);
    }

}
