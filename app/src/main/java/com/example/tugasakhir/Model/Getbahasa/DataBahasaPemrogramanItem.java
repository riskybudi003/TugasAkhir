package com.example.tugasakhir.Model.Getbahasa;

import com.google.gson.annotations.SerializedName;

public class DataBahasaPemrogramanItem{

	@SerializedName("image")
	private String image;

	@SerializedName("nama")
	private String nama;

	@SerializedName("tahun")
	private String tahun;

	@SerializedName("id")
	private String id;

	@SerializedName("deskripsi")
	private String deskripsi;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setTahun(String tahun){
		this.tahun = tahun;
	}

	public String getTahun(){
		return tahun;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDeskripsi(String deskripsi){
		this.deskripsi = deskripsi;
	}

	public String getDeskripsi(){
		return deskripsi;
	}

	@Override
 	public String toString(){
		return 
			"DataBahasaPemrogramanItem{" + 
			"image = '" + image + '\'' + 
			",nama = '" + nama + '\'' + 
			",tahun = '" + tahun + '\'' + 
			",id = '" + id + '\'' + 
			",deskripsi = '" + deskripsi + '\'' + 
			"}";
		}
}