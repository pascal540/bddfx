import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;

public class Main extends Application {

    public static void main(String[] args) throws Exception {
        launch();
    }

    @Override
    public void start(Stage arg0) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("fxml/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        Stage stage = new Stage();
        stage.setTitle("Hello");
        stage.setScene(scene);
        stage.show();

        DatabaseConnection dataBaseConnection = new DatabaseConnection();
        Connection connectDb = dataBaseConnection.getConnection();

        // String query = "SELECT * FROM user";

        String sql = "{call test}"; // procedure stockee
        try {
            Statement statement = connectDb.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String resultName = rs.getString("name");
                // String resultAddress = rs.getString("address");
                // String resultId = rs.getString("id");
                // System.out.println(resultId + "\n" + resultName + "\n" + resultAddress);
                System.out.println(resultName);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erreur dans le Main");
        }
    }
}
