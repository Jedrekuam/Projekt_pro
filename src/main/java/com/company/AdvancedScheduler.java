package com.company;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import static org.quartz.CronScheduleBuilder.cronSchedule;

public class AdvancedScheduler {
        Scheduler scheduler;
        JobDetail job;
        Trigger trigger;


    public AdvancedScheduler() {

            try {
                // Grab the Scheduler instance from the Factory
                scheduler = StdSchedulerFactory.getDefaultScheduler();

                // and start it off
                scheduler.start();

                // define the job and tie it to our HelloJob class
                job = newJob(AdvancedSchedulerImplementation.class)
                        .withIdentity("job2", "group2")
                        .build();

                // Trigger the job to run now, and then repeat every 1 seconds
                trigger = newTrigger()
                        .withIdentity("trigger2", "group2")
                        .startNow()
                        .withSchedule(cronSchedule("0 * * ? * MON,TUE,WED,THU,FRI *"))
                        .build();


                // Tell quartz to schedule the job using our trigger
                scheduler.scheduleJob(job, trigger);

            } catch (SchedulerException se) {
                se.printStackTrace();
            }
        }

        public void close() throws SchedulerException {
            scheduler.shutdown();
        }
    }
