package Exception.main;

import Exception.exception.ExceptionFacultyWithoutGroup;

import java.util.ArrayList;

public class Faculty {
    private String nameFaculty;
    private ArrayList<Group> facultyList;
    private double averageMarkOnSomeSubjectOnFaculty;

    public Faculty(String nameFaculty, ArrayList<Group> facultyList) throws ExceptionFacultyWithoutGroup {
        if (facultyList.isEmpty())
            throw new ExceptionFacultyWithoutGroup("The faculty " + nameFaculty + " without group.");
        this.facultyList = facultyList;
        this.nameFaculty = nameFaculty;
    }

    public void averageMarkOnSubjectOnFaculty(Subject subject) {
        averageMarkOnSomeSubjectOnFaculty = getFacultyList().stream()
                .flatMap(group -> group.getStudentsInGroup().stream())
                .filter(student -> student.getRating().containsKey(subject))
                .mapToInt(student -> student.getRating().get(subject))
                .average()
                .orElse(0.0);

        if (averageMarkOnSomeSubjectOnFaculty == 0)
            System.out.println("There are no students on the faculty " + getNameFaculty() +
                    " which learning " + subject + ".");
        else System.out.println("On the faculty " + getNameFaculty() + " in the subject " + subject +
                " average mark " + averageMarkOnSomeSubjectOnFaculty);
    }

    public String getNameFaculty() {
        return nameFaculty;
    }

    public ArrayList<Group> getFacultyList() {
        return facultyList;
    }


}

