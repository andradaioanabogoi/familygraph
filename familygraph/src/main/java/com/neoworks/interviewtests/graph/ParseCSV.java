package com.neoworks.interviewtests.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.neoworks.interviewtests.graph.User.createUser;

/**
 * Simple Java program to read CSV file in Java. In this program we will read
 * list of books stored in CSV file as comma separated values.
 *
 * @author WINDOWS 8
 *
 */
public class ParseCSV {

    public static void main(String... args) {
        List<User> users = readFromCSV("data/people.csv");
        List<Relationship> relationships = readFromCSVR("data/relationships.csv");
//
//        // let's print all the person read from CSV file
//        for (Relationship r : relationships) {
//            System.out.println(r);
//        }
//
//        System.out.println(" ");
//
//        for (User u : users) {
//            System.out.println(u);
//        }
    }

    protected static List<User> readFromCSV(String fileName) {
        List<User> users = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        // create an instance of BufferedReader
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                User user = User.createUser(attributes);


                // adding user into ArrayList
                users.add(user);

                // read next line before looping
                // if end of file reached, line would be null
                line = br.readLine();
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
        // using try with resource, Java 7 feature to close resources
        try (BufferedReader br = Files.newBufferedReader(pathToFile,
                StandardCharsets.US_ASCII)) {

            // read the first line from the text file
            String line = br.readLine();

            // loop until all lines are read
            while (line != null) {

                if(!line.isEmpty()) {

                    // use string.split to load a string array with the values from
                    // each line of
                    // the file, using a comma as the delimiter
                    String[] attributesR = line.split(",");

                    Relationship relationship = Relationship.createRelationship(attributesR);

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