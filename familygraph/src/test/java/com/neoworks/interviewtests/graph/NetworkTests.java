package com.neoworks.interviewtests.graph;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkTests {

    @Test
    public void loadedExpectedNoOfPeople() {
        Network network = new Network();
        assertEquals(12, network.getNoPeople(), "The number of people when loading 'poeple.csv' is 12");
    }

    @Test
    public void noOfRelationshipsForEachPerson() {
        Network network = new Network();
        assertEquals(4, network.getNoRelationships("Bob"), "Bob has 4 relationships");
        assertEquals(3, network.getNoRelationships("Jenny"), "Jenny has 3 relationships");
        assertEquals(2, network.getNoRelationships("Nigel"), "Nigel has 2 relationships");
        assertEquals(0, network.getNoRelationships("Alan"), "Alan has no relationships");
    }

    @Test
    public void sizeExtendedFamily() {
        Network network = new Network();
        assertEquals(4, network.sizeExtendedFamily("Bob"), "Bob has 4 family members in " +
                      "the extended family");
        assertEquals(4, network.sizeExtendedFamily("Jenny"), "Jenny 4 family members in " +
                "the extended family");
    }

}