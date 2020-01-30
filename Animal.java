package ru.geekbreans.lesson5;

public class Animal {
    protected float run;
    protected float sail;
    protected float jump;
    protected int age;
    protected int life;

    public Animal(int run,int sail,float jumpSmall, int age, int life){
        this.run = run;
        this.sail = sail;
        this.jump = jumpSmall;
        this.age = age;
        this.life = life;
    }


    float getRun(int age) {
        if(age > life/2) return run/2;
        return run;
    }

    float getSail(int age) {
        if(age > life/2) return sail/2;
        return sail;
    }

    float getJump(int age) {
        if(age > life/2) return jump/2;
        return jump;
    }

    int getAge() {
        return age;
    }
}
//