package dbcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class LoginGui extends JFrame {
	public LoginGui() {
		getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(68, 32, 82, 14);
		getContentPane().add(lblUsername);
		
		final TextField uNameField = new TextField();
		uNameField.setBounds(167, 32, 110, 22);
		getContentPane().add(uNameField);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(68, 74, 82, 14);
		getContentPane().add(lblPassword);
		
		final TextField uPassField = new TextField();
		uPassField.setBounds(167, 74, 110, 22);
		getContentPane().add(uPassField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(68, 122, 89, 23);
		btnLogin.addActionListener(new ActionListener(){
	          public void actionPerformed(ActionEvent ae){
	        	  // if send is clicked it takes the text from the sendField and sends it to the server
		             if(uNameField.getText().length() > 0){
		            	 if(uPassField.getText().length() > 0){
			            	 new gui();
			             }
			             else{
			            	 
			             } 
		             }
		             else{
		            	 
		             }
		            } 
		        });
		getContentPane().add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(188, 122, 89, 23);
		getContentPane().add(btnExit);
		
		this.setVisible(true);
		this.setSize(362,203);
		this.getContentPane().setLayout(null);
	}
	
	public static void main(String[] args){
		new LoginGui();
		
	}

}
