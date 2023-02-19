package lk.ijse.spring.dto;

public class customerDTO {
    private String ID;
    private String name;
    private String address;
    private double salary;

    public customerDTO() {
    }

    public customerDTO(String ID, String name, String address, double salary) {
        this.ID = ID;
        this.name = name;
        this.address = address;
        this.salary = salary;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "customerDTO{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
