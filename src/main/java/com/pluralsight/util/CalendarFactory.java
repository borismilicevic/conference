package com.pluralsight.util;

import org.springframework.beans.factory.FactoryBean;

import java.util.Calendar;

/***
 * Factory bean configuration - build on the factory method design pattern
 * great way to integrate legacy code - enforce a contract on how code is configured without creating a specific
 * constructor for it. Typically, creational contracts are implemented in a constructor but with legacy code we
 * often don't have an ability to modify it. Using this pattern enables us to establish a contract without modifying
 * that code.
 * This pattern could be used for working with static methods inside of a class.
 */
public class CalendarFactory implements FactoryBean<Calendar> {

    private Calendar instance = Calendar.getInstance();

    @Override
    public Calendar getObject() throws Exception {
        return instance;
    }

    @Override
    public Class<?> getObjectType() {
        return Calendar.class;
    }

    public void addDays(int days) {
        this.instance.add(Calendar.DAY_OF_YEAR, days);
    }
}
