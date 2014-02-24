package com.google.log;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
@SuppressWarnings("serial")
public class LogViews implements PhaseListener{
	/*
	 * LA CLASE SE CREÓ CON EL FIN DE MONITOREAR LAS FASES DE LAS VISTAS. LA SECUENCIA DE LA PÁGINAS
	 * */
	public static final Log _log = LogFactory.getLog(LogViews.class);
	@Override
	public void afterPhase(PhaseEvent fase) {
		if(_log.isInfoEnabled()){
			_log.info("DESPUES DE FASE: "+fase.getPhaseId().toString());
		}
	}

	@Override
	public void beforePhase(PhaseEvent fase) {
		if(_log.isInfoEnabled()){
			_log.info("ANTES DE FASE: "+fase.getPhaseId().toString());
		}
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}