package UI;

import java.util.Scanner;

import Service.Service;

public class Console {
    private Scanner scan = new Scanner(System.in);
    private Service service;

    public Console(Service service) {
        this.service = service;
    }

    public void run() {
        handleShowMenu();
        this.handleOption();
    }

    private static void handleShowMenu() {
        System.out.println();
        System.out.println("1.  Adaugati persoana");
        System.out.println("2.  Adaugati apartament");
        System.out.println("3.  Modificati persoana");
        System.out.println("4.  Modificati apartament");
        System.out.println("5.  Stergeti persoana");
        System.out.println("6.  Stergeti apartament");
        System.out.println("7.  Afisare tabel persoane");
        System.out.println("8.  Afisare tabel apartamente");
        System.out.println("9.  Afisare tabel taxe");
        System.out.println("10. Afisare tabel informatii bloc");
        System.out.println("11. Inchide");
    }

    private void handleOption() {
        String option = "0";

        while (!option.equals("11")) {
            System.out.print("\nSelectati optiunea: ");
            option = this.scan.next();

            switch (option) {
                case "1":
                    this.handleAddPerson();
                    break;
                case "2":
                    this.handleAddApartment();
                    break;
                case "3":
                    this.handleUpdatePerson();
                    break;
                case "4":
                    this.handleUpdateApartment();
                    break;
                case "5":
                    this.handleDeletePerson();
                    break;
                case "6":
                    this.handleDeleteApartment();
                    break;
                case "7":
                    this.handleShowPeople();
                    break;
                case "8":
                    this.handleShowApartments();
                    break;
                case "9":
                    this.handleShowTaxes();
                    break;
                case "10":
                    this.handleShowInfo();
                    break;
                default:
                    System.out.println("Optiune inexistenta.");
                    break;
            }
            handleShowMenu();
        }
    }

    private void handleAddPerson() {
        try {
            System.out.println("Dati atributele persoanei conform modelului");
            System.out.println("prenume,nume,nr. apartament,zi nastere,job");
            // this.scan.next(); // consuma \n

            String userInput = scan.next();
            for (String line : userInput.split("\n")) {
                String[] personData = line.split(",");
                if (personData.length != 5)
                    throw new IndexOutOfBoundsException("Persoana cu datele\n" + line + " nu este valida.");
                String forename = personData[0];
                String surname = personData[1];
                int noApartment = Integer.parseInt(personData[2]);
                String birthdate = personData[3];
                String job = personData[4];
                this.service.createPerson(forename, surname, noApartment, birthdate, job);
            }
        } catch (NumberFormatException e) {
            System.out.println("Conversie nr. apartament esuata.");
        }

    }

    private void handleAddApartment() {
        // TODO
    }

    private void handleUpdatePerson() {
        // TODO
    }

    private void handleUpdateApartment() {
        // TODO
    }

    private void handleDeletePerson() {
        // TODO
    }

    private void handleDeleteApartment() {
        // TODO
    }

    private void handleShowPeople() {
        // TODO
    }

    private void handleShowApartments() {
        // TODO
    }

    private void handleShowTaxes() {
        // TODO
    }

    private void handleShowInfo() {
        // TODO
    }

}
