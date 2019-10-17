package cap2;

import java.util.Arrays;
import java.util.List;

public class Musica {
public static void main(String[] args) {
    NotasMusicais notas = new NotasMusicais();
    NotasMusicais n = new NotasMusicais();
    

    List<Nota> doReMiFa = Arrays.asList(
            n.pega("sol"),
            n.pega("sol"),
            n.pega("sol"));
        Piano piano1 = new Piano();
        piano1.toca(doReMiFa);
  
    
    List<Nota> doReMiFaa = Arrays.asList(
        notas.pega("mi"),
        notas.pega("mi"));
    Piano piano = new Piano();
    piano.toca(doReMiFaa);
}
}
