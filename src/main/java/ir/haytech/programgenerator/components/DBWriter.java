package ir.haytech.programgenerator.components;

import ir.haytech.programgenerator.entities.Date;
import ir.haytech.programgenerator.repositories.DateRepository;
import ir.haytech.programgenerator.util.Constants;
import ir.haytech.programgenerator.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class DBWriter implements CommandLineRunner {
    @Autowired
    private DateRepository dateRepository;

    @Override
    public void run(String... args) throws Exception {
        Date lastDayInDatabase = dateRepository.findTopByOrderByIdDesc();
        for (int i = 1; i < 21; i++) { // Number of days from today to program (must be greater than 10)
            Date date = new Date();
            if (lastDayInDatabase == null) {
                if (i == Constants.DAY_1) { //Day 1
                    date.setPermittedMessageCount(Constants.DAY_1_COUNT);
                } else if (i == Constants.DAY_2) { //Day 2
                    date.setPermittedMessageCount(Constants.DAY_2_COUNT);
                } else if (i == Constants.DAY_3) { //Day 3
                    date.setPermittedMessageCount(Constants.DAY_3_COUNT);
                } else if (i == Constants.DAY_4) { //Day 4
                    date.setPermittedMessageCount(Constants.DAY_4_COUNT);
                } else if (i == Constants.DAY_5) { //Day 5
                    date.setPermittedMessageCount(Constants.DAY_5_COUNT);
                } else if (i == Constants.DAY_6) { //Day 6
                    date.setPermittedMessageCount(Constants.DAY_6_COUNT);
                } else if (i == Constants.DAY_7) { //Day 7
                    date.setPermittedMessageCount(Constants.DAY_7_COUNT);
                } else if (i == Constants.DAY_8) { //Day 8
                    date.setPermittedMessageCount(Constants.DAY_8_COUNT);
                } else if (i == Constants.DAY_9) { //Day 9
                    date.setPermittedMessageCount(Constants.DAY_9_COUNT);
                } else if (i == Constants.DAY_10) { //Day 10
                    date.setPermittedMessageCount(Constants.DAY_10_COUNT);
                } else {
                    int properValue = Utility.generateRandom(Constants.DAY_10_COUNT, Constants.DAY_AFTER_10_COUNT);
                    date.setPermittedMessageCount(properValue);
                }
                date.setDate(new Timestamp(Utility.addDaysToThisDate(i - 1, new java.util.Date()).getTime()));
            } else {
                int properValue = Utility.generateRandom(Constants.DAY_10_COUNT, Constants.DAY_AFTER_10_COUNT);
                date.setPermittedMessageCount(properValue);
                date.setDate(new Timestamp(Utility.addDaysToThisDate(i , lastDayInDatabase.getDate()).getTime()));
            }

            date.setStartTime(new Timestamp(Utility.getRandomStartTime().getTime()));
            date.setEndTime(new Timestamp(Utility.getRandomEndTime().getTime()));

            date.setLongSleepTimeStart(new Timestamp(Utility.getRandomLongSleepStartTime().getTime()));
            date.setLongSleepTimeEnd(new Timestamp(Utility.getRandomLongSleepEndTime().getTime()));
            dateRepository.save(date);
        }
    }
}
