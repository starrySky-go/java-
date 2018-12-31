import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuAction implements ActionListener {
    private Procedure procedure = null;
    private OutFrame outFrame = null;
    private DialogFrame dialogFrame = null;
    public MenuAction( OutFrame outFrame){
        this.outFrame = outFrame;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String str = e.getActionCommand();
        operator(str);
    }
    private void operator(String str){
        FileGen fileGen = new FileGen();
        if(str == "打开文本文件成绩单"){
             dialogFrame = new DialogFrame(outFrame,"文件名",true,outFrame,"文本");
            File file = dialogFrame.getFile();
            //为什么要这个东西，其实只是为了查询功能罢了，我这个代码已经太烂了，改不回来了。
            if(file.isFile())
            {
                //让这个新建的Produrce重新存储有东西罢了
                procedure = new Procedure(file);
                procedure.fileToRam();
            }
            outFrame.add(dialogFrame);
        }
        else if(str == "另存文本文件成绩单"){


        }else if(str == "打开对象文件成绩单"){
            dialogFrame = new DialogFrame(outFrame,"文件名",true,outFrame,"对象");
            File file = dialogFrame.getFile();
            if(file.isFile()){
                procedure = new Procedure(file);
                procedure.serToRam();
            }
        }
        else if(str == "另存为对象文件成绩单"){
            String name = dialogFrame.getName();
            System.out.println(name);
            FileOutputStream f = fileGen.generator(name,".score");
            procedure.toSeri(f);
            String msg = String.format("对象文件成绩单,%s","已经另存");
            JOptionPane.showMessageDialog(outFrame, msg);
        }
        else if(str == "清除数据"){

        }
        else if(str == "查询") {
            String st = outFrame.getSearch();
            char[] c = st.toCharArray();
            Object[][] objects = procedure.toArray();
            System.out.println("查询测试");
            process(c,objects,st);
            //float[] a = procedure.toFloatArray();
           // Arrays.sort(a);
           // outFrame.showToUI(a);
        }
    }
    private boolean isDig(char[] c){
        if(c[0]>='0' && c[0] <= '9'){
            return true;
        }else{
            return false;
        }
    }


    /**
     * 进行查询的方法
     * @param c
     * @param objects
     * @param st
     */
    private void process(char[] c,Object[][] objects,String st){
        ArrayList<Student> arrayList = null;
        float[] a = new float[objects.length];
        if (isDig(c)){
           arrayList = getResult(st,0,objects);
        }
        else{
           arrayList = getResult(st,1,objects);
        }
        Object[][] objects1 = new Object[arrayList.size()][3];
        for(int i = 0 ; i < objects1.length ; i ++){
            objects1[i][0] = arrayList.get(i).getId();
            objects1[i][1] = arrayList.get(i).getName();
            objects1[i][2] = arrayList.get(i).getGrade();
        }
        outFrame.showGrade(objects1);
    }
    /**
     * 返回一个ArrayList数组
     * @param str
     * @param choise
     * @param all
     * @return
     */
    private ArrayList<Student> getResult(String str,int choise,Object[][] all){
        Pattern pattern =Pattern.compile(str);
        ArrayList<Student> arrayList = new ArrayList<>();
        for(int i = 0 ; i < all.length ; i ++){
            Matcher matcher = pattern.matcher((String)all[i][choise]);
            if(matcher.find()){
                Student student = new Student((String)all[i][0],(String)all[i][1],(float)all[i][2]);
                arrayList.add(student);
            }
        }
        return arrayList;
    }
    public static void main(String[] args){
        OutFrame outFrame = new OutFrame();
        MenuAction menuAction = new MenuAction(outFrame);
    }
}
