package com.neoworks.interviewtests.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Relationship {

    private String email1;
    private String relationship;
    private String email2;

    public Relationship(String email1, String relationship, String email2) {
        this.email1 = email1;
        this.relationship = relationship;
        this.email2 = email2;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    protected static Relationship createRelationship(String[] metadata) {
        String email1 = metadata[0];
        String relationship = metadata[1];
        String email2 = metadata[2];
        return new Relationship(email1, relationship, email2);
    }

    @Override
    public String toString(){
        return "\nEmail1="+getEmail1()+"::Relationship="+getRelationship()+"::Email2="+getEmail2();
    }

}
