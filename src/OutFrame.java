import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Objects;
/**
 * @author chenjiazhan
 */
public class OutFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 700;
    private JPanel left;
    private JTextField maxGrade;
    private JTextField minGrade;
    private JTextField aveGrade;
    private JTextField excellentField;
    private JTextField excellentPerFIeld;
    private JTextField goodField ;
    private JTextField goodPerFIeld;
    private JTextField middleField;
    private JTextField middlePerFIeld;
    private JTextField passField;
    private JTextField passPerFIeld;
    private JTextField failField;
    private JTextField failPerFIeld;
    private JTextField search;
    JTable jTable = null;
    JScrollPane scoll = null;
    public OutFrame(){
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setTitle("成绩分析程序");
        Dimension c = this.getContentPane().getSize();
        this.setSize(new Dimension(DEFAULT_WIDTH,DEFAULT_HEIGHT));
        //this.getContentPane().setBackground(Color.gray);
        this.setResizable(false);
        this.setLayout(null);

        /**
         * add a fileMenu
         */
        JMenu file= new JMenu("文件");
        JMenuItem open = new JMenuItem("打开文本文件成绩单");
        JMenuItem saveAsText = new JMenuItem("另存文本文件成绩单");
        JMenuItem openObject = new JMenuItem("打开对象文件成绩单");
        JMenuItem SavaAsObject = new JMenuItem("另存为对象文件成绩单");
        JMenuItem clear = new JMenuItem("清除数据");
        file.add(open);
        file.add(saveAsText);
        file.addSeparator();
        file.add(openObject);
        file.add(SavaAsObject);
        file.addSeparator();
        file.add(clear);
        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(file);
        setJMenuBar(jMenuBar);


        /**
         * 加一个查询框
         */
        this.setLayout(null);
        search = new JTextField(20);
        search.setBounds(5,0,200,25);
        add(search);
        JButton searchButton = new JButton("查询");
        searchButton.setBounds(208,0,100,25);
        this.add(searchButton);


        /**
         * 为菜单栏里面的按钮增加监听器
         */
        //在这里文件打开，在监视器里面进行创建Procedure对文件进行处理
        //在里面对文件进行处理
        //File file1  = new File("C:\\Users\\陈佳展\\Desktop\\first.txt");
        MenuAction menuAction = new MenuAction(this);
        open.addActionListener(menuAction);
        saveAsText.addActionListener(menuAction);
        clear.addActionListener(menuAction);
        SavaAsObject.addActionListener(menuAction);
        openObject.addActionListener(menuAction);
        //为查询增加了一个查询监视器，如果真的查询了，要怎么办呢
        searchButton.addActionListener(menuAction);

        /**
         * 在文本框下面加一个大大的JPanel,然后再在Jpanel中加两个小小的JPanel了
         */
        JPanel down = new JPanel();
        down.setLayout(null);
        down.setSize(700,700);
        down.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.gray));
        down.setBounds(0,25,900,700);
        this.add(down);
        JLayeredPane downLayeredPane = new JDesktopPane();//不知道这是一个怎么样的东西

        /**
         * 再加两个JLable在其中.加两个标签
         */
        JLabel gradeItem = new JLabel("成绩单");
        gradeItem.setFont(new Font("Bold",Font.BOLD,15));
        JLabel date = new JLabel("数据分析");
        date.setFont(new Font("Bold",Font.BOLD,15));
        gradeItem.setBounds(5,0,75,50);
        date.setBounds(410,0,75,50);
        down.add(gradeItem);
        down.add(date);

        /**
         * 接下来加两个Jpanel了，用来放东西
         */

        /**
         * 在这里加的left主要是用来显示成绩单的，就是这样，不爽啊，打我呀
         */
        left = new JPanel();


        JPanel right = new JPanel();
        right.setLayout(null);
        left.setBorder(BorderFactory.createLineBorder(Color.gray,2,true));
        left.setBackground(new Color(208, 208, 208));
        left.setBounds(5,40,400,550);
        right.setBorder(BorderFactory.createLineBorder(Color.gray,2,true));
        right.setBackground(new Color(208, 208, 208));
        right.setBounds(410,40,370,550);
        down.add(left);
        down.add(right);
        /**
         * 这里是要在left里面加一写东西的，加一个Jtable，但是现在我想要写概率论作业了，今天
         * 要把第二章的全部搞定，就是这样，下次再见。
         */
        JTable table = new JTable();
        JScrollPane scoll = new JScrollPane(table);
        add(scoll);
        left.add(table);

        /**
         * 接下来在Right里面添加一些元素
         */
        JLabel max = new JLabel("最高分");
        maxGrade = new JTextField(10);
        max.setBounds(10,10,50,40);
        max.setFont(new Font("Bold",Font.BOLD,12));
        maxGrade.setBounds(120,18,100,25);


        JLabel min = new JLabel("最低分");
        minGrade = new JTextField(10);
        min.setBounds(10,60,50,40);
        min.setFont(new Font("Bold",Font.BOLD,12));
        minGrade.setBounds(120,68,100,25);

        JLabel aver = new JLabel("平均分");
        aveGrade = new JTextField(10);
        aver.setBounds(10,110,50,40);
        aver.setFont(new Font("Bold",Font.BOLD,12));
        aveGrade.setBounds(120,118,100,25);


        JLabel excellent = new JLabel("优秀(90-100)");
        JLabel exceCoroprtion = new JLabel("人,占");
        JLabel excellentPercent = new JLabel("%");
        excellentField = new JTextField(10);
        excellentPerFIeld = new JTextField(5);
        setFont(new Font("Bold",Font.BOLD,12));
        excellent.setBounds(10,170,70,40);
        excellentField.setBounds(120,180,100,25);
        exceCoroprtion.setBounds(225,180,50,25);
        excellentPerFIeld.setBounds(265,180,50,25);
        excellentPercent.setBounds(325,180,35,25);

        right.add(excellent);
        right.add(excellentField);
        right.add(exceCoroprtion);
        right.add(excellentPerFIeld);
        right.add(excellentPercent);



        JLabel good = new JLabel("良好(80-89)");
        JLabel goodCorportion = new JLabel("人,占");
        JLabel goodPercent = new JLabel("%");
        setFont(new Font("Bold",Font.BOLD,12));
        goodField = new JTextField(10);
        goodPerFIeld = new JTextField(5);
        good.setBounds(10,225,70,40);
        goodField.setBounds(120,235,100,25);
        goodCorportion.setBounds(225,235,50,25);
        goodPerFIeld.setBounds(265,235,50,25);
        goodPercent.setBounds(325,235,35,25);

        right.add(good);
        right.add(goodCorportion);
        right.add(goodPercent);
        right.add(goodPerFIeld);
        right.add(goodField);



        JLabel middle = new JLabel("中等(70-79)");
        JLabel midCorportion = new JLabel("人占");
        JLabel middlePercent = new JLabel("%");
        middleField = new JTextField(10);
        middlePerFIeld = new JTextField(5);
        middle.setBounds(10,280,70,40);
        middleField.setBounds(120,290,100,25);
        midCorportion.setBounds(225,290,50,25);
        middlePerFIeld.setBounds(265,290,50,25);
        middlePercent.setBounds(325,290,35,25);
        right.add(middle);
        right.add(midCorportion);
        right.add(middleField);
        right.add(middlePerFIeld);
        right.add(middlePercent);


        JLabel pass = new JLabel("及格(60-69)");
        JLabel passCorportion = new JLabel("人,占");
        JLabel passPercent = new JLabel("%");
        passField = new JTextField(10);
        passPerFIeld = new JTextField(5);
        pass.setBounds(10,335,70,40);
        passField.setBounds(120,345,100,25);
        passCorportion.setBounds(225,345,50,25);
        passPerFIeld.setBounds(265,345,50,25);
        passPercent.setBounds(325,345,35,25);
        right.add(pass);
        right.add(passCorportion);
        right.add(passField);
        right.add(passPercent);
        right.add(passPerFIeld);


        JLabel fail = new JLabel("不及格(0-59)");
        JLabel failCorportion = new JLabel("人,占");
        JLabel failPercent = new JLabel("%");
        failField = new JTextField(10);
        failPerFIeld = new JTextField(5);
        fail.setBounds(10,390,70,40);
        failField.setBounds(120,400,100,25);
        failCorportion.setBounds(225,400,50,25);
        failPerFIeld.setBounds(265,400,50,25);
        failPercent.setBounds(325,400,35,25);
        right.add(fail);
        right.add(failCorportion);
        right.add(failField);
        right.add(failPerFIeld);
        right.add(failPercent);

        JButton first = new JButton("显示柱形分析图");
        JButton second = new JButton("显示饼形分析图");
        first.setBounds(10,465,125,25);
        second.setBounds(160,465,125,25);
        right.add(first);
        right.add(second);

        /**
         * 把上面那些按钮全部放进去
         */
        right.add(max);
        right.add(maxGrade);
        right.add(min);
        right.add(minGrade);
        right.add(aver);
        right.add(aveGrade);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);
    }


    public String getSearch(){
        return search.getText();
    }
    /**
     * 在left_Jpanel里面显示东西的，这个没问题
     * @param c
     */
    public  void showGrade(Object[][] c){

        Object[] columTitle = {"学号","姓名","成绩"};
        System.out.println("显示文件信息");
        for(int i = 0 ; i < c.length; i ++){
            for(int j = 0 ; j < c[i].length; j++){
                System.out.print(c[i][j]);
            }
        }
        check(scoll);
        jTable = new JTable(c,columTitle);
        scoll = new JScrollPane(jTable);
        Toolkit kit = left.getToolkit();
        scoll.setBounds(0,0,400,550);
        left.add(scoll);
        //jTable.setVisible(true);
    }
    private void check(JScrollPane jScrollPane){
        if(jScrollPane != null){
            jScrollPane.setVisible(false);
        }
    }
    public  void showToUI(float[] c){
        float excellPer = 0;
        float goodPer = 0;
        float midPer = 0;
        float passPer = 0;
        float failPer = 0;
        float max = 0,min = 0,per = 0,total = 0;
        int length = c.length;
        max = c[length-1];
        min = c[0];
        for(int i = 0 ; i < length ; i ++){
            total += c[i];
            int t = checkLevel(c[i]);
            switch(t){
                case 1: excellPer += 1;break;
                case 2:goodPer += 1;  break;
                case 3: midPer += 1;break;
                case 4:  passPer += 1;break;
                case 5 : failPer += 1;break;
                default:break;
            }
        }
        per = total/length;
        maxGrade.setText(Objects.toString(max));
        minGrade.setText(Objects.toString(min));
        aveGrade.setText(Objects.toString(per));
        goodField.setText(Objects.toString((int)goodPer));
        goodPerFIeld.setText(Objects.toString((goodPer/length)*100));
        excellentField.setText(Objects.toString((int)excellPer));
        excellentPerFIeld.setText(Objects.toString((excellPer/length)*100));
        middleField.setText(Objects.toString((int)midPer));
        middlePerFIeld.setText(Objects.toString((midPer/length)*100));
        passField.setText(Objects.toString((int)passPer));
        passPerFIeld.setText(Objects.toString((passPer/length)*100));
        failField.setText(Objects.toString((int)failPer));
        failPerFIeld.setText(Objects.toString((failPer/length)*100));


    }
    private int checkLevel(float grade) {
        if (grade > 100 || grade < 0) {
            throw new IllegalStateException();
        }
        if (grade >= 90) {
            return 1;
        } else if (grade >= 80 && grade < 90) {
            return 2;
        } else if (grade >= 70 && grade < 80) {
            return 3;
        } else if (grade >= 60 && grade < 70) {
            return 4;
        } else {
            return 5;
        }
    }
    public static void main(String[] args){
        new OutFrame();
    }
}
