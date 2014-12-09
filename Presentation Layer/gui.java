package dbcon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.TextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class gui extends JFrame {
	private JTable table;
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bank Prog");
		getContentPane().setLayout(null);
		

		
		JPanel accPan = new JPanel();
		accPan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		accPan.setBounds(10, 35, 136, 128);
		getContentPane().add(accPan);
		accPan.setLayout(null);
		
		
		JLabel lblAccounts = new JLabel("Accounts");
		lblAccounts.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAccounts.setBounds(34, 11, 73, 20);
		accPan.add(lblAccounts);
		
		JLabel lblSelectAccount = new JLabel("Select Account:");
		lblSelectAccount.setBounds(22, 52, 90, 14);
		accPan.add(lblSelectAccount);
		
		JComboBox accDrop = new JComboBox();
		accDrop.setBounds(22, 77, 90, 20);
		accPan.add(accDrop);
		
		JPanel adminPan = new JPanel();
		adminPan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		adminPan.setBounds(10, 210, 136, 128);
		getContentPane().add(adminPan);
		adminPan.setLayout(null);
		
		JButton btnAddAccount = new JButton("Add Account");
		btnAddAccount.setBounds(10, 27, 116, 23);
		adminPan.add(btnAddAccount);
		
		JButton btnArchieveAcc = new JButton("Archieve Acc.");
		btnArchieveAcc.setBounds(10, 81, 116, 23);
		adminPan.add(btnArchieveAcc);
		
		JPanel outterRightPan = new JPanel();
		outterRightPan.setBounds(185, 35, 497, 303);
		getContentPane().add(outterRightPan);
		outterRightPan.setLayout(null);
		
		JPanel innerTopPan = new JPanel();
		innerTopPan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		innerTopPan.setBounds(0, 0, 497, 52);
		outterRightPan.add(innerTopPan);
		innerTopPan.setLayout(null);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCustomerName.setBounds(192, 11, 131, 30);
		innerTopPan.add(lblCustomerName);
		
		JPanel innerMidPan = new JPanel();
		innerMidPan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		innerMidPan.setBounds(0, 51, 497, 106);
		outterRightPan.add(innerMidPan);
		innerMidPan.setLayout(null);
		
		JLabel lblAccountInfo = new JLabel("Account Access:");
		lblAccountInfo.setBounds(10, 11, 82, 14);
		innerMidPan.add(lblAccountInfo);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 36, 31, 14);
		innerMidPan.add(lblName);
		
		TextField nameField = new TextField();
		nameField.setBounds(45, 31, 82, 22);
		innerMidPan.add(nameField);
		
		JLabel lblAccountNumber = new JLabel("Account Number:");
		lblAccountNumber.setBounds(148, 36, 88, 14);
		innerMidPan.add(lblAccountNumber);
		
		TextField accNumField = new TextField();
		accNumField.setEnabled(false);
		accNumField.setBounds(242, 31, 82, 22);
		innerMidPan.add(accNumField);
		
		JLabel lblCurrentBalance = new JLabel("Current Balance:");
		lblCurrentBalance.setBounds(337, 36, 82, 14);
		innerMidPan.add(lblCurrentBalance);
		
		TextField curBalField = new TextField();
		curBalField.setEnabled(false);
		curBalField.setBounds(425, 28, 62, 22);
		innerMidPan.add(curBalField);
		
		JButton btnMakeDeposit = new JButton("Make Deposit");
		btnMakeDeposit.setBounds(247, 72, 97, 23);
		innerMidPan.add(btnMakeDeposit);
		
		JButton btnMakeWithdrawl = new JButton("Make Withdraw");
		btnMakeWithdrawl.setBounds(365, 72, 109, 23);
		innerMidPan.add(btnMakeWithdrawl);
		
		JPanel innerBotPan = new JPanel();
		innerBotPan.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		innerBotPan.setBounds(0, 155, 497, 148);
		outterRightPan.add(innerBotPan);
		innerBotPan.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Date", "Transaction Amt.", "Transaction Type", "Final Balance"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Double.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(42);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(96);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(94);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.setBounds(72, 11, 369, 126);
		innerBotPan.add(table);
		
		
		
		this.setVisible(true);
		this.setSize(725,393);
		this.getContentPane().setLayout(null);
		
	}
	
	public static void main(String[] args){
		new gui();
	}
}
