package com.neoworks.interviewtests.graph;

import java.util.*;

import static com.neoworks.interviewtests.graph.ParseCSV.readFromCSV;
import static com.neoworks.interviewtests.graph.ParseCSV.readFromCSVR;

public class Network {

    static List<User> users = readFromCSV("data/people.csv");
    static List<Relationship> relationships = readFromCSVR("data/relationships.csv");

    public String emailToName(String email) {
        String name = "";
        for(User u : users) {
            if(u.getEmail().equals(email)) {
                name = u.getName();
            }
        }
        return name;
    }

    public static String nametoEmail(String name) {
        String email = "";
        for(User u : users) {
            if(u.getName().equals(name)) {
                email = u.getEmail();
            }
        }
        return email;
    }

    public int getNoPeople() {
        return users.size();
    }

    public int getNoRelationships(String name) {
        int noRelationships = 0;
        String email = nametoEmail(name);
        for(Relationship r : relationships) {
            if (email.equals(r.getEmail1()) || email.equals(r.getEmail2())) {
                noRelationships++;
            }
        }
            return noRelationships;
    }
//
//    public static Map<String, List<String>> buildMap(){
//        Map<String, List<String>> map = new HashMap<>();
//        for(Relationship r:relationships) {
//            List<String> list = new ArrayList<>();
//            String email1 = r.getEmail1();
//            if(r.getRelationship().equals("FAMILY")) {
//                list.add(r.getEmail2());
//            }
//            if(r.getRelationship().equals("FAMILY") && r.getEmail2().equals(email1)) {
//                list.add(r.getEmail1());
//            }
//            map.put(r.getEmail2(), list);
//        }
//        return map;
//    }

    public static List<String> getFamilyNetwork(String email) {
//        Map<String, List<String>> familyNetwork = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(Relationship r:relationships) {
            if(r.getEmail1().equals(email) && r.getRelationship().equals("FAMILY")) {
                list.add(r.getEmail2());
            }
            if(r.getEmail2().equals(email) && r.getRelationship().equals("FAMILY")) {
                list.add(r.getEmail1());
            }
        }
//        familyNetwork.put(email, list);
        return list;
    }

    public int sizeExtendedFamily(String name) {
        Set<String> s = new LinkedHashSet<>();
        String email = nametoEmail(name);
        List<String> list = getFamilyNetwork(email);
        System.out.println(list);
        for(String l:list) {
            List newList = getFamilyNetwork(l);
            s.addAll(newList);
        }
        return s.size();
    }
}
