import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import javax.swing.*;
/*
 * Created by JFormDesigner on Sun Dec 03 16:04:35 EST 2023
 */

import org.ini4j.Ini;



/**
 * @author leviathan
 */
public class Loader extends JFrame {
	public Loader() {
		Load();
	}

	public void Load() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
		// Generated using JFormDesigner Evaluation license - Leviathan
		label1 = new JLabel();
		label2 = new JLabel();
		progressBar1 = new JProgressBar();

		//======== this ========
		setTitle("Azalia | SecurePignus Loader v1.2");
		setVisible(true);
		setResizable(false);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		//---- label1 ----
		label1.setText("Azalia");
		label1.setFont(new Font("Liberation Sans", Font.ITALIC, 36));
		contentPane.add(label1);
		label1.setBounds(130, 20, 130, 60);

		//---- label2 ----
		label2.setText("Loading ${PROGRESS}%");
		contentPane.add(label2);
		label2.setBounds(new Rectangle(new Point(105, 135), label2.getPreferredSize()));
		contentPane.add(progressBar1);
		progressBar1.setBounds(0, 225, 400, 30);

		{
			// compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < contentPane.getComponentCount(); i++) {
				Rectangle bounds = contentPane.getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = contentPane.getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			contentPane.setMinimumSize(preferredSize);
			contentPane.setPreferredSize(preferredSize);
		}
		setSize(400, 300);
		setLocationRelativeTo(getOwner());
        File file = new File("bin/LOADSTAT");  
		try {
            FileReader fReader = new FileReader(file);
            Ini fIni = new Ini(fReader);
            String Rfiles = (fIni.get("LoaderInfo", "Files"));
            ArrayList<String> sArrayList = new ArrayList<String>();
            
            String[] files = Rfiles.split(",");
            for (String lString : files) {
                sArrayList.add(lString);
            }
            File folder = new File("bin");
            File[] listOfFiles = folder.listFiles();
            boolean hasFailed = false;
            Utils.print(listOfFiles);
           
            
            //[] -> {}
            //[file, item2, item3, ...] -> {item1: true, item2: true, item3: true}
            
            for (int i = 0; i < listOfFiles.length; i++) {
              if (listOfFiles[i].isFile()) {
                //System.out.println("File " + listOfFiles[i].getName());
                String fileName = listOfFiles[i].getName();
                if (sArrayList.contains(fileName)){
                    Thread.sleep(300);
                    UpdateProgress(listOfFiles.length % 100 / 2);
                }else{
                    hasFailed = true; 
                    BailOut();
                }
                
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
              }
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        } 
	}
    private void UpdateProgress(int ptoA){
        Utils.print(progressBar1.getValue());
        progressBar1.setValue(progressBar1.getValue() + ptoA);
        label2.setText("Loading "+progressBar1.getValue()+"%");
        if(progressBar1.getValue() >= 100){
            dispose();
            App.afterLoad();
        }
        
    }
    private void BailOut(){ 
        Thread.currentThread().stop();
    }

	private JLabel label1;
	private JLabel label2;
	private JProgressBar progressBar1;
	
}