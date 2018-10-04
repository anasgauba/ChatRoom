package ChatRoom;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu();
        MenuItem menuItem = new MenuItem();
        Button userName = new Button();

        HBox userLists = new HBox();
        Button activeUsers = new Button("Active");
        Button allUsers = new Button("All");

        ListView<String> users = new ListView<>();
        ScrollPane userMsgs = new ScrollPane();

        HBox userOptions = new HBox();
        TextField typeMsg = new TextField();
        Button send = new Button();

        //setting menu options.
        menuBar.setPrefWidth(247.0);
        menuBar.setPrefHeight(22.0);
        menu.setText("Options");
        menuItem.setText("Add Users");

        menu.getItems().add(menuItem);
        menuBar.getMenus().add(menu);
        VBox.setMargin(menuBar, new Insets(0,0,10,0));

        // setting user button.
        // Hbox for active, all buttons.
        userName.setStyle("-fx-background-color: rgb(0, 191,255)");
        userName.setPrefWidth(247.0);
        userName.setPrefHeight(39.0);

        userLists.setPrefWidth(247.0);
        userLists.setPrefHeight(62.0);

        activeUsers.setPrefWidth(78.0);
        activeUsers.setPrefHeight(36.0);

        HBox.setMargin(activeUsers, new Insets(10, 0, 0, 0));
        HBox.setMargin(allUsers, new Insets(10, 0, 0, 90));

        allUsers.setPrefWidth(78.0);
        allUsers.setPrefHeight(36.0);


        //ListView to show active and all users.
        users.setPrefWidth(247.0);
        users.setPrefHeight(70.0);
        users.setStyle("-fx-background-color: rgb(214, 192, 128)");
        VBox.setMargin(users, new Insets(0, 0,0,0));

        //ScrollPane to show user messages.
        userMsgs.setPrefWidth(247.0);
        userMsgs.setPrefHeight(174.0);
        VBox.setMargin(userMsgs, new Insets(10, 0,0,0));

        //Hbox to add textField and a send button.
        userOptions.setPrefWidth(247);
        userOptions.setPrefHeight(101.0);

        typeMsg.setPrefWidth(156.0);
        typeMsg.setPrefHeight(88.0);
        typeMsg.setPromptText("Type a message");
        HBox.setMargin(typeMsg, new Insets(10,0,0,0));

        send.setPrefWidth(92.0);
        send.setPrefHeight(88.0);
        send.setText("SEND");
        send.setStyle("-fx-background-color: yellow; -fx-font-weight: bold");
        HBox.setMargin(send, new Insets(10, 0,0 ,5));


        userLists.getChildren().addAll(activeUsers, allUsers);
        userOptions.getChildren().addAll(typeMsg, send);

        vBox.setLayoutX(27.0);
        vBox.setLayoutY(22.0);
        vBox.setPrefWidth(247.0);
        vBox.setPrefHeight(457.0);
        vBox.getChildren().addAll(menuBar, userName, userLists, users, userMsgs,
                userOptions);

        root.prefHeight(500.0);
        root.prefWidth(300.0);
        root.setStyle("-fx-background-color: rgb(72, 103, 178)");
        root.getChildren().add(vBox);

        //TODO: Add actionListeners.
        Message message = new Message();
        User user = new User("Bob", true);
        User user2 = new User("John", true);
        User user3 = new User("Smith", false);
        User user4 = new User("Anas", false);


        UserList usersList = new UserList();
        usersList.addUser(user, user2, user3, user4);

        allUsers.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ArrayList<User> allUsers = usersList.getAllUsers();
                users.getItems().clear();
//                allUsers.setStyle("-fx-background-color: yellow; -fx-font-weight: bold");
                for (int i = 0; i < allUsers.size(); i++) {
                    users.getItems().add(allUsers.get(i).getName());
                }
            }
        });
        activeUsers.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ArrayList<User> activeUsers = usersList.getActiveUsers();
                users.getItems().clear();
                for(int i = 0; i < activeUsers.size(); i++) {
                    users.getItems().add(activeUsers.get(i).getName());
                }
            }
        });

        users.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String whichUser = users.getSelectionModel().getSelectedItem();
                userName.setText(whichUser);

//                if(whichUser.equals(user.getName())) {
//                    user.setActive(true);
//                }
            }
        });
        send.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");
                Date now = new Date();
                String time = date.format(now);
                System.out.println(time);

                // Re visit this thing. Do we have to use for loop
                // and create list???
                ArrayList<User> active = usersList.getActiveUsers();
                for (int i = 0; i < active.size(); i++) {
                    if (!typeMsg.getText().isEmpty()) {
                        if (active.get(i).isActive()) {
                            //String chatArea = message.getLastTenMsgs();
                            message.addMsg(time, active.get(i), typeMsg.getText
                                    ());
                            userMsgs.setContent(new Text(active.get(i).getName()));
                        }
                    }
                }
                typeMsg.clear();
                typeMsg.getPromptText();
            }
        });


        primaryStage.setTitle("ChatRoom");
        primaryStage.setScene(new Scene(root, 300, 500));
        primaryStage.show();
    }
}
