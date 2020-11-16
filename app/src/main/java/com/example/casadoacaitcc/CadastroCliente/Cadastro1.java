package com.example.casadoacaitcc.CadastroCliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.casadoacaitcc.Login;
import com.example.casadoacaitcc.R;

import utils.utilsCadastro_cliente;

public class Cadastro1 extends AppCompatActivity implements View.OnClickListener {

    EditText txtNome, txtSenha, txtEmail, txtData;
    Button btnCad1;
    TextView lblFacaLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro1);

        txtNome = findViewById(R.id.txtNome);
        txtSenha = findViewById(R.id.txtSenha);
        txtEmail = findViewById(R.id.txtEmail);
        txtData = findViewById(R.id.txtData);
        btnCad1 = findViewById(R.id.btnCad1);
        lblFacaLogin = findViewById(R.id.lblFacaLogin);
        btnCad1.setOnClickListener(this);
        lblFacaLogin.setOnClickListener(this);

        setTextCorDegrade();


    }
    private void setTextCorDegrade(){
        TextPaint paint = lblFacaLogin.getPaint();
        float width = paint.measureText("faça o login aqui");

        Shader shader = new LinearGradient(0,0,width,lblFacaLogin.getTextSize(),
                new int[]{
                        Color.parseColor("#9300E9"),
                        Color.parseColor("#BF0085"),


                }, null, Shader.TileMode.CLAMP);
        lblFacaLogin.getPaint().setShader(shader);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnCad1:

                utilsCadastro_cliente.setUnome_cli(txtNome.getText().toString());
                utilsCadastro_cliente.setUsenha_cli(txtSenha.getText().toString());
                utilsCadastro_cliente.setUemail_cli(txtEmail.getText().toString());
                utilsCadastro_cliente.setUdtnasc_cli(txtData.getText().toString());


                Intent telaCad2 = new Intent(this, Cadastro2.class);
                startActivity(telaCad2);

                break;
            case R.id.lblFacaLogin:
                Intent login = new Intent(this, Login.class);
                startActivity(login);
                break;
        }
    }
}