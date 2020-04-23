package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.jfoenix.controls.JFXButton.ButtonType.RAISED;


public class Main extends Application {

    JFXTextField jfxtxt;
    JFXPasswordField jfxpwd;

    @Override
    public void start(Stage primaryStage) throws Exception{
        /*
        Pane root   = new Pane();
        //
        Circle circle = new Circle();
        circle.setCenterX(100);
        circle.setCenterY(100);
        circle.setRadius(60);
        circle.setFill(Color.TURQUOISE);

        circle.centerXProperty().bind(root.widthProperty().divide(2));
        circle.centerYProperty().bind(root.heightProperty().divide(2));
        circle.radiusProperty().bind((root.widthProperty().divide(4)));
        //
        root.getChildren().add(circle);
        //
        TextField txtField = new TextField();
        txtField.setMaxWidth(300);

        Label txtLabel = new Label();
        txtLabel.setFont(new Font(20));
        txtLabel.setLayoutX(100);
        txtLabel.setLayoutY(100);

        txtLabel.textProperty().bind(txtField.textProperty());
        //
        root.getChildren().addAll(txtField,txtLabel);
        //
        Scene scene = new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        //
        //
*/      Font test = Font.loadFont(getClass().getResourceAsStream("/sample/Quicksand/static/Quicksand-Regular.ttf"), 20);
        //LayOut
        Stage secondStage = new Stage();
        GridPane gridRoot = new GridPane();
        HBox btnBox = new HBox();
        Region middelReg = new Region();
        HBox.setHgrow(middelReg, Priority.ALWAYS);

        //Button SetUp
        jfxtxt = new JFXTextField();
        jfxpwd = new JFXPasswordField();
        JFXButton loginBtn = new JFXButton("Anmelden");
        JFXButton backBtn = new JFXButton("Zurück");
        //Btn Style
        loginBtn.getStyleClass().add("raised-button");
        loginBtn.setButtonType(RAISED);
        backBtn.getStyleClass().add("raised-button");
        backBtn.setButtonType(RAISED);

        //Textfield
        jfxtxt.setPromptText("Benutzername");
        jfxtxt.setLabelFloat(true);
        jfxtxt.getStyleClass().add("jfxtxt");
        //Passwortfield
        jfxpwd.setPromptText("Passwort");
        jfxpwd.setLabelFloat(true);
        jfxpwd.getStyleClass().add("jfxtxt");

        Text userIcon = GlyphsDude.createIcon(FontAwesomeIcon.USER, "22px");
        Text pwdIcon = GlyphsDude.createIcon(FontAwesomeIcon.KEY,"22px");
        userIcon.setFill(Color.web("#18146a"));
        pwdIcon.setFill(Color.web("#18146a"));

        //HBox Layout
        btnBox.getChildren().addAll(backBtn, middelReg, loginBtn);

        //Add Nodes
        gridRoot.add(userIcon,0,1);
        gridRoot.add(pwdIcon,0,2);
        gridRoot.add(jfxtxt,1,1);
        gridRoot.add(jfxpwd,1,2);
        gridRoot.add(btnBox, 1,3);

        gridRoot.getStyleClass().add("gridRoot");

        Scene secondScene = new Scene(gridRoot);
        secondScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        secondStage.setScene(secondScene);
        secondStage.sizeToScene();
        secondStage.setResizable(true);
        secondStage.show();

        //Eventhandling
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String username = jfxtxt.getText();
                String password = jfxpwd.getText();

                if (username.equals("admin")&& password.equals("admin")){
                    SecondSceneUi scui = new SecondSceneUi();
                    Scene scene2 = new Scene(scui.secondScene(primaryStage));
                    scene2.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
                    secondStage.setScene(scene2);
                    secondStage.sizeToScene();
                }else if (username.equals("") && password.equals("")){
                    jfxtxt.getStyleClass().add("wrong-credentials");
                    jfxpwd.getStyleClass().add("wrong-credentials");
                }else{
                    jfxtxt.getStyleClass().add("wrong-credentials");
                    jfxpwd.getStyleClass().add("wrong-credentials");
                    jfxpwd.clear();
                    jfxtxt.clear();
                }
            }
        };
        loginBtn.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
