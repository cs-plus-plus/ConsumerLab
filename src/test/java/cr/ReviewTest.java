package cr;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


public class ReviewTest {

    // HashMap to store sentiment values from the CSV for testing purposes
    private static HashMap<String, Double> sentimentMap = new HashMap<>();

    // Load the sentiment data into a HashMap for quick lookup during tests
    static {
        try {
            Scanner input = new Scanner(new File("cleanSentiment.csv"));
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");
                sentimentMap.put(temp[0].toLowerCase(), Double.parseDouble(temp[1])); // Store words as lowercase for consistency
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Error reading or parsing cleanSentiment.csv");
        }
    }

    @Test
    public void testSentimentVal() {
        // This test checks that the sentimentVal method correctly reads and returns sentiment values
        // from cleanSentiment.csv. This test is provided to verify that the CSV file is being read correctly
        // and is not part of the student's grading.
        assertEquals(0.09, Review.sentimentVal("1960s"), 0.01);
        assertEquals(-0.07, Review.sentimentVal("1970s"), 0.01);
        assertEquals(-0.15, Review.sentimentVal("1980s"), 0.01);
        assertEquals(0.05, Review.sentimentVal("1990s"), 0.01);
        assertEquals(-0.32, Review.sentimentVal("aaron"), 0.01);
        assertEquals(-0.09, Review.sentimentVal("abandoned"), 0.01);
        assertEquals(0.64, Review.sentimentVal("abby"), 0.01);
        assertEquals(-0.34, Review.sentimentVal("abnormal"), 0.01);
        assertEquals(-1.23, Review.sentimentVal("absurd"), 0.01);
        assertEquals(-1.51, Review.sentimentVal("absolute"), 0.01);
    }

    @Test
    public void testSentimentValWithInvalidInput() {
        // This test checks that the sentimentVal method handles invalid input correctly.
        // It verifies that the method returns 0 for null or unknown words.
        // This test is also not part of the student's grading, as it only ensures basic functionality of the CSV read.
        assertEquals(0, Review.sentimentVal(null), 0.01);
        assertEquals(0, Review.sentimentVal(""), 0.01);
        assertEquals(0, Review.sentimentVal("unknownword"), 0.01);
    }

    @Test
    public void testTotalSentiment() throws IOException {
        // 20 points: Tests totalSentiment by checking if it correctly calculates the sum of sentiment values in a review.
        assertEquals(-2.92, Review.totalSentiment("simpleReview.txt"), 0.01);
        assertEquals(29.04, Review.totalSentiment("26WestReview.txt"), 0.01);
        assertEquals(2.2, Review.totalSentiment("positiveReview.txt"), 0.01);
    }

    @Test
    public void testStarRating() throws IOException {
        // 20 points: Tests starRating by ensuring that the star rating matches the calculated total sentiment value.
        // Test 4-star rating
        assertEquals(4, Review.starRating("26WestReview.txt"));
        // Test 1-star rating
        assertEquals(1, Review.starRating("negativeReview.txt"));
        // Test 2-star rating
        assertEquals(2, Review.starRating("positiveReview.txt"));
    }

    @Test
    public void testFakeReview() throws IOException {
        // 20 points: Tests fakeReview by verifying it replaces adjectives with random ones from the lists.
        
        // Generate the fake review
        String fakeReview = Review.fakeReview("fakeReview.txt", true);

        // Check that the generated review is not the same as the original text
        assertNotEquals("The *quick *brown fox jumps over the *lazy dog.", fakeReview);

        // Ensure that the review still has the context of "fox jumps over the"
        assertTrue(fakeReview.contains("fox jumps over the"));

        // Check that the review does not contain any asterisks ('*'), indicating adjectives were replaced
        assertFalse(fakeReview.contains("*"));

        // Ensure that the words "quick," "brown," and "lazy" are not present in the fake review
        assertFalse(fakeReview.toLowerCase().contains("quick"));
        assertFalse(fakeReview.toLowerCase().contains("brown"));
        assertFalse(fakeReview.toLowerCase().contains("lazy"));

        // Check that the review contains at least one word with a sentiment value (positive or negative)
        boolean containsSentimentWord = containsSentimentWord(fakeReview);
        assertTrue(containsSentimentWord); // Checks if the review has any positive or negative words
    }

    @Test
    public void testFakeReviewPositive() throws IOException {
        // 20 points: Tests if the fakeReview method correctly generates a positive review.
        // Assuming fakeReview is modified to generate positive reviews

        // Read the original negative review and calculate its total sentiment
        double originalSentiment = Review.totalSentiment("negativeReview.txt");

        // Generate a positive fake review
        String positiveFakeReview = Review.fakeReview("negativeReview.txt", true);

        // Ensure that the review does not contain any asterisks ('*')
        assertFalse(positiveFakeReview.contains("*"));

        // Check if the generated review contains at least one positive word
        boolean containsPositiveWord = containsPositiveWord(positiveFakeReview);
        assertTrue(containsPositiveWord); // Checks if the review contains at least one positive word

        // Calculate the total sentiment of the positive fake review
        double fakeReviewSentiment = Review.totalSentiment("fakeReview.txt");

        // Ensure that the total sentiment of the fake review is greater than the original sentiment
        assertTrue(fakeReviewSentiment > originalSentiment);
    }

    @Test
    public void testFakeReviewNegative() throws IOException {
        // 20 points: Tests if the fakeReview method correctly generates a negative review.
        // Assuming fakeReview is modified to generate negative reviews

        // Read the original positive review and calculate its total sentiment
        double originalSentiment = Review.totalSentiment("positiveReview.txt");

        // Generate a negative fake review
        String negativeFakeReview = Review.fakeReview("positiveReview.txt", false);

        // Ensure that the review does not contain any asterisks ('*')
        assertFalse(negativeFakeReview.contains("*"));

        // Check if the generated review contains at least one negative word
        boolean containsNegativeWord = containsNegativeWord(negativeFakeReview);
        assertTrue(containsNegativeWord); // Checks if the review contains at least one negative word

        // Calculate the total sentiment of the negative fake review
        double fakeReviewSentiment = Review.totalSentiment("fakeReview.txt");

        // Ensure that the total sentiment of the fake review is less than the original sentiment
        assertTrue(fakeReviewSentiment < originalSentiment);
    }


    @Test
    public void testCheckCompilation() {
        // This test checks if the method signatures and parameter types are correct.
        // Students do not need to modify this; it's a reference for expected signatures.
        double num = Review.sentimentVal("warm"); // Should compile
        assertEquals(1.46, num, 0.01); // Adjust value based on actual data if needed
        // Uncomment the below lines to see expected compilation failures
        // String word = Review.sentimentVal(0.5); // Should not compile: Incorrect parameter type
        // double x = Review.sentimentVal("good", "bad"); // Should not compile: Incorrect number of parameters
    }

    // Helper method to check if the review contains a positive word from the sentiment map
    private boolean containsPositiveWord(String review) {
        for (String word : review.split("\\s+")) {
            Double sentimentValue = sentimentMap.get(word.toLowerCase());
            if (sentimentValue != null && sentimentValue > 0) {
                return true; // Found a positive word
            }
        }
        return false; // No positive words found
    }

    // Helper method to check if the review contains a negative word from the sentiment map
    private boolean containsNegativeWord(String review) {
        for (String word : review.split("\\s+")) {
            Double sentimentValue = sentimentMap.get(word.toLowerCase());
            if (sentimentValue != null && sentimentValue < 0) {
                return true; // Found a negative word
            }
        }
        return false; // No negative words found
    }

    // Helper method to check if the review contains any sentiment word from the sentiment map
    private boolean containsSentimentWord(String review) {
        for (String word : review.split("\\s+")) {
            if (sentimentMap.containsKey(word.toLowerCase())) {
                return true; // Found a word with sentiment value
            }
        }
        return false; // No sentiment words found
    }
}
