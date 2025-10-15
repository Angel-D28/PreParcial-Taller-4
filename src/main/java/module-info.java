module co.edu.uniquindio.poo.taller4preparcialmotos {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.taller4preparcialmotos to javafx.fxml;
    exports co.edu.uniquindio.poo.taller4preparcialmotos;
    exports co.edu.uniquindio.poo.taller4preparcialmotos.model;
    opens co.edu.uniquindio.poo.taller4preparcialmotos.model to javafx.fxml;
}