package com.company;

import org.quartz.*;

import java.io.FileNotFoundException;

public class SimpleSchedulerImplementation implements org.quartz.Job {

    public SimpleSchedulerImplementation() {
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            SchedulerContext schedulerContext = context.getScheduler().getContext();
            FileSave file = (FileSave)schedulerContext.get("file");
            file.Save_File();
        }
        catch (SchedulerException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}