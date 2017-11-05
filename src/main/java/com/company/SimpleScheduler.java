package com.company;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class SimpleScheduler {
    Scheduler scheduler;
    JobDetail job;
    Trigger trigger;
    FileSave file;

    public SimpleScheduler(FileSave file) {
        try {
            this.file = file;
            scheduler = StdSchedulerFactory.getDefaultScheduler();

            job = newJob(SimpleSchedulerImplementation.class)
                    .withIdentity("job1", "group1")
                    .build();

            trigger = newTrigger()
                    .withIdentity("trigger1", "group1")
                    .startNow()
                    .withSchedule(simpleSchedule()
                            .withIntervalInSeconds(30)
                            .repeatForever())
                    .build();

            scheduler.getContext().put("file", this.file);

            scheduler.scheduleJob(job, trigger);
            scheduler.start();
        }
        catch (SchedulerException se) {
            se.printStackTrace();
        }
    }

        public void close() throws SchedulerException {
             scheduler.shutdown();
    }


}