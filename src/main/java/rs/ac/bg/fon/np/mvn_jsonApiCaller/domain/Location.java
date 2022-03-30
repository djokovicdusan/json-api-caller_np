package rs.ac.bg.fon.np.mvn_jsonApiCaller.domain;
/**
 * Klasa predstavlja model serverskog odgovora koji predstavlja lokaciju i blizi opis mernih stanica polena u Republici Srbiji
 * @author ddjok
 *
 */


public class Location {
	private int id;
	private String name;
	private String description;
	public Location() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Location [name=" + name + ", description=" + description + "]";
	}
	
	
	
	     
	
	
	

}
