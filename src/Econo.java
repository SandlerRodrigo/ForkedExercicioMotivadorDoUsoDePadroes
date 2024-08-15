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
            if(motor.getQuilometragem() + distancia > controleQuilometragem + 5000 && motor.getConsumo() > 10)
            {
                controleQuilometragem += 5000;
                motor.setConsumo(motor.getConsumo() - 1);
            }
            motor.percorre(distancia);
            tanque.gasta(motor.combustivelNecessario(distancia));
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
