package com.plexus.crtvgHorarios.view.common.dataModel;

import java.util.List;
import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaUbicacionDto;

public class HorarioSemanasUbicacionDataModel extends ListDataModel<HorarioSemanaUbicacionDto> implements SelectableDataModel<HorarioSemanaUbicacionDto> {  

    public HorarioSemanasUbicacionDataModel() {
    }

    public HorarioSemanasUbicacionDataModel(List<HorarioSemanaUbicacionDto> data) {
        super(data);
    }
    
    @Override
    public HorarioSemanaUbicacionDto getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data
        
        List<HorarioSemanaUbicacionDto> horarios = (List<HorarioSemanaUbicacionDto>) getWrappedData();
        
        for(HorarioSemanaUbicacionDto horarioSemanaUbicacion : horarios) {
            if(horarioSemanaUbicacion.getIdHorarioSemanaUbicacion().equals(rowKey))
                return horarioSemanaUbicacion;
        }
        
        return null;
    }

    @Override
    public Object getRowKey(HorarioSemanaUbicacionDto horarioSemanaUbicacion) {
        return horarioSemanaUbicacion.getIdHorarioSemanaUbicacion();
    }
}