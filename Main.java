package PrimeNumber;


import jdk.jfr.Experimental;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws IOException{
        Scanner klavye = new Scanner(System.in);
        System.out.print("Dosya Adı Giriniz : ");
        String dosyaadi = klavye.nextLine();
        File dosya = new File(dosyaadi+".txt");
        if (!dosya.exists()) dosya.createNewFile();

        for (int i = 0; i < 10; i++) {
            FileWriter f_writer = new FileWriter(dosya, true);
            BufferedWriter b_writer = new BufferedWriter(f_writer);
            System.out.print(i + 1 + ". İçerik : ");
            var icerik = klavye.nextLine();
            b_writer.write(icerik);
            b_writer.newLine();
            b_writer.close();
        }

        FileReader fr = new FileReader(dosya);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<Integer> liste = new ArrayList<>();
        ArrayList<String> dosyalist = new ArrayList<>();

        while (br.ready())
            dosyalist.add(br.readLine());

        for (int i = 0; i < dosyalist.size(); i++) {
            try {
                liste.add(Integer.parseInt(dosyalist.get(i)));

            } catch (Exception e) {
                e.getMessage();
            }
        }
        System.out.println("***********************");

        Boolean kontrol = false;
        int sayac = 0;

        for (int i = 0; i < liste.size(); i++) {
            int sayi = liste.get(i);
            if (sayi == 2) kontrol = true;
            else if(sayi<=1) kontrol=false;
            else {
                for (int j = 2; j < sayi; j++) {
                    if (sayi % j == 0) {
                        kontrol = false;
                        break;
                    } else {
                        kontrol = true;
                    }
                }
            }

            if (kontrol == true) sayac++;
        }
        System.out.println("Dosyada " + sayac + " tane asal sayı vardır");
    }
}
