package service;

import java.util.ArrayList;

import model.Favourite;

public interface IFavouriteService {
	
	public String addFavourites(String email, int item_id);

	public ArrayList<Favourite> getFavourites(String email);
	
	public String removeFavourite(String email, int item_id);
}
