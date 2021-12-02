package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerWedding;
import edu.javacourse.studentorder.domain.StudentOrder;

public class WeddingValidator {
    AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding started");
        return new AnswerWedding();
    }
}
