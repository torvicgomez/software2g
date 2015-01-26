package com.software2g.service.facade;

import java.util.List;

public interface IGestionFacadeAutoCompletado {
	public List<String> findPersonaPortal(String datoFind)  throws Exception;
	public List<String> findAllPersonasProfesional(String datoFind)  throws Exception;
}
