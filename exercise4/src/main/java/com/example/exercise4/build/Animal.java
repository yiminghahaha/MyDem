package com.example.exercise4.build;

public class Animal {
    public  static  class  builder{
        Animal animal;
        public  builder(){
            animal = new Animal();
        }

        public  builder setname(String name){
            animal.setName(name);
            return this;
        }
        public  builder setsex(String sex){
            animal.setSex(sex);
            return this;
        }

        public  builder setage(int age){
            animal.setAge(age);
            return  this;
        }

        public  Animal build(){
            return animal;
        }
    }

    private  String name;
    private  String sex;
    private  int age;

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal() {

    }

    public Animal(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
