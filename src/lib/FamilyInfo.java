package lib;

import java.util.ArrayList;
import java.util.List;

public class FamilyInfo {
    private String spouseName;
    private String spouseIdNumber;
    private List<Employee.Child> children = new ArrayList<>();

    public void setSpouse(String name, String idNumber) {
        this.spouseName = name;
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String name, String idNumber) {
        children.add(new Employee.Child(name, idNumber));
    }

    public boolean hasSpouse() {
        return spouseIdNumber != null && !spouseIdNumber.isEmpty();
    }

    public int getNumberOfChildren() {
        return children.size();
    }
}