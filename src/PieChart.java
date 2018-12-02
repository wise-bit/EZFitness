//import javax.swing.JFrame;
//
//import org.jfree.chart.ChartFactory;
//import org.jfree.chart.ChartPanel;
//import org.jfree.chart.JFreeChart;
//import org.jfree.chart.plot.PiePlot3D;
//import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.data.general.PieDataset;
//import org.jfree.util.Rotation;
//
//public class PieChart extends JFrame {
//
//    private static final long serialVersionUID = 1L;
//
//    public PieChart(String applicationTitle, String chartTitle) {
//        super(applicationTitle);
//        PieDataset dataset = createDataset();
//        JFreeChart chart = createChart(dataset, chartTitle);
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
//        setContentPane(chartPanel);
//
//    }
//
//    /**
//     * Creates a sample dataset
//     */
//    private PieDataset createDataset() {
//        DefaultPieDataset result = new DefaultPieDataset();
//        result.setValue("Linux", 29);
//        result.setValue("Mac", 20);
//        result.setValue("Windows", 51);
//        return result;
//
//    }
//
//    /**
//     * Creates a chart
//     */
//    private JFreeChart createChart(PieDataset dataset, String title) {
//
//        JFreeChart chart = ChartFactory.createPieChart3D(
//                title,                  // chart title
//                dataset,                // data
//                true,                   // include legend
//                true,
//                false
//        );
//
//        PiePlot3D plot = (PiePlot3D) chart.getPlot();
//        plot.setStartAngle(290);
//        plot.setDirection(Rotation.CLOCKWISE);
//        plot.setForegroundAlpha(0.5f);
//        return chart;
//
//    }
//}