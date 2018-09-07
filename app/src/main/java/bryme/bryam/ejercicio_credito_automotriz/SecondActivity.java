package bryme.bryam.ejercicio_credito_automotriz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public TextView txtViewMontoSolicitado;
    public TextView txtViewContoTotalCredito;
    public TextView txtViewCantidadDeCuotas;
    public TextView txtViewValorCuota;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtViewMontoSolicitado = (TextView) findViewById(R.id.txtViewMontoSolicitado);
        txtViewContoTotalCredito = (TextView) findViewById(R.id.txtViewContoTotalCredito);
        txtViewCantidadDeCuotas = (TextView) findViewById(R.id.txtViewCantidadDeCuotas);
        txtViewValorCuota = (TextView) findViewById(R.id.txtViewValorCuota);

        Bundle bundle = SecondActivity.this.getIntent().getExtras();

        if (bundle != null){

            txtViewMontoSolicitado.setText("Monto solicitado: "+bundle.getDouble("valorVehiculo"));
            txtViewContoTotalCredito.setText("Monto total credito: "+bundle.getDouble("montoTotalCredito"));
            txtViewCantidadDeCuotas.setText("Cantidad de cuotas: "+bundle.getDouble("cantCuotas"));
            txtViewValorCuota.setText("Valor de la cuota: "+bundle.getDouble("valorCuota"));
        }

    }
}
