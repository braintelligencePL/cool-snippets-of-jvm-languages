package pl.braintelligence.katas

import spock.lang.Specification

// Sock Merchant - from Hackerrank
class _Java_1_SocketsPairsTest extends Specification {

    public static final int NUMBER_OF_PAIRS = 4

    def "Should find number of pairs (test for java)"() {
        given: "primitive array of sockets colors"
        int[] socksColors = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3]
        def socketPairs = new Java_1_SocketsPairs()

        when: "count all pairs"
        def result = socketPairs.findAllPairs(socksColors)

        then:
        result == NUMBER_OF_PAIRS
    }

    def "Should find number of pairs (test for kotlin)"() {
        given: "primitive array of sockets colors"
        def socketPairs = new Kotlin_1_FindSocketsPairs()
        int[] socksColors = [1, 1, 3, 1, 2, 1, 3, 3, 3, 3]

        when: "count all pairs"
        def result = socketPairs.findAllPairs(socksColors)

        then:
        result == NUMBER_OF_PAIRS
    }
}
