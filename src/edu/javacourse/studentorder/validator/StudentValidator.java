package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerStudent;
import edu.javacourse.studentorder.domain.StudentOrder;

public class StudentValidator {
    AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Student checking");
        return new AnswerStudent();
    }
}
