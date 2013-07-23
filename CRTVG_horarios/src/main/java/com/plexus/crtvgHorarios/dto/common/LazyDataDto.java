package com.plexus.crtvgHorarios.dto.common;

import java.util.List;


public class LazyDataDto<T> {
	
	// Indica el número de registros que cumplen los criterios establecidos para la carga perezosa
	private int rowCount;
	private List<T> data;
	
	public LazyDataDto(int rowCount, List<T> data) {
		super();
		this.rowCount = rowCount;
		this.data = data;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}	
	
}
                    