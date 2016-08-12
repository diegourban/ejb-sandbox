package br.com.ebook.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class SearchFacadeBean implements SearchFacade, SearchFacadeLocal {

	@Override
	public List<String> wineSearch(String wineType) {
		List<String> wineList = new ArrayList<String>();

		if (wineType.equals("Red")) {
			wineList.add("Bordeaux");
			wineList.add("Merlot");
			wineList.add("Pinot Noir");
		} else if (wineType.equals("White")) {
			wineList.add("Chardonnay");
		}

		return wineList;
	}

}
