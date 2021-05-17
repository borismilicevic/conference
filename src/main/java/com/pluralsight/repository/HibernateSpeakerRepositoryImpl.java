package com.pluralsight.repository;

import com.pluralsight.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository")
public class HibernateSpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    private Calendar cal;

    /***
     * SpEL Spring Expression Language - used to generate values at run time. Useful for seeding password encryption
     */
    @Value("#{ T(java.lang.Math).random() * 100 }")
    private double seedNum;

    @Override
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<>();
        System.out.println("cal: " + cal.getTime());
        speakers.add(new Speaker("Petar", "Petrovic", seedNum));
        speakers.add(new Speaker("Mitar", "Petrovic", seedNum));
        return speakers;
    }
}
