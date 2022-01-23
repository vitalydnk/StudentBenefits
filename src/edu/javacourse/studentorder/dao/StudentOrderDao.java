package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.StudentOrder;

public interface StudentOrderDao {
    Long saveStudentOrder (StudentOrder so) throws DaoException;
}
