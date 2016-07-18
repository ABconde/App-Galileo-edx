package com.example.abcon.dispensadorbebidas;

import android.content.Intent;
import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    private Button btnPedido;
    private TextView txtCan;
    String ord;
    Double pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnPedido = (Button)findViewById(R.id.btnPedido);
        txtCan = (TextView) findViewById(R.id.txtCan);
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] valores = {"CocaCola","Grapete","Te Frio","Agua Pura","Limonada"};
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, valores));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
            {
                //Toast.makeText(adapterView.getContext(), (String) adapterView.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
                ord = (String) adapterView.getItemAtPosition(position);
                switch (ord){
                    case "CocaCola": pre = 7.50; break;
                    case "Grapete": pre = 6.00; break;
                    case "Te Frio": pre = 7.00; break;
                    case "Agua Pura": pre = 5.00; break;
                    case "Limonada": pre = 7.00; break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
            }
        });
        btnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtCan.getText().toString().equals("")){
                        txtCan.setText("1");
                };
                Toast.makeText(getApplicationContext(), ord,Toast.LENGTH_SHORT).show();
                Intent pasar = new Intent(Menu.this, Final.class);
                pasar.putExtra("orden",ord );
                pasar.putExtra("precio", pre);
                pasar.putExtra("Cantidad", txtCan.getText().toString());
                startActivity(pasar);
            }
        });


    }
}
