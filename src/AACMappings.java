import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import structures.AssociativeArray;
import structures.KeyNotFoundException;

/**
 * A classs that helps map filenames to their corresponding words
 *
 * @author Nye Tenerelli
 */

public class AACMappings {

    String file;
    AssociativeArray<String, AACCategory> categs;
    AACCategory curCat;
    AACCategory home;

    public AACMappings(String file) {
        this.file = file;
        this.home = new AACCategory(file);
        this.curCat = new AACCategory("");
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
        try {
          PrintWriter pw = null;
          pw = new PrintWriter(fileName);
          for (int i = 0; i < categs.size(); i++) {
            
            for (String cur : categs.get(this.categs.getKey(i)).getImages()) {
              pw.println(">" + getCategory() + "/" + this.categs.getKey(i) + "/" + cur + " " + categs.get(this.categs.getKey(i)).getText(cur));
            }

            // File file = new File(fileName);
            // FileWriter fw = new FileWriter(file, true);

          }

          if (pw != null) {
          pw.close();
          }
        } catch (IOException e) {
              e.printStackTrace();
        }
      }
      
}
