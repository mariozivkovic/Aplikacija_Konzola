package zivkovic.obrada;
import java.util.ArrayList;
import java.util.List;

import zivkovic.Pomocno;
import zivkovic.Start;
import zivkovic.model.Busotina;
import zivkovic.model.NaftnoPolje;
import zivkovic.model.Odrzavanje;
import zivkovic.model.Posao;
import zivkovic.model.PosaoBusotina;

public class ObradaPosaoBusotina {
	
	private List<PosaoBusotina> posloviBusotine;
	


	public ObradaPosaoBusotina() {
		super();
		posloviBusotine = new ArrayList<>();
	}
	

	public ObradaPosaoBusotina(List<PosaoBusotina> posloviBusotine) {
		super();
		this.posloviBusotine = posloviBusotine;
	}


	public List<PosaoBusotina> getPosloviBusotine() {
		return posloviBusotine;
	}

	public void setPosloviBusotine(List<PosaoBusotina> posloviBusotine) {
		this.posloviBusotine = posloviBusotine;
	}
	
	
	
	
	

}
