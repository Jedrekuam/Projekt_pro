package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class FileSave {
    List<Request> rqst_array;
    PrintWriter writer;

    public FileSave() throws IOException {
        rqst_array = new ArrayList<Request>();
        writer = new PrintWriter("odp.txt");
        writer.close();
    }

    public void Add_Rqst(Request rqst) {
        boolean repeat = false;
        for(int i = 0; i < rqst_array.size(); i++)
        {
            if(rqst_array.get(i).Get_Num() == rqst.Get_Num()){
                rqst_array.get(i).Set_Request(rqst);
                repeat = true;
                break;
            }
        }
        if(!repeat)
            rqst_array.add(new Request(rqst));
    }

    public void Save_File() throws FileNotFoundException {
        writer = new PrintWriter("odp.txt");

        boolean zmiana = true;
        while(!zmiana)
        {
            zmiana = false;
            for(int i = 0; i < rqst_array.size() -1; i++)
            {
                if(rqst_array.get(i).Get_Num() > rqst_array.get(i+1).Get_Num())
                {
                    rqst_array.get(i).Swap(rqst_array.get(i+1));
                    zmiana = true;
                    break;
                }
            }
        }

        for(int i = 0; i < rqst_array.size(); i++)
            writer.println(rqst_array.get(i).Get_Num() + rqst_array.get(i).Get_Rqst());

        writer.close();
    }
}
