//package formularios;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.SwingConstants;
//
//public class BienvenidaForm extends JFrame {
//
//	private JPanel contentPane;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BienvenidaForm frame = new BienvenidaForm();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public BienvenidaForm() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("BIENVENIDO");
//		lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 20));
//		lblNewLabel.setBounds(156, 55, 92, 48);
//		contentPane.add(lblNewLabel);
//	}
//}
package formularios;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BienvenidaForm extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BienvenidaForm frame = new BienvenidaForm();
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
    public BienvenidaForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("BIENVENIDO");
        lblNewLabel.setFont(new Font("Gabriola", Font.BOLD, 20));
        lblNewLabel.setBounds(256, 10, 92, 48);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 70, 564, 281);
        contentPane.add(scrollPane);

        // Crear la tabla
        table = new JTable();
        scrollPane.setViewportView(table);

        // Crear el modelo de tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Rut");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Telefono");
        model.addColumn("FechaIngreso");

        // Conectar a la base de datos y obtener los datos
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco_platinum", "root", "Root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM persona");

            while (rs.next()) {
                model.addRow(new Object[] { rs.getString("Rut"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Telefono"), rs.getString("FechaIngreso") });
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Establecer el modelo en la tabla
        table.setModel(model);
    }
}
