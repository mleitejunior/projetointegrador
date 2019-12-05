package visual.reports;

// 1- PRODUTO MAIS VENDIDO PERIODO DE 1 MES
// GRAFICO TIPO BARCHART *Falta passar efeito 3D

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import model.entities.Product;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


public class ReportProductSales extends JFrame {
    
    protected List<Product> products;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    
    public ReportProductSales(String applicationTitle, String chartTitle, List<Product> products) {
        super(applicationTitle);
        setTitle(chartTitle);
        setLocationRelativeTo(null);
        
        this.products = products;
        createDataset();
        createChart(chartTitle);
        
        chart.getTitle().setPaint(Color.blue); 
        
        ChartFrame frame = new ChartFrame("RELATÓRIO DE VENDA DE PRODUTOS",chart);
        frame.setVisible(true);
        frame.setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates a sample dataset
     */
    private void createDataset() {
        dataset = new DefaultCategoryDataset();
        
        dataset.setValue(27, "Produto", "Cachecol Rosa");
        dataset.setValue(11.25, "Produto", "Brusinha");
        dataset.setValue(0, "Produto", "Tênis");
        
//        for (Product p : products) {
//            dataset.setValue(p.getCost(), "Marca", p.getName());
//        }
    }

    /**
     * Creates a chart
     */
    private void createChart(String chartTitle) {
        chart = ChartFactory.createBarChart(
                chartTitle,
                "PRODUTO",
                "VALOR (R$)",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
    }    
}
