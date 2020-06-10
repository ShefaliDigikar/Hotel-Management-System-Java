package hotel;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AddDishes extends JFrame {

	private JPanel contentPane;
	private JTextField d1;
	private JTextField d2;
	private JTextField d3;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDishes frame = new AddDishes();
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
	public AddDishes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				displayDishes();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 972, 611);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDishName = new JLabel("DISH NAME");
		lblDishName.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblDishName.setBounds(33, 211, 155, 22);
		contentPane.add(lblDishName);
		
		JLabel lblD = new JLabel("DISH PRICE");
		lblD.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblD.setBounds(33, 284, 155, 27);
		contentPane.add(lblD);
		
		JLabel lblDishType = new JLabel("DISH TYPE");
		lblDishType.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblDishType.setBounds(33, 353, 155, 27);
		contentPane.add(lblDishType);
		
		d1 = new JTextField();
		d1.setFont(new Font("High Tower Text", Font.BOLD, 20));
		d1.setBounds(182, 207, 232, 30);
		contentPane.add(d1);
		d1.setColumns(10);
		
		d2 = new JTextField();
		d2.setFont(new Font("High Tower Text", Font.BOLD, 20));
		d2.setBounds(182, 282, 232, 30);
		contentPane.add(d2);
		d2.setColumns(10);
		
		d3 = new JTextField();
		d3.setFont(new Font("High Tower Text", Font.BOLD, 20));
		d3.setBounds(182, 351, 232, 30);
		contentPane.add(d3);
		d3.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(456, 194, 418, 279);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAddDish = new JButton("ADD DISH");
		btnAddDish.setIcon(new ImageIcon("images\\plus (1).png"));
		btnAddDish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDishes();
				
			}
		});
		btnAddDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnAddDish.setBounds(45, 486, 176, 53);
		contentPane.add(btnAddDish);
		
		JButton btnDeleteDish = new JButton("DELETE DISH");
		btnDeleteDish.setIcon(new ImageIcon("images\\iconfinder_f-cross_256_282471 (1).png"));
		btnDeleteDish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDishes();
			}
		});
		btnDeleteDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnDeleteDish.setBounds(245, 486, 221, 53);
		contentPane.add(btnDeleteDish);
		
		JButton btnUpdateDish = new JButton("UPDATE DISH");
		btnUpdateDish.setIcon(new ImageIcon("images\\updated.png"));
		btnUpdateDish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 updateDishes();
			}
		});
		btnUpdateDish.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnUpdateDish.setBounds(502, 486, 221, 53);
		contentPane.add(btnUpdateDish);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setIcon(new ImageIcon("images\\back.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForm af = new AdminForm();
				af.setVisible(true);
				af.pack();
				af.setLocationRelativeTo(null);
			
				af.setBounds(100, 100, 1080, 633);
				setVisible(false);
			}
		});
		btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnBack.setBounds(765, 486, 143, 53);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setBounds(879, 100, 239, 163);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images\\34.jpg"));
		lblNewLabel.setBounds(0, 0, 300, 195);
		contentPane.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("images\\i3.jpg"));
		label_1.setBounds(310, -1, 319, 195);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("images\\cock.jpg"));
		lblNewLabel_1.setBounds(623, 0, 331, 195);
		contentPane.add(lblNewLabel_1);
	}
	
	public void displayDishes()
	{
		GetConnection connect=new GetConnection();
		Connection conn=connect.getConnection();
		 DefaultTableModel model = new DefaultTableModel();
		model.addColumn("DISH NO");
		model.addColumn("DISH NAME");
		model.addColumn("DISH TYPE");
		model.addColumn("PRICE");
		
		try {
			String query = "SELECT * FROM restaurant";
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("itemNo"),
						rs.getString("itemName"),
						rs.getString("Type"),
						rs.getString("Price")
				});
			}
			
			rs.close();
			st.close();
			conn.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(70);
			table.getColumnModel().getColumn(1).setPreferredWidth(167);
			table.getColumnModel().getColumn(2).setPreferredWidth(90);
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			
			
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}
	
	
	public void addDishes()
	{
		 PreparedStatement ps = null;
		    ResultSet result = null;
				try {
			    	   
			    		GetConnection connect=new GetConnection();
			    		Connection conn=connect.getConnection();
			        	 ps=conn.prepareStatement("INSERT INTO restaurant(itemName,Price,Type) VALUES (?,?,?)");
		                 ps.setString(1,d1.getText());
			             ps.setString(2,d2.getText());
			             ps.setString(3,d3.getText());
			             
			             
			             if(ps.executeUpdate()>0)
			             {
			            	 JOptionPane.showMessageDialog(null, "New Dish Added");
			             }
			         
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	
	public void updateDishes()
	{
		 PreparedStatement ps = null;
		    ResultSet result = null;
				try {
					int i =table.getSelectedRow();
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					String no= model.getValueAt(i, 0).toString();
					System.out.println(no);
			    		GetConnection connect=new GetConnection();
			    		Connection conn=connect.getConnection();
			        	 ps=conn.prepareStatement("UPDATE restaurant SET itemName=?, Price= ?, Type=? where itemNo=?");
		                 ps.setString(1,d1.getText());
			             ps.setString(2,d2.getText());
			             ps.setString(3,d3.getText());
			             ps.setString(4, no);
			             
			             
			             if(ps.executeUpdate()>0)
			             {
			            	 JOptionPane.showMessageDialog(null, " Dish Updated ");
			             }
			         
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	
	public void deleteDishes()
	{
		PreparedStatement ps = null;
	    ResultSet result = null;
			try { 
				int i =table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				String no= model.getValueAt(i, 0).toString();
				System.out.println(no);
		    		GetConnection connect=new GetConnection();
		    		Connection conn=connect.getConnection();
		        	 ps=conn.prepareStatement("DELETE FROM restaurant  where itemNo=?");
	                
		             ps.setString(1, no);
		             
		             
		             if(ps.executeUpdate()>0)
		             {
		            	 JOptionPane.showMessageDialog(null, " Dish Deleted ");
		             }
		         
		    	}
		    	
		    	catch(Exception ex)
		    	{
		    		ex.printStackTrace();
		    	}
	}
	
		

}
