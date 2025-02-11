package org.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.UUID;

import org.example.Services.UserBookingService;
import org.example.entities.User;
import org.example.entities.ticket;
import org.example.entities.Train;
import org.example.util.UserserviceUtil;

public class App {
    public static void main(String[] args) throws IOException {
        UserBookingService userBookingService = new UserBookingService();
        Scanner scanner = new Scanner(System.in);
        User loggedInUser = null;

        System.out.println("Starting Train Booking System");
        int option = 0;

        while (option != 7) {
            System.out.println("\nMenu:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Book Ticket");
            System.out.println("4. Cancel Ticket");
            System.out.println("5. Print Ticket");
            System.out.println("6. Print All Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1: // Register
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    UserserviceUtil userUtil = new UserserviceUtil();
                    String hashedPassword = userUtil.hashPassword(password);
                    User newUser = new User(name, password, hashedPassword, new ArrayList<>(), UUID.randomUUID().toString());

                    if (userBookingService.register(newUser)) {
                        System.out.println("Registration successful!");
                    } else {
                        System.out.println("Registration failed. Try again.");
                    }
                    break;

                case 2: // Login
                    System.out.print("Enter your name: ");
                    String loginName = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    loggedInUser = new User(loginName, loginPassword, new UserserviceUtil().hashPassword(loginPassword), new ArrayList<>(), UUID.randomUUID().toString());
                    userBookingService = new UserBookingService(loggedInUser);

                    if (userBookingService.login()) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Login failed. Invalid credentials.");
                        loggedInUser = null; // Reset login
                    }
                    break;

                case 3: // Book Ticket
                    if (loggedInUser == null) {
                        System.out.println("Please login first.");
                        break;
                    }

                    System.out.print("Enter train name: ");
                    String trainName = scanner.nextLine();
                    System.out.print("Enter train number: ");
                    String trainNumber = scanner.nextLine();


                    scanner.nextLine(); // Consume newline





                    System.out.println("Ticket booked successfully!");
                    break;
                case 5:
                    System.out.println("enter the ticket number to print the ticket");


                case 7: // Exit
                    System.out.println("Exiting Train Booking System.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
