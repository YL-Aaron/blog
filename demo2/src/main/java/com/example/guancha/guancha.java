package com.example.guancha;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 *
 * @author YL
 * @date 22:28 2021/3/23
 */
public class guancha {
   private List<Person> list = new ArrayList<>();

    public void addPerson(Person person) {
        list.add(person);
    }

    public void notifyPerson() {
        for (Person person : list) {
            person.getMessage("你说啥");
        }
    }


    public static void main(String[] args) {
        laowang laowang = new laowang();
        laoli laoli = new laoli();
        guancha guancha = new guancha();
        guancha.addPerson(laoli);
        guancha.addPerson(laowang);
        guancha.notifyPerson();
    }
}
