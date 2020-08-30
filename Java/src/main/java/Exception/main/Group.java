package Exception.main;

import Exception.exception.ExceptionGroupWithoutStudents;

import java.util.ArrayList;

public class Group {
    private String nameGroup;
    private ArrayList<Student> studentsInGroup;

    public Group(String nameGroup, ArrayList<Student> studentsInGroup) throws ExceptionGroupWithoutStudents {
        if (studentsInGroup.isEmpty()) throw new ExceptionGroupWithoutStudents("The group " + nameGroup +
                " without students.");
        else {
            this.nameGroup = nameGroup;
            this.studentsInGroup = studentsInGroup;
        }
    }

    public void printAverageMarkOnSubjectInGroup(Subject subject) {
        double averageMark = averageMarkOnSubjectInGroup(subject);
        if (averageMark == 0)
            System.out.println("There are no students in the group " + getNameGroup() +
                    " which learning " + subject + ".");
        else System.out.println("In the group " + getNameGroup() + " in the subject " + subject +
                " average mark " + averageMark + ".");
    }

    public double averageMarkOnSubjectInGroup(Subject subject) {
        return studentsInGroup.stream()
                .filter(student -> student.getRating().containsKey(subject))
                .mapToInt(student -> student.getRating().get(subject))
                .average()
                .orElse(0.0);
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public ArrayList<Student> getStudentsInGroup() {
        return studentsInGroup;
    }

}

