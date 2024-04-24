import structures.AssociativeArray;

/**
 * A classs that represents the mappings for a single page of items that should be displayed
 *
 * @author Nye Tenerelli
 */
public class AACCategory {
  
  AssociativeArray<String, String> arr;
  String category;



  public AACCategory(String category) {
    arr = new AssociativeArray<String, String>();
    this.category = category;
  }

  public void addItem​(String imageLoc, String text) {
    try {
    this.arr.set(imageLoc, text);
    } catch (Exception e){
        System.out.println("NEINNNN");
    }
  }

  public String getCategory(){
    return this.category;
  }

  public String[] getImages(){
    String imag[] = new String[this.arr.size()];
    for(int i = 0; i < this.arr.size(); i++) {
      imag[i] = this.arr.getKey(i);
    }
    return imag;
  }

  public String getText(String txt){
    try{
      return this.arr.get(txt);
    } catch(Exception e) {
      System.out.println("SHIZZLE AINT HERE");
    }
    return txt;
  }

  public boolean hasImage​(String imageLoc) {
    try { 
      this.arr.find(imageLoc);
      return true;
    } catch (Exception e){
      return false;
    }
  }
}
