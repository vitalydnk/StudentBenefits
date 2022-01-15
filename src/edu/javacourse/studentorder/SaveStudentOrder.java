package edu.javacourse.studentorder;

import edu.javacourse.studentorder.dao.DaoException;
import edu.javacourse.studentorder.dao.DictionaryDao;
import edu.javacourse.studentorder.dao.DictionaryDaoImpl;
import edu.javacourse.studentorder.domain.*;
import org.postgresql.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws DaoException {
        List<Street> d = new DictionaryDaoImpl().findStreets("про");
        for (Street s : d) {
            System.out.println(s.getStreetName());
        }

        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        for (PassportOffice p : po) {
            System.out.println(p.getOfficeName());
        }

        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        for (RegisterOffice r : ro) {
            System.out.println(r.getOfficeName());
        }

        List<CountryArea> ca1 = new DictionaryDaoImpl().findAreas("");
        for (CountryArea c : ca1) {
            System.out.println(c.getAreaName());
        }
        System.out.println("-------");
        List<CountryArea> ca2 = new DictionaryDaoImpl().findAreas("020000000000");
        for (CountryArea c : ca2) {
            System.out.println(c.getAreaName());
        }
        System.out.println("-------");
        List<CountryArea> ca3 = new DictionaryDaoImpl().findAreas("020010000000");
        for (CountryArea c : ca3) {
            System.out.println(c.getAreaName());
        }
        System.out.println("-------");
        List<CountryArea> ca4 = new DictionaryDaoImpl().findAreas("020010010000");
        for (CountryArea c : ca4) {
            System.out.println(c.getAreaName());
        }

//        StudentOrder s = buildStudentOrder(10);
//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder");

        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice ro = new RegisterOffice(1L, "", "");
        so.setMarriageOffice(ro);

        Street street = new Street(1L, "First street");
        Address address = new Address("195000", street, "12", "", "142");

        // Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeries("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice po1 = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(po1);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        // Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алекссевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeries("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice po2 = new PassportOffice(2L, "", "");
        husband.setIssueDepartment(po2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        // Ребенок 1
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro2 = new RegisterOffice(2L, "", "");
        so.setMarriageOffice(ro2);
        child1.setAddress(address);
        // Ребенок 2
        Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (300000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro3 = new RegisterOffice(3L, "", "");
        so.setMarriageOffice(ro3);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}