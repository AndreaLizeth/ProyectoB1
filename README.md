# README #

En este README contiene un explicativo del la aplicación de realizada en Android Studio acerca de un chat.

## Acerca del proyecto ##
### Explicación ###
El repositorio contiene el proyecto **build-android-start** y la aplicación de android **apk**.
Estos son lo requisitos para ejecutar la aplicación:
* **Espacio Libre**: 5 Mb
* **Dispositivos**: Android
* **Versión**: 5.0 o superiores

### Funcionalidades ###
La aplicación permite iniciar sesión tanto con una cuenta de la aplicación como con una cuenta de Google.
 <p align="center"> 
 <img src="https://elvismpq.github.io/test/images/1.jpeg" width="300"/> 
</p> 

Se pude realizar un registro de usuarios con un formulario

<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/5.jpeg" width="300"/> 
</p> 

Al ingresar al chat permite enviar mandar mensajes en una sala global a todos los usuarios de la aplicacion
<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/6.jpeg" width="300"/> 
</p> 

Permite adjunta imagenes de todo tipo para enviar al chat.
<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/7.jpeg" width="300"/> 
</p> 


<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/8.jpeg" width="300"/> 
</p> 

Y finalmente la aplicación permite cerrar sesión.

## Dispositivos usados ##
 ### Sony Xperia XZ1 ###
* **Sistema Operativo:** Android
* **Versión:** 9.0

<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/10.jpeg" width="300"/> 
</p> 


* * *
### Galaxy Note 10.1 2014 ###
* **Sistema Operativo:** Android
* **Versión:** 5.1.1


<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/9.jpeg" width="300"/> 
</p> 



* * *
### Xiaomi Redmi Note 7 ###
* **Sistema Operativo:** Android
* **Versión:** 9.0
<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/2.jpeg" width="300"/> 
</p> 


* * *
### Nexus 10 API 30 ###
* **Sistema Operativo:** Android
* **Versión:** 11.0 



<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/11.png" width="300"/> 
</p> 



* * *
### Samsung A5 2017 ###
* **Sistema Operativo:** Android
* **Versión:** 8.0


<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/12.jpeg" width="300"/> 
</p> 



* * *
### NEXUS 7 API 25 ###
* **Sistema Operativo:** Android
* **Versión:** 6.0


<p align="center"> 
 <img src="https://elvismpq.github.io/test/images/13.jpeg" width="300"/> 
</p> 



* * *
## Código ##
En esta parte del codigo se indica las animaciones que tiene el splash screen, en esta ocasion los desplazamiento hascia arriba y abajo.

>        Animation animacion1= AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
>        Animation animacion2= AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);
>
>        TextView tvBienvenido= findViewById(R.id.tvBienvenido);
>        TextView tvTopicos= findViewById(R.id.tvTopicos);
>        ImageView imageView= findViewById(R.id.imageView);
>
>       tvBienvenido.setAnimation(animacion1);
>        tvTopicos.setAnimation(animacion1);
>        imageView.setAnimation(animacion2);
>        new Handler().postDelayed(new Runnable() {
>            @Override
>            public void run() {
>                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
>                startActivity(intent);
>               finish();
>            }

* * *
Esta parte del código permite la autentificación con Google ubicado en el `SignInActivity.java`.
>private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
>        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
>        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
>        mFirebaseAuth.signInWithCredential(credential)
>                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
>                    @Override
>                    public void onComplete(@NonNull Task<AuthResult> task) {
>                        Log.d(TAG, "signInWithCred>ential:onComplete:" + task.isSuccessful());
>
>                        if (!task.isSuccessful()) {
>                            Log.w(TAG, "signInWithCredential", task.getException());
>                            Toast.makeText(SignInActivity.this, "Authentication failed.",
>                                    Toast.LENGTH_SHORT).show();
>                        } else {
>                            startActivity(new Intent(SignInActivity.this, MainActivity.class));
>                            finish();
>                        }
>                    }
>                });
>    }
* * *
En cambio este otro fragmento permite la autentificacion con una cuenta de correo previamente registrada.
>  mFirebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
>            @Override
>            public void onComplete(@NonNull Task<AuthResult> task) {
>                //Verificacion del inicio de sesion
>                if(task.isSuccessful()){
>                    Toast.makeText(SignInActivity.this,"Bienvenido " + email1.getText(), Toast.LENGTH_LONG).show();
>                    Intent i = new Intent(SignInActivity.this, MainActivity.class);
>                    startActivity(i);
>                }else{
>                    //Verifica si el usuario existe
>                    Toast.makeText(SignInActivity.this,"Ese usuario no existe o el email y la contraseña no son validos", Toast.LENGTH_LONG).show();
>                }
>                progressDialog.dismiss();
>            }
>        });
* * *
Este fragmento sacado del `MainActivity.java` permite subir imagenes al chat de la aplicación.
>          private void putImageInStorage(StorageReference storageReference, Uri uri, final String key) {
>             storageReference.putFile(uri).addOnCompleteListener(MainActivity.this,
>                  new OnCompleteListener<UploadTask.TaskSnapshot>() {
>                       @Override
>                      public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
>                        if (task.isSuccessful()) {
>                            task.getResult().getMetadata().getReference().getDownloadUrl()
>                                    .addOnCompleteListener(MainActivity.this,
>                                            new OnCompleteListener<Uri>() {
>                                                @Override
>                                                public void onComplete(@NonNull Task<Uri> task) {
>                                                    if (task.isSuccessful()) {
>                                                        FriendlyMessage friendlyMessage =
>                                                                new FriendlyMessage(null, mUsername, mPhotoUrl,
>                                                                        task.getResult().toString());
>                                                        mFirebaseDatabaseReference.child(MESSAGES_CHILD).child(key)
>                                                                .setValue(friendlyMessage);
>                                                    }
>                                                }
>                                            });
>                        } else {
>                            Log.w(TAG, "Image upload task was not successful.",
>                                    task.getException());
>                        }
>                    }
>                });
>    }
* * *
Este fragmento de código llama los mensajes de `Firebase` y los va actualizando continuamente.
>      mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
>         SnapshotParser<FriendlyMessage> parser = new SnapshotParser<FriendlyMessage>() {
>            @Override
>            public FriendlyMessage parseSnapshot(DataSnapshot dataSnapshot) {
>                FriendlyMessage friendlyMessage = dataSnapshot.getValue(FriendlyMessage.class);
>                if (friendlyMessage != null) {
>                    friendlyMessage.setId(dataSnapshot.getKey());
>                }
>                return friendlyMessage;
>            }
>        };
>
>          DatabaseReference messagesRef = mFirebaseDatabaseReference.child(MESSAGES_CHILD);
>         FirebaseRecyclerOptions<FriendlyMessage> options =
>                new FirebaseRecyclerOptions.Builder<FriendlyMessage>()
>                        .setQuery(messagesRef, parser)
>                        .build();
>          mFirebaseAdapter = new FirebaseRecyclerAdapter<FriendlyMessage, MessageViewHolder>(options) {
>            @Override
>            public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
>                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
>                return new MessageViewHolder(inflater.inflate(R.layout.item_message, viewGroup, false));
>            }
>
>            @Override
>            protected void onBindViewHolder(final MessageViewHolder viewHolder,
>                                            int position,
>                                            FriendlyMessage friendlyMessage) {
>                mProgressBar.setVisibility(ProgressBar.INVISIBLE);
>                if (friendlyMessage.getText() != null) {
>                    viewHolder.messageTextView.setText(friendlyMessage.getText());
>                    viewHolder.messageTextView.setVisibility(TextView.VISIBLE);
>                    viewHolder.messageImageView.setVisibility(ImageView.GONE);
>                } else if (friendlyMessage.getImageUrl() != null) {
>                    String imageUrl = friendlyMessage.getImageUrl();
>                    if (imageUrl.startsWith("gs://")) {
>                        StorageReference storageReference = FirebaseStorage.getInstance()
>                                .getReferenceFromUrl(imageUrl);
>                        storageReference.getDownloadUrl().addOnCompleteListener(
>                                new OnCompleteListener<Uri>() {
>                                    @Override
>                                    public void onComplete(@NonNull Task<Uri> task) {
>                                        if (task.isSuccessful()) {
>                                            String downloadUrl = task.getResult().toString();
>                                            Glide.with(viewHolder.messageImageView.getContext())
>                                                    .load(downloadUrl)
>                                                    .into(viewHolder.messageImageView);
>                                        } else {
>                                            Log.w(TAG, "Getting download url was not successful.",
>                                                    task.getException());
>                                        }
>                                    }
>                                });
>                    } else {
>                        Glide.with(viewHolder.messageImageView.getContext())
>                                .load(friendlyMessage.getImageUrl())
>                                .into(viewHolder.messageImageView);
>                    }
>                    viewHolder.messageImageView.setVisibility(ImageView.VISIBLE);
>                    viewHolder.messageTextView.setVisibility(TextView.GONE);
>                }
>
>
>                viewHolder.messengerTextView.setText(friendlyMessage.getName());
>                if (friendlyMessage.getPhotoUrl() == null) {
>                    viewHolder.messengerImageView.setImageDrawable(ContextCompat.getDrawable(MainActivity.this,
>                            R.drawable.ic_account_circle_black_36dp));
>                } else {
>                    Glide.with(MainActivity.this)
>                            .load(friendlyMessage.getPhotoUrl())
>                            .into(viewHolder.messengerImageView);
>                }
>
>            }
>        };
* * *
### Manual de Usuario ###
El archivo `Manual de Usuario.pdf` describe cada paso que debe seguir para la instalación, su forma de uso y la configuración.
* * *
### Referencias ###
    1. https://www.youtube.com/watch?v=BrgOzY5BHdg
    2. https://codelabs.developers.google.com/codelabs/firebase-android/
    3. https://www.youtube.com/watch?v=lEacPYUB9cc
  
