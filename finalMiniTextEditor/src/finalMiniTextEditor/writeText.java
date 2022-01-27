package finalMiniTextEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JOptionPane;

public class writeText implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		try {
			String fileName = (String)JOptionPane.showInputDialog("File name");
			if(fileName.equals("")) {
				JOptionPane.showMessageDialog(null, "Invalid Filename");
			}
			else {
			FileWriter writer = new FileWriter(""+fileName);
			
			BufferedWriter bw = new BufferedWriter(writer);
			
			notepadWindow.textArea.write(bw);
			bw.close();
		    //JOptionPane.showMessageDialog(null, "written");
			
		    //notepadWindow.textArea.setText("");
			notepadWindow.textArea.requestFocus();
			}
			
		}
		catch(Exception E){
			JOptionPane.showMessageDialog(null, E);
		}

	}

}
