package com.neoworks.interviewtests.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

// This class contains the CSV Parsers for both users and relationships
// Can be improved

public class ParseCSV {

    protected static List<User> readFromCSV(String fileName) {

        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                if(!line.isEmpty()) {

                    // use string.split to load a string array with the values from each line of the file; delimiter: comma
                    String[] attributes = line.split(",");
                    User user = User.createUser(attributes);

                    // adding user into ArrayList
                    users.add(user);

                    // read next line before looping; null if eof is reached
                    line = br.readLine();
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return users;
    }

    protected static List<Relationship> readFromCSVR(String fileName) {
        List<Relationship> relationships = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                if(!line.isEmpty()) {

                    // use string.split to load a string array with the values from each line of the file; delimiter: comma
                    String[] attributes = line.split(",");
                    Relationship relationship = Relationship.createRelationship(attributes);

                    // adding user into ArrayList
                    relationships.add(relationship);
                }

                    // read next line before looping
                    // if end of file reached, line would be null
                    line = br.readLine();

            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return relationships;
    }

}