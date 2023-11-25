/**
 * @author Leviathenn, pwitzel
 * 25 November 2023
 */
import javax.swing.JFrame;


public class App {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Azalia");
		
		window.add(new GamePanel());
		
		window.pack();
	
		window.setLocationRelativeTo(null);
		window.setVisible(true);
        SaveFile.ParseSave();
    }
	
	
}