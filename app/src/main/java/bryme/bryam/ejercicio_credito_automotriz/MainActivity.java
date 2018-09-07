package bryme.bryam.ejercicio_credito_automotriz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import clases.Calculo;

public class MainActivity extends AppCompatActivity {

    private View btn;
    private EditText eTxtValorVehiculo, eTxtPie;
    private CheckBox chkBoxSeguro;
    private Spinner spinCuotas;
    ArrayAdapter<String> adapter;
    private double montoVehiculo,interes;
    public String[] cuotas = new String[47];
    public boolean checked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //llenamos spinner
        for (int i = 0; i< 47; i++)
            cuotas[i] = String.valueOf(i+2);
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item, cuotas);
        spinCuotas = (Spinner) findViewById(R.id.SpiCuotas);
        spinCuotas.setAdapter(adapter);
        chkBoxSeguro = (CheckBox) findViewById(R.id.chkBoxSeguro);
        btn = (Button) findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                eTxtValorVehiculo = (EditText) findViewById(R.id.eTxTValorVehiculo);
                eTxtPie = (EditText) findViewById(R.id.eTxtPie);
                double selCuota =  Integer.parseInt(spinCuotas.getSelectedItem().toString());
                double valPie = Double.parseDouble(eTxtPie.getText().toString());
                montoVehiculo = Double.parseDouble(eTxtValorVehiculo.getText().toString());

                // VALIDACIONES
                if (TextUtils.isEmpty(eTxtValorVehiculo.getText()))
                    eTxtValorVehiculo.setError("Monto es obligatorio");
                if (TextUtils.isEmpty(eTxtPie.getText()))
                    eTxtPie.setError("El pie es obligatorio");
                if ((montoVehiculo*0.1) > valPie || (montoVehiculo*0.5) < valPie )
                    eTxtPie.setError("El pie debe ser mayor al 10% y menor al 50%");
                if (chkBoxSeguro.isChecked())
                    checked = true;

                Calculo calculo = new Calculo();
                //sacamos interes
                interes = calculo.calcularInteres(montoVehiculo,selCuota);
                double montoCredito = calculo.calcularMontoCredito(montoVehiculo, valPie, interes);
                if (checked)
                    montoCredito += (montoCredito*0.05);
                double valorCuota = montoCredito/selCuota;
                //creamos intent
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("montoTotalCredito",montoCredito);
                intent.putExtra("valorCuota", valorCuota);
                intent.putExtra("valorVehiculo", montoVehiculo);
                intent.putExtra("cantCuotas",selCuota);
                startActivity(intent);




            }
        });

    }

}
