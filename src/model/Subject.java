package model;

public class Subject {
    private int id;
    private String name;
    private String description;
    private Integer teacherId;

    public Subject(int id, String name, String description, Integer teacherId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacherId = teacherId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}