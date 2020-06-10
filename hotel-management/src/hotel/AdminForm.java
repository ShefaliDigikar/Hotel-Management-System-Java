package hotel;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminForm extends JFrame {

	private JPanel contentPane;
	Customer cust = new Customer();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminForm frame = new AdminForm();
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
	public AdminForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDelete = new JButton("MANAGE ROOMS");
		btnDelete.setIcon(new ImageIcon("images\\bed (1).png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddRooms ar = new AddRooms();
				//RestaurantForm rf = new RestaurantForm();
				ar.setVisible(true);
				ar.pack();
				ar.setLocationRelativeTo(null);
				ar.setBounds(50, 50, 965, 577);
				setVisible(false);
			}
		});
		btnDelete.setFont(new Font("High Tower Text", Font.BOLD, 22));
		btnDelete.setBounds(229, 227, 383, 256);
		contentPane.add(btnDelete);
		
		JButton btnNewButton_2 = new JButton("MANAGE DISHES");
		btnNewButton_2.setIcon(new ImageIcon("images\\dining (2).png"));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDishes ad = new AddDishes();
				ad.setVisible(true);
				ad.pack();
				ad.setLocationRelativeTo(null);
				ad.setBounds(50,50, 965, 577);
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnNewButton_2.setBounds(622, 228, 369, 256);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\user (1).png"));
		label.setBounds(0, 0, 253, 221);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 204));
		panel.setBounds(23, 172, 183, 357);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setBounds(168, 30, 811, 172);
		contentPane.add(panel_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondPage sp = new secondPage();
				sp.setVisible(true);
				sp.pack();
				sp.setLocationRelativeTo(null);
				sp.setBounds(50,50, 965, 577);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("High Tower Text", Font.BOLD, 22));
		btnBack.setBounds(651, 528, 169, 45);
		contentPane.add(btnBack);
	}
}
