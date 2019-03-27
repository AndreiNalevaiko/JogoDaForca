package up.edu.br.jogodaforca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private char[] vetorPalavraInteira;
    private String[] vetorPalpite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerificar = (Button) findViewById(R.id.btnverificar);
        edtLetra = (EditText) findViewById(R.id.edtLetra);
        txtLetrasErradas = (TextView) findViewById(R.id.txtLetrasErradas);
        txtPalavra = findViewById(R.id.txtPalavra);
        imgForca = findViewById(R.id.imgForca);

        vetorPalavraInteira = PALAVRA.toCharArray();

        vetorPalpite = new String[PALAVRA.length()];

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String letra = edtLetra.getText().toString();

                if (PALAVRA.contains(letra)) {
                    for (int i = 0; i < vetorPalavraInteira.length; i++) {
                        if (vetorPalavraInteira[i] == letra.charAt(0)) {
                            vetorPalpite[i] = String.valueOf(vetorPalavraInteira[i]);
                            Log.i("Index", String.valueOf(i));
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Não", Toast.LENGTH_SHORT).show();
                }

                String vetor = "";
                for (int i = 0; i < vetorPalpite.length; i++) {
                    vetor += vetorPalpite[i];
                }
                Log.i("index ", vetor);
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
