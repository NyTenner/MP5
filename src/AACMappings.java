import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import structures.AssociativeArray;
import structures.KeyNotFoundException;
import structures.NullKeyException;

/**
 * A classs that helps map filenames to their corresponding words
 *
 * @author Nye Tenerelli
 */

public class AACMappings {

    AssociativeArray<String, AACCategory> categs;
    AACCategory curCat;
    AACCategory home;

    public AACMappings(String file) throws KeyNotFoundException, NullKeyException {
        this.home = new AACCategory("");
        this.curCat = this.home;
        this.categs = new AssociativeArray<String, AACCategory>();

        try {
          File txtf = new File(file);
          Scanner input = new Scanner(txtf);

          while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] lines = line.split(" ", 2);

            if (!line.substring(0, 1).equals(">")) {
              // System.out.println(lines[0].substring(1, lines[0].length()));
              // System.out.println(lines[1]);

              this.home.addItem​(lines[0], lines[1]);
              this.categs.set(lines[0], new AACCategory(lines[1]));
              this.curCat = this.categs.get(lines[0]);
              
            } else {
              // System.out.println(lines[0]);
              this.categs.set(lines[0], new AACCategory(lines[1]));
              this.curCat.addItem​(lines[0].substring(1, lines[0].length()), lines[1]);
            }
          }
          this.curCat = this.home;
          input.close();
        }catch (FileNotFoundException e){

        }




        //this.categ = new AssociativeArray<String, AACCategory>();
        try{
        this.categs.set(file, new AACCategory(file));
        } catch (Exception e){

        }
    }

    public void add​(String imageLoc, String text){
      this.curCat.addItem​(imageLoc, text);

    }
    public String[] getImageLocs() {
        return this.curCat.getImages(); // STUB
      } // getImageLocs()
    
      public String getText(String imageLoc) throws KeyNotFoundException {
        if (this.getCategory().equals("") ){
          this.curCat = this.categs.get(imageLoc);
          return this.home.getText(imageLoc);
        } else{
          return curCat.getText(imageLoc); 
        }
      }
    
      public String getCategory() {
        return this.curCat.getCategory();  // STUB
      }

      public void reset() {
        this.curCat = this.home;
      }

      public boolean isCategory​(String imageLoc){
        return this.home.hasImage​(imageLoc);
      }

      public void writeToFile(String fileName) throws KeyNotFoundException{
        // System.out.println(categs.size());
        try {
          PrintWriter pw = null;
          pw = new PrintWriter(fileName);
          int num = 0;
          for (int i = 0; i+1 < categs.size(); i++) {

            pw.println(categs.getKey(i) + " " + categs.get(categs.getKey(i)).getCategory());

          }

          if (pw != null) {
          pw.close();
          }
        } catch (IOException e) {
              e.printStackTrace();
        }
      }


      // public void writeToFile(String fileName) throws KeyNotFoundException{
      //   try {
      //     PrintWriter pw = null;
      //     pw = new PrintWriter(fileName);
      //     for (int i = 0; i < categs.size(); i++) {
            
      //       // for (String cur : categs.get(this.categs.getKey(i)).getImages()) {
      //       //   pw.println(">" + cur + " " + categs.get(this.categs.getKey(i)).getText(cur));
      //       //   pw.println(">" + getCategory() + "/" + this.categs.getKey(i) + "/" + cur + " " + categs.get(this.categs.getKey(i)).getText(cur));
      //       // }
      //         pw.println(">" + categs[i] + " " + categs[i].get(this.categs.getKey(i)).getText(cur));
      //         pw.println(">" + getCategory() + "/" + this.categs.getKey(i) + "/" + cur + " " + categs.get(this.categs.getKey(i)).getText(cur));

      //       // File file = new File(fileName);
      //       // FileWriter fw = new FileWriter(file, true);

      //     }

      //     if (pw != null) {
      //     pw.close();
      //     }
      //   } catch (IOException e) {
      //         e.printStackTrace();
      //   }
      // }
      
}
