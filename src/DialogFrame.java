import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.LineBreakMeasurer;
import java.io.File;
import java.util.Arrays;

/**
 * @author chenjiazhan
 * 这个类的作用其实也不大，就是在打开文件是弹出一个小小的对话框，对对话框里面
 * 的内容进行读取，就是这样子的。。。。
 * 每一个类都有图形界面这个对象
 */
public class DialogFrame extends Dialog {
    private OutFrame outFrame = null;
    private Procedure procedure = null;
    private File file;
    private JTextField className;
    private JTextField courseName;
    private JButton sure = null;
    private JButton cancel = null;
    private String string;
    public DialogFrame(Frame owner, String title, boolean modal, OutFrame outFrame,String string) {
        super(owner, title, modal);
        this.outFrame = outFrame;
        this.string = string;
        /**
         * 创建两个按钮，对对话框里面的数据是否读取进行选择，打开这个对话框之后
         * 必须进行选择
         */
        sure = new JButton("确定");
        cancel = new JButton("取消");
        JPanel buttonJpanel = new JPanel(new GridLayout(1,2));
        buttonJpanel.add(sure);
        buttonJpanel.add(cancel);
        this.add(buttonJpanel,BorderLayout.SOUTH);

        //在这里创建画板，并且使用绝对位置进行定位，没有使用其他的布局管理器，我觉得有
        //一个布局管理器是挺好的，可是我不懂得怎么用
        JPanel textJpanel = new JPanel(null);


        JLabel classLabel = new JLabel("班级名称");
        classLabel.setFont(new Font("Bold",Font.BOLD,15));
        className = new JTextField(20);
        classLabel.setBounds(2,2,80,23);
        className.setBounds(82,3,150,23);

        JLabel courseLabel = new JLabel("课程名称");
        courseLabel.setFont(new Font("Bold",Font.BOLD,15));
        courseName = new JTextField(15);
        courseLabel.setBounds(2,26,80,23);
        courseName.setBounds(82,26,150,23);

        textJpanel.add(classLabel);
        textJpanel.add(className);
        textJpanel.add(courseLabel);
        textJpanel.add(courseName);
        this.add(textJpanel,BorderLayout.CENTER);

        //创建监视器,对两个按钮进行监听
        sure.addActionListener(e->{
            String str;
            str = className.getText()+courseName.getText();
            String pathname =this.getPathName(str);
            file = new File(pathname);
            procedure = new Procedure(file);
            if(string == "对象"){

            }
            else if(string == "文本"){
                procedure.fileToRam();
            }
            Object[][] c = procedure.toArray();
            //对数组a排序
            float[] a = procedure.toFloatArray();
            Arrays.sort(a);
            outFrame.showGrade(c);
            outFrame.showToUI(a);
            String msg = String.format("文件读取%s", "成功");
            JOptionPane.showMessageDialog(outFrame, msg);
            this.dispose();
        });
        //暂时让这个东西看不见就是setVisible(false)，写好之后再来更改；
        cancel.addActionListener(e->{
            this.dispose();
        });
        /**
         * 是不是这样呢，不是很清楚，但是试一下吧
         */
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension dimension = kit.getScreenSize();
        int width = dimension.width;
        int height = dimension.height;

        this.setLocation(width/3,height/3);
        this.setSize(280,120);
        this.setVisible(true);
    }
    public String getPathName(String s){
        return "C:\\Users\\陈佳展\\Desktop\\"+s+".txt";
    }
    @Override
    public String getName(){
        return className.getText()+"-"+courseName.getText();
    }
    public void setName(String str,String string){
        className.setText(str);
        courseName.setText(string);
    }

    /**
     * 这个方法是修改sure的监视器，无他，不过要好无聊，会不会呢，我在想什么呢？我在想什么呢？哎
     * @param a
     */
    public void setListener(ActionListener a){
        sure.addActionListener(a);
    }

    public File getFile(){
        return this.file;
    }

    public static void main(String[] args){
       JFrame jFrame = new JFrame();
      // DialogFrame dialogFrame = new DialogFrame(jFrame,"try",true);
       //jFrame.add(dialogFrame,BorderLayout.CENTER);
       //.setSize(400,500);
       jFrame.setVisible(true);
       jFrame.addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
       });
    }

}
