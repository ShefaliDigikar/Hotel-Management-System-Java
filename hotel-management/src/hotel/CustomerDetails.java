package hotel;



import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
//import net.proteanit.sql.DbUtils;

public class CustomerDetails extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;

	private JLabel a2 = new JLabel("*");
	private JLabel a1 = new JLabel("*");

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerDetails frame = new CustomerDetails();
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
	public CustomerDetails() {
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				displayCustomers();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setFont(new Font("High Tower Text", Font.PLAIN, 22));
		lblName.setBounds(66, 142, 128, 36);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setFont(new Font("High Tower Text", Font.PLAIN, 22));
		lblAddress.setBounds(66, 201, 155, 46);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNo = new JLabel("PHONE NO");
		lblPhoneNo.setFont(new Font("High Tower Text", Font.PLAIN, 22));
		lblPhoneNo.setBounds(66, 283, 140, 36);
		contentPane.add(lblPhoneNo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("High Tower Text", Font.PLAIN, 22));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Room", "Restaurant"}));
		comboBox.setBounds(206, 359, 186, 29);
		contentPane.add(comboBox);
		
		JLabel lblService = new JLabel("SERVICE");
		lblService.setFont(new Font("High Tower Text", Font.PLAIN, 22));
		lblService.setBounds(66, 355, 116, 36);
		contentPane.add(lblService);
		
		textField = new JTextField();
		textField.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		textField.setBounds(206, 146, 199, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		textField_1.setBounds(206, 210, 199, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(!Character.isDigit(e.getKeyChar()))
				{
					e.consume();
				}
			}
		});
		textField_2.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		textField_2.setBounds(206, 287, 186, 30);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(431, 100, 452, 432);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setIcon(new ImageIcon("images\\plus (1).png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
				a1.setVisible(false);
				a2.setVisible(false);
				
				
				if(textField.getText().equals(""))
				{
					a1.setVisible(true);
				}
				if(textField_1.getText().equals(""))
				{
					a2.setVisible(true);
				}
				
				
				
				else {
				Customer cust = new Customer();
				cust.custName=textField.getText();
				cust.addr=textField_1.getText();
				cust.phone=textField_2.getText();
				cust.Type = comboBox.getSelectedItem().toString();
			
				cust.addCustomer("i",cust);
				}
				
			}
		});
		btnAdd.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		btnAdd.setBounds(46, 436, 136, 36);
		contentPane.add(btnAdd);
		
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setIcon(new ImageIcon("images\\delete.png"));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer cust = new Customer();
				cust.custName=textField.getText();
				cust.deleteCustomer("d", cust);
			}
		});
		
		btnDelete.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		btnDelete.setBounds(206, 436, 161, 36);
		contentPane.add(btnDelete);
		
		JButton btnEdit = new JButton("NEXT");
		btnEdit.setIcon(new ImageIcon("images\\forward.png"));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
					/*if(comboBox.getSelectedItem()=="Restaurant")
					{	
					RestaurantForm rf = new RestaurantForm();
					rf.setVisible(true);
					rf.pack();
					rf.setLocationRelativeTo(null);
					rf.setBounds(100, 100, 922, 630);
					}
					
					else {
						
						RoomForm r = new RoomForm();
						r.setVisible(true);
						r.pack();
						r.setLocationRelativeTo(null);
						r.setBounds(100, 100, 922, 630);
					}*/
							
			}
		});
		
		btnEdit.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		btnEdit.setBounds(46, 496, 136, 36);
		contentPane.add(btnEdit);
		
		JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setFont(new Font("High Tower Text", Font.BOLD, 28));
		lblCustomerDetails.setBounds(370, 41, 335, 46);
		contentPane.add(lblCustomerDetails);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setIcon(new ImageIcon("images\\back.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondPage pg = new secondPage();
				pg.setVisible(true);
				pg.pack();
				pg.setLocationRelativeTo(null);
			}
		});
		btnBack.setFont(new Font("High Tower Text", Font.PLAIN, 21));
		btnBack.setBounds(206, 496, 161, 36);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("images\\teamwork (1).png"));
		label.setBounds(217, 0, 202, 133);
		contentPane.add(label);
		
		
		a1.setForeground(Color.RED);
		a1.setFont(new Font("High Tower Text", Font.BOLD, 23));
		a1.setBounds(409, 146, 21, 33);
		contentPane.add(a1);
		a1.setVisible(false);
		
		a2.setForeground(Color.RED);
		a2.setFont(new Font("High Tower Text", Font.BOLD, 23));
		a2.setBounds(409, 206, 21, 36);
		contentPane.add(a2);
		a2.setVisible(false);
		
		
		
	}
	
	public void displayCustomers()
	{
		GetConnection connect=new GetConnection();
		Connection conn=connect.getConnection();
		 DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("ADDRESS");
		model.addColumn("PHONE NO");
		model.addColumn("TYPE");
		
		try {
			String query = "SELECT * FROM customer";
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("customerID"),
						rs.getString("customerName"),
						rs.getString("address"),
						rs.getString("phoneNo"),
						rs.getString("type")
				});
			}
			
			rs.close();
			st.close();
			conn.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(40);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			table.getColumnModel().getColumn(4).setPreferredWidth(110);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}
