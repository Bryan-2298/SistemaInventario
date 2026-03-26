module org.uacm.sistemainventario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens org.uacm.sistemainventario to javafx.fxml;
    exports org.uacm.sistemainventario;
    
    opens modelo to javafx.base;
}
