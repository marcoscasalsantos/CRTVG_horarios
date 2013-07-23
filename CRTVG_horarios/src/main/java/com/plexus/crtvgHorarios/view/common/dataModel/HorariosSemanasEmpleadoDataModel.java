package com.plexus.crtvgHorarios.view.common.dataModel;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;

import org.primefaces.model.SelectableDataModel;

import com.plexus.crtvgHorarios.dto.horarios.HorarioSemanaEmpleadoDto;

public class HorariosSemanasEmpleadoDataModel extends ListDataModel<HorarioSemanaEmpleadoDto> implements SelectableDataModel<HorarioSemanaEmpleadoDto>, Serializable{  

    public HorariosSemanasEmpleadoDataModel() {
    }

    public HorariosSemanasEmpleadoDataModel(List<HorarioSemanaEmpleadoDto> data) {
        super(data);
    }
    
    @Override
    public HorarioSemanaEmpleadoDto getRowData(String rowKey) {
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data
        
        List<HorarioSemanaEmpleadoDto> horarios = (List<HorarioSemanaEmpleadoDto>) getWrappedData();
        
        for(HorarioSemanaEmpleadoDto horarioSemanaEmpleado : horarios) {
            if(horarioSemanaEmpleado.getIdHorarioSemanaEmpleado().equals(rowKey))
                return horarioSemanaEmpleado;
        }
        
        return null;
    }

    @Override
    public Object getRowKey(HorarioSemanaEmpleadoDto horarioSemanaEmpleado) {
    	return horarioSemanaEmpleado.getIdHorarioSemanaEmpleado();
    }
}