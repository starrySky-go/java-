import javax.swing.*;

public class Menu extends JMenu {
    public Menu(){
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
    }
}
