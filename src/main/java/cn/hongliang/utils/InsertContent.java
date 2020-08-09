package cn.hongliang.utils;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * @author Hongliang Zhu
 * @create 2020-08-09 16:53

 * 使用RandomAccessFile实现在指定文件的指定位置插入指定的内容
 */


public class InsertContent {
    private String filePath; //要操作的文件的路径
    private String content;    //要插入的内容

    //构造方法
    public InsertContent(String path, String con) {
        filePath = path;
        content = con;
    }
    //设置要操作的文件的路径
    public void setFilePath(String path) {
        filePath = path;
    }
    //设置要插入文件的内容
    public void setContent(String con) {
        content = con;
    }

    //插入内容的具体实现方法
    public void insertCon(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(filePath, "rw"); //将随机存取文件流连接到文件，访问方式设置为可读可写
            long length = raf.length();
            raf.seek(length-1); //指定插入的位置
            //***************先将插入点后面的内容保存起来****************
            StringBuffer sb = new StringBuffer();
            byte[] b = new byte[1024];
            int len;
            while( (len=raf.read(b)) != -1 ) {
                sb.append( new String(b, 0, len) );
            }
            raf.seek(length-1); //重新设置插入位置
            raf.write( content.getBytes() ); //插入指定内容
            raf.write( sb.toString().getBytes() ); //恢复插入点后面的内容

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //关闭随机存取文件流
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
