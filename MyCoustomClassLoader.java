package www.hailong.classload;


import java.io.*;

public class MyCoustomClassLoader extends ClassLoader {
    /**
     * 重要这个类加载方法
     * @param name 这个类名就我们字节码类名
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //创建一个文件
        //File ClassName=new File(name);
        //String absClassName= ClassName.getAbsolutePath();
        //指定我们从哪里去加载我们字节码文件
        //FileInputStream fis = new FileInputStream(absClassName);
        ByteArrayOutputStream bos=null;
        try {
            InputStream fin=new FileInputStream("E:\\IntelliJ_IDEA_install_path\\WebClassLoader\\out\\production\\ClassLoaderDemo\\www\\hailong\\classload\\"+name+".class");
            //进行读取字码文件
            bos=new ByteArrayOutputStream();
            int ch=0;
            while((ch=fin.read())!=-1){
                bos.write(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
           // System.out.println();
        }
        byte b[]=bos.toByteArray();
        //进行把二进行制转换Class文件
        return super.defineClass("www.hailong.classload."+name,b,0,b.length,null);
    }

    //v如果想要破坏双亲类类加载机制人话，那么则就实现怕个类加载方法，类加载方法双亲加载方法如下
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return super.loadClass(name, resolve);
    }
}
