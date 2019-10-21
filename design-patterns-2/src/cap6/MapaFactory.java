package cap6;

public class MapaFactory {
	public Mapa getMapa() {
		return new GoogleMaps();
	}
}
