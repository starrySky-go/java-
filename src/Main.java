import java.io.*;

public class Main {

    public void show(String[] s){
        for(int i = 0 ;i < s.length; i ++){
            System.out.println(s[i]);
        }
    }
    public String getPathName(String s){
        return "C:\\Users\\陈佳展\\Desktop\\"+s+".txt";
    }
    public static void main(String[] args) {
        String s = "first";
        String pathname = new Main().getPathName(s);
        File file = new File(pathname);
        String s1 = file.getName();
        System.out.println(s1);
        Procedure procedure = new Procedure(file);
        //procedure.Tofile();
        procedure.load();
    }
}

