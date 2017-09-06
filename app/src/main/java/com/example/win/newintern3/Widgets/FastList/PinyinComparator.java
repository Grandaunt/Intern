package com.example.win.newintern3.Widgets.FastList;

import com.example.win.newintern3.Entity.CityEntity;
import com.example.win.newintern3.NewEntity.CityInfo;

import java.util.Comparator;



public class PinyinComparator implements Comparator<CityEntity.CitylistEntity> {

	public int compare(CityEntity.CitylistEntity o1, CityEntity.CitylistEntity o2) {
		if (o1.getFirstChar().equals("@")
				|| o2.getFirstChar().equals("#")) {
			return -1;
		} else if (o1.getFirstChar().equals("#")
				|| o2.getFirstChar().equals("@")) {
			return 1;
		} else {
			return o1.getFirstChar().compareTo(o2.getFirstChar());
		}
	}

}
