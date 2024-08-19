public class SUVFlex extends Carro {
    private static final int consumoGasolina=8;
    private static final int consumoAlcool=6;
    private static final int capacidadeTanque=65;
    private static final String modeloflex = "suvFlex";
    
    public SUVFlex(TipoCombustivel tipoCombustivel){// tipo de conbustivel gasolina
       super(modeloflex, TipoCombustivel.GASOLINA, getTipoCombustivel(tipoCombustivel), capacidadeTanque);
    }

    private static int getTipoCombustivel(TipoCombustivel tipoCombustivel){
  if (tipoCombustivel== TipoCombustivel.ALCOOL){
    return consumoGasolina;
  }else{
    return consumoAlcool;
  }
    }

    public static int getConsumogasolina() {
        return consumoGasolina;
    }

    public static int getConsumoalcool() {
        return consumoAlcool;
    }

    public static int getCapacidadetanque() {
        return capacidadeTanque;
    }

    @Override
    public int abastece(TipoCombustivel tipoCombustivel, int quantidade) {
        int capacidadeLivre = getTanque().getCapacidade() - getTanque().getCombustivelDisponivel();
        if (capacidadeLivre < quantidade) {
            getTanque().abastece(tipoCombustivel, capacidadeLivre);
            return capacidadeLivre;
        } else {
            getTanque().abastece(tipoCombustivel, quantidade);
            return quantidade;
        }
    }

    @Override
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            getMotor().percorre(distancia);
            getTanque().gasta(getMotor().combustivelNecessario(distancia));
            return true;
        }
        return false;
    }
  
 
}
