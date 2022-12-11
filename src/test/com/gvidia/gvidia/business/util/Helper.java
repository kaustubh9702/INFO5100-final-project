package com.gvidia.gvidia.business.util;

import com.github.javafaker.Faker;
import com.gvidia.gvidia.business.enterprise.employee.Employee;
import com.gvidia.gvidia.business.enterprise.organisation.Organization;
import com.gvidia.gvidia.business.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Helper {


    public static List<Employee> createEmployees(Organization org, int i) {

        List<Employee> employeeList = new ArrayList<>();
        for(;i>=0;i--) {

            Faker faker = new Faker(new Locale("en-IND"));
            employeeList.add(    org.getEmployeeDirectory().addEmployee(faker.name().fullName(), faker.phoneNumber().cellPhone(), getAvatarFile()));
        }
        return employeeList;
    }

    public static String getAvatarFile() {
        int i = new Random().nextInt(5);
        String s = ImageUtil.BASE_IMAGE + "avatars\\avatar" + i + ".png";

        return s;
    }


}
