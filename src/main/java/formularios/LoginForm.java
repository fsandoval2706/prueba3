package formularios;

import java.awt.EventQueue;
import mantenimiento.GestionUsuario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textFieldUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblusuario = new JLabel("Usuario:");
		lblusuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblusuario.setBounds(59, 96, 65, 14);
		contentPane.add(lblusuario);
		
		JLabel lblpass = new JLabel("Contraseña:");
		lblpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpass.setBounds(59, 134, 86, 14);
		contentPane.add(lblpass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(169, 133, 123, 20);
		contentPane.add(passwordField);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(169, 95, 123, 20);
		contentPane.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnSalir.setBounds(56, 187, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnIngresar.setBounds(238, 187, 109, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel = new JLabel("BANCO PLATINUM");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(155, 35, 172, 29);
		contentPane.add(lblNewLabel);
	}

	protected void ingresar() {
		// TODO Auto-generated method stub
		String username=textFieldUsuario.getText();
		String password=String.valueOf(passwordField.getPassword());
		
		
		GestionUsuario gestionUsuario=new GestionUsuario();
		
		Usuario usuario2=new Usuario();
		
		usuario2.setUsername(username);
		usuario2.setPassword(password);
		
		
		Usuario usu=gestionUsuario.obtenerUsuario(usuario2);
		
		if(usu!=null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			
			this.dispose();
			
			BienvenidaForm bienvenida=new BienvenidaForm();
			bienvenida.setVisible(true);
			
		}else {
			JOptionPane.showMessageDialog(contentPane, "Datos Invalidos", "ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void salir() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
