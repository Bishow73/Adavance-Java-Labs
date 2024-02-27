package Javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
public class shape extends Application {
@Override
public void start(Stage primaryStage) {
// Create a pane to hold the shapes
Pane pane = new Pane();
// Create a line
Line line = new Line(50, 50, 200, 50);
line.setStroke(Color.RED);
// Create a rectangle
Rectangle rectangle = new Rectangle(50, 100, 150, 80);
rectangle.setFill(Color.PURPLE);
// Create a circle
Circle circle = new Circle(350, 140, 30);
circle.setFill(Color.BLACK);
// Create an ellipse
Ellipse ellipse = new Ellipse(500, 140, 50, 30);
ellipse.setFill(Color.GREEN);
// Add shapes to the pane
pane.getChildren().addAll(line, rectangle, circle, ellipse);
// Create the scene and set it in the stage
Scene scene = new Scene(pane, 600, 200);
primaryStage.setTitle("JavaFX Shapes Example");
primaryStage.setScene(scene);
primaryStage.show();
}
public static void main(String[] args) {
launch(args);
} }
