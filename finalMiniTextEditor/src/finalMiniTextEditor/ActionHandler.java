package finalMiniTextEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ActionHandler implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

				int res = (int)JOptionPane.showConfirmDialog(notepadWindow.textArea, "Do you want to save whats's on panel ?");
				if(res == 0) {
					//code to redirect to save content
				}
				else {
					notepadWindow.textArea.setText("");
				}
			
			}
	}


