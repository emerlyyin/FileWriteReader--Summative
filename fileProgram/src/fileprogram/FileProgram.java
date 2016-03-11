/*
 * Created by Emily Rain Yin 
 * March 8, 2016
 * To replace chosen words from a text file with a word inputted by user.
 */
package fileprogram;

/**
 *
 * @author raind
 */
//imports for scanner and read/write streams
import java.util.Scanner;
import java.io.*;
public class FileProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //creates a file object from text file that already exists
        File paragraph = new File ("Y:\\ICS4U\\madLibsFile.txt");
        
        //declaring file writers
        FileWriter out;
        BufferedWriter writeFile;
        
        //declaring file readers
        FileReader in;
        BufferedReader readFile;
       
        //declaring scanner to get input from user
        Scanner input = new Scanner (System.in);
        
        //declaring string variables for later use
        String text;
        String entireParagraph=""; 
        String fileParagraph;
        String words, changeWord;
        
        
        
         try{
            //the file reader reads the file 
            in = new FileReader(paragraph);
            readFile = new BufferedReader(in);
             
            //reads each line of the file until all lines of file are read
            while ((fileParagraph = readFile.readLine()) !=null){
               //sets the text file as the string variable declared
               entireParagraph=fileParagraph;   
            
            }
                //closes the file reader streams 
                readFile.close();
                in.close();
            
            //the file writer writes to the file    
            out = new FileWriter(paragraph);
            writeFile = new BufferedWriter (out);
            
            System.out.println("Input the words nounOne, nounTwo, nounThree, nounFour, nounFive, nounSix to replace.");
            //loops until 6 words are inputted to change by user
            for (int i=0; i<6; i++){
                //inputs words by user
                System.out.print("Enter word to replace: ");
                words = input.nextLine();
            
                System.out.print("Enter a word: ");
                changeWord = input.nextLine();
                    
                    //replaces words inputted by user with word the user wishes to replace it with
                    entireParagraph=entireParagraph.replaceAll(words, changeWord);
                    
                    
            }
                //words are written to file
                    writeFile.write(entireParagraph);
                //displays the paragraph    
                System.out.println(entireParagraph);
                
                writeFile.close();
                out.close();
                
      
                System.out.println("Data writtern to file.");
            
            //if the file isn't found then this message will show up
            }catch (FileNotFoundException e){
            System.out.println("File does not exist or could not be found.");
            System.err.println("FileNotFoundException: " + e.getMessage());
            
            //if there is a problem with writing the input to the file these messages will appear
            }catch (IOException e){
            System.out.println("Problem writing to file.");
            System.err.println("IOException: " + e.getMessage());
            }
        
        
       
    }
    
        
    
    
}
