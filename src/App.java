/**
 * @author Leviathenn, PrestonWitzel
 * 25 November 2023
 */
import javax.swing.JFrame;


public class App {
	public static void afterLoad() {
		
	}
	public static void main(String[] args) {
		//Loader loader = new Loader();
		//loader.Load();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Azalia");
		GamePanel gp = new GamePanel();
		window.add(gp);
		
		window.pack();
        
	
		window.setLocationRelativeTo(null);
		window.setVisible(true);
        SaveFile save = new SaveFile(gp);
        save.ParseSave();
		
		
		
		
    }
	
	
}