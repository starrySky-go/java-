import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @author 陈佳展
 */
public class OpenAdapter implements ActionListener {
    private File file = null;
    private JTextField first = null;
    private JTextField second = null;
    public OpenAdapter(JTextField first,JTextField second){
        this.first = first;
        this.second = second;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public File getfile(){
        return this.file;
    }
}
