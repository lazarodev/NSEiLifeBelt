package com.gt.dev.ilifebelt.nseilifebelt.activity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gt.dev.ilifebelt.nseilifebelt.R;

public class ContactActivity extends AppCompatActivity {

    private EditText etName, etEmail, etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etName = (EditText) findViewById(R.id.et_name_contact);
        etEmail = (EditText) findViewById(R.id.et_email_contact);
        etMessage = (EditText) findViewById(R.id.et_message_contact);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_contact_activity);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etEmail.getText().toString().equals("")) {
                    Toast.makeText(ContactActivity.this, "Debes ingresar un correo", Toast.LENGTH_SHORT).show();
                } else {
                    sendEmail();
                }
            }
        });
    }

    private void sendEmail() {
        // Instanciamos un intent del tipo ACTION SEND
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        // Definimos la tipologia de datos para el envio del email
        emailIntent.setType("text/html");
        // Indicamos con un array de tipo string para indicar nuestros destinatarios
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@ilifebelt.com"});
        // Definimos un titulo para el email
        emailIntent.putExtra(Intent.EXTRA_TITLE, "Formulario de contacto NSEx");
        // Definimos el asunto para el email
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contactanos NSEx");
        // Obtenemos la referencia del texto y lo pasamos al Email Intent
        emailIntent.putExtra(Intent.EXTRA_TEXT, etName.getText().toString() + etEmail.getText().toString() + etMessage.getText().toString());
        try {
            // Enviamos el correo con un email intent
            startActivity(Intent.createChooser(emailIntent, "Enviando email..."));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No hay ninguna app para enviar correos instalada", Toast.LENGTH_SHORT).show();
        }
    }

}
