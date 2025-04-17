import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        // CREATE
        createStudent("John", "Doe", "john.doe@example.com");

        // READ
        Student student = readStudent(1);
        System.out.println("Read: " + student);

        // UPDATE
        updateStudentEmail(1, "new.email@example.com");

        // DELETE
        deleteStudent(1);
    }

    public static void createStudent(String first, String last, String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student(first, last, email);
        session.save(student);

        tx.commit();
        session.close();
        System.out.println("Student saved: " + student);
    }

    public static Student readStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public static void updateStudentEmail(int id, String newEmail) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            student.setEmail(newEmail);
            session.update(student);
        }

        tx.commit();
        session.close();
        System.out.println("Updated Student: " + student);
    }

    public static void deleteStudent(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
            System.out.println("Deleted Student with ID: " + id);
        }

        tx.commit();
        session.close();
    }
}