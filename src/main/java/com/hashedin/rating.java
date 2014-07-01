package com.hashedin;

public class rating {
private int userID;
private int itemID;
private int ratingValue;

@Override
public String toString() {
	return "rating ["+ userID + "," + itemID + ","
			+ ratingValue + "]";
}
public int getUserID() {
	return userID;
}
public void setUserID(int userID) {
	this.userID = userID;
}
public int getItemID() {
	return itemID;
}
public void setItemID(int itemID) {
	this.itemID = itemID;
}
public int getRatingValue() {
	return ratingValue;
}
public void setRatingValue(int ratingValue) {
	this.ratingValue = ratingValue;
}


}
