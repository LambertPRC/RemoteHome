package SDK;

import java.io.IOException;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

public class Tools {
	HashMap<Integer, String> flowerMap;

	public Tools() {
		flowerMap = new HashMap<Integer, String>();
		flowerMap.put(0, "菊花");
		flowerMap.put(1, "蒲公英");
		flowerMap.put(2, "玫瑰");
		flowerMap.put(3, "向日葵");
		flowerMap.put(4, "郁金香");
	}

	public int getFlowerIndex(String[] data) {
		String[][] degreeConfidence = new String[5][2];
		degreeConfidence[0][0] = "-1000";
		for (int i = 0; i < 5; i++) {
			degreeConfidence[i] = data[i].split("e-");
		}
		for (String[] strings : degreeConfidence) {
			for (String string : strings) {
				System.out.println(string);
			}
		}
		int minIndex = 1000;
		if (!degreeConfidence[0][0].equals("-1000")) {
			for (int i = 0; i < 5; i++) {
				if (Integer.valueOf(degreeConfidence[i][1]) < minIndex) {
					minIndex = Integer.valueOf(degreeConfidence[i][1]);
				}
			}
		} else {
			for (int i = 0; i < 5; i++) {
				degreeConfidence[i][1] = "1000";
			}
		}
		int index = 0;
		double maxDegree = -1000;
		for (int i = 0; i < 5; i++) {
			if (Integer.valueOf(degreeConfidence[i][1]) == minIndex) {
				if (maxDegree < Double.valueOf(degreeConfidence[i][0])) {
					index = i;
					maxDegree = Double.valueOf(degreeConfidence[i][0]);
				}
			}
		}

		return index;
	}

	public String getFlowerClass(int index) {
		return flowerMap.get(index);
	}

	public int getFlowerIndex(String[] data, int k) {
		int index = 0;
		double maxDegree = -1000;
		for (int i = 0; i < 5; i++) {
			if (maxDegree < Double.valueOf(data[i])) {
				index = i;
				maxDegree = Double.valueOf(data[i]);
			}
		}
		return index;
	}

}
