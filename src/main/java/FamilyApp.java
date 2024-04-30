import controller.FamilyController;
import controller.FamilyOverflowException;
import dao.CollectionFamilyDao;
import dao.FamilyDao;
import service.FamilyService;
import dao.entity.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FamilyApp {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Family> families = new ArrayList<>();
    private static FamilyController familyController;

    public static void main(String[] args) {
        FamilyDao familyDao = new CollectionFamilyDao(families);
        familyController = new FamilyController(new FamilyService(familyDao));

        while (true) {
            displayMainMenu();
            int choice = getUserChoice();
            handleChoice(choice);
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nFamily Management App");
        System.out.println("1. Fill with test data");
        System.out.println("2. Display all families");
        System.out.println("3. Display families with more than N people");
        System.out.println("4. Display families with less than N people");
        System.out.println("5. Count families with N members");
        System.out.println("6. Create a new family");
        System.out.println("7. Delete a family by ID");
        System.out.println("8. Edit a family by ID");
        System.out.println("9. Remove children over age");
        System.out.println("10. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        int choice;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            choice = -1;
        }
        return choice;
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                try {

                    familyController.saveFamily((Family) families);
                } catch (Exception e) {
                    System.out.println("Error creating test data: " + e.getMessage());
                }
                break;
            case 2:
                try {
                    familyController.displayAllFamilies();
                } catch (FamilyOverflowException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            case 3:
                System.out.print("Enter the minimum number of people: ");
                int minPeople;
                try {
                    minPeople = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    break;
                }
                familyController.getFamiliesBiggerThan(minPeople);
                break;
            case 4:
                System.out.print("Enter the maximum number of people: ");
                int maxPeople;
                try {
                    maxPeople = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                    break;
                }
                familyController.getFamiliesLessThan(maxPeople);
                break;
            case 5:
                try {
                    int count = familyController.count();
                    System.out.println("Number of families: " + count);
                } catch (Exception e) {
                    System.out.println("Error counting families: " + e.getMessage());
                }
                break;
            case 6:
                System.out.print("Enter mother's name: ");
                String motherName = scanner.nextLine();
                System.out.print("Enter mother's last name: ");
                String motherLastName = scanner.nextLine();
                System.out.print("Enter mother's IQ: ");
                double motherIq = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Enter father's name: ");
                String fatherName = scanner.nextLine();
                System.out.print("Enter father's last name: ");
                String fatherLastName = scanner.nextLine();



                System.out.print("Enter father's IQ: ");
                double fatherIq = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter mother's birth year: ");
                String motherBirthYearStr = scanner.nextLine();
                System.out.print("Enter mother's month of birth (1-12): ");
                String motherBirthMonthStr = scanner.nextLine();
                System.out.print("Enter mother's day of birth (1-31): ");
                String motherBirthDayStr = scanner.nextLine();

                int motherBirthYear = Integer.parseInt(motherBirthYearStr);
                int motherBirthMonth = Integer.parseInt(motherBirthMonthStr);
                int motherBirthDay = Integer.parseInt(motherBirthDayStr);

                LocalDate motherBirthDate = LocalDate.of(motherBirthYear, motherBirthMonth, motherBirthDay);
                //          Human father = new Human(fatherName, fatherLastName, LocalDate.of(motherBirthDay,motherBirthMonth,motherBirthYear).toEpochDay(), fatherIq);
                //          Human mother = new Human(motherName, motherLastName, motherBirthDate.toEpochDay(), motherIq);
                //        familyController.createNewFamily(father, mother);
                break;

            case 7:
                System.out.print("Enter the family ID to delete: ");
                int familyId = scanner.nextInt();
                scanner.nextLine();
                familyController.deleteFamily(familyId);
                break;
            case 8:
                System.out.print("Enter the family ID to edit: ");
                int editFamilyId = scanner.nextInt();
                scanner.nextLine();
                familyController.getFamiliesLessThan(editFamilyId);
                break;
            case 9:
                System.out.print("Enter the age of majority: ");
                int ageOfMajority = scanner.nextInt();
                scanner.nextLine();
                familyController.deleteFamily(ageOfMajority);
                break;
            case 0:
                System.out.println("Exiting application.");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}