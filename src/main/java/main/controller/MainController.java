package main.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.model.Student;
import main.service.StudentFactory;
import main.service.StudentService;

import java.util.List;

public class MainController {
    public TextField idField;
    public TextField nameField;
    public TextField ageField;
    public TextField ratingField;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Integer> ageColumn;
    @FXML
    private TableColumn<Student, Double> ratingColumn;
    @FXML
    private Pane pane;
    @FXML
    private Canvas canvas;
    @FXML
    private TextField textField;

    private StudentService studentService;

    public void initialize() {

        studentService = new StudentService();

        StudentFactory sf = new StudentFactory();
        studentService.addAll(List.of(
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent(),
                sf.createRandomStudent()
        ));

        //studentService.getStudents().forEach(System.out::println);

        canvas.heightProperty().bind(pane.heightProperty());
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().addListener((observable, oldValue, newValue) -> draw());
        canvas.widthProperty().addListener((observable, oldValue, newValue) -> draw());

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("rating"));

        updateTable();
    }

    private void updateTable() {
        studentTable.setItems(FXCollections.observableList(studentService.getStudents()));
    }

    public void close() {
        Platform.exit();
    }

    public void draw() {
        double width = pane.getWidth();
        double height = pane.getHeight();
        GraphicsContext g = canvas.getGraphicsContext2D();
        g.setFill(Color.WHITESMOKE);
        g.fillRect(0, 0, width, height);
        g.setStroke(Color.BLUE);
        g.strokeLine(0, 0, width, height);
        g.strokeLine(0, height, width, 0);
    }

    public void about() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText(null);
        alert.setContentText("First cool program in JavaFX");
        alert.show();
    }

    public void hello() {
        String text = textField.getText();
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Hello");
        alert.setHeaderText("This is Hello");
        alert.setContentText("Hello, " + text + "!");
        alert.show();
    }

    public void addStudent() {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        double rating = Double.parseDouble(ratingField.getText());
        Student student = new Student(id, name, age, rating);
        studentService.add(student);
        clearFields();
        updateTable();
    }

    private void clearFields() {
        nameField.clear();
        ageField.clear();
        ratingField.clear();
        idField.clear();
    }
}
