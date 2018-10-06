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
 * Game Coordinator/ Display class for ChatRoom App. Runs the javafx
 * application. Sets up the initial gui, then adds actionListeners and logic
 * in them. Game Coordinator has access to User, UserList, and UserMessages.
 * The new User can be added to the chatRoom, the user can logIn/logOff based
 * on the click in listView (any user becomes active when it gets selected
 * and it types a message). Initially, all the users are inactive, they can
 * get active when the person clicks a user from "All" button's listView and
 * types a message.
 * @version date: 2018-09-29
 * @author Anas Farooq Gauba
 */
public class GameCoordinator extends Application {
    /**
     * Launches the app.
     * @param args command line ignored.
     */
    public static void main(String[]args) {
        launch(args);
    }

    /**
     * Initial display setup and actionListeners.
     * @param primaryStage the stage
     * @throws IOException any exception.
     */
    @Override
    public void start(Stage primaryStage) throws IOException {

        //Initial GUI Setup.

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

        //Display logic begins.
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
        viewUsers.setPrefHeight(100.0);
        VBox.setMargin(viewUsers, new Insets(0, 0,0,0));

        //ScrollPane to show user messages.
        viewMsgs.setPrefWidth(247.0);
        viewMsgs.setPrefHeight(170.0);
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

        //Adding everything in the correct order.
        hBox1.getChildren().addAll(newUserTextField, newUserBtn);
        hBox2.getChildren().addAll(activeUsers, allUsers);
        hBox3.getChildren().addAll(typeMsg, sendBtn);

        // Layout of vBox and root pane.
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
          Start of the logic. Instantiate userMsgs, initially create some
          users, put them in the userList.
         */
        UserMessages userMessages = new UserMessages();
        User user = new User("Bob", false);
        User user2 = new User("John", false);
        User user3 = new User("Smith", false);
        User user4 = new User("Anas", false);

        UserList usersList = new UserList();
        usersList.addUser(user, user2, user3, user4);

        // ActionListener for newUserBtn. Adds a new user to the userList.
        // When newUser is added, automatically fires (clicks/goes to) to
        // "All" button listView. Clears the textField and gets a placeholder
        // (promptText).
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
        // "All" users button action event. Shows the list of all users.
        // Sets the send button back to active if it was disabled from
        // "Active" listView call. Every time, this action triggers, I make
        // sure to clear the listView and repaint it (getItems.add).
        // Doing javafx button stylesfor better user experience to detect
        // which one got clicked. Clicked one turns yellow.
        allUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sendBtn.setDisable(false);
                ArrayList<User> allUser = usersList.getAllUsers();
                viewUsers.getItems().clear();

                for (int i = 0; i < allUser.size(); i++) {
                    viewUsers.getItems().add(allUser.get(i).getName());
                }
                allUsers.setStyle("-fx-background-color: yellow; " +
                        "-fx-font-weight: " + "bold; -fx-font: 16 " +
                        "arial");
                activeUsers.setStyle("-fx-background-color: beige; " +
                        "-fx-font-weight: " + "bold; -fx-font: 16 " +
                        "arial");
            }
        });
        // "Active" users button action event. Shows the list of active users.
        // Every time, this action triggers, I make sure to clear the
        // listView and repaint it (getItems.add). Doing javafx button styles
        // for better user experience to detect which one got clicked.
        // Clicked one turns yellow.
        activeUsers.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<User> activeUser = usersList.getActiveUsers();
                viewUsers.getItems().clear();

                for(int i = 0; i < activeUser.size(); i++) {
                    viewUsers.getItems().add(activeUser.get(i).getName());
                }
                allUsers.setStyle("-fx-background-color: beige; " +
                        "-fx-font-weight: " + "bold; -fx-font: 16 " +
                        "arial");
                activeUsers.setStyle("-fx-background-color: yellow; " +
                        "-fx-font-weight: " + "bold; -fx-font: 16 " +
                        "arial");
            }
        });
        // ListView actionListener. Shows the selected user onto blue button
        // only if the user is active, otherwise empty text "". Doing logic
        // for logging off user in here. Get all the activeUsers list, and
        // loop thru them and check which one got clicked, set their boolean
        // to false, disable the send button. Repaint the "Active" listView
        // (by calling fire() method). Javafx button styling to show the user
        // that they are in "Active" listView currently.
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
                        activeUsers.setStyle("-fx-background-color: yellow; " +
                                "-fx-font-weight: " + "bold; -fx-font: 16 " +
                                "arial");
                    }
                }
            }
        });
        // Send button actionListener. Gets the current time at which user
        // tried to send the message, store it in string, based on which user
        // gets selected from "All" listView, and gets the message from
        // textField that the user typed, add that msg to the tupleSpace by
        // calling a method in userMessages class. Note: I am taking into
        // account that the user should'nt be able to send a blank message
        // (!empty textField). Showing that message on viewMsgs(scrollPane) by
        // calling printLastTenMsgs() method from userMessages class. Making
        // sure to clear the textField once the user sends a message and put
        // the placeholder (promptText).
        sendBtn.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                String time = date.format(now);
                ArrayList<User> selectUser = usersList.getAllUsers();

                for (int i = 0; i < selectUser.size(); i++) {
                    if (!typeMsg.getText().isEmpty()) {
                        if (viewUsers.getSelectionModel().getSelectedItem()
                                .contentEquals(selectUser.get(i).getName())) {
                            selectUser.get(i).setActive(true);
                            userMessages.addMsg(time, selectUser.get(i), typeMsg
                                    .getText());
                            viewMsgs.setContent(new Text(userMessages.printLastTenMsgs()));
                        }
                    }
                }
                typeMsg.clear();
                typeMsg.getPromptText();
            }
        });

        // initially, when the program runs, I want the user to see "All"
        // users listView by calling fire() method.
        allUsers.fire();
        primaryStage.setTitle("ChatRoom");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }
}
