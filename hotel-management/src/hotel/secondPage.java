package hotel;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hotel.Hotel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextField;

public class secondPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			Hotel hotel = Hotel.getInstance();
			public void run() {
				try {
					secondPage frame = new secondPage();
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
	public secondPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1015, 574);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("High Tower Text", Font.BOLD, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ROOM", "RESTAURANT"}));
		comboBox.setBounds(53, 371, 408, 48);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("  CUSTOMER");
		btnNewButton.setToolTipText("");
		btnNewButton.setFont(new Font("High Tower Text", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*CustomerDetails cd = new CustomerDetails();
				cd.setVisible(true);
				cd.pack();
				cd.setLocationRelativeTo(null);
				cd.setBounds(100, 100, 1038, 623);*/
				
				if(comboBox.getSelectedItem()=="RESTAURANT")
				{	
				CustomerRoom cr = new CustomerRoom();
				//RestaurantForm rf = new RestaurantForm();
				cr.setVisible(true);
				cr.pack();
				cr.setLocationRelativeTo(null);
				cr.setBounds(50, 50, 1367, 772);
				setVisible(false);
				}
				
				else {
					
					CustomerRestaurant cg = new CustomerRestaurant();
					//RestaurantForm rf = new RestaurantForm();
					cg.setVisible(true);
					cg.pack();
					cg.setLocationRelativeTo(null);
					cg.setBounds(50, 50, 1236, 700);
					setVisible(false);
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("images\\dining (1).png"));
		btnNewButton.setBounds(53, 174, 408, 197);
		contentPane.add(btnNewButton);
		
		JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.setFont(new Font("High Tower Text", Font.BOLD, 30));
		btnAdmin.setIcon(new ImageIcon("images\\admin.png"));
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForm af = new AdminForm();
				af.setVisible(true);
				af.pack();
				af.setLocationRelativeTo(null);
				af.setBounds(100, 100, 1038, 623);
				setVisible(false);
			}
		});
		btnAdmin.setBounds(523, 174, 379, 245);
		contentPane.add(btnAdmin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\bb.jpg"));
		lblNewLabel.setBounds(0, 0, 997, 220);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 432, 997, 95);
		contentPane.add(panel);
		
		JLabel lblFromSeasideTo = new JLabel("From Seaside To Lakeside...");
		lblFromSeasideTo.setForeground(new Color(240, 255, 255));
		lblFromSeasideTo.setFont(new Font("Monotype Corsiva", Font.BOLD | Font.ITALIC, 60));
		panel.add(lblFromSeasideTo);
		
		
	}
}
