
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class TabelaMaria extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField primeiro;
	private JTextField segundo;
	private JTextField terceiro;
	private JTextField quarto;
	private JTextField quinto;
	private JTextField sexto;
	private JButton btnNewButton;
	private JTextField primeiraParcelaField;
	private JTextField segundaParcelaField;
	private JTextField somaField;
	private JButton btnNewButton_1;
	private final Action somaAction = new SwingAction_1();
	private Soma modelo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TabelaMaria frame = new TabelaMaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TabelaMaria() {
		modelo = new Soma();
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 657, 321);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.PINK, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 606, 114);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"        1", new Integer(12), new Integer(12), new Integer(12), new Integer(0), new Integer(0)},
				{"        2", new Integer(24), new Integer(12), new Integer(24), new Integer(0), new Integer(1)},
				{"        3", new Integer(10), new Integer(10), new Integer(24), new Integer(1), new Integer(1)},
				{"        4", new Integer(24), new Integer(10), new Integer(24), new Integer(1), new Integer(1)},
			},
			new String[] {
				"Jogo", "Placar", "M\u00EDnimo da temporada", "M\u00E1ximo da temporada", "Quebra recorde min.", "Quebra recorde m\u00E1x."
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Integer.class, Integer.class, Integer.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(41);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(116);
		table.getColumnModel().getColumn(4).setPreferredWidth(110);
		table.getColumnModel().getColumn(5).setPreferredWidth(114);
		scrollPane.setViewportView(table);
		
		primeiro = new JTextField();
		primeiro.setBackground(Color.WHITE);
		primeiro.setBounds(10, 128, 49, 20);
		contentPane.add(primeiro);
		primeiro.setColumns(10);
		
		segundo = new JTextField();
		segundo.setBackground(Color.WHITE);
		segundo.setBounds(56, 128, 60, 20);
		contentPane.add(segundo);
		segundo.setColumns(10);
		
		terceiro = new JTextField();
		terceiro.setBackground(Color.WHITE);
		terceiro.setBounds(114, 128, 120, 20);
		contentPane.add(terceiro);
		terceiro.setColumns(10);
		
		quarto = new JTextField();
		quarto.setBackground(Color.WHITE);
		quarto.setBounds(229, 128, 138, 20);
		contentPane.add(quarto);
		quarto.setColumns(10);
		
		quinto = new JTextField();
		quinto.setBackground(Color.WHITE);
		quinto.setBounds(364, 128, 126, 20);
		contentPane.add(quinto);
		quinto.setColumns(10);
		
		sexto = new JTextField();
		sexto.setBackground(Color.WHITE);
		sexto.setBounds(490, 128, 126, 20);
		contentPane.add(sexto);
		sexto.setColumns(10);
		
		btnNewButton = new JButton("INSERIR");
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel ();
				model.addRow(new Object [] {Integer.parseInt(primeiro.getText ()), Integer.parseInt (segundo.getText()), terceiro.getText(), quarto.getText(), quinto.getText(), sexto.getText() } );
				
			}
			
		});
		btnNewButton.setBounds(256, 159, 89, 23);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(489, 242, 1, -81);
		contentPane.add(separator);
		
		primeiraParcelaField = new JTextField();
		primeiraParcelaField.setBounds(518, 159, 86, 20);
		contentPane.add(primeiraParcelaField);
		primeiraParcelaField.setColumns(10);
		
		segundaParcelaField = new JTextField();
		segundaParcelaField.setBounds(518, 190, 86, 20);
		contentPane.add(segundaParcelaField);
		segundaParcelaField.setColumns(10);
		
		somaField = new JTextField();
		somaField.setEditable(false);
		somaField.setBounds(518, 255, 86, 20);
		contentPane.add(somaField);
		somaField.setColumns(10);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setAction(somaAction);
		btnNewButton_1.setBounds(515, 221, 89, 23);
		contentPane.add(btnNewButton_1);
									
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Somar");
			putValue(SHORT_DESCRIPTION, "Calcula a soma das duas parcelas");
		}
		public void actionPerformed(ActionEvent e) {
			String textoA = primeiraParcelaField.getText();
			String textoB = segundaParcelaField.getText();
			int a = Integer.parseInt(textoA);
			int b = Integer.parseInt(textoB);
			modelo.setA(a);
			modelo.setB(b);
			int soma = modelo.getSoma();
			String textoSoma = String.format("%d", soma);
			somaField.setText(textoSoma);			
		}
	}
}
