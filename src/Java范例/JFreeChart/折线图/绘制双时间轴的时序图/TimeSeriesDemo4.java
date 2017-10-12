/**
 * @jdk版本:1.6
 * @编码时间:2010-7-20
 */
package Java范例.JFreeChart.折线图.绘制双时间轴的时序图;

import java.awt.Font;
import java.text.SimpleDateFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 双时间轴位置 
 * @author baiweiming
 * 
 */
public class TimeSeriesDemo4 extends ApplicationFrame {

	public TimeSeriesDemo4(String title) {
		super(title);
	}

	/**
	 * 创建数据集
	 * 
	 * @return
	 */
	private XYDataset getDataset() {

		final TimeSeries s1 = new TimeSeries("JAVA图书");
		s1.add(new Month(1, 2010), 480);
		s1.add(new Month(2, 2010), 381);
		s1.add(new Month(3, 2010), 264);
		s1.add(new Month(4, 2010), 185);
		s1.add(new Month(5, 2010), 209);
		s1.add(new Month(6, 2010), 302);

		final TimeSeries s2 = new TimeSeries("VC图书");
		s2.add(new Month(1, 2010), 315);
		s2.add(new Month(2, 2010), 418);
		s2.add(new Month(3, 2010), 580);
		s2.add(new Month(4, 2010), 308);
		s2.add(new Month(5, 2010), 200);
		s2.add(new Month(6, 2010), 501);

		final TimeSeries s3 = new TimeSeries("VB图书");
		s3.add(new Month(1, 2010), 310);
		s3.add(new Month(2, 2010), 489);
		s3.add(new Month(3, 2010), 512);
		s3.add(new Month(4, 2010), 589);
		s3.add(new Month(5, 2010), 359);
		s3.add(new Month(6, 2010), 402);

		final TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(s1);
		dataset.addSeries(s2);
		dataset.addSeries(s3);

		return dataset;

	}

	/**
	 * 生成JFreeChart
	 * 
	 * @return
	 */
	private JFreeChart getJFreeChart() {
		XYDataset dataset = getDataset();
		JFreeChart chart = ChartFactory.createTimeSeriesChart("2010年上半年销售量", // 图表标题
				"月份", // x轴标签
				"销售量（单位：本）", // y轴标签
				dataset, // 数据集
				true, // 是否显示图例
				false, // 是否生成工具
				false // 是否生成URL链接
				);
		return chart;
	}

	/**
	 * 更新图表显示
	 * 
	 * @param chart
	 */
	private void updatePlot(JFreeChart chart) {
		// 分类图表
		XYPlot xyPlot = chart.getXYPlot();
		DateAxis dateAxis = (DateAxis) xyPlot.getDomainAxis();
		//设置显示格式
		dateAxis.setDateFormatOverride(new SimpleDateFormat("yyyy-MM"));

		//添加时间轴
		DateAxis dateAxis1 = new DateAxis();
		dateAxis1.setRange(new Month(1, 2010).getStart(), new Month(7, 2010).getEnd());
		dateAxis1.setDateFormatOverride(new SimpleDateFormat("yyyy-MMM"));
		xyPlot.setDomainAxis(1,dateAxis1);
		//设置时间轴
		xyPlot.setDomainAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);

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
		XYPlot xyPlot = chart.getXYPlot();

		ValueAxis domainyAxis = xyPlot.getDomainAxis();
		// X轴字体
		domainyAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// X轴标签字体
		domainyAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));

		ValueAxis rangeAxis = xyPlot.getRangeAxis();
		// y轴字体
		rangeAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 14));
		// y轴标签字体
		rangeAxis.setLabelFont(new Font("宋体", Font.PLAIN, 14));
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
		// 修改图表
		updatePlot(chart);
		setContentPane(new ChartPanel(chart));
	}

	public static void main(String[] args) {
		TimeSeriesDemo4 demo = new TimeSeriesDemo4("时序图");
		demo.createPlot();
		demo.pack();
		// 把窗体显示到显示器中央
		RefineryUtilities.centerFrameOnScreen(demo);
		// 设置可以显示
		demo.setVisible(true);
	}
}
