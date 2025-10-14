package at.htl.arrayvslist;

import java.util.ArrayList;

public class ListWithPojo {

    ArrayList<Subject> subjectList;

    public ListWithPojo() {

        subjectList = new ArrayList<Subject>();
        fillList();

        // Check weekly hours
        int totalWeeklyHours = 0;
        for (Subject subject : subjectList) {
            totalWeeklyHours = totalWeeklyHours + subject.getWeeklyHours();
        }
        System.out.println("Total weekly hours: " + totalWeeklyHours);
    }

    private void fillList(){
        subjectList.add(new Subject("SEW1", "GEI", 1));
        subjectList.add(new Subject("SEW", "GEI", 2));
    }

    public static void main(String[] args) {
        new ListWithPojo();
    }
}
