package sales_analysis;
import com.opencsv.*;
import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class SalesAnalysis extends JFrame {
	private Map<String, Double> monthlySales=new HashMap<>();
	
	public SalesAnalysis() {
		setTitle("Sales Analysis");
		setSize(900,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JButton loadBtn=new JButton("Load CSV");
		loadBtn.addActionListener(e->loadCSV());
		
		JPanel panel=new JPanel();
		panel.add(loadBtn);
		
		add(panel, BorderLayout.CENTER);
	}
	
	private void loadCSV() {
		JFileChooser fileChooser=new JFileChooser();
		int result=fileChooser.showOpenDialog(this);
		
		if(result==JFileChooser.APPROVE_OPTION) {
			try(CSVReader csvreader=new CSVReader(new FileReader(fileChooser.getSelectedFile()))){
				List<String[]> rows=csvreader.readAll();
				rows.remove(0);
				monthlySales.clear();
				
				SimpleDateFormat input=new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat monthformat=new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH);
				
				for(String[] row:rows) {
					Date date=input.parse(row[0]);
					String month=monthformat.format(date);
					double quantity=Double.parseDouble(row[2]);
					double price=Double.parseDouble(row[3]);
					double total=quantity*price;
					
					monthlySales.put(month ,monthlySales.getOrDefault(month, 0.0)+total);
				}
				
				showChart();				
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(this,"Error reading CSV.");
			}
		}
	}
	
	private void showChart() {
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		
		List<String> sortedMonths=new ArrayList<>(monthlySales.keySet());
		sortedMonths.sort(Comparator.comparing(ex->{
			try {
				return new SimpleDateFormat("MMMM yyyy",Locale.ENGLISH).parse(ex);
				
			}catch(Exception e) {
				return new Date();
			}
		}));
		
		for(String month:sortedMonths) {
			dataset.addValue(monthlySales.get(month),"Sales", month);
		}
		
		JFreeChart chart=ChartFactory.createBarChart(
				"Monthly Sales",
				"Month",
				"Total Sales (Euros)",
				dataset
				);
		
		
		ChartPanel chartPanel=new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(800,500));
		
		getContentPane().removeAll();
		add(chartPanel, BorderLayout.CENTER);
	}
}
