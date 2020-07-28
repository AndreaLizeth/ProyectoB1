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
>![Alt text](https://elvismpq.github.io/test/images/1.jpeg)

Se pude realizar un registro de usuarios con un formulario

>![Alt text](https://elvismpq.github.io/test/images/5.jpeg)

Al ingresar al chat permite enviar mandar mensajes en una sala global a todos los usuarios de la aplicacion

>![Alt text](https://elvismpq.github.io/test/images/6.jpeg)

Permite adjunta imagenes de todo tipo para enviar al chat.

>![Alt text](https://elvismpq.github.io/test/images/7.jpeg) 


>![Alt text](https://elvismpq.github.io/test/images/8.jpeg)

Y finalmente la aplicación permite cerrar sesión.

## Dispositivos usados ##
 ### Sony Xperia XZ1 ###
>* **Sistema Operativo:** Android
* **Versión:** 9.0
![Alt text](https://elvismpq.github.io/test/images/10.jpeg)
* * *
### Galaxy Note 10.1 2014 ###
* **Sistema Operativo:** Android
* **Versión:** 5.1.1
![Alt text](https://elvismpq.github.io/test/images/9.jpeg)
* * *
### Xiaomi Redmi Note 7 ###
* **Sistema Operativo:** Android
* **Versión:** 0.9
![Alt text](https://elvismpq.github.io/test/images/2.jpeg)
* * *
### Nexus 10 API 30 ###
* **Sistema Operativo:** Android
* **Versión:** 0.9
![Alt text](https://elvismpq.github.io/test/images/11.jpeg)
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
El fragmento de código a continuación se encuentra en el **MainActivity.java** y permite leer los mensajes que cada usuario envia  en el chat, obteniendo la identificación
del usuario y mostrando en el chat.
* * *

### Manual de Usuario ###
El archivo `Manual de Usuario.pdf` describe cada paso que debe seguir para la instalación, su forma de uso y la configuración.

