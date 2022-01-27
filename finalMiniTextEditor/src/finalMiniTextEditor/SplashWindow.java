//24/01/2022
//Completed. TODO Enhancement if Any

package finalMiniTextEditor;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;

public class SplashWindow extends JFrame {

	private JPanel contentPane;
	private static JProgressBar progressBar;
	public static SplashWindow frame;
	private static JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
					frame = new SplashWindow();
					frame.setVisible(true);	
					
					int x;
					try {
						for(x=0;x<=100;x++) {
							SplashWindow.progressBar.setValue(x);
							Thread.sleep(40);
							SplashWindow.lblNewLabel_2.setText(Integer.toString(x)+"%");
							
							if(x==100) {
								frame.dispose();
								try {
									Thread.sleep(1000);
									notepadWindow window = new notepadWindow();
									window.frmMiniTextEditor.setVisible(true);
									}
									catch(Exception E) {
										//no code
										
									}
							}
						}
					}
					catch(Exception e) {
						//no code
					}
					
	}

	/**
	 * Create the frame.
	 */
	public SplashWindow() {
		setBackground(Color.BLACK);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(36, -15, 516, 650);
		contentPane.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/Developers.gif"));
		lblNewLabel.setIcon(icon);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0, 128, 0));
		progressBar.setBounds(86, 661, 428, 27);
		contentPane.add(progressBar);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setBounds(273, 631, 70, 27);
		contentPane.add(lblNewLabel_2);
		
		

	}
}
