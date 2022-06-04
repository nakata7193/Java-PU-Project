package Project;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class ApartmentFrame extends JFrame {
	Connection conn=null;
	PreparedStatement state = null;
	ResultSet result = null;
	int id=-1;
	int idag = -1;
	
	JPanel clientsP = new JPanel();
	JPanel apartmentsP = new JPanel();
	JPanel agenciesP = new JPanel();
	JPanel spravkaP = new JPanel();
	
	JTabbedPane tab = new JTabbedPane();
	
	//-------------------------------------CLIENTS--------------------------------//
	
	//PANELS
	JPanel clientsPanel1 = new JPanel(); 
	JPanel clientsPanel2 = new JPanel();
	JPanel clientsPanel3 = new JPanel();
	
	//LABELS
	JLabel clFNameL = new JLabel("���:");
	JLabel clLNameL = new JLabel("�������:");
	JLabel ageL = new JLabel("������:");

	//TEXTFIELDS
	JTextField clFNameTF = new JTextField();
	JTextField clLNameTF = new JTextField();
	JTextField clageTF = new JTextField();
	
	//BUTTONS
	JButton clADD = new JButton("������");
	JButton clDelete = new JButton("������");
	JButton clUpdate = new JButton("�������");
	JButton clShowAll = new JButton("������ ������");
	
	//TABLE
	JTable tableClients = new JTable();
	
	//SCROLL
	JScrollPane ClientsScroll = new JScrollPane(tableClients);
	

	//-----------------------------------------APARTMENTS----------------------------------//
	
	//-----PANELS-----//
	JPanel apartmentPanel1 = new JPanel(); 
	JPanel apartmentPanel2 = new JPanel();
	JPanel apartmentPanel3 = new JPanel();
	
	//----LABELS------//
	JLabel kvadraturaL = new JLabel("��������:");
	JLabel kvartalL = new JLabel("�������:");
	JLabel agenAPL = new JLabel("�������:");
	JLabel cityL = new JLabel("����:");
	JLabel priceL = new JLabel("����:");
	
	//----COMBOBOX----//
	JComboBox<String> comboAg = new JComboBox<String>();
	
	//----TEXTFIELDS---//
	JTextField kvadraturaTF = new JTextField();
	JTextField kvartalTF = new JTextField();
	JTextField cityTF = new JTextField();
	JTextField priceTF = new JTextField();
	
	//----BUTTONS----//
	JButton APAdd = new JButton("������");
	JButton APDelete = new JButton("������");
	JButton APUpdate = new JButton("�������");
	JButton APShowAll = new JButton("������ ������");
	
	//-----TABLE----//
	JTable APTable = new JTable();
	
	//---SCROLL----//
	JScrollPane apartmentScroll = new JScrollPane(APTable);
	
	//-----------------------------------------AGENCIES----------------------------------//
	
	//Panels
	JPanel agenciPanel1 = new JPanel();
	JPanel agenciPanel2 = new JPanel();
	JPanel agenciPanel3 = new JPanel();
	
	//LABELS
	JLabel AGNameL = new JLabel("���:");
	
	//TEXTFIELDS
	JTextField AGNameTF = new JTextField();
	
	//BUTTONS
	JButton AGAdd = new JButton("������");
	JButton AGDelete = new JButton("������");
	JButton AGUpdate = new JButton("�������");
	JButton AGShowAll = new JButton("������ ������");
	
	//TABLE
	JTable tableAgenci = new JTable();
		
	//SCROLL
	JScrollPane AgenciScroll = new JScrollPane(tableAgenci);
	
	//-----------------------------------SPRAVKA--------------------//
	
	//-----------PANELS----------------//
	
	JPanel sprPanel1 = new JPanel();
	JPanel sprPanel2 = new JPanel();
	JPanel sprPanel3 = new JPanel();
	
	//--------------LABELS------------//
	JLabel SpriceL = new JLabel("����:");
	JLabel SagencyL = new JLabel("�������:");
	
	//-------TEXTFIELD----------------//
	JTextField SpriceTF = new JTextField();
	
	//-------------BUTTONS-----------//
	JButton searchS = new JButton("�����");
	
	//--------------Combo----------//
	JComboBox<String> ScomboAg = new JComboBox<String>();
	
	//-------TABLE----------------//
	JTable tableSP = new JTable();
	
	//----------SCROLL----------//
	
	JScrollPane scrollSP = new JScrollPane(tableSP);
	
	public ApartmentFrame() {
		conn=DBConnection.getConnection();

		this.setSize(600, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		tab.add(clientsP, "�������");
		tab.add(apartmentsP, "�����������");
		tab.add(agenciesP, "�������");
		tab.add(spravkaP, "������� �� ����");
		
		
		//------------------------------CLIENTS TAB-----------------------------------------------------//
		clientsP.setLayout(new GridLayout(3,1));
		clientsP.add(clientsPanel1);
		clientsPanel1.setLayout(new GridLayout(5,1));
		clientsPanel1.add(clFNameL);clientsPanel1.add(clFNameTF);
		clientsPanel1.add(clLNameL);clientsPanel1.add(clLNameTF);
		clientsPanel1.add(ageL);clientsPanel1.add(clageTF);
		
		clientsP.add(clientsPanel2);
		clientsPanel2.add(clADD);clientsPanel2.add(clDelete);clientsPanel2.add(clUpdate);clientsPanel2.add(clShowAll);
		
		clientsP.add(clientsPanel3);
		ClientsScroll.setPreferredSize(new Dimension(350,150));
		clientsPanel3.add(ClientsScroll);
		
		
		clADD.addActionListener(new AddClientAction());
		clShowAll.addActionListener(new ShowAllActionClients());
		clDelete.addActionListener(new DeleteClientAction());
		clUpdate.addActionListener(new UpdateClientAction());
		
		tableClients.addMouseListener(new MouseActionClients());
		
		
		//-----------------------------------------APARTMENTS----------------------------------//
		
		apartmentsP.setLayout(new GridLayout(6,4));
		apartmentsP.add(apartmentPanel1);
		apartmentPanel1.setLayout(new GridLayout(5,2));
		apartmentPanel1.add(kvadraturaL);apartmentPanel1.add(kvadraturaTF);
		apartmentPanel1.add(cityL);apartmentPanel1.add(cityTF);
		apartmentPanel1.add(kvartalL);apartmentPanel1.add(kvartalTF);
		apartmentPanel1.add(agenAPL);apartmentPanel1.add(comboAg);
		apartmentPanel1.add(priceL);apartmentPanel1.add(priceTF);
		
		apartmentsP.add(apartmentPanel2);
		apartmentPanel2.add(APAdd);apartmentPanel2.add(APDelete);apartmentPanel2.add(APUpdate);apartmentPanel2.add(APShowAll);
		
		apartmentsP.add(apartmentPanel3);
		apartmentScroll.setPreferredSize(new Dimension(550,150));
		apartmentPanel3.add(apartmentScroll);
		
		APAdd.addActionListener(new ApartmentAddAction());
		APDelete.addActionListener(new DeleteApartmentsAction());
		APUpdate.addActionListener(new UpdateApartmentsAction());
		APShowAll.addActionListener(new ApartmentShowAll());
		APTable.addMouseListener(new MouseActionApartments());
		
		comboAg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(tab.getSelectedIndex() == 1 && idag>0) {
					String str = "select * from agencies where name = '"+comboAg.getSelectedItem().toString()+"'";
					try {
						state = conn.prepareStatement(str);
						result = state.executeQuery();
						result.next();
						idag = Integer.parseInt(result.getObject(1).toString());
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		ScomboAg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tab.getSelectedIndex() == 3 && idag>0) {
					String str = "select * from agencies where name = '"+ScomboAg.getSelectedItem().toString()+"'";
					try {
						state = conn.prepareStatement(str);
						result = state.executeQuery();
						result.next();
						idag = Integer.parseInt(result.getObject(1).toString());
					}catch(SQLException e1) {
						e1.printStackTrace();
					}
					}
				}
			});
		
		
		
		//-----------------------------------------AGENCIES------------------------------------//
		agenciesP.setLayout(new GridLayout(7,2));
		agenciesP.add(agenciPanel1);
		agenciPanel1.setLayout(new GridLayout(1,3));
		agenciPanel1.add(AGNameL);agenciPanel1.add(AGNameTF);
		
		//----------AGENCI BUTTONS--------------------//
		agenciesP.add(agenciPanel2);
		agenciPanel2.add(AGAdd);agenciPanel2.add(AGDelete);agenciPanel2.add(AGUpdate);agenciPanel2.add(AGShowAll);
		
		//------------------AGENCI tabel---------------//
		agenciesP.add(agenciPanel3);
		agenciPanel3.setLayout(new GridLayout(1,4));
		AgenciScroll.setPreferredSize(new Dimension(350,150));
		agenciPanel3.add(AgenciScroll);
		
		
		///--------------------AGENCI ACTIONS------------------//
		AGAdd.addActionListener(new AddAgenciAction());
		AGDelete.addActionListener(new DeleteAgenciAction());
		AGUpdate.addActionListener(new UpdateAgenciAction());
		AGShowAll.addActionListener(new ShowAllActionAgencies());
		
		tableAgenci.addMouseListener(new MouseActionAgencies());
		
		
		
		
		//---------------------------------------------SPRAVKA--------------------------//
		spravkaP.setLayout(new GridLayout(7,5));
		spravkaP.add(sprPanel1);
		sprPanel1.setLayout(new GridLayout(2,2));
		sprPanel1.add(SpriceL);sprPanel1.add(SpriceTF);
		sprPanel1.add(SagencyL);sprPanel1.add(ScomboAg);
		
		spravkaP.add(sprPanel2);
		sprPanel2.add(searchS);
		
		searchS.addActionListener(new SearchDBSpravkaAction());
		
		spravkaP.add(sprPanel3);
		scrollSP.setPreferredSize(new Dimension(500,350));
		sprPanel3.add(scrollSP);
		
		this.refreshScomboAg();
		this.refreshComboAg();
		this.add(tab);
		this.setVisible(true);
	}
	
	public void clearForm() {
		clFNameTF.setText("");
		clLNameTF.setText("");
		clageTF.setText("");
	}
	
	//--------------CLIENTS ACTIONS----------------------//
	
public void refreshTableClients() {
	conn=DBConnection.getConnection();
	try {
		state=conn.prepareStatement("SELECT * FROM Clients");
		result=state.executeQuery();
		tableClients.setModel(new MyModel(result));
	} catch (SQLException e1) {
		e1.printStackTrace();
	} catch (Exception e1) {
		e1.printStackTrace();
	}
}


class AddClientAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		String sqlQuerry = "Insert into clients(fname,lname,age) values(?,?,?)";
		
		try {
			state = conn.prepareStatement(sqlQuerry);
			state.setString(1,clFNameTF.getText());
			state.setString(2,clLNameTF.getText());
			state.setInt(3,Integer.parseInt(clageTF.getText()));
			
			state.execute();
			clearForm();
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
	}	
}


class ShowAllActionClients implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		refreshTableClients();
	}
}


class MouseActionClients implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		int row =  tableClients.getSelectedRow();
		id = Integer.parseInt(tableClients.getValueAt(row,0).toString());
		clFNameTF.setText(tableClients.getValueAt(row,1).toString());
		clLNameTF.setText(tableClients.getValueAt(row, 2).toString());
		clageTF.setText(tableClients.getValueAt(row,3).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}	
}

class DeleteClientAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		String sql = "DELETE FROM clients  WHERE id=?";
		
		try {
			state = conn.prepareStatement(sql);
			state.setInt(1,id);
			state.execute();
			refreshTableClients();
			clearForm();
			id = -1;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
}


class UpdateClientAction implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		if(id>0) {
		String sql = "UPDATE CLIENTS SET FNAME=?,LNAME=?,AGE=?  WHERE ID=?";
		
		try {
			state = conn.prepareStatement(sql);
			state.setString(1,clFNameTF.getText());
			state.setString(2,clLNameTF.getText());
			state.setInt(3, Integer.parseInt(clageTF.getText()));
			state.setInt(4,id);
			
			state.execute();
			refreshTableClients();
		}catch(SQLException el) {
			el.printStackTrace();
		}
		clFNameTF.setText("");
		clLNameTF.setText("");
		clageTF.setText("");
		}	
	}
	
}



//---------------------AGENCIES ACTIONS------------------//

public void reshreshTableAgencies(){
	conn = DBConnection.getConnection();
	try {
		state = conn.prepareStatement("SELECT * FROM AGENCIES");
		result = state.executeQuery();
		tableAgenci.setModel(new MyModel(result));
	}catch(SQLException e1) {
		e1.printStackTrace();
	}catch(Exception e1) {
		e1.printStackTrace();
	}
}


class AddAgenciAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		String sqlQuerry = "Insert into agencies(name) values(?)";
		
		try {
			state = conn.prepareStatement(sqlQuerry);
			state.setString(1, AGNameTF.getText());
			state.execute();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}finally {
			AGNameTF.setText("");
			reshreshTableAgencies();
			refreshComboAg();
			refreshScomboAg();
		}
	}
	
}


class DeleteAgenciAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		String sqlQuerry = "DELETE FROM AGENCIES WHERE ID=?";
		try {
			state = conn.prepareStatement(sqlQuerry);
			state.setInt(1,id);
			state.execute();
			id=-1;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}finally {
			reshreshTableAgencies();
			AGNameTF.setText("");
			refreshComboAg();
			refreshScomboAg();
			refreshTableApartments();
		}
	}
	
}

class UpdateAgenciAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		if(id>0) {
			String sqlQuerry = "UPDATE AGENCIES SET NAME = ? WHERE ID=?";
			try {
				state = conn.prepareStatement(sqlQuerry);
				state.setString(1, AGNameTF.getText());
				state.setInt(2, id);
				state.execute();
				reshreshTableAgencies();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}finally {
				AGNameTF.setText("");
				refreshComboAg();
				refreshScomboAg();
				refreshTableApartments();
			}
		}
	}
}

class ShowAllActionAgencies implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		reshreshTableAgencies();
	}
	}

class MouseActionAgencies implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableAgenci.getSelectedRow();
		id = Integer.parseInt(tableAgenci.getValueAt(row, 0).toString());
		AGNameTF.setText(tableAgenci.getValueAt(row, 1).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

//----------------------------------APARTMENTS---------------------------//

class ApartmentAddAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		
		String sql = "insert into apartments(kvadratura,city,kvartal,agenci,agencyid,price) values(?,?,?,?,?,?)";
		try {
			state = conn.prepareStatement(sql);
			state.setInt(1, Integer.parseInt(kvadraturaTF.getText()));
			state.setString(2, cityTF.getText());
			state.setString(3,kvartalTF.getText());
			state.setString(4, comboAg.getSelectedItem().toString());
			state.setInt(5, idag);
			state.setDouble(6, Double.parseDouble(priceTF.getText()));
			
			state.execute();
		}catch(SQLException e1) {
			e1.printStackTrace();
		}finally {
			refreshTableApartments();
			refreshComboAg();
			kvadraturaTF.setText("");
			cityTF.setText("");
			kvartalTF.setText("");
			priceTF.setText("");
		}
	}
}


class DeleteApartmentsAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		String sqlQuerry = "DELETE FROM APARTMENTS WHERE ID=?";
		try {
			state = conn.prepareStatement(sqlQuerry);
			state.setInt(1, id);
			state.execute();
			refreshTableApartments();
			id=-1;
		}catch(SQLException e1) {
			e1.printStackTrace();
		}finally {
			kvadraturaTF.setText("");
			kvartalTF.setText("");
			cityTF.setText("");
			priceTF.setText("");
			refreshTableApartments();
			refreshComboAg();
		}	
	}	
}


class UpdateApartmentsAction implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		conn = DBConnection.getConnection();
		if(id>0) {
			String sqlQuerry = "UPDATE APARTMENTS SET KVADRATURA =?,CITY = ?,KVARTAL = ?,AGENCI =?,AGENCYID = ?,PRICE = ? WHERE ID=? ";
			try {
				state = conn.prepareStatement(sqlQuerry);
				state.setString(1, kvadraturaTF.getText());
				state.setString(2, cityTF.getText());
				state.setString(3, kvartalTF.getText());
				state.setString(4,comboAg.getSelectedItem().toString());
				state.setInt(5, idag);
				state.setInt(6, id);
				state.setDouble(7, Double.parseDouble(priceTF.getText()));
				
				state.execute();
			}catch(SQLException e1) {
				e1.printStackTrace();
			}finally {
				kvadraturaTF.setText("");
				kvartalTF.setText("");
				cityTF.setText("");
				priceTF.setText("");
				refreshTableApartments();
				refreshComboAg();
			}
		}
	}
}


public void refreshTableApartments() {
	conn = DBConnection.getConnection();
	
	String sql = "select * from APARTMENTS";
	
	try {
		state = conn.prepareStatement(sql);
		result = state.executeQuery();
		APTable.setModel(new MyModel(result));
	}catch(SQLException e1) {
		e1.printStackTrace();
	}catch(Exception e2) {
		e2.printStackTrace();
	}
}

class ApartmentShowAll implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		refreshTableApartments();
	}
}


class MouseActionApartments implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = APTable.getSelectedRow();
		id = Integer.parseInt(APTable.getValueAt(row, 0).toString());
		kvadraturaTF.setText(APTable.getValueAt(row, 1).toString());
		kvartalTF.setText(APTable.getValueAt(row, 2).toString());
		cityTF.setText(APTable.getValueAt(row, 3).toString());
		priceTF.setText(APTable.getValueAt(row, 4).toString());
		comboAg.setSelectedItem(APTable.getValueAt(row, 5));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}





//---------------------------COMBO---------------------------------//

	public void refreshComboAg() {
		idag = -1;
		comboAg.removeAllItems();
		
		String sql = "select id,name from agencies";
		String item = "";
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			if(result.next()) {
				idag = Integer.parseInt(result.getObject(1).toString());
				do {
					item = result.getObject(2).toString();
					comboAg.addItem(item);
				}while(result.next());
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public void refreshScomboAg() {
		idag = -1;
		ScomboAg.removeAllItems();
		
		String sql = "select id,name from agencies";
		String item = "";
		
		try {
			state = conn.prepareStatement(sql);
			result = state.executeQuery();
			if(result.next()) {
				idag = Integer.parseInt(result.getObject(1).toString());
				do {
					item = result.getObject(2).toString();
					ScomboAg.addItem(item);
				}while(result.next());
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
	}

//------------------------SPRAVKA-------------------------//
	class SearchDBSpravkaAction implements ActionListener{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			if(Double.parseDouble(SpriceTF.getText())>0) {
				String sqlQuerry = "SELECT AP.ID,AP.KVADRATURA, AP.CITY,AP.KVARTAL,AP.AGENCI,AP.AGENCYID,AP.PRICE,AG.ID,AG.NAME from APARTMENTS AP,AGENCIES AG where AP.AGENCYID = AG.ID and AP.PRICE <=" + Double.parseDouble(SpriceTF.getText());
				try {
					state = conn.prepareStatement(sqlQuerry);
					result = state.executeQuery();
					tableSP.setModel(new MyModel(result));
					
				}catch(SQLException e1) {
					e1.printStackTrace();
				}catch(Exception e2) {
					e2.printStackTrace();
				}finally {
					refreshScomboAg();
				}
			}
		}
	}
}