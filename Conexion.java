/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.plantas;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Fer
 */
public class Conexion {

    public static Firestore db;

    public static void conectarFirebase() {

        try {
            FileInputStream acountService = new FileInputStream("plantas.json");

            FirebaseOptions      options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(acountService))
                    .build();

            FirebaseApp.initializeApp(options);
            
            db = FirestoreClient.getFirestore();
            System.out.println("Su base de datos ha sido conectada");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

}
