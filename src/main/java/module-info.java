module com.example.oop_projekt {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop_projekt2 to javafx.fxml;
    exports com.example.oop_projekt2;

}