package lk.ijse.gdse.pawsandclawscaremvc.controller;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class IntroController {

    @FXML
    private LineChart<String, Number> GraphStats;

    @FXML
    private ImageView ImgViewSlideShow;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private VBox lowStockContainer;

    @FXML
    private Label LblLowStock;

    private ArrayList<Image> images = new ArrayList<>();
    private int currentIndex = 0;

    public void initialize() {
        updateChart();
        checkLowStock();
        // Load images into the list
        images.add(new Image(getClass().getResource("/images/pic77.jpg").toExternalForm()));
        images.add(new Image(getClass().getResource("/images/pic7.jpg").toExternalForm()));
        images.add(new Image(getClass().getResource("/images/pic66.jpg").toExternalForm()));


        startSlideshowWithFade();

    }
    public void updateChart() {
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Monthly Revenue");

        // Adding data dynamically
        series.getData().add(new XYChart.Data<>("January", 2000));
        series.getData().add(new XYChart.Data<>("February", 2500));
        series.getData().add(new XYChart.Data<>("March", 1800));
        series.getData().add(new XYChart.Data<>("April", 3000));
        series.getData().add(new XYChart.Data<>("May", 2200));

        // Clearing old data and adding new series
        GraphStats.getData().clear();
        GraphStats.getData().add(series);
    }

    private void startSlideshowWithFade() {
        // Set initial image
        if (!images.isEmpty()) {
            ImgViewSlideShow.setImage(images.get(currentIndex));
        }

        // Create a timeline to change the image every 3 seconds
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), event -> {
            currentIndex = (currentIndex + 1) % images.size(); // Cycle through images

            // Set up fade transition
            FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), ImgViewSlideShow);
            fadeOut.setFromValue(1.0);
            fadeOut.setToValue(0.0);
            fadeOut.setOnFinished(e -> {
                // Update the image when fade-out completes
                ImgViewSlideShow.setImage(images.get(currentIndex));

                // Fade in after setting the new image
                FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), ImgViewSlideShow);
                fadeIn.setFromValue(0.0);
                fadeIn.setToValue(1.0);
                fadeIn.play();
            });

            fadeOut.play();
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void checkLowStock() {
        new Thread(() -> {
            try (Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/PawsAndClawsCare", "root", "Ijse@1234")) {

                String query = "SELECT name, qty FROM Product WHERE qty < 10";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();

                StringBuilder lowStockItems = new StringBuilder();

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int qty = resultSet.getInt("qty");
                    lowStockItems.append(name).append(" (Qty: ").append(qty).append(")\n");
                }

                if (lowStockItems.length() > 0) {
                    Platform.runLater(() -> displayLowStockMessage(lowStockItems.toString()));
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void displayLowStockMessage(String message) {
        lowStockContainer.getChildren().clear();

        Label alertLabel = new Label(message);
        alertLabel.setStyle("-fx-text-fill:  #82b1ff; -fx-font-size: 20px; -fx-padding: 9; -fx-background-color: #1e272e; -fx-font-family: 'Times New Roman'; -fx-font-weight: bold; ");
        lowStockContainer.getChildren().add(alertLabel);

        // Auto-hide alert after 10 seconds
        PauseTransition delay = new PauseTransition(Duration.seconds(50));
        delay.setOnFinished(event -> lowStockContainer.getChildren().clear());
        delay.play();
    }
}
