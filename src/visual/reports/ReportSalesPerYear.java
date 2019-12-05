package visual.reports;

// 2 - PERIODO DE MAIOR E MENOR VENDA
// GRAFICO TIPO TIMESERIES

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;
import model.entities.Sale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class ReportSalesPerYear extends JFrame {

    private List<Sale> sales;
    private XYDataset xyDataset;
    TimeSeriesCollection dataset;
    private JFreeChart chart;
    
    public ReportSalesPerYear(String applicationTitle, String chartTitle, List<Sale> sales) {
        super(applicationTitle);
        setTitle(chartTitle);
        setLocationRelativeTo(null);
        
        this.sales = sales;
        createDataset();
        xyDataset = dataset;
        createChart(chartTitle);
        
        XYPlot plot = (XYPlot)chart.getPlot();
        plot.setBackgroundPaint(new Color(255,228,196));       
        
        chart.getTitle().setPaint(Color.blue);
        ChartFrame frame = new ChartFrame("RELATÓRIO DE VENDAS",chart);
        frame.setVisible(true);
        frame.setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates a sample dataset
     */
    private void createDataset() {
        dataset = new TimeSeriesCollection();

        TimeSeries series1 = new TimeSeries("Venda");
        series1.add(new Day(1, 1, 2017), 50);
        series1.add(new Day(2, 1, 2017), 40);
        series1.add(new Day(3, 1, 2017), 45);
        series1.add(new Day(4, 1, 2017), 30);
        series1.add(new Day(5, 1, 2017), 50);
        series1.add(new Day(6, 1, 2017), 45);
        series1.add(new Day(7, 1, 2017), 60);
        series1.add(new Day(8, 1, 2017), 45);
        series1.add(new Day(9, 1, 2017), 55);
        series1.add(new Day(10, 1, 2017), 48);
        series1.add(new Day(11, 1, 2017), 60);
        series1.add(new Day(12, 1, 2017), 45);
        series1.add(new Day(13, 1, 2017), 65);
        series1.add(new Day(14, 1, 2017), 45);
        series1.add(new Day(15, 1, 2017), 55);
        dataset.addSeries(series1);
    }

    /**
     * Creates a chart
     */
    private void createChart(String chartTitle) {
        chart = chart = ChartFactory.createTimeSeriesChart(
                            chartTitle, // Chart
                            "Data", // X-Axis Label
                            "VALOR (R$)", // Y-Axis Label
                            xyDataset);
    }    
  
}

//public ReportSalesPerYear(String title) {
//    super(title);
//    // Create dataset
//    XYDataset dataset = createDataset();
//    // Create chart
//    JFreeChart chart = ChartFactory.createTimeSeriesChart(
//        "Time Series Chart Example | WWW.BORAJI.COM", // Chart
//        "Date", // X-Axis Label
//        "Number", // Y-Axis Label
//        dataset);
//
//    //Changes background color
//    XYPlot plot = (XYPlot)chart.getPlot();
//    plot.setBackgroundPaint(new Color(255,228,196));
//    
//    ChartPanel panel = new ChartPanel(chart);
//    setContentPane(panel);
//  }
//
//  private XYDataset createDataset() {
//    TimeSeriesCollection dataset = new TimeSeriesCollection();
//
//    TimeSeries series1 = new TimeSeries("Series1");
//    series1.add(new Day(1, 1, 2017), 50);
//    series1.add(new Day(2, 1, 2017), 40);
//    series1.add(new Day(3, 1, 2017), 45);
//    series1.add(new Day(4, 1, 2017), 30);
//    series1.add(new Day(5, 1, 2017), 50);
//    series1.add(new Day(6, 1, 2017), 45);
//    series1.add(new Day(7, 1, 2017), 60);
//    series1.add(new Day(8, 1, 2017), 45);
//    series1.add(new Day(9, 1, 2017), 55);
//    series1.add(new Day(10, 1, 2017), 48);
//    series1.add(new Day(11, 1, 2017), 60);
//    series1.add(new Day(12, 1, 2017), 45);
//    series1.add(new Day(13, 1, 2017), 65);
//    series1.add(new Day(14, 1, 2017), 45);
//    series1.add(new Day(15, 1, 2017), 55);
//    dataset.addSeries(series1);
//
//    TimeSeries series2 = new TimeSeries("Series2");
//    series2.add(new Day(1, 1, 2017), 40);
//    series2.add(new Day(2, 1, 2017), 35);
//    series2.add(new Day(3, 1, 2017), 26);
//    series2.add(new Day(4, 1, 2017), 45);
//    series2.add(new Day(5, 1, 2017), 40);
//    series2.add(new Day(6, 1, 2017), 35);
//    series2.add(new Day(7, 1, 2017), 45);
//    series2.add(new Day(8, 1, 2017), 48);
//    series2.add(new Day(9, 1, 2017), 31);
//    series2.add(new Day(10, 1, 2017), 32);
//    series2.add(new Day(11, 1, 2017), 21);
//    series2.add(new Day(12, 1, 2017), 35);
//    series2.add(new Day(13, 1, 2017), 10);
//    series2.add(new Day(14, 1, 2017), 25);
//    series2.add(new Day(15, 1, 2017), 15);
//    dataset.addSeries(series2);
//    
//
//    return dataset;
//  }
//
//  public static void main(String[] args) {
//    SwingUtilities.invokeLater(() -> {
//      ReportSalesPerYear example = new ReportSalesPerYear("Time Series Chart");
//      example.setSize(800, 400);
//      example.setLocationRelativeTo(null);
//      example.setVisible(true);
//      example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//    });
//  }