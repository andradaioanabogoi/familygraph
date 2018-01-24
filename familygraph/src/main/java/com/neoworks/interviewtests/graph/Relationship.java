package com.neoworks.interviewtests.graph;

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

    // creates a Relationship Object from a data array
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
