package br.com.ebook.bean;

import java.util.List;

import javax.ejb.Local;

@Local
public interface SearchFacadeLocal {
	
	List<String> wineSearch(String wineType);

}
