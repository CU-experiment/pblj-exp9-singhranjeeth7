public class Student {
    private Course course;

    // Constructor injection
    public Student(Course course) {
        this.course = course;
    }

    public void displayDetails() {
        System.out.println("Student is enrolled in " + course.getCourseName());
    }
}