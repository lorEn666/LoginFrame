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
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.awt.Cursor;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import clases.Contacto;
import clases.IoDatos;

import javax.swing.JTextArea;
import javax.swing.JList;

public class User extends JFrame {

	private JPanel contentPane;
	private JLabel lblFondo;
	private JLabel lblNombreUsuario;
	private JLabel lblReturn;
	private JLabel lblAgenda;
	private JList listContactos;
	private ArrayList<Contacto> vContacto;
	private JLabel lblRemove;
	private JLabel lblAdd;

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
		setUndecorated(true);
		setType(Type.UTILITY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 349, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblReturn = new JLabel("");
		lblReturn.setToolTipText("Cerrar sesi\u00F3n");
		lblReturn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblReturn.addMouseListener(new LblReturnMouseListener());

		lblAgenda = new JLabel("");
		lblAgenda.setToolTipText("Contactos");
		lblAgenda.addMouseListener(new LblAgendaMouseListener());

		listContactos = new JList();
		listContactos.setVisible(false);
		
		lblRemove = new JLabel("");
		lblRemove.setToolTipText("Eliminar");
		lblRemove.addMouseListener(new LblRemoveMouseListener());
		lblRemove.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemove.setHorizontalTextPosition(SwingConstants.CENTER);
		lblRemove.setIcon(new ImageIcon("C:\\Users\\MICAELA\\git\\LoginFrame\\Login\\recursos\\delete1.png"));
		lblRemove.setVisible(false);
		
		lblAdd = new JLabel("");
		lblAdd.setToolTipText("A\u00F1adir");
		lblAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new LblAddMouseListener());
		lblAdd.setIcon(new ImageIcon("C:\\Users\\MICAELA\\git\\LoginFrame\\Login\\recursos\\add1.png"));
		lblAdd.setVisible(false);
		lblAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(123, 363, 52, 52);
		contentPane.add(lblAdd);
		lblRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblRemove.setBounds(172, 363, 52, 52);
		contentPane.add(lblRemove);
		listContactos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listContactos.setBorder(null);
		listContactos.setBounds(94, 101, 160, 259);
		contentPane.add(listContactos);
		lblAgenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda.png"));
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setBounds(273, 11, 66, 66);
		contentPane.add(lblAgenda);
		lblReturn.setIcon(new ImageIcon(".\\recursos\\return.png"));
		lblReturn.setHorizontalAlignment(SwingConstants.CENTER);
		lblReturn.setBounds(10, 11, 45, 45);
		contentPane.add(lblReturn);

		lblNombreUsuario = new JLabel(nombreUsuario);
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setForeground(new Color(153, 51, 51));
		lblNombreUsuario.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 26));
		lblNombreUsuario.setBounds(68, 11, 214, 49);
		contentPane.add(lblNombreUsuario);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(".\\recursos\\fondo2.jpg"));
		lblFondo.setBounds(0, 0, 349, 429);
		setShape(new RoundRectangle2D.Double(0, 0, lblFondo.getWidth(), lblFondo.getHeight(), 50, 50));
		contentPane.add(lblFondo);
		DefaultListModel modeloLista = new DefaultListModel();
		listContactos.setModel(modeloLista);
		
		vContacto = IoDatos.inicioDeSesion(nombreUsuario);

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
			JOptionPane.showMessageDialog(rootPane, "Sesión cerrada.", "Sesión", 3);
			Main loginFrame = new Main();
			loginFrame.setVisible(true);
		}
	}

	private class LblAgendaMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			if (!listContactos.isVisible()) {
				lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda2.png"));
			} else {
				lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda.png"));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (!listContactos.isVisible()) {
				lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda.png"));
			} else {
				lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda2.png"));
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if (!listContactos.isVisible()) {
				lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda2.png"));
				lblAdd.setVisible(true);
				lblRemove.setVisible(true);
				listContactos.setVisible(true);
			} else {
				lblAgenda.setIcon(new ImageIcon(".\\recursos\\agenda.png"));
				lblAdd.setVisible(false);
				lblRemove.setVisible(false);
				listContactos.setVisible(false);
			}
		}
	}
	private class LblAddMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblAdd.setIcon(new ImageIcon(".\\recursos\\add2.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblAdd.setIcon(new ImageIcon(".\\recursos\\add1.png"));
		}
	}
	private class LblRemoveMouseListener extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			lblRemove.setIcon(new ImageIcon(".\\recursos\\delete2.png"));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			lblRemove.setIcon(new ImageIcon(".\\recursos\\delete1.png"));
		}
	}
}
