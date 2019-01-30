package Aplications;

import java.util.Scanner;

public class Aplication {

    static Office office=new Office();
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int choice ;




        do {
            System.out.println("Program wykonuje następujące czynności: " + "\n1. dodawanie klienta, "
                    + "\n2. dodawanie DVD, " +"\n3. przeglad DVD"+"\n4. przeglad klintow"+"\n5. dodaj wypozyczenie"+"\n6.przeglad wypozyczen"
                    + "\n0. wyjscie " );
            System.out.println("Wybierz opcję: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Dodawanie klienta.");
                    addClients();

                }
                break;
                case 2: {
                    System.out.println("dodawanie Dvd.");
                    addDvd(sc);

                }
                break;
                case 3: {
                    System.out.println("Przegląd listy Dvd.");
                    getDvd();

                    break;
                }
                case 4:{
                    getListClients();
                }break;
                case 5:{
                    System.out.println("Dodaj wypozyczenie");
                    addRental(sc);
                }break;
                case 6:{
                    System.out.println("Lista wypozyczen");
office.getListRent();
                }
                case 7:{
                    office.getData();
                }
                case 0: {

                    System.out.println("Koniec.");

                }break;
                default: {
                    System.out.println("Brak takiej opcji");
                }

            }}while ((choice != 0));
    }


    public static void addDvd(Scanner sc){


office.addDvd();

    }

    public static void getDvd() {
        office.getListDvd();
    }

    public static void addClients(){
        office.addClient();
    }
    public static void getListClients(){
        office.getListClients();
    }
    public static void addRental(Scanner sc){
        office.addRent();
       //System.out.println(office.searchDvd(sc.nextInt()));

    }

}
