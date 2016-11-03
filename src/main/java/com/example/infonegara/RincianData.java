package com.example.infonegara;

public class RincianData {
	private String negara ;
	private int idBendera;
	private boolean isSelected;

	// Konstruktor
	public RincianData(String negara,
			           int idBendera) {
		this.negara = negara;
		this.idBendera = idBendera;
	}
	
	// Metode lain-lain
	public String perolehNegara() {
		return negara;
	}

	public int perolehIdBendera() {
		return idBendera;
	}
	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	
}