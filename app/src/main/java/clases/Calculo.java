package clases;

import android.widget.Toast;

import bryme.bryam.ejercicio_credito_automotriz.MainActivity;

public class Calculo {

   public double TASA = 7;

    public double calcularInteres(double valorVehiculo, double cantCuotas){

        double interes = valorVehiculo * (TASA/100)*(cantCuotas / 12 );
        return interes;
    }

    public double calcularMontoCredito(double valorVehiculo, double valPie, double interes){
        double montoCredito = (valorVehiculo - valPie) + interes;
        return montoCredito;
    }

}
