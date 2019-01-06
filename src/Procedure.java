import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 这个程序还是用来将元素从序列化文件中读取东西吧，不更改它了
 * handle方法，
 */
public class Procedure {
    private File file;
    private int count = 0;//计算此时文件中有多少个对象
    private ArrayList<Student> arrayList;

    /**
     * 这个是用来初始化的，就是读取文本文件里面的东西的，并不是序列化
     * 文件里面的内容
     * @param file
     */
    public Procedure(File file) {
        this.file = file;
    }

    /**
     * 将文本文件里面的内容读取到内存里面.此时ArrayList里面已经有东西了
     */
    public void fileToRam(){
            arrayList = new ArrayList<>();
            try {
                String s = null;
                FileReader fileReader = new FileReader(file);
                System.out.println("看一下这个文件名到底是怎么样的");
                System.out.println(file.getName());
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((s = bufferedReader.readLine()) != null) {
                    System.out.println(s);
                    String[] str = s.split(",");
                    for(int i = 0 ; i < str.length ; i ++){
                        System.out.println("在FileToRam里面进行测试");
                        System.out.println(str[i]);
                    }
                    System.out.println("这里面出现bug了吗+procedure.fileToRam");
                    Student student = new Student(str[0], str[1], Float.parseFloat(str[2]));
                    System.out.println(student.toString()+"在handle方法里面");
                    arrayList.add(student);
                }
                // System.out.println("the method has successed shortaging the date to the file");

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    /**
     * 这是进行了序列化，将程序里面的对象序列化到文件里面
     */
   public void toSeri(FileOutputStream fileOutputStream) {
        try {
            String s = null;
            FileReader fileReader = new FileReader(this.file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ObjectOutputStream oos =
                    new ObjectOutputStream(fileOutputStream);
            //把文件里面的所有信息进行序列化
            while ((s = bufferedReader.readLine()) != null) {
                String[] str = s.split(",");
                Student student = new Student(str[0], str[1], Integer.parseInt(str[2]));
                System.out.println(student.toString()+"在handle方法里面");
                oos.writeObject(student);
                count++;
            }
            System.out.println("the method has successed shortaging the date to the file");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this method translate the date from result.score to the ram
     * use the static method  toRam of test
     * 在加载完成后，顺便对数据进行了排序
     */
    public void load() {
        arrayList = new ArrayList<>();
        System.out.println(count);
        serToRam();
        System.out.println(count);
        System.out.println("the program has success loading date");
    }

    /**
     * 将成绩由大到小进行排序的展示
     * @param student
     */
    public  void show(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            System.out.println(student[i]);
        }
    }


    public void ramToFile(BufferedWriter file){
        BufferedWriter fileWriter = file;
        System.out.println("这个有没有运行到这里呢");
        System.out.print(arrayList.get(0).getGrade());
        try{
            for(int i = 0 ; i < arrayList.size(); i ++){
                String str = arrayList.get(i).getId()+","+arrayList.get(i).getName()+","+arrayList.get(i).getGrade()+"\n";
                System.out.println(str);
                fileWriter.write(str);
            }
            fileWriter.flush();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * 将置于文本的数据读取到该程序中来
     * 将序列化的内容重新读取到程序中来
     */
    public  void serToRam() {
        Student s = null;
        arrayList = new ArrayList<>();
        try {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(this.file));
            while((s = (Student)ois.readObject())!=null)
            {
                arrayList.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ce) {
            ce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }


    /**
     * 返回一个数组，不过这个数组是可以对里面元素进行更改的，这一点感觉不是很好啊
     * @return
     */
    public Object[][] toArray(){
        int length = arrayList.size();
        arrayList.sort((o1,o2)->{
            return (int)o2.getGrade()-(int)o1.getGrade();
        });
        System.out.println(length);
        Object[][] c = new Object[length][3];
        for(int i = 0 ; i < length; i ++){
            c[i][0] = arrayList.get(i).getId();
            c[i][1] = arrayList.get(i).getName();
            c[i][2] = arrayList.get(i).getGrade();
            System.out.println(i);
        }
        return c;
    }
    public float[] toFloatArray(){
        float[] a = new float[this.arrayList.size()];
        for(int i = 0 ; i < arrayList.size(); i ++){
            a[i] = arrayList.get(i).getGrade();
        }
        return a;
    }
    /**
     * 实现了成绩的排序
     * @param s
     * @return
     */
    private  Student[] sort(ArrayList<Student> s) {
        Student[] st = new Student[s.size()];
        Student[] students = s.toArray(st);
        Arrays.sort(students, (o1, o2) -> (int)o2.getGrade() - (int)o1.getGrade());
        return students;
    }
    public void test(){
        System.out.println("这是一个测试，让我来测一下吧，test");
        for(int i = 0 ; i < arrayList.size();i++){
            float grade = arrayList.get(i).getGrade();
            System.out.println(grade);
        }
    }
    public static void main(String[] args) {
        File file1 = new File("first-second.txt");
        Procedure procedure = new Procedure(file1);
      //  procedure.Tofile();
        procedure.load();
        Object[][] objects = procedure.toArray();
        for(int i = 0 ; i < objects.length; i ++){
            for(int j = 0 ; j < objects[i].length; j ++){
                System.out.println(objects[i][j]);
            }
        }
    }


}
