package visual.reports;

// 5 - PORCENTAGEM DOS TIPOS DE GASTO MENSAL
// GRAFICO DO TIPO 3DPIECHART COM ROTATOR

import java.util.List;
import resources.Rotator;
import javax.swing.JFrame;
import model.entities.Sale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.Rotation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;


public class ReportTypePayments extends JFrame {
    List<Sale> sales;
    
    public ReportTypePayments(String applicationTitle, String chartTitle, List<Sale> sales) {
        super(applicationTitle);
        
        this.sales = sales;
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        // put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        // add it to our application
        setContentPane(chartPanel);
        setVisible(true);
    }

    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
        DefaultPieDataset result = new DefaultPieDataset();
        result.setValue("À VISTA", 1);
        result.setValue("À PRAZO", 2);
        result.setValue("CRÉDITO", 0);
        result.setValue("DÉBITO", 0);
        return result;

    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMinimumSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);

        final Rotator rotator = new Rotator(plot);
        rotator.start();
        
        return chart;
    }
}