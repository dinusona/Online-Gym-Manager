package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


import javafx.scene.control.Button;


import java.sql.*;
import java.time.LocalDate;

public class MainInterface extends Application {


    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        window=primaryStage;
//
//        Label label1=new Label("Welcome to 1st Scene!!!");
//        Button button1=new Button("Go to scene 2");
//        button1.setOnAction(e -> window.setScene(scene2));
//
//        //Layout1
//        VBox layout1=new VBox(20);
//        layout1.getChildren().addAll(label1,button1);
//        scene1= new Scene(layout1,200,200);
//
//        //button 2
//        Button button2=new Button("Go back to scene 1");
//        button2.setOnAction(e -> window.setScene(scene1));
//
//        //layout2
//        StackPane layout2=new StackPane();
//        layout2.getChildren().add(button2);
//        scene2=new Scene(layout2,600,300);
//
//        window.setScene(scene1);
//        window.setTitle("KDS");
//        window.show();


        primaryStage.setTitle("Online Gym Management System");
        //creating pane for main UI
        Pane rootForMainUI = new Pane();

        Label lableForMainName = new Label("Gym Management System");
        lableForMainName.setId("mainLableNameCss");
        rootForMainUI.getChildren().add(lableForMainName);
        lableForMainName.setLayoutX(50);
        lableForMainName.setLayoutY(20);

        //creating the btn for view list of details
        Button btnForViewTables = new Button();
        btnForViewTables.setId("mainBtnCss");
        btnForViewTables.setText("View the lit of member Details");
        btnForViewTables.setLayoutX(133);
        btnForViewTables.setLayoutY(100);
        rootForMainUI.getChildren().add(btnForViewTables);

        Button btnForSearch = new Button();
        btnForSearch.setId("mainBtnCss");
        btnForSearch.setText("Search the member details");
        btnForSearch.setLayoutX(140);
        btnForSearch.setLayoutY(160);
        rootForMainUI.getChildren().add(btnForSearch);

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //creating pane for view the details of members
        Pane rootForViewTables = new Pane();
        Scene sceneForViewDetailsTables = new Scene(rootForViewTables, 1275, 600);

        String cssFile4 = this.getClass().getResource("Style.css").toExternalForm();
        rootForViewTables.getStylesheets().add(cssFile4);

        btnForViewTables.setOnAction(e -> primaryStage.setScene(sceneForViewDetailsTables));

        Button backBtn1 = new Button();
        backBtn1.setId("btnCss");
        backBtn1.setText("Back to Home");
        backBtn1.setLayoutX(595);
        backBtn1.setLayoutY(550);
        rootForViewTables.getChildren().add(backBtn1);

        //label for show wich tables
        Label lblForStudent = new Label("Student Member Details Table");
        lblForStudent.setId("cssForNameOfTable");
        rootForViewTables.getChildren().add(lblForStudent);
        lblForStudent.setLayoutX(150);
        lblForStudent.setLayoutY(50);

        Label lblForOver60 = new Label("Over 60 Member Details Table");
        lblForOver60.setId("cssForNameOfTable");
        rootForViewTables.getChildren().add(lblForOver60);
        lblForOver60.setLayoutX(770);
        lblForOver60.setLayoutY(50);


//        Button btnForShowOver60Details = new Button();
//        btnForShowOver60Details.setText("Show Over 60 member Details Table");
//        btnForShowOver60Details.setLayoutX(140);
//        btnForShowOver60Details.setLayoutY(180);
//        rootForSelectMemberCato.getChildren().add(btnForShowOver60Details);
//
//        //back btn for second scene
//        Button backBu1 = new Button();
//        backBu1.setText("Back to Home");
//        backBu1.setLayoutX(950);
//        backBu1.setLayoutY(1200);
//        rootForViewTables.getChildren().add(backBu1);

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------


//        //set another 2 panes for view member details
//        Pane rootForViewStudentMemberDetails = new Pane();
//        Scene sceneForViewStudentMemberDetails = new Scene(rootForViewStudentMemberDetails, 450, 350);
//
//        btnForShowStudentDetails.setOnAction(e -> primaryStage.setScene(sceneForViewStudentMemberDetails));
//
//        Label lableForViewStudentDetails = new Label("Student Details");
//        rootForViewStudentMemberDetails.getChildren().add(lableForViewStudentDetails);
//        lableForViewStudentDetails.setLayoutX(140);
//        lableForViewStudentDetails.setLayoutY(20);
//
//        //back btn for view student details
//        Button backBtnForViewStuDtls = new Button();
//        backBtnForViewStuDtls.setText("Back to Home");
//        backBtnForViewStuDtls.setLayoutX(250);
//        backBtnForViewStuDtls.setLayoutY(280);
//        rootForViewStudentMemberDetails.getChildren().add(backBtnForViewStuDtls);
//
//        Pane rootForViewOver60MemberDetails = new Pane();
//        Scene sceneForViewOver60MemberDetails = new Scene(rootForViewOver60MemberDetails, 450, 350);
//
//        btnForShowOver60Details.setOnAction(e -> primaryStage.setScene(sceneForViewOver60MemberDetails));
//
//        Label lableForViewOver60Member = new Label("Over60 Member Details");
//        rootForViewOver60MemberDetails.getChildren().add(lableForViewOver60Member);
//        lableForViewOver60Member.setLayoutX(140);
//        lableForViewOver60Member.setLayoutY(20);
//
//        //back btn for view student details
//        Button backBtnForViewOver60Dtls = new Button();
//        backBtnForViewOver60Dtls.setText("Back to Home");
//        backBtnForViewOver60Dtls.setLayoutX(250);
//        backBtnForViewOver60Dtls.setLayoutY(280);
//        rootForViewOver60MemberDetails.getChildren().add(backBtnForViewOver60Dtls);
////

        //view the tables

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //view the tables


        //studentMemberTable
        TableView studentMemberTable = new TableView();
        studentMemberTable.setMaxWidth(600);
        studentMemberTable.setMaxHeight(900);
        studentMemberTable.setLayoutX(30);
        studentMemberTable.setLayoutY(100);

        TableColumn<String, StudentMember> column1 = new TableColumn<>("memberID");
        column1.setMinWidth(50);
        column1.setCellValueFactory(new PropertyValueFactory<>("memberID"));


        TableColumn<String, StudentMember> column2 = new TableColumn<>("name");
        column2.setMinWidth(50);
        column2.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<String, StudentMember> column3 = new TableColumn<>("hight");
        column3.setMinWidth(50);
        column3.setCellValueFactory(new PropertyValueFactory<>("hight"));


        TableColumn<String, StudentMember> column4 = new TableColumn<>("weight");
        column4.setMinWidth(50);
        column4.setCellValueFactory(new PropertyValueFactory<>("weight"));


        TableColumn<String, StudentMember> column5 = new TableColumn<>("nearestBranchName");
        column5.setMinWidth(50);
        column5.setCellValueFactory(new PropertyValueFactory<>("nearestBranchName"));


        TableColumn<String, StudentMember> column6 = new TableColumn<>("membershipNumber");
        column6.setMinWidth(50);
        column6.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));


        TableColumn<String, StudentMember> column7 = new TableColumn<>("startMembershipDate");
        column7.setMinWidth(50);
        column7.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));


        TableColumn<String, StudentMember> column8 = new TableColumn<>("schoolName");
        column8.setMinWidth(50);
        column8.setCellValueFactory(new PropertyValueFactory<>("schoolName"));



        studentMemberTable.getColumns().add(column1);
        studentMemberTable.getColumns().add(column2);
        studentMemberTable.getColumns().add(column3);
        studentMemberTable.getColumns().add(column4);
        studentMemberTable.getColumns().add(column5);
        studentMemberTable.getColumns().add(column6);
        studentMemberTable.getColumns().add(column7);
        studentMemberTable.getColumns().add(column8);


        Connection conn = dbConnection.createConnection();
        ResultSet resultSetForStudent = conn.createStatement().executeQuery("SELECT * FROM studentMemberDetails");

        while (resultSetForStudent.next()) {
            studentMemberTable.getItems().add(new StudentMember(resultSetForStudent.getString("memberID"),
                    resultSetForStudent.getString("studentMemName"),
                    resultSetForStudent.getInt("studentMemHight"),
                    resultSetForStudent.getInt("studentMemWeight"),
                    resultSetForStudent.getString("studentMemNearBranch"),
                    resultSetForStudent.getInt("studentMemMembershipNumber"),
                    resultSetForStudent.getInt("studentMemMembershipStartDate"),
                    resultSetForStudent.getString("studentMemSchoolName")));
        }

        rootForViewTables.getChildren().add(studentMemberTable);
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //over60MemberDetails
        TableView over60MemberTable = new TableView();
        over60MemberTable.setMaxWidth(600);
        over60MemberTable.setMaxHeight(900);
        over60MemberTable.setLayoutX(650);
        over60MemberTable.setLayoutY(100);

        TableColumn<String, Over60Member> column01 = new TableColumn<>("memberID");
        column01.setMinWidth(50);
        column01.setCellValueFactory(new PropertyValueFactory<>("memberID"));


        TableColumn<String, Over60Member> column02 = new TableColumn<>("name");
        column02.setMinWidth(50);
        column02.setCellValueFactory(new PropertyValueFactory<>("name"));


        TableColumn<String, Over60Member> column03 = new TableColumn<>("hight");
        column03.setMinWidth(50);
        column03.setCellValueFactory(new PropertyValueFactory<>("hight"));


        TableColumn<String, Over60Member> column04 = new TableColumn<>("weight");
        column04.setMinWidth(50);
        column04.setCellValueFactory(new PropertyValueFactory<>("weight"));


        TableColumn<String, Over60Member> column05 = new TableColumn<>("nearestBranchName");
        column05.setMinWidth(50);
        column05.setCellValueFactory(new PropertyValueFactory<>("nearestBranchName"));


        TableColumn<String, Over60Member> column06 = new TableColumn<>("membershipNumber");
        column06.setMinWidth(50);
        column06.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));


        TableColumn<String, Over60Member> column07 = new TableColumn<>("startMembershipDate");
        column07.setMinWidth(50);
        column07.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));


        TableColumn<String, Over60Member> column08 = new TableColumn<>("age");
        column08.setMinWidth(50);
        column08.setCellValueFactory(new PropertyValueFactory<>("age"));



        over60MemberTable.getColumns().add(column01);
        over60MemberTable.getColumns().add(column02);
        over60MemberTable.getColumns().add(column03);
        over60MemberTable.getColumns().add(column04);
        over60MemberTable.getColumns().add(column05);
        over60MemberTable.getColumns().add(column06);
        over60MemberTable.getColumns().add(column07);
        over60MemberTable.getColumns().add(column08);


        ResultSet rs1 = conn.createStatement().executeQuery("SELECT * FROM over60MemberDetails");

        while (rs1.next()) {
            over60MemberTable.getItems().add(new Over60Member(rs1.getString("memberID"),
                    rs1.getString("over60MemName"),
                    rs1.getInt("over60MemHight"),
                    rs1.getInt("over60MemWeight"),
                    rs1.getString("over60MemNearestBranchName"),
                    rs1.getInt("over60MemMembershipNumber"),
                    rs1.getInt("over60MemMembershipStartDate"),
                    rs1.getString("over60MemAge")));
        }
        rootForViewTables.getChildren().add(over60MemberTable);

//-----------------------------------------------------------------------------------------------------------------------------------------------------------------
        //filter
        Pane rootForFilter = new Pane();
        rootForFilter.setId("rootViewTablecss");

        Scene sceneForViewFilter = new Scene(rootForFilter, 650, 600);

        String cssFile3 = this.getClass().getResource("Style.css").toExternalForm();
        rootForFilter.getStylesheets().add(cssFile3);

        btnForSearch.setOnAction(e -> primaryStage.setScene(sceneForViewFilter));

//        //back btn for second scene
//        Button backbtnForFilter = new Button();
//        backbtnForFilter.setText("Back to Home");
//        backbtnForFilter.setLayoutX(950);
//        backbtnForFilter.setLayoutX(650);
//        rootForFilter.getChildren().add(backBu1);

        Label takeWhichMember = new Label("Enter Student or Over60:");
        rootForFilter.getChildren().add(takeWhichMember);
        takeWhichMember.setLayoutX(50);
        takeWhichMember.setLayoutY(450);

        TextField textFieldForInput = new TextField();
        textFieldForInput.setLayoutX(200);
        textFieldForInput.setLayoutY(450);
        rootForFilter.getChildren().add(textFieldForInput);

        Label takeWhichCondition = new Label("Enter Condition:");
        rootForFilter.getChildren().add(takeWhichCondition);
        takeWhichCondition.setLayoutX(50);
        takeWhichCondition.setLayoutY(500);

        TextField textFielForConditionInput = new TextField();
        textFielForConditionInput.setLayoutX(200);
        textFielForConditionInput.setLayoutY(500);
        rootForFilter.getChildren().add(textFielForConditionInput);



        Button btnForFilter = new Button();
        btnForFilter.setText("View");
        btnForFilter.setId("btnCss");
        btnForFilter.setLayoutX(120);
        btnForFilter.setLayoutY(550);
        rootForFilter.getChildren().add(btnForFilter);


        Button backBtn2 = new Button();
        backBtn2.setText("Back to Home");
        backBtn2.setId("btnCss");
        backBtn2.setLayoutX(200);
        backBtn2.setLayoutY(550);
        rootForFilter.getChildren().add(backBtn2);

//        Pane rootFilterBikeTable = new Pane();
//        Scene sceneforFilterBikeTable = new Scene(rootFilterBikeTable, 1275, 600);
//
//        Pane rootFilterCarTable = new Pane();
//        Scene sceneforCarFilterTable = new Scene(rootFilterCarTable, 1275, 600);


        btnForFilter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                String textFieldforChoose1 = (textFieldForInput.getText());
                String textFieldModel1 = (textFielForConditionInput.getText());

                if (textFieldforChoose1.equals("student")) {


                    btnForFilter.setOnAction(e -> primaryStage.setScene(sceneForViewFilter));


                    TableView studentMemberFilterTableView = new TableView();
                    studentMemberFilterTableView.setMaxWidth(600);
                    studentMemberFilterTableView.setMaxHeight(900);
                    studentMemberFilterTableView.setLayoutX(30);
                    studentMemberFilterTableView.setLayoutY(30);

                    TableColumn<String, StudentMember> column10 = new TableColumn<>("memberID");
                    column10.setMinWidth(50);
                    column10.setCellValueFactory(new PropertyValueFactory<>("memberID"));


                    TableColumn<String, StudentMember> column20 = new TableColumn<>("name");
                    column20.setMinWidth(50);
                    column20.setCellValueFactory(new PropertyValueFactory<>("name"));


                    TableColumn<String, StudentMember> column30 = new TableColumn<>("hight");
                    column30.setMinWidth(50);
                    column30.setCellValueFactory(new PropertyValueFactory<>("hight"));


                    TableColumn<String, StudentMember> column40 = new TableColumn<>("weight");
                    column40.setMinWidth(50);
                    column40.setCellValueFactory(new PropertyValueFactory<>("weight"));


                    TableColumn<String, StudentMember> column50 = new TableColumn<>("nearestBranchName");
                    column50.setMinWidth(50);
                    column50.setCellValueFactory(new PropertyValueFactory<>("nearestBranchName"));


                    TableColumn<String, StudentMember> column60 = new TableColumn<>("membershipNumber");
                    column60.setMinWidth(50);
                    column60.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));


                    TableColumn<String, StudentMember> column70 = new TableColumn<>("startMembershipDate");
                    column70.setMinWidth(50);
                    column70.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));


                    TableColumn<String, StudentMember> column80 = new TableColumn<>("schoolName");
                    column80.setMinWidth(50);
                    column80.setCellValueFactory(new PropertyValueFactory<>("schoolName"));



                    studentMemberFilterTableView.getColumns().add(column10);
                    studentMemberFilterTableView.getColumns().add(column20);
                    studentMemberFilterTableView.getColumns().add(column30);
                    studentMemberFilterTableView.getColumns().add(column40);
                    studentMemberFilterTableView.getColumns().add(column50);
                    studentMemberFilterTableView.getColumns().add(column60);
                    studentMemberFilterTableView.getColumns().add(column70);
                    studentMemberFilterTableView.getColumns().add(column80);

                    Connection conn = null;
                    try {
                        conn = dbConnection.createConnection();
                        ResultSet resultSet3 = conn.createStatement().executeQuery("SELECT * FROM studentMemberDetails WHERE  studentMemNearBranch = '" + textFieldModel1 + "' ");

                        while (resultSet3.next()) {
                            studentMemberFilterTableView.getItems().add(new StudentMember(resultSet3.getString("memberID"),
                                    resultSet3.getString("studentMemName"),
                                    resultSet3.getInt("studentMemHight"),
                                    resultSet3.getInt("studentMemWeight"),
                                    resultSet3.getString("studentMemNearBranch"),
                                    resultSet3.getInt("studentMemMembershipNumber"),
                                    resultSet3.getInt("studentMemMembershipStartDate"),
                                    resultSet3.getString("studentMemSchoolName")));
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    rootForFilter.getChildren().add(studentMemberFilterTableView);


                } else if (textFieldforChoose1.equals("over60")) {

                    btnForFilter.setOnAction(e -> primaryStage.setScene(sceneForViewFilter));

                    TableView over60MemberFilterTableView = new TableView();
                    over60MemberFilterTableView.setMaxWidth(600);
                    over60MemberFilterTableView.setMaxHeight(900);
                    over60MemberFilterTableView.setLayoutX(30);
                    over60MemberFilterTableView.setLayoutY(30);

                    TableColumn<String, Over60Member> column001 = new TableColumn<>("memberID");
                    column001.setMinWidth(50);
                    column001.setCellValueFactory(new PropertyValueFactory<>("memberID"));


                    TableColumn<String, Over60Member> column002 = new TableColumn<>("name");
                    column002.setMinWidth(50);
                    column002.setCellValueFactory(new PropertyValueFactory<>("name"));


                    TableColumn<String, Over60Member> column003 = new TableColumn<>("hight");
                    column003.setMinWidth(50);
                    column003.setCellValueFactory(new PropertyValueFactory<>("hight"));


                    TableColumn<String, Over60Member> column004 = new TableColumn<>("weight");
                    column004.setMinWidth(50);
                    column004.setCellValueFactory(new PropertyValueFactory<>("weight"));


                    TableColumn<String, Over60Member> column005 = new TableColumn<>("nearestBranchName");
                    column005.setMinWidth(50);
                    column005.setCellValueFactory(new PropertyValueFactory<>("nearestBranchName"));


                    TableColumn<String, Over60Member> column006 = new TableColumn<>("membershipNumber");
                    column006.setMinWidth(50);
                    column006.setCellValueFactory(new PropertyValueFactory<>("membershipNumber"));


                    TableColumn<String, Over60Member> column007 = new TableColumn<>("startMembershipDate");
                    column007.setMinWidth(50);
                    column007.setCellValueFactory(new PropertyValueFactory<>("startMembershipDate"));


                    TableColumn<String, Over60Member> column008 = new TableColumn<>("age");
                    column008.setMinWidth(50);
                    column008.setCellValueFactory(new PropertyValueFactory<>("age"));

                    over60MemberFilterTableView.getColumns().add(column001);
                    over60MemberFilterTableView.getColumns().add(column002);
                    over60MemberFilterTableView.getColumns().add(column003);
                    over60MemberFilterTableView.getColumns().add(column004);
                    over60MemberFilterTableView.getColumns().add(column005);
                    over60MemberFilterTableView.getColumns().add(column006);
                    over60MemberFilterTableView.getColumns().add(column007);
                    over60MemberFilterTableView.getColumns().add(column008);


                    Connection conn = null;
                    try {
                        conn = dbConnection.createConnection();
                        ResultSet resultSet4 = conn.createStatement().executeQuery("SELECT * FROM over60MemberDetails WHERE  over60MemNearestBranchName = '" + textFieldModel1 + "' ");

                        while (resultSet4.next()) {
                            over60MemberFilterTableView.getItems().add(new Over60Member(resultSet4.getString("memberID"),
                                    resultSet4.getString("over60MemName"),
                                    resultSet4.getInt("over60MemHight"),
                                    resultSet4.getInt("over60MemWeight"),
                                    resultSet4.getString("over60MemNearestBranchName"),
                                    resultSet4.getInt("over60MemMembershipNumber"),
                                    resultSet4.getInt("over60MemMembershipStartDate"),
                                    resultSet4.getString("over60MemAge")));
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    rootForFilter.getChildren().add(over60MemberFilterTableView);


                }

            }
        });


//-----------------------------------------------------------------------------------------------------------------------------------------------------------------

        //creat main Scene
        Scene scene1 = new Scene(rootForMainUI, 450, 250);

        String cssFile1 = this.getClass().getResource("Style.css").toExternalForm();
        scene1.getStylesheets().add(cssFile1);

        primaryStage.setScene(scene1);
        primaryStage.show();
        backBtn1.setOnAction(e -> primaryStage.setScene(scene1));
        backBtn2.setOnAction(e -> primaryStage.setScene(scene1));

//        backbtnForFilter.setOnAction(e -> primaryStage.setScene(scene1));
//        backBtnForViewStuDtls.setOnAction(e -> primaryStage.setScene(scene1));
//        backBtnForViewOver60Dtls.setOnAction(e -> primaryStage.setScene(scene1));


    }
}

