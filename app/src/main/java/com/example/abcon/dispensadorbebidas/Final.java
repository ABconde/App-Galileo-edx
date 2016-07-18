package com.example.abcon.dispensadorbebidas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    private TextView txtPedido,txtTotal, txtCantidad;
    private Button btnSalir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        txtPedido = (TextView) findViewById(R.id.txtPedido);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        txtCantidad = (TextView) findViewById(R.id.txtCantidad);
        btnSalir = (Button) findViewById(R.id.btnSalir);
        Bundle bundle =this.getIntent().getExtras();
        txtPedido.setText(bundle.getString("orden").toString());
        Double canti =Double.parseDouble(bundle.getString("Cantidad"));
        Double total =bundle.getDouble("precio");
        Double ttotal = canti * total;
        txtCantidad.setText(bundle.getString("Cantidad").toString());
        txtTotal.setText(ttotal.toString());

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Final.this, Bienvenida.class));
            }
        });
    }
}
