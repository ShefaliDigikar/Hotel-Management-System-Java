package hotel;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CustomerRestaurant extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField addr;
	private JTextField phone;
	private JTextField roomtype;
	private JTextField bedtype;
	private JTextField price;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnGenerateReceipt;
	private JButton btnBack;
	private JButton btnCheckout;
	private JTextField days;
	private JLabel lblTotal;
	private JTextField tot;
	private JTextArea textArea;
    int flag =0;
    private JLabel a1;
    private JLabel a2;
    private JLabel a3;
    private JLabel lblRoomNo;
    private JTextField rno;
    SimpleDateFormat sf = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
	Date dt= new Date();
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerRestaurant frame = new CustomerRestaurant();
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
	public CustomerRestaurant() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				displayRooms();
				a1.setVisible(false);
				a2.setVisible(false);
				a3.setVisible(false);
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1236, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("NAME ");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblName.setBounds(32, 142, 107, 32);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("ADDRESS");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblAddress.setBounds(32, 187, 107, 25);
		contentPane.add(lblAddress);
		
		JLabel lblPhoneNum = new JLabel("PHONE NUM ");
		lblPhoneNum.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblPhoneNum.setBounds(25, 229, 164, 25);
		contentPane.add(lblPhoneNum);
		
		JLabel lblRoomType = new JLabel("ROOM TYPE");
		lblRoomType.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblRoomType.setBounds(32, 343, 134, 32);
		contentPane.add(lblRoomType);
		
		JLabel lblBedType = new JLabel("BED TYPE");
		lblBedType.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblBedType.setBounds(27, 403, 123, 25);
		contentPane.add(lblBedType);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblPrice.setBounds(32, 461, 107, 35);
		contentPane.add(lblPrice);
		
		name = new JTextField();
		name.setFont(new Font("High Tower Text", Font.BOLD, 20));
		name.setBounds(201, 142, 197, 32);
		contentPane.add(name);
		name.setColumns(10);
		
		addr = new JTextField();
		addr.setFont(new Font("High Tower Text", Font.BOLD, 20));
		addr.setBounds(201, 187, 197, 32);
		contentPane.add(addr);
		addr.setColumns(10);
		
		phone = new JTextField();
		phone.setFont(new Font("High Tower Text", Font.BOLD, 20));
		phone.setBounds(201, 225, 197, 32);
		contentPane.add(phone);
		phone.setColumns(10);
		
		roomtype = new JTextField();
		roomtype.setFont(new Font("High Tower Text", Font.BOLD, 20));
		roomtype.setBounds(201, 343, 197, 32);
		contentPane.add(roomtype);
		roomtype.setColumns(10);
		
		bedtype = new JTextField();
		bedtype.setFont(new Font("High Tower Text", Font.BOLD, 20));
		bedtype.setBounds(201, 399, 197, 32);
		contentPane.add(bedtype);
		bedtype.setColumns(10);
		
		price = new JTextField();
		price.setFont(new Font("High Tower Text", Font.BOLD, 20));
		price.setBounds(201, 456, 197, 32);
		contentPane.add(price);
		price.setColumns(10);
		
		scrollPane =new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int i =table.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				rno.setText(model.getValueAt(i, 0).toString());
				roomtype.setText(model.getValueAt(i, 1).toString());
				bedtype.setText(model.getValueAt(i,2).toString());
				price.setText(model.getValueAt(i,3).toString());
				
				
			}
		});
		scrollPane.setBounds(427, 173, 419, 408);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		btnGenerateReceipt = new JButton("GENERATE RECEIPT");
		btnGenerateReceipt.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnGenerateReceipt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(name.getText().equals(""))
				{
					a1.setVisible(true);
				}
				else if(addr.getText().equals(""))
				{
					a2.setVisible(true);
				}
				else if(phone.getText().equals(""))
				{
					a3.setVisible(true);
				}
				else {
				
				calculateTotal();
				textArea.setText("**************************************************************************\n");
				textArea.setText(textArea.getText()+"******      	    YOUR BILL RECEIPT      	     ******\n");
				textArea.setText(textArea.getText()+"*************************************************************************\n\n");
				textArea.setText(textArea.getText()+"TIME     : "+sf.format(dt)+"\n\n");

				textArea.setText(textArea.getText()+"NAME     :    "+name.getText()+"\n\n");
				textArea.setText(textArea.getText()+"ADDRESS  :    "+addr.getText()+"\n\n");
				textArea.setText(textArea.getText()+"PHONE NUM  :    "+phone.getText()+"\n\n");
				textArea.setText(textArea.getText()+"ROOM TYPE  : "+roomtype.getText()+"\n\n");
				textArea.setText(textArea.getText()+"BED TYPE  : "+bedtype.getText()+"\n\n");
				textArea.setText(textArea.getText()+"TOTAL AMOUNT   :   "+tot.getText()+"\n\n");
				
				addToDatabase();
				flag=1;
				}
			}
		});
		btnGenerateReceipt.setBounds(215, 603, 264, 38);
		contentPane.add(btnGenerateReceipt);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (flag==0)
					JOptionPane.showMessageDialog(null, "First you need to generate receipt");
				else {
					secondPage sp = new secondPage();
					sp.setVisible(true);
					sp.pack();
					sp.setLocationRelativeTo(null);
					sp.setBounds(100, 100, 1015, 574);
					setVisible(false);
				
				}
				
			}
		});
		btnBack.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnBack.setBounds(536, 603, 141, 38);
		contentPane.add(btnBack);
		
		btnCheckout = new JButton("CHECKOUT");
		btnCheckout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkOut();
			}
		});
		btnCheckout.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnCheckout.setBounds(726, 603, 184, 38);
		contentPane.add(btnCheckout);
		
		days = new JTextField();
		days.setFont(new Font("High Tower Text", Font.BOLD, 20));
		days.setBounds(201, 507, 197, 32);
		contentPane.add(days);
		days.setColumns(10);
		
		JLabel lblNoOfDays = new JLabel("NO OF DAYS");
		lblNoOfDays.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblNoOfDays.setBounds(32, 511, 147, 25);
		contentPane.add(lblNoOfDays);
		
		JButton btnTotal = new JButton("TOTAL");
		btnTotal.setFont(new Font("High Tower Text", Font.BOLD, 20));
		btnTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if(name.getText().equals(""))
					{   a1.setVisible(true);
						throw new MyException("Exception : Please Fill all the details");
						
					}
					else if(addr.getText().equals(""))
					{   a2.setVisible(true);
						 throw new MyException("Exception :Please Fill all the details"); 
						 
					}
					else if(phone.getText().equals(""))
					{   a3.setVisible(true);
						throw new MyException("Exception :Please Fill all the details");
						
					}
					
					else
						{
						 calculateTotal();
						}
					}
					
					catch(MyException r)
					{
						JOptionPane.showMessageDialog(CustomerRestaurant.this, r);
					}
				
			}
		});
		btnTotal.setBounds(44, 605, 122, 35);
		contentPane.add(btnTotal);
		
		lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblTotal.setBounds(32, 556, 107, 25);
		contentPane.add(lblTotal);
		
		tot = new JTextField();
		tot.setFont(new Font("High Tower Text", Font.BOLD, 20));
		tot.setBounds(201, 552, 197, 32);
		contentPane.add(tot);
		tot.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setBounds(858, 176, 348, 408);
		contentPane.add(textArea);
		
		a1 = new JLabel("*");
		a1.setFont(new Font("Tahoma", Font.BOLD, 20));
		a1.setForeground(new Color(255, 0, 0));
		a1.setBounds(404, 143, 22, 25);
		contentPane.add(a1);
		
		a2 = new JLabel("*");
		a2.setFont(new Font("Tahoma", Font.BOLD, 20));
		a2.setForeground(Color.RED);
		a2.setBounds(404, 196, 22, 16);
		contentPane.add(a2);
		
		a3 = new JLabel("*");
		a3.setForeground(Color.RED);
		a3.setFont(new Font("Tahoma", Font.BOLD, 20));
		a3.setBounds(404, 230, 22, 16);
		contentPane.add(a3);
		
		lblRoomNo = new JLabel("ROOM NO");
		lblRoomNo.setFont(new Font("High Tower Text", Font.BOLD, 20));
		lblRoomNo.setBounds(32, 286, 147, 29);
		contentPane.add(lblRoomNo);
		
		rno = new JTextField();
		rno.setFont(new Font("High Tower Text", Font.BOLD, 20));
		rno.setBounds(199, 284, 199, 32);
		contentPane.add(rno);
		rno.setColumns(10);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("images\\jk1.jpg"));
		label.setBounds(0, 0, 1218, 212);
		contentPane.add(label);
	}
	
	public void displayRooms()
	{
		GetConnection connect=new GetConnection();
		Connection conn=connect.getConnection();
		 DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ROOM NO");
		model.addColumn("ROOM TYPE");
		model.addColumn("BED TYPE");
		model.addColumn("PRICE");
		
		try {
			String query = "SELECT * FROM room";
			Statement st= conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] {
						rs.getString("roomNo"),
						rs.getString("roomType"),
						rs.getString("bedType"),
						rs.getString("Price")
				});
			}
			
			rs.close();
			st.close();
			conn.close();
			table.setModel(model);
			table.setAutoResizeMode(0);
			table.getColumnModel().getColumn(0).setPreferredWidth(80);
			table.getColumnModel().getColumn(1).setPreferredWidth(140);
			table.getColumnModel().getColumn(2).setPreferredWidth(120);
			table.getColumnModel().getColumn(3).setPreferredWidth(90);
			
			
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
		}
	
	}
	
	
	public void calculateTotal()
	{
		int day=Integer.parseInt(days.getText());
		int pr= Integer.parseInt(price.getText());
		int total=day*pr;
		System.out.println(total);
		tot.setText(Integer.toString(total));
		
	}
	
	public void addToDatabase()
	{
		 PreparedStatement ps = null;
		    ResultSet result = null;
				try {
			    	   
			    		GetConnection connect=new GetConnection();
			    		Connection conn=connect.getConnection();
			        	 ps=conn.prepareStatement("INSERT INTO roomcutomer(name,address,phone,roomtype,bedtype,price,status) VALUES (?,?,?,?,?,?,?)");
		                 ps.setString(1,name.getText());
			             ps.setString(2,addr.getText());
			             ps.setString(3,phone.getText());
			             ps.setString(4,roomtype.getText());
			             ps.setString(5,bedtype.getText());
			             ps.setString(6,tot.getText());
			             ps.setString(7,"0");
			             
			             if(ps.executeUpdate()>0)
			             {
			            	 JOptionPane.showMessageDialog(null, "New Customer Added");
			             }
			         
			    	}
			    	
			    	catch(Exception ex)
			    	{
			    		ex.printStackTrace();
			    	}
	}
	
	public void checkOut()
	{
		PreparedStatement ps = null;
	    ResultSet result = null;
			try {
		    	   
		    		GetConnection connect=new GetConnection();
		    		Connection conn=connect.getConnection();
		        	 ps=conn.prepareStatement("UPDATE roomcutomer SET status = 1 where name=?");
		        	 ps.setString(1,name.getText());
		            
		             
		             if(ps.executeUpdate()>0)
		             {
		            	 JOptionPane.showMessageDialog(null, "Checked out Successfully");
		             }
		         
		    	}
		    	
		    	catch(Exception ex)
		    	{
		    		ex.printStackTrace();
		    	}
	}
	
	
}
