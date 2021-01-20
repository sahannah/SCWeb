package entity;


import java.util.List;
import java.util.Map;

public class Student {

    private Integer stuId;
    private String stuName;
    private Address stuAddress;
    private List<Subject> subjectList;
    private Map<String,String> map;


    public Student() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Address getStuAddress() {
        return stuAddress;
    }

    public void setStuAddress(Address stuAddress) {
        this.stuAddress = stuAddress;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Student(Integer stuId, String stuName, Address stuAddress, List<Subject> subjectList, Map<String, String> map) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuAddress = stuAddress;
        this.subjectList = subjectList;
        this.map = map;
    }



    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAddress=" + stuAddress +
                ", subjectList=" + subjectList +
                ", map=" + map +
                '}';
    }
}
