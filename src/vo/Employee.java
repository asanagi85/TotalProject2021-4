package vo;

import java.util.List;

public class Employee {
    public static int serial = 0;
    private String eid;
    private String name;
    private int salary;
    private List<String> license;

    public Employee() {
    }

    public Employee(String name, int salary, List license) {
        serial++;
        this.eid = serial + "";
        this.name = name;
        this.salary = salary;
        this.license = license;
    }

    @Override
    public String toString() {
        String temp = null;
        if(license != null){
            for(String s : license){
                temp += "," + s;
            }
        }

        return eid + "," + name + "," + salary + temp;
    }

    public static int getSerial() {
        return serial;
    }

    public static void setSerial(int serial) {
        Employee.serial = serial;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List getLicense() {
        return license;
    }

    public void setLicense(List license) {
        this.license = license;
    }
}
