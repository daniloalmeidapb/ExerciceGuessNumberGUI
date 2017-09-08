package com.deitel.exercicios.Capitulo12.Cap12_14;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.security.SecureRandom;

public class GuessNumber extends JFrame
{
	SecureRandom random = new SecureRandom();
	
	private JPanel contentPane;
	private JTextField textField;
	private final int randomNumber = 1 + random.nextInt( 1000 );
	
	/**
	 * Launch the application.
	 */
	public static void main( String[] args )
	{
		EventQueue.invokeLater( new Runnable()
		{
			public void run()
			{
				try
				{
					GuessNumber frame = new GuessNumber();
					frame.setVisible( true );
				}
				catch( Exception e )
				{
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	public GuessNumber()
	{
		setTitle("Guess Number");
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 400, 400, 479, 168 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		setContentPane( contentPane );
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Eu tenho um n\u00FAmero de 1 \u00E0 1000. Voc\u00EA pode achar meu n\u00FAmero?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 443, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblEntreComUm = new JLabel("Entre com um n\u00FAmero:");
		lblEntreComUm.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEntreComUm.setBounds(52, 55, 128, 15);
		contentPane.add(lblEntreComUm);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 98, 443, 20);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(186, 52, 98, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				
				try
				{
					int choice = convertTextInNumber( textField );
					
					if( choice == randomNumber )
					{
						lblNewLabel_1.setText( "Voc� acertou" );
						textField.setEnabled( false );
						
						contentPane.setBackground( Color.GREEN );
						
						btnNewButton.setEnabled( false );
					}
					else if( choice < randomNumber )
					{
						lblNewLabel_1.setText( "Too High" );
						textField.setText( "" );
					}
					else
					{
						lblNewLabel_1.setText( "Too Low" );	
						textField.setText( "" );
					}
				}	
				catch( NumberFormatException e )
				{
					JOptionPane.showMessageDialog( GuessNumber.this, "Inv�lido, voc� inseriu uma string" );
				}	
				catch( IllegalArgumentException e )
				{
					JOptionPane.showMessageDialog( GuessNumber.this, "Inv�lido, insira um n�mero entre 1 � 1000" );
				}			
			
			}
		});
		btnNewButton.setBounds(309, 51, 89, 23);
		contentPane.add(btnNewButton);
	
	}
	
	public static int convertTextInNumber( JTextField text )
	{
		int number = Integer.parseInt( text.getText() );
		
		if( number < 1 || number > 1000 )
			throw new IllegalArgumentException();

		
		return number;
	}
}
