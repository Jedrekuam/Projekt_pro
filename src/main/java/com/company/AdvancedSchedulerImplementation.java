package com.company;

import org.quartz.*;

import java.util.Date;

@PersistJobDataAfterExecution
public class AdvancedSchedulerImplementation implements Job {

        public void execute(JobExecutionContext context) throws JobExecutionException {

            Date date = new Date();
            int time = date.getHours()*60 + date.getMinutes() - 480;
            boolean is_lesson = false;
            int diff = 0;

            if(time >= 15 && time <= 645) {

                if(time <= 105) {
                    is_lesson = true;
                    diff = time - 105;
                }
                if(time > 105 && time <= 120) {
                    diff = time - 120;
                }
                if(time > 120 && time <= 210 ) {
                    is_lesson = true;
                    diff = time - 210;
                }
                if(time > 210 && time <= 225) {
                    diff = time - 235;
                }
                if(time > 225 && time <= 315) {
                    is_lesson = true;
                    diff = time - 315;
                }
                if(time > 315 && time <= 345) {
                    diff = time - 345;
                }
                if(time > 345 && time <= 435) {
                    is_lesson = true;
                    diff = time - 435;
                }
                if(time > 435&& time <= 450) {
                    diff = time - 450;
                }
                if(time > 450&& time <= 540) {
                    is_lesson = true;
                    diff = time - 540;
                }
                if(time > 540&& time <= 555) {
                    diff = time - 555;
                }
                if(time > 555&& time <= 645) {
                    is_lesson = true;
                    diff = time - 645;
                }
                diff = Math.abs(diff);

                if(is_lesson) {
                    System.out.println(diff + " minut do konca zajec.");
                }
                else
                    System.out.println(diff + " minut do konca przerwy.");
            }

        }
    }

