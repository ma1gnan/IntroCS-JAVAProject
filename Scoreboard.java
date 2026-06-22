import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
// This program stores the final scores for each game in an ArrayList
public class Scoreboard
{
  private ArrayList<Integer> scoreList;
  private int firstPlace;
  private int secondPlace;
  private int thirdPlace;
  public Scoreboard(){
    scoreList = new ArrayList<Integer>();
    firstPlace = -1;
    secondPlace = -1;
    thirdPlace = -1;
  }
  public void addToList(int finalScore){
    scoreList.add(finalScore);
  }
  //sorts scoreList in descending order (bubble sort algorithm)
  //updated to score when there are less than 3 top scores in scorelist
  //
  public void findTopThree(){ //finds the top 3 scores in scoreList
    boolean sort = false;
    int temp;
    while(!sort){
      sort = true;
      for(int i = 0; i < scoreList.size() - 1; i++){
        if(scoreList.get(i) < scoreList.get(i+1)){
          temp = scoreList.get(i);
          scoreList.set(i, scoreList.get(i+1));
          scoreList.set(i+1, temp);
          sort = false;
        }
      }
    }
    if(scoreList.size() > 0){
      firstPlace = scoreList.get(0);
      if(scoreList.size() > 1){
        secondPlace = scoreList.get(1);
        if(scoreList.size() > 2){
          thirdPlace = scoreList.get(2);
        }
      }
    }
  }
  //writes the scores to "topthreescore"
  //if there are no scores, the program won't print anything
  public void setScoreboard(){
    File outfile = new File("topthreescore.txt");
    PrintWriter writer;
    try {
      writer = new PrintWriter("topthreescore.txt");
    } catch(FileNotFoundException exception){
      System.out.println("File not found.");
      return;
    }
    //if a place value is updated, then it gets written to writer
    if(firstPlace >= 0){
      writer.println("" + firstPlace);
      if(secondPlace >= 0){
        writer.println("" + secondPlace);
        if(thirdPlace >= 0){
          writer.println("" + thirdPlace);
        }
      }
    }
    writer.close();
    Scanner read;
    try {
      read = new Scanner(outfile);
    }
    catch(FileNotFoundException exception){
      System.out.println("File not found.");
      return;
    }
    catch(NoSuchElementException exception){
      System.out.println("No such element.");
      return;
    }
    //if it reads something(score) in the next line, it gets read by the scanner
    if(read.hasNext()){
      String p1 = read.next();
      System.out.println("1st Place: " + p1);
      if(read.hasNext()){
        String p2 = read.next();
        System.out.println("2nd Place: " + p2);
        if(read.hasNext()){
          String p3 = read.next();
          System.out.println("3rd Place: " + p3);
        }
      }
    }
    read.close();
  }
}