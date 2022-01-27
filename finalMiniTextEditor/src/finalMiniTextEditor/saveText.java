package finalMiniTextEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class saveText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		
		File f = fileChooser.getSelectedFile();
		String filename = f.getAbsolutePath();
		
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			
			notepadWindow.textArea.read(br,null);
			br.close();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}

	}

}
