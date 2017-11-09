package com.company;


import java.util.Scanner;

public class Request {
    int num;
    String rqst;

    public Request() {
        num = 0;
        rqst = "";
    }

    public Request(Request rqst) {
        this.num = rqst.Get_Num();
        this.rqst = rqst.Get_Rqst();
    }

    public int Get_Num() {return num;}

    public String Get_Rqst() {return rqst;}

    public void Set_Num(int num) {this.num = num;}

    public void Set_Rqst(String rqst) {this.rqst = rqst;}

    public void Set_Request(Request request) {
        this.Set_Rqst(request.Get_Rqst());
        this.Set_Num(request.Get_Num());
    }

    public void Swap(Request a) {
        Request b = new Request();
        b.Set_Num(this.Get_Num());
        b.Set_Rqst(this.Get_Rqst());
        this.Set_Num(a.Get_Num());
        this.Set_Rqst(a.Get_Rqst());
        a.Set_Num(b.Get_Num());
        a.Set_Rqst(b.Get_Rqst());
    }

    public void Take_Rqst(Scanner read) {


        if(read.hasNextInt()) {
            num = read.nextInt();
            if(read.hasNextLine())
                rqst = read.nextLine();
            else
                System.out.println("No request");
        }
        else
            System.out.println("Integer first");
    }

    public boolean Test_Rqst(){

        rqst = rqst.toLowerCase();

        if(rqst.equals("")){
            System.out.println("Empty request");
            return false;
        }
        if(rqst.matches("(.*)select(.*)from(.*)") || rqst.matches("(.*)from(.*)where(.*)") || rqst.matches("(.*)where(.*)order by(.*)") || rqst.matches("(.*)order by(.*)")){
            return true;
        }
        else {
            System.out.println("Doesnt match to pattern");
            return false;
        }
    }
}
