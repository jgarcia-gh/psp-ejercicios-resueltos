package org.example.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Chat");

        // Área de texto donde aparecerán los mensajes del chat
        TextArea chatArea = new TextArea();
        chatArea.setEditable(false);  // Para que solo sea de lectura
        chatArea.setWrapText(true);   // Envuelve el texto automáticamente
        chatArea.setPrefHeight(400);  // Altura preferida del área de chat

        // Campo de texto donde el usuario puede escribir su mensaje
        TextField messageField = new TextField();
        messageField.setPromptText("Escribe tu mensaje aquí...");

        // Botón de enviar mensaje
        Button sendButton = new Button("Enviar");

        // Diseño de la parte inferior (entrada de mensaje y botón)
        HBox inputBox = new HBox(10);
        inputBox.getChildren().addAll(messageField, sendButton);
        inputBox.setHgrow(messageField, Priority.ALWAYS);

        // Diseño principal (contenedor vertical)
        VBox root = new VBox(10);
        root.getChildren().addAll(chatArea, inputBox);
        root.setPrefSize(400, 500); // Tamaño de la ventana

        // Escena principal
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}