package Exception.main;

import Exception.exception.ExceptionUniversityWithoutFaculty;

import java.util.ArrayList;

public class University {
    private ArrayList<Faculty> universityList;
    private double averageMarkOnSomeSubjectInUniversity;

    public University(ArrayList<Faculty> universityList) throws ExceptionUniversityWithoutFaculty {
        if (universityList.isEmpty()) throw new ExceptionUniversityWithoutFaculty("The university without faculty.");
        this.universityList = universityList;
    }

    public void averageMarkOnSubjectOnUniversity(Subject subject) {
        averageMarkOnSomeSubjectInUniversity = getUniversityList().stream()
                .flatMap(faculty -> faculty.getFacultyList().stream())
                .flatMap(group -> group.getStudentsInGroup().stream())
                .filter(student -> student.getRating().containsKey(subject))
                .mapToInt(student -> student.getRating().get(subject))
                .average()
                .orElse(0.0);

        if (averageMarkOnSomeSubjectInUniversity == 0.0)
            System.out.println("There are no students in the university" +
                    " with learning " + subject);
        else System.out.println("On the university in the subject " + subject +
                " middle mark " + averageMarkOnSomeSubjectInUniversity);
    }

    public ArrayList<Faculty> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(ArrayList<Faculty> universityList) {
        this.universityList = universityList;
    }

    public double getAverageMarkOnSomeSubjectInUniversity() {
        return averageMarkOnSomeSubjectInUniversity;
    }

    public void setAverageMarkOnSomeSubjectInUniversity(double averageMarkOnSomeSubjectInUniversity) {
        this.averageMarkOnSomeSubjectInUniversity = averageMarkOnSomeSubjectInUniversity;
    }
}
