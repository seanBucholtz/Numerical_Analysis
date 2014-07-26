/**
 * <p>A simple program that collects integer data and calculate some simple statistics.</p>
 * 
 * <p><u>Grading Level</u>: <b>Challenge</b></p>
 * 
 * @author Sean Bucholtz
 * @version Assignment 6: Statistics
 */
public class IntegerStatistics {
  
  java.util.Scanner scan;
  // declare storage for the integers
  private int[] intArr;
  // lenth accumulator variable. provides array length & proper index value 
  private int arrLen;
  
  /**
   * zero-parameter constructor.
   * instantiates a new array, scanner, and accumulator object.
   */
  public IntegerStatistics() {
    // instantiate array
    intArr = new int[10];
    // instantiate scanner object
    scan = new java.util.Scanner(System.in);
    // instatiate array length counter
    arrLen = 0;
  } 
  /**
   * Method that displays the menu.
   */
  private void showMenu() {
    System.out.println("Menu:");
    System.out.println("   p - Print the list of values");
    System.out.println("   s - Print statistics for the values");
    System.out.println("   f - Fill the list with random values");
    System.out.println("   c - Clear the list of values");
    System.out.println("   h - Print out this menu");
    System.out.println("   x - Exit the program");
  }
  
  /**
   * Method sets the value of the array to zero.
   */
  private void clearValues() {
    // empty (zero out) the array
    for(int i = 0; i < this.arrLen; i ++) {
      intArr[i] = 0;
    }
    // zeros length accumulator variable
    this.arrLen = 0;
  }
  
  /**
   * Method populates the array with sudo-random integers.
   * range: 10 to 15 (inclusive)
   */
  private void fillList() {
    // declare and instantiate random object
    java.util.Random random = new java.util.Random();
    // fill the array
    for(int i = this.arrLen; i < 10; i ++) {
      intArr[i] = random.nextInt(26)-10;
      // increases array length accumulator variable
      this.arrLen += 1;
    }
  }
  
  /**
   * method that displays the array values.
   */
  private void printValues() {
    System.out.print("The values: [");
    // print the values
    for(int i = 0; i < this.arrLen; i ++) {
      if(i != this.arrLen-1) {
        System.out.print(intArr[i] + ", ");
      } else {
        System.out.print(intArr[i]);
      }
    }
    System.out.println("]");
  }
  
  /**
   * method sums the values of the array.
   * 
   * @return The sum of the array values.
   */
  public int getSum() {
    // declares sum value variable and instantiates it at 0
    int sum = 0;
    for(int i = 0; i < this.arrLen; i ++) {
      sum += intArr[i];
    }
    return sum;
  }
  
  /**
   * method gets the maximum value in the array.
   * 
   * @return The maximum value in the array.
   */
  public int getMax() {
    // declares max value variable and instantiates it to first array value
    int max = intArr[0];
    // declares comparison variable
    int next;
    for(int i = 0; i < this.arrLen; i ++) {
      // instantiates comparison value
      next = intArr[i];
      if(next > max){
        max = intArr[i];
      }
    }
    return max;
  }
  
  /**
   * method gets the minimum value in the array.
   * 
   * @return The minimum value in the array.
   */
  public int getMin() {
    // declares min value variable and instantiates it to first array value
    int min = intArr[0];
    // declares comparison variable
    int next;
    for(int i = 0; i < this.arrLen; i ++) {
      // instantiates comparison variable
      next = intArr[i];
      if(next < min){
        min = intArr[i];
      }
    }
    return min;
  }
  
  /**
   * method gets the average of the values in the array.
   * 
   * @return The average of the array values.
   */
  public double getAverage() {
    // declares sum value variable and instantiates it at 0
    int sum = 0;
    for(int i = 0; i < this.arrLen; i ++) {
      sum += intArr[i];
    }
    return (double) sum/this.arrLen;
  }
  
  /**
   * method gets the standard deviation of the array values.
   * 
   * @return The standard deviation of the array values.
   */
  public double getStandardDeviation() {
    // declares sum of the integer values squared variable and instantiates it at 0.
    int intSqdSum = 0;
    // declares sum of the integer values variable and instantiates it at 0.
    int intSum = 0;
    // declares the mean of the sum of the integer values squared variable.
    double intSqdMean;
    // declares the mean of the sum of the integer values variable.
    double intMean;
    // declares the square of the integer mean variable.
    double intMeanSqd;
    for(int i = 0; i < this.arrLen; i ++) {
      intSqdSum += Math.pow(intArr[i], 2);
      intSum += intArr[i];
    }
    intSqdMean = (double) intSqdSum/this.arrLen;
    intMean = (double) intSum/this.arrLen;
    intMeanSqd = Math.pow(intMean, 2);
    return intSqdMean-intMeanSqd;
  }
  
  /**
   * method gets the median of the array values.
   * 
   * @return The median of the array values.
   */
  public double getMedian() {
    // declare and instantiate array clone
    int[] intArrClone = new int[this.arrLen];
    int hold;
    // index of closest median value
    int medianIndex = (this.arrLen/2)-1;
    // create array clone
    for(int i = 0; i < this.arrLen; i ++) {
      intArrClone[i] = intArr[i];
    }
    // bubble sorts the array in accending order
    for(int x = 0; x < this.arrLen-1; x ++) {
      for(int i = 0; i < this.arrLen-1; i ++) {
        if(intArrClone[i] > intArrClone[i+1]) {
          hold = intArrClone[i+1];
          intArrClone[i+1] = intArrClone[i];
          intArrClone[i] = hold;
        }
      }
    }
    // even or odd length condition
    if(this.arrLen % 2 == 0) {
      // even length
      return (double) (intArrClone[medianIndex] + intArrClone[medianIndex+1])/2;
    } else {
      // odd length
      return (double) intArrClone[medianIndex];
    }
  }
  
  /**
   * method prints the statistics of the array values
   */
  private void printStats() {
    System.out.println("Number of values: " + this.arrLen);
    System.out.println("Sum of the values: " + this.getSum() + ".");
    // checks to see if array contains at least two values. prevents computation errors involving zero.
    if(this.arrLen >= 2) {
      System.out.println("Maximum value: " + this.getMax() + "."); 
      System.out.println("Minimum value: " + this.getMin() + ".");
      System.out.println(String.format("Average value: %.3f.", this.getAverage()));
      System.out.println(String.format("Standard deviation value: %.3f.", this.getStandardDeviation()));
      System.out.println(String.format("Median value: %.3f.", this.getMedian()));
    } else {
      System.out.println("There are no values to compute. No other statistics can be reported.");
    }
  }
  
  /**
   * method welcomes user, and prints menu and/or integer input.
   */
  public void go() {
    System.out.println("Welcome to Simple Statistics Program\n");
    // declare and instantiate input variable
    String input = "";
    showMenu();
    do {
      System.out.print("Enter a command or integer value: ");
      // Checks if stream contains integer or string menu option
      if(scan.hasNextInt()){
        // places input token into proper index 
        intArr[this.arrLen] = scan.nextInt();
        // counts/tracks proper array index value
        this.arrLen += 1;
      } else {
        input = scan.next();
        if(input.equals("p")) {
          printValues();
        } else if(input.equals("s")) {
          printStats();
        } else if(input.equals("f")) {
          fillList();
        } else if(input.equals("c")) {
          clearValues();
        } else if(input.equals("h")) {
          showMenu();
        } else if(input.equals("x")) {
          // do nothing
        } else {
          System.out.println("Unrecognized command. Try again.");
          showMenu();
        }
      }
    } while( ! input.equals("x"));
    System.out.println("\nThank you for using the Simple Statistics Program");
  }
  
  /**
   * The application method. This instantiates the class
   * and calls the IntegerStatistics constructor.
   *
   * @param args The command-line arguments
   */
  public static void main(String[] args) {
    new IntegerStatistics().go();
  }
  
}
