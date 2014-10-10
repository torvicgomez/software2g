package com.software2g.util.paintService.facade;

import java.util.List;

public interface IGestionFacadeExamenesConsulta {
	public List<Object[]> findExamenesConsultaEspecialidad(long idInstitucion, long idEspecialidad)  throws Exception;
}
