package io.zilker.rest.bean;

import java.util.List;

public class ItemList implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private List<Items> listOfItems;

	public ItemList() {
		super();
	}

	public List<Items> getItemList() {
		return listOfItems;
	}

	public void setItemList(List<Items> itemList) {
		this.listOfItems = itemList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
