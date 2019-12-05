package visual.reports;

// 3 - PORCENTAGEM DOS GASTOS MENSAIS
// GRAFICO DO TIPO WATERFALL CHART

import java.awt.*;
import javax.swing.JFrame;
import model.structure.MonthlyFixedExpense;
import org.jfree.chart.*;
import org.jfree.data.category.*;
import org.jfree.chart.plot.*;

public class ReportPercentExpenses extends JFrame {
    
    protected MonthlyFixedExpense expense;
    private DefaultCategoryDataset dataset;
    private JFreeChart chart;
    
    public ReportPercentExpenses(String applicationTitle, String chartTitle, MonthlyFixedExpense expense) {
        super(applicationTitle);
        
        this.expense = expense;
        createDataset();
        createChart();
        
        chart.getTitle().setPaint(Color.blue); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        p.setDomainGridlinesVisible(true);
        p.setDomainGridlinePaint(Color.black);
        
        ChartFrame frame = new ChartFrame("RELATÓRIO DE DESPESAS",chart);
        frame.setVisible(true);
        frame.setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Creates a sample dataset
     */
    private void createDataset() {
        dataset = new DefaultCategoryDataset();
        
        dataset.setValue(expense.getEmployees(), "", "Funcionários");
        dataset.setValue(expense.getEquipment(), "", "Equipamento");
        dataset.setValue(expense.getLoan(), "", "Empréstimo");
        dataset.setValue(expense.getMaintenance(), "", "Manutenção");
        dataset.setValue(expense.getMonthlyTax(), "", "Juros Mensais");
        dataset.setValue(expense.getRent(), "", "Aluguel");
        dataset.setValue(expense.getUseMaterial(), "", "Material de Uso");
        dataset.setValue(expense.getOthers(), "", "Outros");
        double total = expense.getEmployees() + expense.getEquipment() + expense.getLoan() +
                       expense.getMaintenance() + expense.getMonthlyTax() + expense.getOthers() +
                       expense.getRent() + expense.getUseMaterial();
        dataset.setValue(total, "", "TOTAL");
    }

    /**
     * Creates a chart
     */
    private void createChart() {
        chart = ChartFactory.createWaterfallChart
            ("Porcentagem das Despesas de" + expense.getDate(),"Despesa", "VALOR (R$)", 
             dataset, PlotOrientation.VERTICAL, true,true, false);
    }
    
}