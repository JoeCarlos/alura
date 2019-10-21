package cap6;

import java.util.Calendar;

public class Programa {
	public static void main(String[] args) {
		MapaFactory mapa = new MapaFactory();
		System.out.println(mapa.getMapa().devolveMapa("Comandante Coelho, 367"));
		Calendar agora = new Relogio().hoje();
		System.out.println(agora.getTime());
	}
}
