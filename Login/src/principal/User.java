package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class User extends JFrame {

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblNombreUsuario;
	private JLabel lblReturn;
	private JLabel lblAgenda;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User("");
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
	public User(String nombreUsuario) {
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 359, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblReturn = new JLabel("");
		lblReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReturn.addMouseListener(new LblReturnMouseListener());
		
		lblAgenda = new JLabel("");
		lblAgenda.addMouseListener(new LblAgendaMouseListener());
		lblAgenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgenda.setIcon(new ImageIcon("C:\\Users\\MICAELA\\git\\LoginFrame\\Login\\recursos\\agenda.png"));
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setBounds(141, 101, 66, 66);
		contentPane.add(lblAgenda);
		lblReturn.setIcon(new ImageIcon("C:\\Users\\MICAELA\\git\\LoginFrame\\Login\\recursos\\return.png"));
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturn.setBounds(10, 370, 45, 45);
		contentPane.add(lblReturn);
		
		lblNombreUsuario = new JLabel(nombreUsuario);
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setForeground(new Color(204, 51, 51));
		lblNombreUsuario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblNombreUsuario.setBounds(68, 11, 214, 49);
		contentPane.add(lblNombreUsuario);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\MICAELA\\git\\LoginFrame\\Login\\recursos\\fondo2.jpg"));
		lblFondo.setBounds(0, 0, 349, 429);
		contentPane.add(lblFondo);
		
	}
	private class LblReturnMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblReturn.setIcon(new ImageIcon(".\\recursos\\return2.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblReturn.setIcon(new ImageIcon(".\\recursos\\return.png"));
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			dispose();
			JOptionPane.showMessageDialog(rootPane, "Sesión cerrada.","Sesión", 3);
			Main loginFrame = new Main();
			loginFrame.setVisible(true);
			
		}
	}
	private class LblAgendaMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda2.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda.png"));
		}
	}
}
