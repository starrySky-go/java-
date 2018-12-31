import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FileGen {

    public FileOutputStream generator(String prefix,String suffic)
    {
        FileOutputStream fileOutputStream = null;
        try{
            File f1 = new File("C:\\Users\\陈佳展\\Desktop\\java课设");
            String str = prefix+suffic;
            if(ifExist(f1,str)){
                File f = new File("C:\\Users\\陈佳展\\Desktop\\java课设\\"+str);
                fileOutputStream = new FileOutputStream(f);
            }
            else{
                fileOutputStream = new FileOutputStream("C:\\Users\\陈佳展\\Desktop\\java课设\\"+prefix+suffic);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
       return fileOutputStream;
    }
    private boolean ifExist(File directory,String str){
        String[] st = directory.list();
        for(int i = 0 ; i < st.length; i ++){
           if(str.equals(st[i])){
               return true;
           }
        }
        return false;

    }
    public static void main(String[] args){
       FileOutputStream f = new FileGen().generator("second",".score");
    }
}
