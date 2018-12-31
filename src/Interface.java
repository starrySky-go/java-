import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.jar.JarEntry;

/**
 * @author chenjiazhan
 */
public class Interface extends JFrame {
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 700;
    private JPanel left;
    private JPanel right;
    public Interface(){
        //将布局管理器改变为gridBaglayouts
        setBackground(Color.gray);
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        //add menu
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

        this.setLayout(null);

        JTextField search = new JTextField(20);
        search.setBounds(8,0,200,30);
        add(search);
        JButton searchButton = new JButton("查询");
        searchButton.setBounds(208,0,100,30);
        this.add(searchButton);



        JPanel upRight = new JPanel();
        upRight.setLayout(null);
        JLabel first = new JLabel("成绩单");
        JLabel second = new JLabel("数据分析");
        upRight.setLayout(null);
        first.setBounds(0,0,100,50);
        second.setBounds(300,0,100,50);
        upRight.add(first);
        upRight.add(second);


        this.add(upRight,BorderLayout.NORTH);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args){
        new Interface();
    }
}
