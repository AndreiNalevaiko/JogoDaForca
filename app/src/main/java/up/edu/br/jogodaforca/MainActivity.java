package up.edu.br.jogodaforca;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnVerificar;
    private EditText edtLetra;
    private TextView txtLetrasErradas, txtPalavra;
    private ImageView imgForca;
    private String PALAVRA = "CASA";
    private char[] vetorPalavraInteira;
    private String[] vetorPalpite;

    List<String> letrasErradas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVerificar = findViewById(R.id.btnverificar);
        edtLetra = findViewById(R.id.edtLetra);
        txtLetrasErradas = findViewById(R.id.txtLetrasErradas);
        txtPalavra = findViewById(R.id.txtPalavra);
        imgForca = findViewById(R.id.imgForca);

        vetorPalavraInteira = PALAVRA.toCharArray();

        vetorPalpite = new String[PALAVRA.length()];

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String letra = edtLetra.getText().toString().toUpperCase();
                //Limpar a caixa de texto;
                edtLetra.setText("");
                if (PALAVRA.contains(letra)) {
                    for (int i = 0; i < vetorPalavraInteira.length; i++) {
                        if (vetorPalavraInteira[i] == letra.charAt(0)) {
                            vetorPalpite[i] = String.valueOf(vetorPalavraInteira[i]);
                            desenharPalavra();

                        }
                    }

                    if (verificarAcerto()) {
                        Toast.makeText(MainActivity.this, "PARABÉNS!!!", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    marcaLetraErrada(letra);
                    desenharLetrasErradas();
                    trocarImagem(letrasErradas.size());
                }
            }
        });

        desenharPalavra();
    }

    private void desenharPalavra() {
        txtPalavra.setText("");
        for (int i = 0; i < PALAVRA.length(); i++) {
            if (vetorPalpite[i] != null) {
                txtPalavra.setText(txtPalavra.getText() + vetorPalpite[i]);
            } else {
                txtPalavra.setText(txtPalavra.getText() + "- ");
            }
        }
    }

    private boolean verificarAcerto() {
        for (int i = 0; i < PALAVRA.length(); i++) {
            if (vetorPalpite[i] == null) {
                return false;
            }
        }
        return true;
    }

    private boolean marcaLetraErrada(String letra){
        for(String letraErrada : letrasErradas){
            if(letraErrada.equals(letra)){
                return false;
            }
        }

        letrasErradas.add(letra);
        return true;
    }

    private void desenharLetrasErradas(){

        txtLetrasErradas.setText(" ");
        for(String letras : letrasErradas){
            txtLetrasErradas.setText(txtLetrasErradas.getText() + letras + "");
        }

    }

    private void trocarImagem(int erros){
        switch (erros){
            case 1:
                imgForca.setImageResource(R.drawable.image2);
                break;
            case 2:
                imgForca.setImageResource(R.drawable.image3);
                break;
            case 3:
                imgForca.setImageResource(R.drawable.image4);
                break;
            case 4:
                imgForca.setImageResource(R.drawable.image5);
                break;
            case 5:
                imgForca.setImageResource(R.drawable.image6);
                break;
            case 6:
                imgForca.setImageResource(R.drawable.image7);
                break;
            case 7:
                imgForca.setImageResource(R.drawable.image8);
                break;
            case 8:
                imgForca.setImageResource(R.drawable.image9);
//                Toast.makeText(MainActivity.this, "GAME OVER.", Toast.LENGTH_SHORT).show();
//                btnVerificar.setEnabled(Boolean.FALSE);
                exibirMensagem();
                break;

            default:
                break;
        }
    }

    private void exibirMensagem(){
        //Caixa de Mensagem
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Você Pedeu! Seu Bosta.");
        builder.setMessage("Deseja reiniciar?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reinicarJogo();
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        //Criando a Mensagem
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void reinicarJogo(){
        txtPalavra.setText("");
        txtLetrasErradas.setText("");
        letrasErradas.clear();

        PALAVRA = "BUNDA";

    }
}
