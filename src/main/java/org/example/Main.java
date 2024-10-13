package org.example;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.config.EntityConfig;
import org.example.dto.config.InfoAnimalHunt;
import org.example.dto.config.SacrificaProbability;
import org.example.service.SaveService;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StartApplication startApplication = new StartApplication();
        startApplication.start();

    }
}