package com.example.tugasakhir.Model.Getbahasa;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseGetbahasa{

	@SerializedName("pesan")
	private String pesan;

	@SerializedName("dataBahasaPemrograman")
	private List<DataBahasaPemrogramanItem> dataBahasaPemrograman;

	@SerializedName("status")
	private int status;

	public void setPesan(String pesan){
		this.pesan = pesan;
	}

	public String getPesan(){
		return pesan;
	}

	public void setDataBahasaPemrograman(List<DataBahasaPemrogramanItem> dataBahasaPemrograman){
		this.dataBahasaPemrograman = dataBahasaPemrograman;
	}

	public List<DataBahasaPemrogramanItem> getDataBahasaPemrograman(){
		return dataBahasaPemrograman;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseGetbahasa{" + 
			"pesan = '" + pesan + '\'' + 
			",dataBahasaPemrograman = '" + dataBahasaPemrograman + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}