package Exception.main;

import Exception.exception.ExceptionIncorrectMark;
import Exception.exception.ExceptionStudentsWithoutSubject;

import java.util.HashMap;

public class Student {
    private HashMap<Subject, Integer> rating;
    private String name;
    private double averageMarkStudent;

    public Student(HashMap<Subject, Integer> rating, String name) throws ExceptionIncorrectMark, ExceptionStudentsWithoutSubject {
        this.rating = rating;
        this.name = name;
        if (rating.isEmpty()) {
            throw new ExceptionStudentsWithoutSubject("The student " + name + "  doesn't has any subject.");
        }

        if (rating.entrySet().stream()
                .anyMatch(s -> s.getValue() > 10 || s.getValue() < 0))
            throw new ExceptionIncorrectMark("The students " + getName() + " has incorrect mark.");
        else {
            averageMarkStudent = rating.entrySet().stream()
                    .mapToInt(student -> student.getValue())
                    .average()
                    .orElse(0.0);
        }
    }

    public String getName() {
        return name;
    }

    public HashMap<Subject, Integer> getRating() {
        return rating;
    }

    public void averageMarkStudent() {
        System.out.println("The middle mark " + this.getName() + " = " + this.averageMarkStudent + ".");
    }

}
