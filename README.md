# Appium-workshop
Repositorio con el código y las instrucciones para para la ejecución de las pruebas con appium.

## Requisitos previos

- Instalar JDK y configurar variable de entorno

- Instalar Maven - [Windows](https://www.mkyong.com/maven/how-to-install-maven-in-windows/) - [Linux](https://www.vultr.com/docs/how-to-install-apache-maven-on-ubuntu-16-04)

- Instalar Android Studio y el SDK de Android - [Descargar aquí](https://developer.android.com/studio/#downloads) - [Configurar el SDK, descargar las ultimas versiones de las API y utilidades](https://www.adslzone.net/software/android-en-el-pc/como-instalar-el-sdk-y-los-componentes-de-android-studio/)

- Instalar Appium Desktop [Descarga la ultima version acorde a tu OS](https://github.com/appium/appium-desktop/releases/tag/v1.8.2)

- Instalar IntelliJ IDEA [Descargar community edition y con la version de tu OS](https://www.jetbrains.com/idea/download/#section=windows) 

- Instalar dentro de IntelliJ IDEA el plugin de TestNG

- Crear un AVD (Android Virtual Device), emulador que correra la prueba [Guia del sitio oficial](https://developer.android.com/studio/run/managing-avds?hl=es-419)

JSON App settings para la ejecucion del inspector de la apk

```javascript
{
  "deviceName": "Nexus_One_API_24",
  "udid": "emulator-5554",
  "platformName": "Android",
  "platformVersion": "7.0",
  "appPackage": "com.soundcloud.android",
  "appActivity": "com.soundcloud.android.main.MainActivity"
}
```

### Videos Appium Conference

Docker - Android: https://www.youtube.com/watch?v=pQdpjuYwvp8 

Repositorio del video: https://github.com/butomo1989/docker-android

Presentación del meetup: https://drive.google.com/open?id=1-6Kpgtss9CU-LONr-DjTVglbWQO-1Ni5
