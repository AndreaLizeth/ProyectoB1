package com.google.firebase.codelab.friendlychat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //Definir Componentes
    private EditText email1;
    private EditText password1;
    private EditText password2;
    private Button   btnRegister1;
    private ProgressDialog progressDialog;
    private TextView btnLogin1;
    private ImageView mImageView;
    //Definir un objeto de firebase
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Inicializamos el objeto firebaseAuth
        firebaseAuth = firebaseAuth.getInstance();

        //Referencia a la vista
        email1 = (EditText)findViewById(R.id.txtEmail);
        password1 = (EditText)findViewById(R.id.txtPassword);
        password2 = (EditText)findViewById(R.id.txtPassword2);
        btnRegister1 = (Button)findViewById(R.id.btnRegister);
        btnLogin1 = (TextView)findViewById(R.id.btnLogin);

        mImageView = (ImageView) findViewById(R.id.imgAdduser);
        mImageView.setImageResource(R.drawable.adduser);
        progressDialog = new ProgressDialog(this);


        //Boton para escuchar un evento
        btnRegister1.setOnClickListener(this);
        btnLogin1.setOnClickListener(this);
    }

    private void registrarUsuario(){
        //Guardar el email y contraseña
        String email = email1.getText().toString().trim();
        String password = password1.getText().toString().trim();
        String password_2 = password2.getText().toString().trim();

        //Validar que los EditText no esten vacios
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Se debe ingresar una contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password_2)){
            Toast.makeText(this,"Se debe ingresar la confirmación de la contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.equals(password,password_2)){
            progressDialog.setMessage("Creando nuevo usuario, por favor espere ..");
            progressDialog.show();

            //Creacion del usuario
            firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    //Verificacion de la creacion del usuario
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,"Se ha creado el nuevo usuario con el email: " + email1.getText(), Toast.LENGTH_LONG).show();
                    }else{
                        //Verifica si el usuario existe
                        if(task.getException() instanceof FirebaseAuthUserCollisionException){
                            Toast.makeText(RegisterActivity.this,"Ese usuario ya existe, por favor inicie sesion", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(RegisterActivity.this, "No se ha podido crear el usuario", Toast.LENGTH_LONG).show();
                        }
                    }
                    progressDialog.dismiss();
                }
            });
        }else{
            Toast.makeText(this,"Las contraseñas no coinciden, por favor intentelo de nuevo", Toast.LENGTH_LONG).show();
            return;
        }
    }

    @Override
    public void onClick(View view){
        //Se llama al metodo de acuerdo al boton presionado
        switch (view.getId()){
            case R.id.btnRegister:
                //Metodo crear usuario
                registrarUsuario();
                break;
            case R.id.btnLogin:
                //Se transfiere al Activity principal para login
                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(i);
                break;
        }
    }

}