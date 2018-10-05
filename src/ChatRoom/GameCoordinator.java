package ChatRoom;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class GameCoordinator extends Application{

    @Override
    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Pane root = new Pane();
        VBox vBox = new VBox();

        HBox hBox1 = new HBox();
        TextField newUserTextField = new TextField();
        Button newUserBtn = new Button();

        Button userName = new Button();

        HBox hBox2 = new HBox();
        Button activeUsers = new Button("Active");
        Button allUsers = new Button("All");

        ListView<String> viewUsers = new ListView<>();
        ScrollPane viewMsgs = new ScrollPane();

        HBox hBox3 = new HBox();
        TextField typeMsg = new TextField();
        Button sendBtn = new Button();


        hBox1.setPrefWidth(247.0);
        hBox1.setPrefHeight(51.0);

        newUserTextField.setPrefWidth(226.0);
        newUserTextField.setPrefHeight(37.0);
        newUserTextField.setPromptText("Add a User");

        newUserBtn.setPrefWidth(141.0);
        newUserBtn.setPrefHeight(37.0);
        newUserBtn.setText("Add");

        HBox.setMargin(newUserTextField, new Insets(0,5,5,0));
        HBox.setMargin(newUserBtn, new Insets(0,0,5,0));

        // setting user button.
        // Hbox for active, all buttons.
        userName.setStyle("-fx-background-color: rgb(0, 191,255)");
        userName.setPrefWidth(247.0);
        userName.setPrefHeight(39.0);

        hBox2.setPrefWidth(247.0);
        hBox2.setPrefHeight(62.0);

        activeUsers.setPrefWidth(78.0);
        activeUsers.setPrefHeight(36.0);
        activeUsers.setStyle("-fx-background-color: beige; -fx-font-weight: " +
                "bold; -fx-font: 16 arial");
        activeUsers.setTextFill(Paint.valueOf("#eb0c0c"));

        HBox.setMargin(activeUsers, new Insets(10, 0, 0, 0));
        HBox.setMargin(allUsers, new Insets(10, 0, 0, 90));

        allUsers.setPrefWidth(78.0);
        allUsers.setPrefHeight(36.0);
        allUsers.setStyle("-fx-background-color: beige; -fx-font-weight: " +
                "bold; -fx-font: 16 arial");
        allUsers.setTextFill(Paint.valueOf("#07aee1"));


        //ListView to show active and all view.
        viewUsers.setPrefWidth(247.0);
        viewUsers.setPrefHeight(70.0);
//        view.setStyle("-fx-background-color: rgb(214, 192, 128)");
        VBox.setMargin(viewUsers, new Insets(0, 0,0,0));

        //ScrollPane to show user messages.
        viewMsgs.setPrefWidth(247.0);
        viewMsgs.setPrefHeight(174.0);
        VBox.setMargin(viewMsgs, new Insets(10, 0,0,0));

        //Hbox to add textField and a sendBtn.
        hBox3.setPrefWidth(247);
        hBox3.setPrefHeight(101.0);

        typeMsg.setPrefWidth(156.0);
        typeMsg.setPrefHeight(88.0);
        typeMsg.setPromptText("Type a message");
        HBox.setMargin(typeMsg, new Insets(10,0,0,0));

        sendBtn.setPrefWidth(92.0);
        sendBtn.setPrefHeight(88.0);
        sendBtn.setText("SEND");
        sendBtn.setStyle("-fx-background-color: yellow; -fx-font-weight: bold");
        HBox.setMargin(sendBtn, new Insets(10, 0,0 ,5));


        hBox1.getChildren().addAll(newUserTextField, newUserBtn);
        hBox2.getChildren().addAll(activeUsers, allUsers);
        hBox3.getChildren().addAll(typeMsg, sendBtn);

        vBox.setLayoutX(27.0);
        vBox.setLayoutY(22.0);
        vBox.setPrefWidth(247.0);
        vBox.setPrefHeight(457.0);
        vBox.getChildren().addAll(hBox1, userName, hBox2, viewUsers, viewMsgs,
                hBox3);

        root.prefHeight(500.0);
        root.prefWidth(300.0);
        root.setStyle("-fx-background-color: rgb(72, 103, 178)");
        root.getChildren().add(vBox);


        /*
          Start of the logic.
         */
        UserMessages userMessages = new UserMessages();
        User user = new User("Bob", false);
        User user2 = new User("John", false);
        User user3 = new User("Smith", true);
        User user4 = new User("Anas", true);

        UserList usersList = new UserList();
        usersList.addUser(user, user2, user3, user4);

//        ArrayList<User> list = usersList.getAllUsers();
//        for(int i = 0; i < list.size(); i++){
//            if(list.get(i).isActive()){
//                userMessages.addMsg();
//            }
//        }

        newUserBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!newUserTextField.getText().isEmpty()) {
                    User newUser = new User(newUserTextField.getText(), false);
                    usersList.addUser(newUser);
                }
                allUsers.fire();
                newUserTextField.clear();
                newUserTextField.getPromptText();
            }
        });

        allUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendBtn.setDisable(false);
                ArrayList<User> allUsers = usersList.getAllUsers();
                viewUsers.getItems().clear();

                for (int i = 0; i < allUsers.size(); i++) {
                    viewUsers.getItems().add(allUsers.get(i).getName());
                }
            }
        });
        activeUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<User> activeUsers = usersList.getActiveUsers();
                viewUsers.getItems().clear();
                //TODO: When a user clicks, that user should become offline.

                for(int i = 0; i < activeUsers.size(); i++) {
                    viewUsers.getItems().add(activeUsers.get(i).getName());
                }
            }
        });

        viewUsers.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String whichUser = viewUsers.getSelectionModel().getSelectedItem();
                userName.setText(whichUser);
                ArrayList<User> active = usersList.getActiveUsers();
                for (int i = 0; i < active.size(); i++) {
                    if (viewUsers.getSelectionModel().getSelectedItem()
                            .contentEquals(active.get(i).getName())) {
                        active.get(i).setActive(false);
                        userName.setText("");
                        sendBtn.setDisable(true);
                        activeUsers.fire();
//                        viewUsers.getItems().clear();
//                        viewUsers.getItems().add(active.get(i).getName());
                    }
                }
            }
        });
        sendBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                String time = date.format(now);
                //String chatArea = userMessages.printLastTenMsgs();
//                if (!typeMsg.getText().isEmpty()) {
//                    userMessages.addMsg(time, user, typeMsg.getText());
//                    viewMsgs.setContent(new Text(userMessages.printLastTenMsgs()));
//                }
                ArrayList<User> active = usersList.getAllUsers();
                for (int i = 0; i < active.size(); i++) {
                    if (!typeMsg.getText().isEmpty()) {
                        if (viewUsers.getSelectionModel().getSelectedItem()
                                .contentEquals(active.get(i).getName())) {
                            active.get(i).setActive(true);
                            userMessages.addMsg(time, active.get(i), typeMsg
                                    .getText());
                            viewMsgs.setContent(new Text(userMessages.printLastTenMsgs()));
                        }
                    }
                }
                typeMsg.clear();
                typeMsg.getPromptText();
            }
        });


        allUsers.fire();
        primaryStage.setTitle("ChatRoom");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }
}
