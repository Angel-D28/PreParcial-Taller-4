module co.edu.uniquindio.poo.taller4preparcialmotos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    exports co.edu.uniquindio.poo.taller4preparcialmotos;
    exports co.edu.uniquindio.poo.taller4preparcialmotos.controllers;
    exports co.edu.uniquindio.poo.taller4preparcialmotos.model;

    opens co.edu.uniquindio.poo.taller4preparcialmotos.controllers to javafx.fxml;
    opens co.edu.uniquindio.poo.taller4preparcialmotos.model to javafx.fxml;
}