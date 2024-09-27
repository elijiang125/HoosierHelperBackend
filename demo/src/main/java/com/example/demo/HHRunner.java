package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class HHRunner {

	public static void main(String[] args) throws IOException {

		// This is necessary to start the Spring Boot application and display the Spring Boot banner.
		SpringApplication.run(HHRunner.class, args);

		// Firebase initialization logic
		ClassLoader classLoader = HHRunner.class.getClassLoader();

		// Load Firebase service account key
		File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccountKey.json")).getFile());
		FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());

		// Firebase options setup
		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		// Initialize FirebaseApp
		FirebaseApp.initializeApp(options);
	}
}
