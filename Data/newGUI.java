package Data;
@Controller 
public class newGUI { 
@Autowired 
private World world; 

 public DataGUI{
      world= new World();
 }





public void findDiet(){
String color = inputField.getText(); 
String diet = world.getDietByColor(color); 
// Call the World service
resultArea.setText("Diet(s) for color " + color + ": " + diet);
}

