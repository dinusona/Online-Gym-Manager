import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import static java.lang.System.err;

public class MyGymManager implements GymManager {

    private Object Connection;

    @Override
    public void addStudentMember(StudentMember studentMember) {
        try {
            Connection conn = dbConnection.createConnection();
            String query = "insert into studentMemberDetails (memberID,studentMemName,studentMemHight,studentMemWeight,studentMemNearBranch,studentMemMembershipNumber,studentMemMembershipStartDate,studentMemSchoolName) " + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, studentMember.getMemberID());
            preparedStatement.setString(2, studentMember.getName());
            preparedStatement.setInt(3, studentMember.getHight());
            preparedStatement.setInt(4, studentMember.getWeight());
            preparedStatement.setString(5, studentMember.getNearestBranchName());
            preparedStatement.setInt(6, studentMember.getMembershipNumber());
            preparedStatement.setInt(7, studentMember.getStartMembershipDate());
            preparedStatement.setString(8, studentMember.getSchoolName());


            preparedStatement.execute();
            conn.close();
            System.out.println("~ Student details added to DB ~");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("error" + e.getMessage());
        }
    }

    @Override
    public void addOver60Member(Over60Member over60Member) {
        try {
            Connection conn = dbConnection.createConnection();
            String query = "insert into over60MemberDetails (memberID,over60MemName,over60MemHight,over60MemWeight,over60MemNearestBranchName,over60MemMembershipNumber,over60MemMembershipStartDate,over60MemAge) " + "values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(query);

            preparedStatement.setString(1, over60Member.getMemberID());
            preparedStatement.setString(2, over60Member.getName());
            preparedStatement.setInt(3, over60Member.getHight());
            preparedStatement.setInt(4, over60Member.getWeight());
            preparedStatement.setString(5, over60Member.getNearestBranchName());
            preparedStatement.setInt(6, over60Member.getMembershipNumber());
            preparedStatement.setInt(7, over60Member.getStartMembershipDate());
            preparedStatement.setString(8, over60Member.getAge());


            preparedStatement.execute();
            conn.close();
            System.out.println("~ Over 60 Member details added to DB ~");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("error" + e.getMessage());
        }
    }

    @Override
    public void deleteVehicle(String memberID, String type) {
        if (type.equals("student")) {
            try {

                Connection conn = dbConnection.createConnection();

                // create the mysql delete statement.
                String query = "delete from studentMemberDetails where memberID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, memberID);

                preparedStmt.execute();

                conn.close();
                System.out.println("~ Student member Details Delete from DB ~");

            } catch (Exception e) {
                err.println("Got an exception! ");
                err.println(e.getMessage());
            }
        } else {
            try {

                Connection conn = dbConnection.createConnection();

                // create the mysql delete statement.
                String query = "delete from over60MemberDetails where memberID = ?";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, memberID);

                // execute the preparedstatement
                preparedStmt.execute();

                conn.close();
                System.out.println("~ over 60 member Details Delete from DB ~");

            } catch (Exception e) {
                err.println("Got an exception! ");
                err.println(e.getMessage());
            }
        }
    }

    @Override
    public void printListOfStudentMembers() {
        System.out.println(" Student member table viewing");
        try {
            try {

                String query2 = "SELECT studentMemMembershipNumber, studentMemMembershipStartDate, studentMemName  FROM studentMemberDetails ";
                Connection conn = dbConnection.createConnection();

                Statement st = conn.createStatement();


                ResultSet getFromStudentDetailsTbl = st.executeQuery(query2);
                System.out.println("Student Meber Details Table ");
                System.out.println("--------");
                while (getFromStudentDetailsTbl.next()) {
                    System.out.println("Student member membership number : " + getFromStudentDetailsTbl.getInt("studentMemMembershipNumber"));
                    System.out.println("Student member membership start date : " + getFromStudentDetailsTbl.getInt("studentMemMembershipStartDate"));
                    System.out.println("Student member name : " + getFromStudentDetailsTbl.getString("studentMemName"));

//                    System.out.println("Student member ID : " + getFromStudentDetailsTbl.getString("memberID"));
//                    System.out.println("Student member Hight : " + getFromStudentDetailsTbl.getInt("studentMemHight"));
//                    System.out.println("Student member Weight : " + getFromStudentDetailsTbl.getInt("studentMemWeight"));
//                    System.out.println("Student member nearest branch : " + getFromStudentDetailsTbl.getString("studentMemNearBranch"));
//                    System.out.println("Student member school : " + getFromStudentDetailsTbl.getString("studentMemSchoolName"));

                    System.out.println("-----------");
                }

            } catch (Exception e) {
                System.err.println("Got an exception!(wrong inputs)");
                System.err.println(e.getMessage());
            }


        } catch (Exception e) {
            err.println("Got an exception! ");
            err.println(e.getMessage());
        }

    }

    @Override
    public void printListOfOver60Members() {
        System.out.println(" over 60 member table viewing");
        try {
            try {

                String query2 = "SELECT over60MemMembershipNumber, over60MemMembershipStartDate, over60MemName FROM over60MemberDetails";
                Connection conn = dbConnection.createConnection();

                Statement st = conn.createStatement();


                ResultSet getFromStudentDetailsTbl = st.executeQuery(query2);
                System.out.println("Over 60 Member Details Table ");
                System.out.println("--------");
                while (getFromStudentDetailsTbl.next()) {
                    System.out.println("Over 60 member membership number : " + getFromStudentDetailsTbl.getInt("over60MemMembershipNumber"));
                    System.out.println("Over 60 member membership start date : " + getFromStudentDetailsTbl.getInt("over60MemMembershipStartDate"));
                    System.out.println("Over 60 member name : " + getFromStudentDetailsTbl.getString("over60MemName"));

//                    System.out.println("Over 60 member ID : " + getFromStudentDetailsTbl.getString("memberID"));
//                    System.out.println("Over 60 member Hight : " + getFromStudentDetailsTbl.getInt("over60MemHight"));
//                    System.out.println("Over 60 member Weight : " + getFromStudentDetailsTbl.getInt("over60MemWeight"));
//                    System.out.println("Over 60 member nearest branch : " + getFromStudentDetailsTbl.getString("over60MemNearestBranchName"));
//                    System.out.println("Over 60 member Age : " + getFromStudentDetailsTbl.getInt("over60MemAge"));

                    System.out.println("-----------");
                }

            } catch (Exception e) {
                System.err.println("Got an exception!(wrong inputs)");
                System.err.println(e.getMessage());
            }


        } catch (Exception e) {
            err.println("Got an exception! ");
            err.println(e.getMessage());
        }

    }

    @Override
    public void viewMemberCount() {
        int memberCount = 0;

        try {
            try {

                String query8 = "SELECT COUNT(*)FROM studentMemberDetails UNION SELECT COUNT(*) FROM over60MemberDetails";
                Connection conn = dbConnection.createConnection();

                Statement st = conn.createStatement();


                ResultSet getCountFromTables = st.executeQuery(query8);
                while (getCountFromTables.next()) { //recieving ID
                    memberCount = getCountFromTables.getInt(1);
                }
                if (memberCount < 100) {
                    System.out.println((100 - memberCount) + " Member count is going out of 100");
                } else {
                    System.out.println("Maximum member Count reached.if you want to add more please delete members!");
                    Main.runMenu();


                }


            } catch (Exception e) {
                System.err.println("Got an exception!(wrong inputs)");
                System.err.println(e.getMessage());
            }

        } catch (Exception e) {
            err.println("Got an exception! ");
            err.println(e.getMessage());
        }
    }
        @Override
        public void sortStudentMembers () {
            System.out.println(" Student member table viewing");
            try {
                try {

                    String query2 = "SELECT * FROM studentMemberDetails ORDER BY studentMemName ASC";
                    Connection conn = dbConnection.createConnection();

                    Statement st = conn.createStatement();


                    ResultSet getFromStudentDetailsTbl = st.executeQuery(query2);
                    System.out.println("Student Meber Details Table ");
                    System.out.println("--------");
                    while (getFromStudentDetailsTbl.next()) {
                        System.out.println("Student member membership number : " + getFromStudentDetailsTbl.getInt("studentMemMembershipNumber"));
                        System.out.println("Student member membership start date : " + getFromStudentDetailsTbl.getInt("studentMemMembershipStartDate"));
                        System.out.println("Student member name : " + getFromStudentDetailsTbl.getString("studentMemName"));

                        System.out.println("Student member ID : " + getFromStudentDetailsTbl.getString("memberID"));
                        System.out.println("Student member Hight : " + getFromStudentDetailsTbl.getInt("studentMemHight"));
                        System.out.println("Student member Weight : " + getFromStudentDetailsTbl.getInt("studentMemWeight"));
                        System.out.println("Student member nearest branch : " + getFromStudentDetailsTbl.getString("studentMemNearBranch"));
                        System.out.println("Student member school : " + getFromStudentDetailsTbl.getString("studentMemSchoolName"));

                        System.out.println("-----------");
                    }

                } catch (Exception e) {
                    System.err.println("Got an exception!(wrong inputs)");
                    System.err.println(e.getMessage());
                }


            } catch (Exception e) {
                err.println("Got an exception! ");
                err.println(e.getMessage());
            }
        }

        @Override
        public void sortOver60Members () {
            System.out.println(" over 60 member table viewing");
            try {
                try {

                    String query2 = "SELECT * FROM over60MemberDetails ORDER BY over60MemName ASC";
                    Connection conn = dbConnection.createConnection();

                    Statement st = conn.createStatement();


                    ResultSet getFromStudentDetailsTbl = st.executeQuery(query2);
                    System.out.println("Over 60 Member Details Table ");
                    System.out.println("--------");
                    while (getFromStudentDetailsTbl.next()) {
                        System.out.println("Over 60 member membership number : " + getFromStudentDetailsTbl.getInt("over60MemMembershipNumber"));
                        System.out.println("Over 60 member membership start date : " + getFromStudentDetailsTbl.getInt("over60MemMembershipStartDate"));
                        System.out.println("Over 60 member name : " + getFromStudentDetailsTbl.getString("over60MemName"));

                        System.out.println("Over 60 member ID : " + getFromStudentDetailsTbl.getString("memberID"));
                        System.out.println("Over 60 member Hight : " + getFromStudentDetailsTbl.getInt("over60MemHight"));
                        System.out.println("Over 60 member Weight : " + getFromStudentDetailsTbl.getInt("over60MemWeight"));
                        System.out.println("Over 60 member nearest branch : " + getFromStudentDetailsTbl.getString("over60MemNearestBranchName"));
                        System.out.println("Over 60 member Age : " + getFromStudentDetailsTbl.getInt("over60MemAge"));

                        System.out.println("-----------");
                    }

                } catch (Exception e) {
                    System.err.println("Got an exception!(wrong inputs)");
                    System.err.println(e.getMessage());
                }


            } catch (Exception e) {
                err.println("Got an exception! ");
                err.println(e.getMessage());
            }

        }

        @Override
        public void saveData () {

            try {
                String query3 = "SELECT * FROM studentMemberDetails";

                Connection conn = dbConnection.createConnection();
                Statement st = conn.createStatement();

                ResultSet result = st.executeQuery(query3);


                FileWriter writer = new FileWriter("studentMemberDetails.txt", false);
                while (result.next()) {
                    String fileString = "Student member membership number : " + result.getInt("studentMemMembershipNumber")
                            + "  Student member membership start date : " + result.getInt("studentMemMembershipStartDate")
                            + "  Student member name : " + result.getString("studentMemName")
                            + "  Student member ID :" + result.getString("memberID")
                            + "  Student member Hight : " + result.getInt("studentMemHight")
                            + "  Student member Weight : " + result.getInt("studentMemWeight")
                            + "  Student member nearest branch : " + result.getString("studentMemWeight")
                            + "  Student member school : " + result.getString("studentMemSchoolName");
                    writer.write(fileString);
                    writer.write("\r\n");
                }
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                String query3 = "SELECT * FROM over60MemberDetails";
                Connection conn = dbConnection.createConnection();
                Statement st = conn.createStatement();

                ResultSet result = st.executeQuery(query3);


                FileWriter writer = new FileWriter("over60MemberDetails.txt", false);
                while (result.next()) {
                    String fileString = "Over 60 member membership number : " + result.getInt("over60MemMembershipNumber")
                            + "  Over 60 member membership start date : " + result.getInt("over60MemMembershipStartDate")
                            + "  Over 60 member name : " + result.getString("over60MemName")
                            + "  Over 60 member ID : " + result.getString("memberID")
                            + "  Over 60 member Hight : " + result.getInt("over60MemHight")
                            + "  Over 60 member Weight : " + result.getInt("over60MemWeight")
                            + "  Over 60 member nearest branch : " + result.getString("over60MemNearestBranchName")
                            + "  Over 60 member Age : " + result.getInt("over60MemAge");
                    writer.write(fileString);
                    writer.write("\r\n");
                }
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }

//    public void Availability(){
//        int memberList = 0;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, user, password);
//            Statement myStat = conn.createStatement();
//            String code = "select count(*) from members";
//
//            ResultSet rs = myStat.executeQuery(code);
//            while (rs.next()) { //recieving ID
//                memberList = rs.getInt(1);
//            }
//            if (memberList< 100) {
//                System.out.println((100 - memberList) + " slots remaining out of 100");
//            }else{
//                System.out.println("Maximum member limit reached. Delete members to add more");
//                Main.MainMenue();
//            }
//        }catch (SQLException e) {
//
//            e.printStackTrace();
//        }
//        catch (ClassNotFoundException | NullPointerException e) {
//            e.printStackTrace();
//        }
//    }