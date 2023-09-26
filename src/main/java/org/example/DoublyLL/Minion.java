package org.example.DoublyLL;

public class Minion {
    private String name;
    private int age;
    private boolean isActive;

    private int eyeCount;

    public Minion(String name, int age, int eyeCount) {
        setName(name);
        setAge(age);
        setEyeCount(eyeCount);
        this.isActive = true;
    }

    public int getEyeCount() {
        return eyeCount;
    }

    public void setEyeCount(int eyeCount) {
        this.eyeCount = eyeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setisActive(){
        this.isActive = !this.isActive;
    }


    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                '}';
    }
}
