import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
	 private PrintStream ps;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		
					GUI frame = new GUI();
					frame.setVisible(true);
					
				
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 483);
	
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 484, 168);
		contentPane.add(scrollPane);
		JTextArea txtrScreen = new JTextArea();
		txtrScreen.setBounds(14, 13, 527, 263);
		contentPane.add(txtrScreen);
		scrollPane.setViewportView(txtrScreen);
		JTextArea txtrInput = new JTextArea();
		txtrInput.setBounds(24, 289, 518, 80);
		txtrInput.setText("please input statement in the textarea.");
		contentPane.add(txtrInput);
		
		JButton btnNewButton = new JButton("input");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String input=txtrInput.getText();
					System.out.println(input);
					
					A.run(getInputStreamFromString(input));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(420, 396, 113, 27);
		contentPane.add(btnNewButton);
		txtrScreen.setEditable(false);
		 ps = new PrintStream(System.out){
		      public void println(String x) {
		        txtrScreen.append(x + "\n");
		        txtrScreen.setCaretPosition(txtrScreen.getText().length());
		      }
		      public void print(String x){
		    	  txtrScreen.append(x);
		      txtrScreen.setCaretPosition(txtrScreen.getText().length());}
		      
		      public void print(double x){
		    	  txtrScreen.append(String.valueOf(x));
		      txtrScreen.setCaretPosition(txtrScreen.getText().length());}
		      };
		      System.setOut(ps);
	}
	public InputStream getInputStreamFromString(String str){  
		  
	    InputStream in=new ByteArrayInputStream(str.getBytes());
		return in;  
	}  
}
