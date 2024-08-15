public class Econo extends Carro {

    private int controleQuilometragem;
    
    public Econo(String modelo) {
        super(modelo, TipoCombustivel.GASOLINA, 20, 1000);
        controleQuilometragem = 0;
    }

    // Viagem modificada conforme o enunciado
    @Override
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            if(getMotor().getQuilometragem() + distancia > controleQuilometragem + 5000 && getMotor().getConsumo() > 10)
            {
                controleQuilometragem += 5000;
                getMotor().setConsumo(getMotor().getConsumo() - 1);
            }
            getMotor().percorre(distancia);
            getTanque().gasta(getMotor().combustivelNecessario(distancia));
            return true;
        }
        return false;
    }

    // Deletar -- Usando pra testar
    public void encheTanque()
    {
        abastece(TipoCombustivel.GASOLINA, 1000);
    }
}
