package Java范例.JFreeChart.折线图.绘制排序折线图;

import java.awt.Font;
import java.awt.Label;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

/**
 * 排序折线图
 * @author baiweiming
 *
 */
public class LineDemo12 extends ApplicationFrame {

	public LineDemo12(String title) {
		super(title);
	}

	/**
	 * 创建一个数据集
	 * 
	 * @return
	 */
	private CategoryDataset getCategoryDataset() {

		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
		keyedValues.addValue("1", 310);
		keyedValues.addValue("2", 489);
		keyedValues.addValue("3", 512);
		keyedValues.addValue("4", 589);
		keyedValues.addValue("5", 359);
		keyedValues.addValue("6", 402);
		//排序
		keyedValues.sortByValues(SortOrder.ASCENDING);
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"JAVA图书", keyedValues);
		
		return dataset;
	}


	/**
	 * 生成JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		CategoryDataset dataset = getCategoryDataset();
		JFreeChart chart = ChartFactory.createLineChart("2010年上半年销售量", // 图表标题
				"月份", // x轴标签
				"销售量（单位：本）", // y轴标签
				dataset, // 数据集
				PlotOrientation.VERTICAL, // 图表方向：水平、垂直
				true, // 是否显示图例
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		return chart;
	}

	/**
	 * 修改字体
	 * 
	 * @param chart
	 */
	private void updateFont(JFreeChart chart) {

		// 标题
		TextTitle textTitle = chart.getTitle();
		textTitle.setFont(new Font("宋体", Font.PLAIN, 20));
		LegendTitle legendTitle = chart.getLegend();
		legendTitle.setItemFont(new Font("宋体", Font.PLAIN, 14));
		// 图表
		CategoryPlot categoryPlot = chart.getCategoryPlot();

		CategoryAxis categoryAxis = categoryPlot.getDomainAxis();
		// X轴字体
		categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// X轴标签字体
		categoryAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));

		ValueAxis valueAxis = categoryPlot.getRangeAxis();
		// y轴字体
		valueAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// y轴标签字体
		valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
	}

	/**
	 * 设置图表
	 * 
	 * @param
	 */
	public void createPlot() {
		JFreeChart chart = getJFreeChart();
		// 修改字体
		updateFont(chart);
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		LineDemo12 demo = new LineDemo12("折线图");
		demo.createPlot();
		demo.pack();
		// 把窗体显示到显示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 设置可以显示
		demo.setVisible(true);

	}

}
