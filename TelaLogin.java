

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.Cursor;
import java.awt.Dimension;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void close() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	
	
	public TelaLogin() throws IOException {
		Log.log("Tela de Login iniciada.");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/images/spaceship_png-7.png")));
		setPreferredSize(new Dimension(800, 600));
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("TelaLogin by Valoriza");
		setBackground(Color.WHITE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtAviso = new JLabel("");
		txtAviso.setForeground(Color.RED);
		txtAviso.setFont(new Font("Consolas", Font.BOLD, 11));
		txtAviso.setBounds(167, 223, 247, 14);
		contentPane.add(txtAviso);
		
		JButton btnTelaLogin = new JButton("Entrar");
		btnTelaLogin.setBackground(Color.LIGHT_GRAY);
		btnTelaLogin.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		btnTelaLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTelaLogin.setFont(new Font("Consolas", Font.BOLD, 11));
		btnTelaLogin.addActionListener(new ActionListener() {
		
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Login login = null;
				try {
					login = new Login();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				int estado = 0;
				try {
					estado = login.logar(txtUser.getText(), txtPassword.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				switch(estado) {
					case 1:
					try {
						Main.abrirJanela(1);
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						close();
						break;
					case 2:
					try {
						Main.abrirJanela(2);
					} catch (IOException | ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
						close();
						break;
					case 4:
						txtAviso.setText("Usuário não Encontrado");
						break;
					case 5:
						txtAviso.setText("Senha Errada");
						break;
				
				}		
			}
		});
		btnTelaLogin.setBounds(167, 189, 89, 23);
		contentPane.add(btnTelaLogin);
		
		txtUser = new JTextField();
		txtUser.setBounds(167, 95, 89, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblValoriza = new JLabel("Valoriza");
		lblValoriza.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/spaceship_png-7.png")));
		lblValoriza.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblValoriza.setBounds(141, -12, 131, 96);
		contentPane.add(lblValoriza);
		
		txtPassword = new JPasswordField();
		txtPassword.setToolTipText("password");
		txtPassword.setBounds(167, 151, 89, 20);
		contentPane.add(txtPassword);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setFont(new Font("Consolas", Font.BOLD, 11));
		lblUser.setBounds(167, 70, 89, 14);
		contentPane.add(lblUser);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Consolas", Font.BOLD, 11));
		lblPassword.setBounds(167, 126, 89, 14);
		contentPane.add(lblPassword);
		
		SwingUtilities.getRootPane(btnTelaLogin).setDefaultButton(btnTelaLogin);


	}
}
