package com.neoworks.interviewtests.graph;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTests {

    @Test
    public void loadedExpectedNoOfPeople() {
        Network network = new Network();
        // assert statements
        assertEquals(12, network.getNoPeople(), "The number of people when loading 'poeple.csv' is 12");
    }

    @Test
    public void noOfRelationshipsForEachPerson() {
        Network network = new Network();
        // assert statements
        assertEquals(4, network.getNoRelationships("Bob"), "Bob has 4 relationships");
        assertEquals(3, network.getNoRelationships("Jenny"), "Jenny has 3 relationships");
        assertEquals(2, network.getNoRelationships("Nigel"), "Nigel has 2 relationships");
        assertEquals(0, network.getNoRelationships("Alan"), "Alan has no relationships");
    }

    @Test
    public void sizeExtendedFamily() {
        Network network = new Network();
        // assert statements
        assertEquals(4, network.sizeExtendedFamily("Bob"), "Bob has 4 family members in " +
                      "the extended family");
        assertEquals(4, network.sizeExtendedFamily("Jenny"), "Jenny 4 family members in " +
                "the extended family");
    }
//
//
//    @Test
//    public void familyNetworks() {
//        Network network = new Network();
//        assertEquals((["finn@gmail.com, amber@gmail.com, anna@clothes.com"]), network.getFamilyNetwork("bob@bob.com"), "The Family Network of Bob is finn@gmail.com, amber@gmail.com, anna@clothes.com");
//    }
}