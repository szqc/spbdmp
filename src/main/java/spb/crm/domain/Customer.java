package spb.crm.domain;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String custNo;
    private String custName;
    private int custLevel;
    private String groupId;
    private List<Course> courseList;
    private City city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public int getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(int custLevel) {
        this.custLevel = custLevel;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}
