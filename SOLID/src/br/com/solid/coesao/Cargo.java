package br.com.solid.coesao;
public enum Cargo {
    DESENVOLVEDOR(new CalculaSalario10Ou20PorCento()),
    DBA (new CalculaSalario15Ou25PorCento()),
    TESTER(new CalculaSalario15Ou25PorCento());
    
    private CalculaSalario regra;

	private Cargo(CalculaSalario regra) {
		this.regra = regra;
	}

	public CalculaSalario getRegra() {
		return regra;
	}
	
}