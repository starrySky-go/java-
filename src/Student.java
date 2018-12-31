import java.util.Comparator;

public class Student implements Comparator<Student>,java.io.Serializable {
    private String id;
    private String name;
    private float grade;
    public  Student(String id,String name,float  grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public float getGrade() {
        return grade;
    }

    public String getId() {
        return id;
    }

    public void setGrade(float  grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[id:"+id+"][name:"+name+"][grade:"+grade+"]";
    }
    @Override
    public int compare(Student o1, Student o2) {
        return (int)o1.getGrade()-(int)o2.getGrade();
    }
}
