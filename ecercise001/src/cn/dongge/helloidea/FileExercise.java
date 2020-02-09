package cn.dongge.helloidea;

import java.io.File;
import java.io.IOException;

public class FileExercise {
    public static void main(String[] args) {
        testDelete();
    }

    public static void fileSeparator(){
        // 路径分隔符，Windows是分号“;”，Linux上是冒号“:”
        String pathSeparator= File.pathSeparator;
        System.out.println("separator_"+pathSeparator);

        //文件分隔符，Windows上是反斜杠“\”，linux上是斜杠“/”
        String separator=File.separator;
        System.out.println("separator_"+separator);
    }
    public static void testFile1(){
        String path="C:\\java\\test.txt";
        path=path.replaceAll("\\\\",File.separatorChar+""+File.separatorChar);
        File file=new File(path);
        show(file);
    }

    public static void testFile2(){
        String path="C:\\java";
        String fileName="test.txt";
        path=path.replaceAll("\\\\",File.separatorChar+""+File.separatorChar);
        File file=new File(path,fileName);
        show(file);
    }

    public static void testFile3(){
        String fileName="test.txt";
        File file=new File(fileName);
        show(file);
    }

    public static void testFile4(){
        String path="E:\\ideacode\\out\\production\\ecercise001\\cn\\dongge\\helloidea";
        path=path.replaceAll("\\\\",File.separator+File.separator);
        String fileName="FileExercise.class";
        File file1=new File(path);
        System.out.println("目录大小："+file1.length());
        File file2=new File(path,fileName);
        System.out.println("文件大小："+file2.length());

    }

    public static void show(File file){
        //toString方法调用的就是getPath方法
        System.out.println(file);
        //获取的就是构造方法里填写的路径
        System.out.println(file.getPath());
        //无论构造方法里填的是相对的还是绝对路径，这里都显示绝对路径
        System.out.println(file.getAbsolutePath());
    }

    public static void testCreateDriretAndFile(){
        String path="ecercise001\\src\\cn\\dongge\\helloidea\\file\\source";
        File file=new File(path,"test.txt");
        File fileParent=file.getParentFile();
        if(!fileParent.exists()){
            boolean mked=fileParent.mkdirs();
            System.out.println("make director:"+mked);
        }
        try{
            file.createNewFile();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void testDelete(){
        String path="file";
        File file=new File(path);
        boolean del=file.delete();
        System.out.println("删除文件："+del);
    }
}
