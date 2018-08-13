/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

package 面向对象.Printer;

import java.util.zip.ZipOutputStream;

public class Printer {
      private  Ink ink;
      private  Paper paper;

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    public  void print() {

          System.out.println("我用"+this.ink.offerColor()+"墨盒在"+this.paper.offerPaper()+"纸上打印了一些东西");
      }

    public static void main(String[] args) {
        Printer printer=new Printer();
        Paper paper=new A4Paper();
          Ink ink=new ColorInk();
        printer.setInk(ink);
        printer.setPaper(paper);
        printer.print();

    }



}
