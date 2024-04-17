package com.mrwantesting;

import com.mrwantesting.dao.*;
import com.mrwantesting.model.*;
import com.mrwantesting.model.Module;

import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class app {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("----------------- Menu -----------------");
        for (String s : Arrays.asList("0: Log Up","1: Forms.", "2: Student.",
                "3: Teachers.", "4: Modules", "5: Logout")) {
            System.out.println(s);
        }
        System.out.print("Enter what you want : ");
        int menu = scanner.nextInt();

        switch (menu)
        {
            case 0 -> {
                System.out.flush();
                System.out.println("----------------- Log Up -----------------");
                System.out.println("1: Create User."); //
                System.out.println("2: Open User."); //
                System.out.println("3: Back to menu"); //
                System.out.print("Enter what you want : ");
                int student = scanner.nextInt();


                switch (student)
                {
                    case 1 -> {
                        saveDataOfuser(args);
                        returnmenu(args);
                    }
                    case 2 -> {
                        MyFirstJFrame log = new MyFirstJFrame();
                        log.show();
                        returnmenu(args);
                    }
                    default -> System.out.println("error !! ");
                }

            }
            // forms
            case 1 -> {
                System.out.flush();
                System.out.println("----------------- Forms -----------------");
                System.out.println("1: Add Forms."); // done
                System.out.println("2: View Forms."); // done
                System.out.println("3: Find by ID."); // done
                System.out.println("4: Edite form. "); // done
                System.out.println("5: Delete Forms. "); // done
                System.out.println("6: Back to menu"); // done
                System.out.print("Enter what you want : ");
                int Froms = scanner.nextInt();


            switch (Froms)
            {
                case 1 -> {
                    ADDNewForms(args);
                    returnmenu(args);
                }
                case 2 -> {
                    viewForms(args);
                    returnmenu(args);
                }
                case 3 -> {
                    scanner.nextLine();

                    // View student by ID
                    System.out.print("Enter the ID of the Forms: ");
                    int idToSearch = scanner.nextInt();
                    scanner.nextLine();
                    searchFormsById(idToSearch);

                    returnmenu(args);
                }
                    case 4 -> {
                        EditeFormByID(args);
                        returnmenu(args);
                    }
                    case 5 -> {
                        DeleteFormsData(args);
                        returnmenu(args);
                    }
                case 6 -> {
                    main(args);
                }
                    default -> System.out.println("error !! ");
                }

            }
            // Students
            case 2 -> {
                System.out.flush();
                System.out.println("----------------- Students -----------------");
                System.out.println("1: Add Student."); // done
                System.out.println("2: View Student."); // done
                System.out.println("3: Find by ID."); // done
                System.out.println("4: Edite Student. "); // done
                System.out.println("5: Delete Student. "); // done
                System.out.println("6: Back to menu"); // done
                System.out.print("Enter what you want : ");
                int student = scanner.nextInt();


                switch (student)
                {
                    case 1 -> {
                        SaveStudentData(args);
                        returnmenu(args);
                    }
                    case 2 -> {
                        viewStudentData(args);
                        returnmenu(args);
                    }
                    case 3 -> {
                        scanner.nextLine();

                        // View student by ID
                        System.out.print("Enter the ID of the Student: ");
                        int idToSearch = scanner.nextInt();
                        scanner.nextLine();
                        searchStudentById(idToSearch);

                        returnmenu(args);
                    }
                    case 4 -> {
                        UpdatedDataOfStudent(args);
                        returnmenu(args);
                    }
                    case 5 -> {
                        DeleteStudentData();
                        returnmenu(args);
                    }
                    case 6 -> {
                        main(args);
                    }
                    default -> System.out.println("error !! ");
                }

            }
            // teachers
            case 3 -> {
                System.out.flush();
                System.out.println("----------------- teachers -----------------");
                System.out.println("1: Add teachers."); //
                System.out.println("2: View teachers."); //
                System.out.println("3: Find by ID."); //
                System.out.println("4: Edite teachers. "); //
                System.out.println("5: Delete teachers. "); //
                System.out.println("6: Back to menu"); //
                System.out.print("Enter what you want : ");
                int Teachers = scanner.nextInt();


                switch (Teachers)
                {
                    case 1 -> {
                        SaveTeachersData(args);
                        returnmenu(args);
                    }
                    case 2 -> {
                        viewTeachersData(args);
                        returnmenu(args);
                    }
                    case 3 -> {
                        scanner.nextLine();

                        // View student by ID
                        System.out.print("Enter the ID of the teachers: ");
                        int idToSearch = scanner.nextInt();
                        scanner.nextLine();
                        searchTeachersById(idToSearch);

                        returnmenu(args);
                    }
                    case 4 -> {
                        UpdatedDataOfTeachers(args);
                        returnmenu(args);
                    }
                    case 5 -> {
                        DeleteTeachersData();
                        returnmenu(args);
                    }
                    case 6 -> {
                        main(args);
                    }
                    default -> System.out.println("error !! ");
                }

            }
            // modules
            case 4 -> {
                System.out.flush();
                System.out.println("----------------- modules -----------------");
                System.out.println("1: Add modules."); // done
                System.out.println("2: View modules."); //
                System.out.println("3: Find by ID."); //
                System.out.println("4: Edite modules. "); //
                System.out.println("5: Delete modules. "); //
                System.out.println("6: Back to menu"); //
                System.out.print("Enter what you want : ");
                int modules = scanner.nextInt();


                switch (modules)
                {
                    case 1 -> {
                        SaveModulesData(args);
                        returnmenu(args);
                    }
                    case 2 -> {
                        ViewModulesData(args);
                        returnmenu(args);
                    }
                    case 3 -> {
                        scanner.nextLine();

                        // View student by ID
                        System.out.print("Enter the ID of the Module: ");
                        int idToSearch = scanner.nextInt();
                        scanner.nextLine();
                        searchModulesById(idToSearch);

                        returnmenu(args);
                    }
                    case 4 -> {
                        System.out.print("Enter the ID of the Module: ");
                        int idToSearch = scanner.nextInt();
                        scanner.nextLine();

                        // edite
                        EditeModulesByID(idToSearch);
                        returnmenu(args);
                    }
                    case 5 -> {
                        DeleteModulesData();
                        returnmenu(args);
                    }
                    case 6 -> {
                        main(args);
                    }
                    default -> System.out.println("error !! ");
                }

            }
        }

    }

    /// Forms ///
    public static void ADDNewForms(String[]args) {
        EmployeeformsDao employeeformsDao = new EmployeeformsDaolmpl();
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------- Add new Form -----------------");
            // name of Form
            System.out.print("Enter name of Form : ");
            String NameOfForm = scanner.nextLine();

            // Teacher Of Form
            System.out.print("Enter Teacher Of Form : ");
            String TeachersOfForm = scanner.nextLine();

            // Time of Form
            System.out.print("Enter Time of Form: ");
            int TimeOfForm = scanner.nextInt();


            // Save Data, name of Form, Teacher Of Form , Time of Form.



            Employeeforms employeeforms = new Employeeforms(0,NameOfForm , TeachersOfForm, TimeOfForm);
            employeeformsDao.save(employeeforms);

        }

    public static void EditeFormByID(String[]args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Edite Form -----------------");
        // ANSI color codes for different colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";

        // Print colored text
        System.out.println(ANSI_YELLOW + "!!! If the models do not exist in the database, nothing will happen !!!" + ANSI_RESET);
        // ID of Form
        System.out.print("Enter ID of Form : ");
        int returnID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name of Form : ");
        String NameOfForm = scanner.nextLine();

        // Teacher Of Form
        System.out.print("Enter Teacher Of Form : ");
        String TeachersOfForm = scanner.nextLine();

        // Time of Form
        System.out.print("Enter Time of Form: ");
        int TimeOfForm = scanner.nextInt();
        scanner.nextLine();

        // Save Data, name of Form, Teacher Of Form , Time of Form.
        EmployeeformsDao employeeformsDao = new EmployeeformsDaolmpl();


        Employeeforms employeeforms = new Employeeforms(returnID,NameOfForm , TeachersOfForm, TimeOfForm);
        employeeformsDao.save(employeeforms);
    }
    public static void viewForms(String[]args) {
        EmployeeformsDao employeeformsDao = new EmployeeformsDaolmpl();
        System.out.println("\n-------------------------------------------------\n");
        employeeformsDao.findAll().forEach(System.out::println);
        System.out.println("\n-------------------------------------------------\n");
    }
    public static void searchFormsById(int idToSearch) {
        EmployeeformsDao employeeformsDao = new EmployeeformsDaolmpl();
        Employeeforms eap = employeeformsDao.findById(idToSearch);
        System.out.println(eap);

    }
    public static void DeleteFormsData(String[] args) {
        EmployeeformsDao employeeformsDao = new EmployeeformsDaolmpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID : ");
        int deletbyid = scanner.nextInt();

        employeeformsDao.deleteById(deletbyid);

    }

    /// Students ///
    // add student //
    public static void SaveStudentData(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Student -----------------");
        // variable Firstname
        System.out.print("Enter your Firstname : ");
        String Firstname = scanner.nextLine();

        // variable Surname
        System.out.print("Enter your Surname : ");
        String Surname = scanner.nextLine();

        // variable Age
        System.out.print("how old are you : ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // variable City
        System.out.print("Where are you from : ");
        String city = scanner.nextLine();

        // variable Fields
        System.out.print("Enter Fields of Student : ");
        String Fields = scanner.nextLine();
        EmployeestudentDao employeestudentDao = new EmployeestudentDaolmpl();

        Employeestudent employeestudent = new Employeestudent(0,Firstname , Surname, city, Fields, age);
        employeestudentDao.save(employeestudent);
    }
    // view all Data of Students //
    public static void viewStudentData(String[] args) {
        System.out.println("----------------- View all Student -----------------");
        EmployeestudentDao employeestudentDao = new EmployeestudentDaolmpl();
        employeestudentDao.findAll().forEach(System.out::println);
    }
    // Search about Students by ID: //
    public static void searchStudentById(int idToSearch) {
        EmployeestudentDao employeestudentDao = new EmployeestudentDaolmpl();
        Employeestudent eap = employeestudentDao.findById(idToSearch);
        System.out.println(eap);

    }
    // Delete Data of Students //
    public static void DeleteStudentData() {
        EmployeestudentDao employeestudentDao = new EmployeestudentDaolmpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID : ");
        int deletbyid = scanner.nextInt();

        employeestudentDao.deleteById(deletbyid);
    }
    // Updated Data of Students //
    public static void UpdatedDataOfStudent(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Edite Data of Student -----------------");
        // ANSI color codes for different colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";

        // Print colored text
        System.out.println(ANSI_YELLOW + "!!! If the models do not exist in the database, nothing will happen !!!" + ANSI_RESET);
        // ID of Form
        System.out.print("Enter ID of Form : ");
        int returnID = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Firstname of Form : ");
        String Firstname = scanner.nextLine();

        // Teacher Of Form
        System.out.print("Enter Surname Of Form : ");
        String Surname = scanner.nextLine();

        // Teacher Of Form
        System.out.print("Enter city Of Form : ");
        String city = scanner.nextLine();

        // Teacher Of Form
        System.out.print("Enter fields Of Form : ");
        String fields = scanner.nextLine();

        // Time of Form
        System.out.print("Enter age of Form: ");
        int age = scanner.nextInt();
        scanner.nextLine();


        EmployeestudentDao employeestudentDao = new EmployeestudentDaolmpl();

        Employeestudent employeestudent = new Employeestudent(returnID,Firstname , Surname, city, fields, age);
        employeestudentDao.save(employeestudent);
    }
    /// Return to menu ///
    public static void returnmenu(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n1:menu\n2:Logout");
        System.out.print("Enter what you want : ");
        int AddNewData = scanner.nextInt();
        if(AddNewData == 1){
            main(args);
        }else{
            System.out.println("Exiting program.");
        }
    }

    /// Teachers ///
    // Add New Teacher //
    public static void SaveTeachersData(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Teacher -----------------");
        // variable Firstname of teacher
        System.out.print("Enter the teacher's First Name : ");
        String Firstnameofteacher = scanner.nextLine();

        // variable Surname of teacher
        System.out.print("Enter the teacher's Surname : ");
        String Surnameofteacher = scanner.nextLine();

        // variable City of teacher
        System.out.print("Enter where the teacher was born : ");
        String cityofteacher = scanner.nextLine();

        // variable Age of teacher
        System.out.print("Enter the teacher's age : ");
        int ageofteacher = scanner.nextInt();





        EmployeeteachersDao employeeteachersDao = new EmployeeteachersDaolmpl();

        Employeeteachers employeeteachers = new Employeeteachers(0,Firstnameofteacher , Surnameofteacher, cityofteacher, ageofteacher);
        employeeteachersDao.save(employeeteachers);


    }
    // Updated Data of Students //
    public static void UpdatedDataOfTeachers(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Edite Data of Student -----------------");
        // ANSI color codes for different colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";

        // Print colored text
        System.out.println(ANSI_YELLOW + "!!! If the models do not exist in the database, nothing will happen !!!" + ANSI_RESET);
        // ID of Form
        System.out.print("Enter ID of Form : ");
        int returnID = scanner.nextInt();
        scanner.nextLine();

        // variable Firstname of teacher
        System.out.print("Enter the teacher's First Name : ");
        String Firstnameofteacher = scanner.nextLine();

        // variable Surname of teacher
        System.out.print("Enter the teacher's Surname : ");
        String Surnameofteacher = scanner.nextLine();

        // variable Age of teacher
        System.out.print("Enter the teacher's age : ");
        int ageofteacher = scanner.nextInt();

        // variable City of teacher
        System.out.print("Enter where the teacher was born : ");
        String cityofteacher = scanner.nextLine();


        EmployeeteachersDao employeeteachersDao = new EmployeeteachersDaolmpl();

        Employeeteachers employeeteachers = new Employeeteachers(returnID,Firstnameofteacher , Surnameofteacher, cityofteacher, ageofteacher);
        employeeteachersDao.save(employeeteachers);
    }
    // View Teachers //
    public static void viewTeachersData(String[] args) {
        System.out.println("----------------- View all Teachers -----------------");
        EmployeeteachersDao employeeteachersDao = new EmployeeteachersDaolmpl();
        employeeteachersDao.findAll().forEach(System.out::println);
    }
    // Search about Teachers by ID //
    public static void searchTeachersById(int idToSearch) {
        EmployeeteachersDao employeeteachersDao = new EmployeeteachersDaolmpl();
        Employeeteachers eap = employeeteachersDao.findById(idToSearch);
        System.out.println(eap);
    }
    // Delete Data of Students //
    public static void DeleteTeachersData() {
        EmployeeteachersDao employeeteachersDao = new EmployeeteachersDaolmpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID : ");
        int deletbyid = scanner.nextInt();

        employeeteachersDao.deleteById(deletbyid);

    }

    /// Modules ///

    // Add New Modules //
    public static void SaveModulesData(String[] args) {
        ModuleDao moduleDao = new ModuleDaolmpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Add new Modules -----------------");

        // name of Form
        System.out.print("Enter name of Modules : ");
        String NameOfModules = scanner.nextLine();

        // forms Of Modules
        System.out.print("Enter first Form : ");
        String formsOfModules1 = scanner.nextLine();

        System.out.print("Enter second Form : ");
        String formsOfModules2 = scanner.nextLine();

        System.out.print("Enter Third Form : ");
        String formsOfModules3 = scanner.nextLine();



        Module module = new Module(0,NameOfModules , formsOfModules1, formsOfModules2, formsOfModules3);
        moduleDao.save(module);


    }

    public static void EditeModulesByID(int idToSearch) {
        ModuleDao moduleDao = new ModuleDaolmpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Edite Modules -----------------");
        // ANSI color codes for different colors
        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";

        // Print colored text
        System.out.println(ANSI_YELLOW + "!!! If the models do not exist in the database, nothing will happen !!!" + ANSI_RESET);

        Module eap = moduleDao.findById(idToSearch);
        System.out.println(eap);

        // name of Form
        System.out.print("Enter name of Modules : ");
        String NameOfModules = scanner.nextLine();

        // forms Of Modules
        System.out.print("Enter first Form : ");
        String formsOfModules1 = scanner.nextLine();

        System.out.print("Enter second Form : ");
        String formsOfModules2 = scanner.nextLine();

        System.out.print("Enter Third Form : ");
        String formsOfModules3 = scanner.nextLine();



        Module module = new Module(idToSearch,NameOfModules , formsOfModules1, formsOfModules2, formsOfModules3);
        moduleDao.save(module);
    }
    // View  Modules //
    public static void ViewModulesData(String[] args){
        ModuleDao moduleDao = new ModuleDaolmpl();
        System.out.println("----------------- All Modules -----------------");
        moduleDao.findAll().forEach(System.out::println);
        System.out.println("\n-------------------------------------------------\n");
    }

    // Search about Modules by ID //
    public static void searchModulesById(int idToSearch) {
        ModuleDao moduleDao = new ModuleDaolmpl();
        Module eap = moduleDao.findById(idToSearch);
        System.out.println(eap);
    }
    // Delete Data of Students //
    public static void DeleteModulesData() {
        ModuleDao moduleDao = new ModuleDaolmpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID : ");
        int deletbyid = scanner.nextInt();

        moduleDao.deleteById(deletbyid);
        System.out.print("Done");
    }

    // log Up

    public static void saveDataOfuser(String[] args) {
        LogupDao logupDao = new LogupDaolmpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("----------------- Log UP -----------------");

        // name
        System.out.print("name  : ");
        String name = scanner.nextLine();

        //
        System.out.print("email : ");
        String email = scanner.nextLine();

        System.out.print("password : ");
        String password = scanner.nextLine();

        System.out.print("rapet password : ");
        String repatpassword  = scanner.nextLine();

        if (Objects.equals(password, repatpassword)){
            Logup logup = new Logup(0,name , email, password);
            logupDao.save(logup);
            System.out.println("Done.");
        }else {
            System.out.println("the password is not some");
        }


    }

}


