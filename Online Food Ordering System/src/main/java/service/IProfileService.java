package service;

import model.Profile;

public interface IProfileService {

	public Profile getDetailsByEmail(String email);
	
	public void deleteProfileByEmail(String email);
	
	public String updateProfileByEmail(String email , Profile profile);
	
	public String checkPhone(String phone);
}
