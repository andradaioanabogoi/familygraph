package com.neoworks.interviewtests.graph;

import java.util.*;

import static com.neoworks.interviewtests.graph.ParseCSV.readFromCSV;
import static com.neoworks.interviewtests.graph.ParseCSV.readFromCSVR;

public class Network {

    static List<User> users = readFromCSV("src/test/resources/people.csv");
    static List<Relationship> relationships = readFromCSVR("src/test/resources/relationships.csv");

    // converts emails to names
    public String emailToName(String email) {
        String name = "";
        for(User u : users) {
            if(u.getEmail().equals(email)) {
                name = u.getName();
            }
        }
        return name;
    }

    // converts names to emails
    public static String nametoEmail(String name) {
        String email = "";
        for(User u : users) {
            if(u.getName().equals(name)) {
                email = u.getEmail();
            }
        }
        return email;
    }

    // returns the no of people loaded from CSV files
    public int getNoPeople() {
        return users.size();
    }

    // returns the no of relationships of a person, being friends or family
    public int getNoRelationships(String name) {
        int noRelationships = 0;

        // convert name to email
        String email = nametoEmail(name);

        // for each relationship, increase the no of relationships in case the email corresponds to any of the sides
        // of the relationship object
        for(Relationship r : relationships) {
            if (email.equals(r.getEmail1()) || email.equals(r.getEmail2())) {
                noRelationships++;
            }
        }
        return noRelationships;
    }

    // returns the list of emails of the close family network
    public List<String> getFamilyNetwork(String email) {
        List<String> list = new ArrayList<>();

        for(Relationship r:relationships) {
            if(r.getEmail1().equals(email) && r.getRelationship().equals("FAMILY")) {
                list.add(r.getEmail2());
            }
            if(r.getEmail2().equals(email) && r.getRelationship().equals("FAMILY")) {
                list.add(r.getEmail1());
            }
        }
        return list;
    }

    // returns the size of the extended family
    public int sizeExtendedFamily(String name) {
        Set<String> familyExtended = new LinkedHashSet<>();

        // get the email of the person
        String email = nametoEmail(name);

        // get the close family network
        List<String> list = getFamilyNetwork(email);

        // for each member of the close family, add the members of the extended family
        for(String l:list) {
            List newList = getFamilyNetwork(l);
            familyExtended.addAll(newList);
        }
        return familyExtended.size();
    }
}
