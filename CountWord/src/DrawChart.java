import java.awt.BasicStroke;

import java.awt.Color;

import java.awt.Font;

import java.awt.GradientPaint;

import java.awt.Paint;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.jfree.chart.ChartFrame;

import org.jfree.chart.JFreeChart;

import org.jfree.chart.axis.CategoryAxis;

import org.jfree.chart.axis.CategoryLabelPositions;

import org.jfree.chart.axis.NumberAxis;

import org.jfree.chart.labels.CategoryItemLabelGenerator;

import org.jfree.chart.labels.ItemLabelAnchor;

import org.jfree.chart.labels.ItemLabelPosition;

import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;

import org.jfree.chart.plot.CategoryPlot;

import org.jfree.chart.plot.DatasetRenderingOrder;

import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.renderer.category.BarRenderer;

import org.jfree.chart.renderer.category.CategoryItemRenderer;

import org.jfree.chart.renderer.category.LineAndShapeRenderer;

import org.jfree.chart.renderer.category.StandardBarPainter;

import org.jfree.chart.title.TextTitle;

import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.GradientPaintTransformType;

import org.jfree.ui.HorizontalAlignment;

import org.jfree.ui.StandardGradientPaintTransformer;

import org.jfree.ui.TextAnchor;

/**
 * 
 * A simple demonstration application showing how to create a bar chart overlaid
 * 
 * with a line chart.
 * 
 */

public class DrawChart {

	String arr[] = new String[10000]; // [WORD1] [WORD2] [] [] [][]...[]
	int cnt[] = new int[10000]; // [2] [1] [] [] [][]...[]
	int n = 0; // 배열에서 index를 진행할 변수

	// Run As > Java Application 으로 실행하면 바로 확인할 수 있음.

	public static void main(final String[] args) {

		DrawChart demo = new DrawChart();
		demo.countText();

		JFreeChart chart = demo.getChart();

		ChartFrame frame1 = new ChartFrame("Bar Chart", chart);

		frame1.setSize(800, 400);

		frame1.setVisible(true);

	}

	public JFreeChart getChart() {

		// 데이터 생성

		DefaultCategoryDataset dataset1 = new DefaultCategoryDataset(); // bar chart 1

		// 데이터 입력 ( 값, 범례, 카테고리 )

		// 그래프 1
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] != null)
				dataset1.addValue(cnt[k], "Rogan", arr[k]);
		}

		// 렌더링 생성 및 세팅

		// 렌더링 생성

		final BarRenderer renderer = new BarRenderer();

		// 공통 옵션 정의

		final CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator();

		final ItemLabelPosition p_center = new ItemLabelPosition(

				ItemLabelAnchor.CENTER, TextAnchor.CENTER

		);

		Font f = new Font("Gulim", Font.BOLD, 10);

		Font axisF = new Font("Gulim", Font.PLAIN, 10);

		// 렌더링 세팅

		// 그래프 1

		renderer.setBaseItemLabelGenerator(generator);

		renderer.setBaseItemLabelsVisible(true);

		renderer.setBasePositiveItemLabelPosition(p_center);

		renderer.setBaseItemLabelFont(f);

		// renderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(

		// GradientPaintTransformType.VERTICAL));

		// renderer.setSeriesPaint(0, new GradientPaint(1.0f, 1.0f, Color.white, 0.0f,
		// 0.0f, Color.blue));

		renderer.setSeriesPaint(0, new Color(0, 162, 255));

		// plot 생성

		final CategoryPlot plot = new CategoryPlot();

		// plot 에 데이터 적재

		plot.setDataset(dataset1);

		plot.setRenderer(renderer);

		// plot 기본 설정

		plot.setOrientation(PlotOrientation.VERTICAL); // 그래프 표시 방향

		plot.setRangeGridlinesVisible(true); // X축 가이드 라인 표시여부

		plot.setDomainGridlinesVisible(true); // Y축 가이드 라인 표시여부

		// 렌더링 순서 정의 : dataset 등록 순서대로 렌더링 ( 즉, 먼저 등록한게 아래로 깔림 )

		plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);

		// X축 세팅

		plot.setDomainAxis(new CategoryAxis()); // X축 종류 설정

		plot.getDomainAxis().setTickLabelFont(axisF); // X축 눈금라벨 폰트 조정

		plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.STANDARD); // 카테고리 라벨 위치 조정

		// Y축 세팅

		plot.setRangeAxis(new NumberAxis()); // Y축 종류 설정

		plot.getRangeAxis().setTickLabelFont(axisF); // Y축 눈금라벨 폰트 조정

		// 세팅된 plot을 바탕으로 chart 생성

		final JFreeChart chart = new JFreeChart(plot);

		// chart.setTitle("Overlaid Bar Chart"); // 차트 타이틀

		// TextTitle copyright = new TextTitle("JFreeChart WaferMapPlot", new
		// Font("SansSerif", Font.PLAIN, 9));

		// copyright.setHorizontalAlignment(HorizontalAlignment.RIGHT);

		// chart.addSubtitle(copyright); // 차트 서브 타이틀

		return chart;

	}

	public void countText() {

		try {
			// 파일 객체 생성
			File file = new File("Rogan.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
				line = line.replaceAll(match, "");
				StringTokenizer st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					String s = st.nextToken().replaceAll(" ", "");
					// 만약 중복되면 중복되는 배열에 index를 알고 cnt[index]를 1증가한다.
					int i = 0;
					for (i = 0; i < n; i++) {
						if (s.equalsIgnoreCase(arr[i])) { // 토큰에서 뽑아온 글자가 배열에 이미 있는지 검사하는것
							break;
						}
					}
					if (i < n) {
						cnt[i]++;
					}
					if (n == 0 || i == n) {
						arr[n] = s;
						cnt[n] = 1;
						n++;
					}

				}
			}
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i] + " --> " + cnt[i]);
		}

	}

}
