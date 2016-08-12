package br.com.ebook.bean;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface SearchFacade {
	
	List<String> wineSearch(String wineType);

}
