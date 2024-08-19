public class App {
    public static void main(String[] args) throws Exception {

        Carro basico = new Carro("Basico", TipoCombustivel.GASOLINA, 10, 55);

        System.out.println("Tipos de veiculos:");
        System.out.println(basico);

        System.out.println("\n\n----------------");
        System.out.println("\nAbastencendo carro basico com gasolina");
        basico.abastece(TipoCombustivel.GASOLINA, 55);
        System.out.println(basico);
        System.out.println("\nViajando com o carro basico");
        basico.viaja(250);
        basico.viaja(150);
        System.out.println(basico);
        System.out.println("\n\n----------------");

        SUVFlex suvFlex = new SUVFlex(TipoCombustivel.GASOLINA);
        System.out.println("Tipos de veiculos:");
        System.out.println(suvFlex);
        System.out.println("\nAbastencendo carro Modelo suvFlex com gasolina:");
        suvFlex.abastece(TipoCombustivel.GASOLINA, 65);
        System.out.println(suvFlex);
        System.out.println("\nViajando com o carro suvFlex");
        suvFlex.viaja(250);
        suvFlex.viaja(150);
        System.out.println(suvFlex);
    }
}
