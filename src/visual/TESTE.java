package visual;

public class TESTE {
    public static void main(String[] args) {
//        TESTEAXISCHART testFrame = new TESTEAXISCHART();
//        testFrame.setVisible(true);;
        
//        ReportProductSale reportFrame = new ReportProductSale();
//        reportFrame.setVisible(true);
    ReportProductSale demo = new ReportProductSale("Comparison", "Which operating system are you using?");
    demo.pack();
    demo.setVisible(true);
    }
}
