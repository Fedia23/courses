import fragments.ControllerLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import users.User;

public class Main extends Application {

    @Override
    public void start (Stage primaryStage) throws Exception {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("/login.fxml"));
        Pane root = loader.load();

        ControllerLogin controllerLogin = loader.getController();
        Scene scene = new Scene(root);
        primaryStage = new Stage();

        controllerLogin.setPrimaryStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
