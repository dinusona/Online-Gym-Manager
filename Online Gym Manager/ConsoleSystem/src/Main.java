import java.lang.invoke.MutableCallSite;
import java.util.Scanner;

import static java.lang.System.out;

public class Main {
    public static void main(String[] args) {
        runMenu();
    }

    public static void runMenu() {
        Scanner sc = new Scanner(System.in);
        int choise1;
        do {
            out.println("\nTo Add a new Member to press 1");
            out.println("To delete a Member to press 2");
            out.println("To Print the list of members to press 3");
            out.println("To Sort the item to press 4");
            out.println("To save database to press 5");
            out.println("To exit press 6");
            out.print("> ");
            while (!sc.hasNextInt()) {
                sc.next();
                out.println("- Invalid Input!! -");
                out.print("Re Enter Valid Input:\n");
            }
            choise1 = sc.nextInt();
            switch (choise1) {
                case 1:
                    addMember();
                    break;
                case 2:
                    deleteMember();
                    break;
                case 3:
                    printListOfMembers();
                    break;
                case 4:
                    sort();
                    break;
                case 5:
                    saveDataAsTextFile();
                    break;
                case 6:
                    exite();
                    break;
            }

        } while (choise1 > 1 || choise1 < 4);
    }

    public static void addMember() {
        Scanner sc1 = new Scanner(System.in);
//        out.println("Add method running");
        int count;
        int maxCount = 100;

        out.println("Press 1 if you want to add a Student Member");
        out.println("Press 2 if you want to add a Over 60 Member");
        while (!sc1.hasNextInt()) {
            sc1.next();
            out.println("- Invalid Input!! -");
            out.print("Re Enter Valid Input:\n");
        }

        int choise2 = sc1.nextInt();
        //get car inputs
        switch (choise2) {
            case 1:
                out.println("enter Member ID");

                String inputMemID = sc1.next();

                out.println("enter Member Name");

                String inputMemName = sc1.next();

                out.println("enter Member hight:");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputMemHight = sc1.nextInt();

                out.println("enter Member Weight:");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputMemWeight = sc1.nextInt();

                System.out.println("enter nearest Branch name");
                String inputMemnearestBranchName = sc1.next();

                out.println("enter Membership Number:");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputMemMembershipNumber = sc1.nextInt();

                out.println("enter start Membership date :");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputMemStartMembershipDate = sc1.nextInt();

                System.out.println("enter school name");
                String inputMemSchoolName = sc1.next();


                StudentMember studentMemberObj = new StudentMember(inputMemID, inputMemName, inputMemHight, inputMemWeight, inputMemnearestBranchName, inputMemMembershipNumber, inputMemStartMembershipDate, inputMemSchoolName);
                MyGymManager gymManagerObj = new MyGymManager();
                gymManagerObj.addStudentMember(studentMemberObj);
                gymManagerObj.viewMemberCount();

                break;
            case 2:
                out.println("enter Member ID");

                String inputOver60MemID = sc1.next();
                out.println("enter Member Name");

                String inputOver60MemName = sc1.next();

                out.println("enter Member hight:");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputOver60Hight = sc1.nextInt();

                out.println("enter Member Weight:");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputOver60Weight = sc1.nextInt();

                System.out.println("enter nearest Branch name");
                String inputOver60NearestBranchName = sc1.next();

                out.println("enter Membership Number:");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputMemOver60BershipNumber = sc1.nextInt();

                out.println("enter start Membership date :");
                while (!sc1.hasNextInt()) {
                    sc1.next();
                    out.print("- Please Enter Valid Integer Input only -\n");
                }
                int inputMemStartOver60MembershipDate = sc1.nextInt();

                System.out.println("enter Age of the member :");
                String inputOver60Age = sc1.next();

                Over60Member Over60Obj = new Over60Member(inputOver60MemID, inputOver60MemName, inputOver60Hight, inputOver60Weight, inputOver60NearestBranchName, inputMemOver60BershipNumber, inputMemStartOver60MembershipDate, inputOver60Age);
                MyGymManager gymManagerObjForOver60 = new MyGymManager();
                gymManagerObjForOver60.addOver60Member(Over60Obj);
                gymManagerObjForOver60.viewMemberCount();

                break;

        }

    }

    public static void deleteMember() {
        Scanner sc2 = new Scanner(System.in);
        out.println("Press 1 if you want to delete a Student member Details");
        out.println("Press 2 if you want to delete a over 60 member Details");
        while (!sc2.hasNextInt()) {
            sc2.next();
            out.println("- Invalid Input!! -");
            out.print("Re Enter Valid Input:\n");
        }
        int choise3 = sc2.nextInt();

        switch (choise3) {
            case 1:

                out.println("enter MemberID you want to delete");
//                while (!sc2.hasNextInt()) {
//                    sc2.next();
//                    out.print("- please enter valid plate number -\n");
//                }
                String studentMemberID = sc2.next();

                MyGymManager myGymManager1 = new MyGymManager();
                myGymManager1.deleteVehicle(studentMemberID, "student");
                myGymManager1.viewMemberCount();
                break;
            case 2:

                out.println("enter MemberID you want to delete");
//                while (!sc2.hasNextInt()) {
//                    sc2.next();
//                    out.print("- please enter valid plate number -\n");
//                }
                String over60MemberID = sc2.next();

                MyGymManager myGymManager2 = new MyGymManager();
                myGymManager2.deleteVehicle(over60MemberID, "over60");
                myGymManager2.viewMemberCount();
                break;
        }
    }

    public static void printListOfMembers() {
        Scanner sc3 = new Scanner(System.in);
        out.println("Press 1 if you want to view Student Details table");
        out.println("Press 2 if you want to view over 60 member Details table");
        while (!sc3.hasNextInt()) {
            sc3.next();
            out.println("- Invalid Input!! -");
            out.print("Re Enter Valid Input:\n");
        }
        int choise4 = sc3.nextInt();

        switch (choise4) {
            case 1:

                MyGymManager myGymManager3=new MyGymManager();
                myGymManager3.printListOfStudentMembers();

                break;
            case 2:

                MyGymManager myGymManager4=new MyGymManager();
                myGymManager4.printListOfOver60Members();


                break;
        }


    }

    public static void sort() {
        Scanner sc4 = new Scanner(System.in);
        out.println("Press 1 if you want to sort Student Details in ascending order according to the name");
        out.println("Press 2 if you want to sort over 60 member Details in ascending order according to the name");
        while (!sc4.hasNextInt()) {
            sc4.next();
            out.println("- Invalid Input!! -");
            out.print("Re Enter Valid Input:\n");
        }
        int choise4 = sc4.nextInt();

        switch (choise4) {
            case 1:

                MyGymManager myGymManager5=new MyGymManager();
                myGymManager5.sortStudentMembers();

                break;
            case 2:

                MyGymManager myGymManager6=new MyGymManager();
                myGymManager6.sortOver60Members();


                break;
        }
    }

    public static void saveDataAsTextFile() {
        MyGymManager myGymManager5=new MyGymManager();
        myGymManager5.saveData();
        out.println("Data saved as text file!!!");
    }

    public static void exite() {
        out.println("you successfully exited!!! ");
        System.exit(0);
    }
}