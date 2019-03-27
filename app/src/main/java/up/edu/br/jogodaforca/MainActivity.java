package up.edu.br.jogodaforca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnVerificar;
    private EditText edtLetra;
    private TextView txtLetrasErradas, txtPalavra;
    private ImageView imgForca;
    private final String PALAVRA = "CASA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerificar = (Button) findViewById(R.id.btnverificar);
        edtLetra = (EditText) findViewById(R.id.edtLetra);
        txtLetrasErradas = (TextView) findViewById(R.id.txtLetrasErradas);
        txtPalavra = findViewById(R.id.txtPalavra);
        imgForca = findViewById(R.id.imgForca);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (PALAVRA.contains(edtLetra.getText().toString().toLowerCase())) {
                    Toast.makeText(MainActivity.this, "SIM", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_SHORT).show();
                }
            }
        });

        desenharPalavra();
    }

    private void desenharPalavra() {
        for (int i = 0; i < PALAVRA.length(); i++) {
            txtPalavra.setText(txtPalavra.getText() + "- ");
        }
    }
}
