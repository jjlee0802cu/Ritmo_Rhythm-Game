import java.io.*;
/**
 * FileReaderTest.java  
 *
 * @author:
 * Assignment #:
 * 
 * Brief Program Description:
 * 
 *
 */
public class FileReaderTest
{
    public static void main(String s[]) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("test.TXT"));
            String first = br.readLine();
            String second = br.readLine();
            String[] strArray = second.split(" ");
            int[] intArray = new int[strArray.length];
            for (int i = 0; i < intArray.length; i++){
                intArray[i] = Integer.parseInt(strArray[i]);
                System.out.print(intArray[i]);
            }
            
            System.out.println(first);
            
            
            
            //Levels will be stored in folders according to level name
            //Each folder will contain the song in wav format and a text file
            //The text file will store information like so
            // 
        }

        catch (IOException e){

        }
    }
}
