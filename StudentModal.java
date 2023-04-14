package com.example.crud;

public class StudentModal {
    private String name;
    private String roll;
    private String sub;
    private String marks;
    private int id;

    // creating getter and setter methods
    public String getName() { return name; }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getRoll()
    {
        return roll;
    }

    public void setRoll(String roll)
    {
        this.roll = roll;
    }

    public String getSub()
    {
        return sub;
    }

    public void setSub(String sub)
    {
        this.sub = sub;
    }

    public String getMarks()
    {
        return marks;
    }

    public void setmarks(String marks)
    {
        this.marks = marks;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public StudentModal(String name,
                       String roll,
                       String sub,
                       String marks)
    {
        this.name = name;
        this.roll = roll;
        this.sub = sub;
        this.marks = marks;
    }
}
