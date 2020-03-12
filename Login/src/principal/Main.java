package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import clases.IoDatos;

import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Frame;

public class Main extends JFrame {

	private JPanel contentPane;
	private JLabel lblFondo;
	private JTextField textFieldUser;
	private JPasswordField passwordFieldPass;
	private JLabel lblEnter;
	private JLabel lblExit;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setUndecorated(true);
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("LOGIN");
		setType(Type.UTILITY);
		setBounds(100, 100, 349, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblExit = new JLabel("");
		lblExit.addMouseListener(new LblExitMouseListener());
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setBounds(13, 384, 33, 32);
		contentPane.add(lblExit);

		lblEnter = new JLabel("");
		lblEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnter.addMouseListener(new LblEnterMouseListener());
		lblEnter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEnter.setBounds(151, 280, 51, 49);
		contentPane.add(lblEnter);

		passwordFieldPass = new JPasswordField();
		passwordFieldPass.addKeyListener(new PasswordFieldPassKeyListener());
		passwordFieldPass.addMouseListener(new PasswordFieldPassMouseListener());
		passwordFieldPass.addFocusListener(new PasswordFieldPassFocusListener());
		passwordFieldPass.setForeground(Color.LIGHT_GRAY);
		passwordFieldPass.setFont(new Font("Tahoma", Font.ITALIC, 12));
		passwordFieldPass.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldPass.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		passwordFieldPass.setBounds(132, 202, 110, 25);
		contentPane.add(passwordFieldPass);

		textFieldUser = new JTextField();
		textFieldUser.addKeyListener(new TextFieldUserKeyListener());
		textFieldUser.addMouseListener(new TextFieldUserMouseListener());
		textFieldUser.addFocusListener(new TextFieldUserFocusListener());
		textFieldUser.setText("Insert User...");
		textFieldUser.setForeground(Color.LIGHT_GRAY);
		textFieldUser.setFont(new Font("Tahoma", Font.ITALIC, 12));
		textFieldUser.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldUser.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		textFieldUser.setBounds(132, 150, 110, 25);
		contentPane.add(textFieldUser);
		textFieldUser.setColumns(10);

		lblFondo = new JLabel("");
		lblFondo.addMouseListener(new LblFondoMouseListener());
		lblFondo.setIcon(new ImageIcon(".\\recursos\\fondo.jpg"));
		lblFondo.setBounds(0, 0, 349, 429);
		contentPane.add(lblFondo);
		passwordFieldPass.setEchoChar((char) 0);
		passwordFieldPass.setText("Insert Pass...");
		textFieldUser.setFocusable(false);
		passwordFieldPass.setFocusable(false);
		lblEnter.setToolTipText("Login");
		lblExit.setToolTipText("Salir");
		setShape(new RoundRectangle2D.Double(0, 0, lblFondo.getWidth(), lblFondo.getHeight(), 50, 50));
	}

	private class LblExitMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		}
	}

	private class TextFieldUserFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			if (textFieldUser.getText().equalsIgnoreCase("Insert User...")) {
				textFieldUser.setText("");
				textFieldUser.setFont(new Font("Tahoma", Font.BOLD, 12));
				textFieldUser.setForeground(Color.BLACK);
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if (textFieldUser.getText().isEmpty()) {
				textFieldUser.setText("Insert User...");
				textFieldUser.setFont(new Font("Tahoma", Font.ITALIC, 12));
				textFieldUser.setForeground(Color.LIGHT_GRAY);
			}
		}
	}

	private class PasswordFieldPassFocusListener extends FocusAdapter {
		@Override
		public void focusGained(FocusEvent e) {
			password = String.valueOf(passwordFieldPass.getPassword());
			if (password.equals("Insert Pass...") && passwordFieldPass.getEchoChar() != '●') {
				passwordFieldPass.setText("");
				passwordFieldPass.setFont(new Font("Tahoma", Font.BOLD, 12));
				passwordFieldPass.setForeground(Color.BLACK);
				passwordFieldPass.setEchoChar('●');
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			password = String.valueOf(passwordFieldPass.getPassword());
			if (password.isEmpty()) {
				passwordFieldPass.setEchoChar((char) 0);
				passwordFieldPass.setForeground(Color.LIGHT_GRAY);
				passwordFieldPass.setFont(new Font("Tahoma", Font.ITALIC, 12));
				passwordFieldPass.setText("Insert Pass...");
			}
		}
	}

	private class LblEnterMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			login();
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			password = String.valueOf(passwordFieldPass.getPassword());
			if ((password.equals("Insert Pass...") && passwordFieldPass.getEchoChar() != '●')
				|| textFieldUser.getText().equalsIgnoreCase("Insert User...") || password.isEmpty()
				|| textFieldUser.getText().isEmpty()) {
				lblEnter.setIcon(new ImageIcon("./recursos/cancel.png"));
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblEnter.setIcon(new ImageIcon());
		}
	}

	private class TextFieldUserMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			textFieldUser.setFocusable(true);
			textFieldUser.requestFocus();
			passwordFieldPass.setFocusable(true);
		}
	}

	private class PasswordFieldPassMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			passwordFieldPass.setFocusable(true);
			passwordFieldPass.requestFocus();
			textFieldUser.setFocusable(true);
		}
	}

	private class LblFondoMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			passwordFieldPass.setFocusable(false);
			textFieldUser.setFocusable(false);
		}
	}

	private class TextFieldUserKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				login();
			}
		}
	}
	
	private void login() {
		passwordFieldPass.setFocusable(false);
		textFieldUser.setFocusable(false);
		password = String.valueOf(passwordFieldPass.getPassword());
		if ((password.equals("Insert Pass...") && passwordFieldPass.getEchoChar() != '●')
				|| textFieldUser.getText().equalsIgnoreCase("Insert User...") || password.isEmpty()
				|| textFieldUser.getText().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane,
					"Debe rellenar todos los campos antes de proceder al login.", "Error", 0);
		} else if (IoDatos.verificarLogin(textFieldUser.getText(), password)) {
			JOptionPane.showMessageDialog(rootPane, "¡Usuario loggeado con éxito!", "Login", 1);
			User userFrame = new User(textFieldUser.getText());
			userFrame.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrectos", "Error", 0);
		}
	}

	private class PasswordFieldPassKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				login();
			}
		}
	}
}
