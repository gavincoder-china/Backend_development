package jdk8;


import java.util.*;

public class OptionalTest2 {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");

        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee, employee2);
//        company.setEmployees(employees);

        List<Employee> list = company.getEmployees();

        Optional<Company> optional = Optional.ofNullable(company);

        System.out.println(optional.map(theCompany -> theCompany.getEmployees()).
                orElse(Collections.emptyList()));


    }

    public void test(Optional optional) {

    }
}
