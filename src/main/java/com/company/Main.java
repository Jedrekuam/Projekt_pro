package com.company;

import org.quartz.SchedulerException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, SchedulerException {
        FileSave file = new FileSave();
        SimpleScheduler scheduler1 = new SimpleScheduler(file);
        AdvancedScheduler scheduler2 = new AdvancedScheduler();

        Request request = new Request();
        Scanner read = new Scanner(System.in);

                while(true) {
                    request.Take_Rqst(read);
                    if (request.Test_Rqst()) {
                        file.Add_Rqst(request);
                    }
                }

    }
}
