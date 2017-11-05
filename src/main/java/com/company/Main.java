package com.company;

import org.quartz.SchedulerException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SchedulerException {
        FileSave file = new FileSave();
        SimpleScheduler scheduler1 = new SimpleScheduler(file);

        Request request = new Request();


            request.Take_Rqst();
            if(request.Test_Rqst()){
                file.Add_Rqst(request);
            }

        scheduler1.close();
    }
}
