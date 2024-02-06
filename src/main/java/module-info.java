module com.reflectionjava {
	requires javafx.controls;
	requires javafx.fxml;

	opens com.reflectionjava to javafx.fxml;
	exports com.reflectionjava;
}