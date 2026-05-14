package com.pms.PatientManagementSystem;
import java.util.Scanner;

import com.pms.PatientManagementSystem.controller.AppointmentController;
import com.pms.PatientManagementSystem.controller.BillingController;
import com.pms.PatientManagementSystem.controller.DoctorController;
import com.pms.PatientManagementSystem.controller.PatientController;
import com.pms.PatientManagementSystem.util.DBConnection;

public class MainApp {

    public static void main(String[] args) {

        // Create tables automatically
        DBConnection.createTables();

        Scanner sc = new Scanner(System.in);

        PatientController patientController = new PatientController();
        DoctorController doctorController = new DoctorController();
        AppointmentController appointmentController = new AppointmentController();
        BillingController billingController = new BillingController();

        while (true) {
            System.out.println("\n========= PATIENT MANAGEMENT SYSTEM =========");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing Management");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--- Patient Menu ---");
                    System.out.println("1. Add Patient");
                    System.out.println("2. View Patients");
                    System.out.println("3. Search Patient");
                    System.out.println("4. Update Patient");
                    System.out.println("5. Delete Patient");
                    System.out.print("Enter choice: ");
                    int p = sc.nextInt();

                    switch (p) {
                        case 1: patientController.addPatient(); break;
                        case 2: patientController.viewPatients(); break;
                        case 3: patientController.searchPatient(); break;
                        case 4: patientController.updatePatient(); break;
                        case 5: patientController.deletePatient(); break;
                    }
                    break;

                case 2:
                    System.out.println("\n--- Doctor Menu ---");
                    System.out.println("1. Add Doctor");
                    System.out.println("2. View Doctors");
                    System.out.print("Enter choice: ");
                    int d = sc.nextInt();

                    if (d == 1) doctorController.addDoctor();
                    else if (d == 2) doctorController.viewDoctors();
                    break;

                case 3:
                    System.out.println("\n--- Appointment Menu ---");
                    System.out.println("1. Book Appointment");
                    System.out.println("2. View Appointments");
                    System.out.print("Enter choice: ");
                    int a = sc.nextInt();

                    if (a == 1) appointmentController.bookAppointment();
                    else if (a == 2) appointmentController.viewAppointments();
                    break;

                case 4:
                    System.out.println("\n--- Billing Menu ---");
                    System.out.println("1. Generate Bill");
                    System.out.println("2. View Bills");
                    System.out.print("Enter choice: ");
                    int b = sc.nextInt();

                    if (b == 1) billingController.generateBill();
                    else if (b == 2) billingController.viewBills();
                    break;

                case 5:
                    System.out.println("Thank you for using HMS");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
