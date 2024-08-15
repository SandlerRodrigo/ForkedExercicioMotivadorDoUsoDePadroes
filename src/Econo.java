public class Econo extends Carro {

    private int controleQuilometragem;
    
    public Econo(String modelo) {
        super(modelo, TipoCombustivel.GASOLINA, 20, 55); // Arrumar a capacidadeTaqnque
        controleQuilometragem = 0;
    }

    // Viagem modificada da forma lógicamente correta conforme o enunciado mas n faz muito sentido não
    @Override
    public boolean viaja(int distancia) {
        if (verificaSePodeViajar(distancia) >= distancia) {
            if(getMotor().getQuilometragem() + distancia > controleQuilometragem + 5000 && getMotor().getConsumo() > 10)
            {
                int dif = calculaDiferenca(distancia);

                System.out.println(dif + "   ||  " + distancia);
                
                // Percorre a diferenca até o decresimento do consumo
                getMotor().percorre(distancia - dif);
                getTanque().gasta(getMotor().combustivelNecessario(distancia - dif));

                // Automenta o consumo
                aumentaConsumo();

                // Percorre o resto
                getMotor().percorre(dif);
                getTanque().gasta(getMotor().combustivelNecessario(dif));

                controleQuilometragem += 5000;
                return true;
            }
            getMotor().percorre(distancia);
            getTanque().gasta(getMotor().combustivelNecessario(distancia));
            return true;

        }
        return false;
    }
    

    // Aumenta o consumo do motor
    private void aumentaConsumo()
    {
        getMotor().setConsumo(getMotor().getConsumo() - 1);
    }

    // Calculo da diferenca de distância
    private int calculaDiferenca(int distancia)
    {
        return (distancia + getMotor().getQuilometragem() - controleQuilometragem + 5000) - 10000; 
    }
}
