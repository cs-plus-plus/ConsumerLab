# AP Consumer Lab

This lab is designed for Mr. Hare's APCS-A class, focusing on text sentiment analysis and review generation. The project includes a set of methods that students need to implement in the `Review` class, along with JUnit tests to verify their functionality.

## Project Structure

- **`Review.java`**: Contains method headers and task descriptions related to sentiment analysis and review generation. Students are required to implement the method bodies.
- **`ReviewTest.java`**: JUnit test cases for each method in `Review.java`. These tests validate the correctness of the implemented methods.
- **`pom.xml`**: Maven configuration file that manages dependencies and plugins required to build and run the project.
- **Data Files**:
  - `cleanSentiment.csv`: Contains words with their corresponding sentiment values.
  - `positiveAdjectives.txt`: A list of positive adjectives.
  - `negativeAdjectives.txt`: A list of negative adjectives.
  - Review Text Files: Includes files such as `simpleReview.txt`, `26WestReview.txt`, `negativeReview.txt`, `positiveReview.txt`, `fakeReview.txt`.

## Prerequisites

- Java 17 (or compatible version)
- Maven 3.x

## Getting Started

### Accept the Project

Use the link provided in Google Classroom to accept the project in GitHub Classroom.

### Clone the Repository

Clone this repository to your local machine using GitHub Desktop.

### Run Tests

Run the JUnit tests in `ReviewTest.java` to verify your implementations.

## Required Files and Their Usage

### 1. `positiveAdjectives.txt`
- **Purpose**: Contains a list of positive adjectives.
- **Usage**: Used by the methods `randomPositiveAdj()` and `randomAdjective()` to select random positive adjectives when generating fake reviews.
- **Student Action**: Ensure this file is populated with suitable positive adjectives.
  - **Updating Instructions**: Review the adjectives in the provided file and consider adding more positive adjectives that could be relevant to various contexts. Make sure each adjective is on a new line.

### 2. `negativeAdjectives.txt`
- **Purpose**: Contains a list of negative adjectives.
- **Usage**: Used by the methods `randomNegativeAdj()` and `randomAdjective()` to select random negative adjectives when generating fake reviews.
- **Student Action**: Ensure this file is populated with suitable negative adjectives.
  - **Updating Instructions**: Review the adjectives in the provided file and consider adding more negative adjectives that could be relevant to various contexts. Make sure each adjective is on a new line.

### 3. `cleanSentiment.csv`
- **Purpose**: Contains words and their corresponding sentiment values, which range from -1 (very negative) to 1 (very positive).
- **Usage**: Loaded into the `sentiment` map in `Review.java` to provide sentiment values for words. Used by methods such as `sentimentVal(String word)` and `totalSentiment(String fileName)`.
- **Student Action**: Verify that this file is correctly formatted and accessible.

### 4. Review Text Files
- **Files**: Includes `simpleReview.txt`, `26WestReview.txt`, `negativeReview.txt`, `positiveReview.txt`, `fakeReview.txt`.
- **Purpose**: These files contain reviews that will be analyzed and manipulated in the lab.
  - **`totalSentiment(String fileName)`**: Calculates the total sentiment of a review from a file.
  - **`starRating(String fileName)`**: Determines the star rating based on the review's total sentiment.
  - **`fakeReview(String fileName, boolean pos)`**: Generates a fake review by replacing adjectives with positive or negative adjectives based on the `pos` parameter.
- **Student Action**:
  - **Annotate Adjectives**: For tasks involving `fakeReview`, you may need to update or create review files by annotating adjectives with a special character (e.g., `*`) so that the method can identify and replace them.
  - **Create or Modify Files**: Create or modify review files as necessary to test your implementations of `totalSentiment`, `starRating`, and `fakeReview`.

## Method Descriptions

Students need to implement the following methods in `Review.java`:

1. **`sentimentVal(String word)`**: Returns the sentiment value of a given word as a number between -1 (very negative) to 1 (very positive).
2. **`totalSentiment(String fileName)`**: Calculates the total sentiment of all the words in a review text file.
3. **`starRating(String fileName)`**: Determines the star rating of a review based on the total sentiment value.
4. **`fakeReview(String fileName, boolean pos)`**: Generates a fake review by replacing adjectives in the original review with random positive or negative adjectives depending on the `pos` parameter.

## Reference Material

For more detailed guidance on completing the Consumer Review Lab, refer to the [AP Computer Science A Consumer Review Lab Student Guide](https://apcentral.collegeboard.org/media/pdf/ap-computer-science-a-consumer-review-lab-student-guide.pdf).

## Common Mistakes to Avoid

- **Infinite Loops**: Make sure loop variables change appropriately to avoid infinite loops.
- **Incorrect Method Signatures**: Double-check that method signatures match the provided descriptions exactly.
- **File Not Found Errors**: Ensure all required data files (`cleanSentiment.csv`, `positiveAdjectives.txt`, `negativeAdjectives.txt`) are in the correct directory.
- **Incorrect Sentiment Values**: Verify values in `cleanSentiment.csv` and ensure that your code correctly reads and interprets the data.

## Running the Unit Tests

JUnit tests have been provided in `ReviewTest.java` to help verify your method implementations. Each test method is associated with a specific part of the lab and is assigned a point value.

### Test Descriptions and Point Values

1. **`testTotalSentiment`** - **40 points**  
   This test checks whether the `totalSentiment` method correctly calculates the sum of sentiment values for a review.

2. **`testStarRating`** - **30 points**  
   This test verifies the `starRating` method to ensure it accurately assigns star ratings based on the review's total sentiment value.

3. **`testFakeReview`** - **10 points**  
   This test ensures that the `fakeReview` method replaces adjectives in the review with random adjectives from the positive or negative lists as appropriate.

4. **`testFakeReviewPositive`** - **10 points**  
   This test checks if the `fakeReview` method can generate a positive review by confirming the presence of positive words.

5. **`testFakeReviewNegative`** - **10 points**  
   This test verifies if the `fakeReview` method can generate a negative review by confirming the presence of negative words.

### Total Points: 100

Uncomment and run the tests in `ReviewTest.java` once you have implemented the corresponding methods to verify their correctness. Use the test descriptions above to understand the purpose of each test and the associated point values.

## Contributing

Feel free to submit issues or pull requests if you find bugs or have suggestions for improvement.

## Contact

For any questions, please contact [kevin@csplusplus.com](mailto:kevin@csplusplus.com)
