package br.com.atv_tratamento_excecoes;

public class CalculoMatematico {

    public double dividir(int num1, int num2) throws ArithmeticException, DivisorZeroException {
//        try {
//            return num1 / num2;
//        } catch (ArithmeticException e) {
//            System.out.println("Você tentou uma divisão por zero." + e);
//            return Double.NaN;
//        }
        if(num2 == 0){
            throw new DivisorZeroException("A divisão por zero não é permitida");
        }
        return num1/num2;

    }

}
