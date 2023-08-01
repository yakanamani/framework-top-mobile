# Cucumber BDD Framework with Appium, TestNG and Java 11 and parallel execution on Android & IOS

Framework-top-mobile-android est un framework d'automatisation mobile basé sur Appium, Cucumber et TestNG et qui exécute les tests en séquentiel et en parallèle sur les devices Android et IOS et émulateurs, simulateurs Android et IOS.

Si vous souhaitez tester une application mobile de préférence sur IOS et Mac.<br/>
🌟Si vous êtes TESTEUR AUTOMATICIEN et que vous voulez apprendre à automatiser des tests fonctionnels.<br/>
🌟Si vous êtes un RECRUTEUR pour évaluer les compétences de nos testeurs automaticiens talentueux.<br/>
🌟 Ou encore si vous êtes un PARTICULIER ou une ENTREPRISE à la recherche de solution répondant à vos besoins d'automatisation en test alors ce framework est fait pour vous!<br/>

🎁 Ce framework permet d'exécuter vos tests (scénarios) en `Séquentiel` et en `parallel` sur le périphérique IOS de votre choix, que ce soit un device physique ou un simulateur IOS et également sur la plateforme Mac.<br/>
🎁Il contient plusieurs modèles et bonnes pratiques comme le `Page Object Model`, le `Page Factory` qui vous permettent d'avoir un framework assez Robuste, Réutisable, Maintenable et Rapide.<br/>
🎁Il offre également des `Logs` qui vous fournissent une traçabilité, des informations pertinentes sur l'exécution de vos tests et aident à déboguer le framework en cas d'échec des tests.<br/>
🎁Il offre aussi le `Screen Record` qui enregistre des vidéos d'exécution des tests effectués pour vous offrir une meilleure expérience de test.</br>
🎁Il contient aussi du reporting avec `Allure report` pour vous permettre d'avoir une visibilité de la couverture des tests effectués avec succès et ceux qui ont échoués.<br/>

### 🎯Sommaire:
🏷️[Architecture et Présentation du framework](#architecture-et-présentation-du-framework)<br/>
🏷️[Technologies et outils utilisés](#technologies-et-outils-utilisés)<br/>
🏷️[Fonctionnalités](#fonctionnalités)<br/>
🏷️[Environnement de développement](#environnement-de-développement)<br/>
🏷️[Installation du framework](#installation-du-framework)<br/>
🏷️[Pré-requis](#prérequis)<br/>
🏷️[Mise a jour du fichier testng.xml](#mise-à-jour-du-fichier-testngxml)<br/>
🏷️[Exécution du framework](#exécution-du-framework)<br/>
🏷️[Exécution séquentielle](#exécution-séquentielle-un-device-après-lautre)<br/>
🏷️[Exécution parallèle](#exécution-parallèle)<br/>
🏷️[Reporting](#reporting)<br/>
🏷️[Mise à jour et adaptation du Framework](#mise-à-jour-et-adaptation-du-framework)<br/>
🏷️[Déboggage et Maintenance](#déboggage-et-maintenance)<br/>

## 🎯Architecture et Présentation du Framework 

````
📦framework-top-mobile
┣ 📂src
┃ ┣ 📂main
┃ ┃ ┣ 📂java
┃ ┃ ┃ ┣📂FrameworkTop.utils
┃ ┃ ┃ ┃ ┗ 📜CapabilitiesManager.java
┃ ┃ ┃ ┃ ┗ 📜DriverManager.java
┃ ┃ ┃ ┃ ┗ 📜GlobalParams.java
┃ ┃ ┃ ┃ ┗ 📜PropertyManager.java
┃ ┃ ┃ ┃ ┗ 📜ServerManager.java
┃ ┃ ┃ ┃ ┗ 📜TestUtils.java
┃ ┃ ┃ ┃ ┗ 📜VideoManager.java
┃ ┃ ┣ 📂resources
┃ ┃ ┃ ┗ 📜config.properties
┃ ┃ ┃ ┗ 📑log4j2.xml
┃ ┣ 📂test
┃ ┃ ┣ 📂java
┃ ┃ ┃ ┣📂FrameworkkTop
┃ ┃ ┃ ┃ ┣ 📂pages
┃ ┃ ┃ ┃ ┃ ┗ 📜BasePage.java
┃ ┃ ┃ ┃ ┃ ┗ 📜LoginPage.java
┃ ┃ ┃ ┃ ┃ ┗ 📜MenuPage.java
┃ ┃ ┃ ┃ ┃ ┗ 📜ProductDetailsPage.java
┃ ┃ ┃ ┃ ┃ ┗ 📜ProductPage.java
┃ ┃ ┃ ┃ ┃ ┗ 📜SettingsPage.java
┃ ┃ ┃ ┃ ┃ ┣ 📂runners
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyFirstDeviceTestngRunnerTest.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyFourthDeviceTestngRunnerTest.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MySecondDeviceTestngRunnerTest.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyThirdDeviceTestngRunnerTest.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜RunnerBase.java
┃ ┃ ┃ ┃ ┃ ┣ 📂stepdef
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Hooks.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜LoginStepDef.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ProductStepDef.java
┃ ┃ ┃ ┃ ┃ ┗ 📜Main.java
┃ ┃ ┣ 📂resources
┃ ┃ ┃ ┃ ┣ 📂apps
┃ ┃ ┃ ┃ ┃ ┣ 📂SwagLabsMobileApp.app
┃ ┃ ┃ ┃ ┃ ┗ 📑Android.SauceLabs.Mobile.Sample.app.2.7.1.apk
┃ ┃ ┃ ┃ ┗ 📑allure.properties
┃ ┃ ┃ ┃ ┗ 📑Login.feature
┃ ┃ ┃ ┃ ┗ 📑Products.feature
┃ ┃ ┣ 📂Test-output
┃ ┃ ┃ ┣ 📂YYYY-MM-DD
┃ ┃ ┃ ┃ ┣ 📂Device_Name1
┃ ┃ ┃ ┃ ┃ ┣ 📂Logs
┃ ┃ ┃ ┃ ┃ ┗ 📑Application.log
┃ ┃ ┃ ┃ ┃ ┗ 📑Server.log
┃ ┃ ┃ ┃ ┃ ┣ 📂Videos
┃ ┃ ┃ ┃ ┃ ┗ 📑senarioName.mp4
┃ ┃ ┃ ┃ ┣ 📂Device_Name2
┃ ┃ ┃ ┃ ┃ ┣ 📂Logs
┃ ┃ ┃ ┃ ┃ ┗ 📑Application.log
┃ ┃ ┃ ┃ ┃ ┗ 📑Server.log
┃ ┃ ┃ ┃ ┃ ┣ 📂Videos
┃ ┃ ┃ ┃ ┃ ┗ 📑senarioName.mp4
┃ ┃ ┃ ┃ ┣ 📂Device_Name3
┃ ┃ ┃ ┃ ┃ ┣ 📂Logs
┃ ┃ ┃ ┃ ┃ ┗ 📑Application.log
┃ ┃ ┃ ┃ ┃ ┗ 📑Server.log
┃ ┃ ┃ ┃ ┃ ┣ 📂Videos
┃ ┃ ┃ ┃ ┃ ┗ 📑senarioName.mp4
┃ ┃ ┃ ┃ ┣ 📂Device_Name4
┃ ┃ ┃ ┃ ┃ ┣ 📂Logs
┃ ┃ ┃ ┃ ┃ ┗ 📑Application.log
┃ ┃ ┃ ┃ ┃ ┗ 📑Server.log
┃ ┃ ┃ ┃ ┃ ┣ 📂Videos
┃ ┃ ┃ ┃ ┃ ┗ 📑senarioName.mp4
┃ ┃ ┃ ┣ 📂allure-report
┃ ┃ ┃ ┣ 📂allure-results
┃ ┃ ┃ ┣ 📂reports
┃ ┃ ┃ ┃ ┣ 📂cucumber
┃ ┃ ┃ ┃ ┃ ┣ 📂first_device
┃ ┃ ┃ ┃ ┃ ┗ 📑report.html
┃ ┃ ┃ ┃ ┃ ┗ 📑report.json
┃ ┃ ┃ ┃ ┃ ┗ 📑report.xml
┃ ┃ ┃ ┃ ┃ ┣ 📂second_device
┃ ┃ ┃ ┃ ┃ ┗ 📑report.html
┃ ┃ ┃ ┃ ┃ ┗ 📑report.json
┃ ┃ ┃ ┃ ┃ ┗ 📑report.xml
┃ ┃ ┃ ┃ ┃ ┣ 📂third_device
┃ ┃ ┃ ┃ ┃ ┗ 📑report.html
┃ ┃ ┃ ┃ ┃ ┗ 📑report.json
┃ ┃ ┃ ┃ ┃ ┗ 📑report.xml
┃ ┃ ┃ ┃ ┃ ┣ 📂fourth_device
┃ ┃ ┃ ┃ ┃ ┗ 📑report.html
┃ ┃ ┃ ┃ ┃ ┗ 📑report.json
┃ ┃ ┃ ┃ ┃ ┗ 📑report.xml
┣ 📑pom.xml
┣ 📑README.md
┣ 📑testng.xml
````

## 🎯Technologies et outils utilisés
➡️ IntelliJ - IDE<br/>
➡️ Appium - Mobile Automation library<br/>
➡️ Maven - Build automation tool<br/>
➡️ Java - Programming language<br/>
➡️ Cucumber - BDD<br/>
➡️ Gherkin<br/>
➡️ TestNG - Unit testing framework<br/>
➡️ Log4J - Logging framework<br/>
➡️ Allure Reports - Reporting framework<br/>
➡️ JSON - Test Data<br/>
➡️ XML - Static text<br/>

## 🎯Fonctionnalités
✅ Abstraction layer pour les intérations UI (click, sendkeys, ...)<br/>
✅ Paramétrisation par les fichier TestNG XML et config.properties<br/>
✅ Abstraction layer pour les jeux de données<br/>
✅ Abstraction layer pour les textes statiques<br/>
✅ Méthode éffective de capture Screenshots/Vidéos<br/>
✅ Exécution séquentielle avec testNG<br/>
✅ Exécution parallèle avec testNG<br/>
✅ Exécution sequentielle sur devices physiques (et/ou Emulateurs/Simulateurs ) Android et iOS<br/>
✅ Exécution parallèle sur devices physiques (et/ou Emulateurs/Simulateurs ) Android et iOS<br/>
✅ Démarrage automatique programmé du serveur Appium<br/>
✅ Cucumber-HTML-Reporter plugin<br/>
✅ Gestion des logs  avec Log4J2 Logging framework<br/>

## 🎯Environnement de développement

| **Logiciel**                   | **version**       | **Description**                                                                                                                                                                                                                                                                                                                                                                                                   | **Windows** | **Macbook** |
|--------------------------------|-------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------|-------------|
| Java JDK                       | JAVA 11           | [Dowloadable here](https://www.oracle.com/eg/java/technologies/javase/jdk11-archive-downloads.html) and install on [Windows](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA) or [Macbook](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) | X           | X           |
| Android SDK via Android studio | current available | [Dowloadable here](https://developer.android.com/studio?gclid=Cj0KCQjwuLShBhC_ARIsAFod4fIcuMWb00yxfjGTPrFEemQ_pc3UrvmvB45VSYcnueWrfyX8fLJpz_4aAthfEALw_wcB&gclsrc=aw.ds)                                                                                                                                                                                                                                          | X           | X           |
| Node.js                        | 18.15.0           | [Dowloadable here](https://nodejs.org/en/download)                                                                                                                                                                                                                                                                                                                                                                | X           |             |
| maven                          | 3.8.6             | [Download here](https://maven.apache.org/download.cgi) and [Install here](https://maven.apache.org/install.html)                                                                                                                                                                                                                                                                                                  |             | X           |
| maven                          | 3.8.6             | terminal : `brew install maven`                                                                                                                                                                                                                                                                                                                                                                                   | X           | X           |
| Allure                         | current available | [Downloadable here](https://docs.qameta.io/allure/)                                                                                                                                                                                                                                                                                                                                                               | X           | X           |
| npm                            | 9.5.0             | Downloaded with node.js                                                                                                                                                                                                                                                                                                                                                                                           | X           | X           |
| appium                         | 2.0.0-beta.59     | terminal: `npm install -g appium@next`                                                                                                                                                                                                                                                                                                                                                                            | X           | X           |
| UiAutomator2                   | current available | terminal: `appium driver install uiautomator`                                                                                                                                                                                                                                                                                                                                                                     | X           | X           |
| XCuitest                       | current available | terminal: `appium driver install xcuitest`                                                                                                                                                                                                                                                                                                                                                                        |             | X           |
| appium client (wd)             | current available | terminal: `npm install wd`                                                                                                                                                                                                                                                                                                                                                                                        | X           | X           |
| Carthage                       | -                 | terminal: `brew install carthage`                                                                                                                                                                                                                                                                                                                                                                                 |             | X           |
| libimobiledevice               | current available | terminal : `brew install libimobiledevice`                                                                                                                                                                                                                                                                                                                                                                        |             | X           |
| Xcode                          | -                 | Downloadable via App Store                                                                                                                                                                                                                                                                                                                                                                                        |             | X           |
| Authorize-ios                  | current available | terminal : `npm install authorize-ios`                                                                                                                                                                                                                                                                                                                                                                            |             | X           |
| ios-deploy                     | current available | terminal : `npm install ios-deploy`                                                                                                                                                                                                                                                                                                                                                                               |             | X           |
| ideviceinstaller               | current available | terminal : `npm install ideviceinstaller`                                                                                                                                                                                                                                                                                                                                                                         |             | X           |



## 🎯Installation du framework

#### Prérequis
🟥 NB: POUR EXÉCUTER CE FRAMEWORK, VOUS DEVEZ AVOIR UNE BONNE CONNEXION INTERNET !

- Devices
  - 📌**Device physique**
    
    | **Description**                       | **Android** | **iOS** |
    |---------------------------------------|-------------|---------|
    | Mode développeur activé sur le device | x           | x       |
    | Débogage usb activé                   | x           | x       |
    | Connexion internet activée            | x           | x       |
    | Device déverouillé                    | x           | x       |
    | Device connecté au poste via usb      | x           | x       |

  - 📌**Emulateur(Android) / Simulateur(IOS)** : </br>
    - L'émulateur ou le simulateur doit être lancé et en bon état de marche
      
## 🎯Mise à jour du fichier testng.xml
- Remplir les informations concernant le device utilisé pour les tests automatisés  
  Les informations concernant les caractéristiques du device sont a modifier dans le fichier testng.xml (path_du_repertoire_du_framework/testng.xml)

  1) **Mettre a jour le paramètre platformName**:  
     Il prendra pour valeur **Android** ou **iOS**
  2) **Mettre a jour le paramètre udid**:
     Il est récupérable depuis le terminal (Le device doit etre connecté a l'ordinateur(device physique) ou démarré (device virtuel))
    ```shell
        # Android device  
        adb devices
    ```
  ```shell 
        # iOS device  
        xcrun simctl list
    ```
  3) **Mettre à jour de deviceName**
  4) **Mettre à jour le paramètre virtualDevice**
     Il prendra pour valeur **true** or "false"
        - true = simulator/emulator
        - false = real device

- 📌**exemple**
```xml
   <test name="Tests on third device">

        <parameter name="platformName" value="Android_or_iOS"/>
        <parameter name="udid" value="virtual_device_udid"/>
        <parameter name="deviceName" value="virtual_device_name"/>
        <parameter name="virtualDevice" value="true_or_false"/>
    </test>
```

- 📌**Paramètres requis** :

  | **Paramètre**        | **Android** | **iOS** |
  |----------------------|-------------|---------|
  | platformName         | x           | x       |
  | udid                 | x           | x       |
  | deviceName           | x           | x       |
  | virtualDevice        | x           | x       |
  | systemPort           | x           |         |
  | chromeDriverPort     | x           |         |
  | wdaLocalPort         |             | x       |
  | webkitDebugProxyPort |             | x       |

- 📌**Important** : la valeur choisie pour chacun des paramètres suivants doit être unique et différente des autres valeurs
  - systemPort
  - chromeDriverPort
  - wdaLocalPort
  - webkitDebugProxyPort

## 🎯Exécution du framework

### 🎯Exécution séquentielle (un device après l'autre)
Ce mode d'exécution permet de voir le framework se dérouler sur les devices de manière ordonnée selon la configuration définie dans le fichier **_testng.xml_**

#### 🔴 Android Devices
Il s'agira de paramétrer et d'exécuter le framework sur plusieurs devices Android</br>
  
**Etapes**: 
1. **Configurer le fichier testng.xml en suivant le template suivant pour chaque device** (**Maximum 4 devices**) :
      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
    
      <suite name="Suite">
      
          <test name="Tests on first device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10001"/>
              <parameter name="chromeDriverPort" value="11001"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFirstDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on second device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10002"/>
              <parameter name="chromeDriverPort" value="11002"/>
              <classes>
                  <class name="FrameworkTop.runners.MySecondDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on third device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10003"/>
              <parameter name="chromeDriverPort" value="11003"/>
              <classes>
                  <class name="FrameworkTop.runners.MyThirdDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on fourth device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10004"/>
              <parameter name="chromeDriverPort" value="11004"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFourthDeviceTestngRunnerTest"/>
              </classes>
          </test>
      </suite>
      ````
2. **Lancer l'exécution**
   - **Depuis l'IDE**:</br>
   Depuis le fichier **testng.xml** ou **Main.java** 

   - **Depuis la CLI** (Command Line Interface = Invite de commande)
   Depuis l'invite de commande, exécuter le script suivant:
   ```shell
    mvn clean test
    ```
#### 🔴iOS Devices
Il s'agira de paramétrer et d'exécuter le framework sur plusieurs devices iOS</br>

**Etapes**:
1. **Configurer le fichier testng.xml en suivant le template suivant pour chaque device** (**Maximum 4 devices**) :
      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
     
      <suite name="Suite">
      
          <test name="Tests on first device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10001"/>
              <parameter name="webkitDebugProxyPort" value="11001"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFirstDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on second device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10002"/>
              <parameter name="webkitDebugProxyPort" value="11002"/>
              <classes>
                  <class name="FrameworkTop.runners.MySecondDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on third device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10003"/>
              <parameter name="webkitDebugProxyPort" value="11003"/>
              <classes>
                  <class name="FrameworkTop.runners.MyThirdDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on fourth device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10004"/>
              <parameter name="webkitDebugProxyPort" value="11004"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFourthDeviceTestngRunnerTest"/>
              </classes>
          </test>
      </suite>
      ````
2. **Lancer l'exécution**
  - **Depuis l'IDE**:</br>
    Depuis le fichier **testng.xml** ou **Main.java**
    
  - **Depuis la CLI** (Command Line Interface = Invite de commande)
    Depuis l'invite de commande, exécuter le script suivant:
    ```shell
    mvn clean test
    ```

#### 🔴Android and iOS Devices
Il s'agira de paramétrer et d'exécuter le framework sur plusieurs devices</br>

**Etapes**:
1. **Configurer le fichier testng.xml en suivant le template suivant pour chaque device** (**Maximum 4 devices**) :
      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
      
      <suite name="Suite">
      
          <test name="Tests on first device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10001"/>
              <parameter name="webkitDebugProxyPort" value="11001"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFirstDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on second device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10002"/>
              <parameter name="chromeDriverPort" value="11002"/>
              <classes>
                  <class name="FrameworkTop.runners.MySecondDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on third device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10003"/>
              <parameter name="webkitDebugProxyPort" value="11003"/>
              <classes>
                  <class name="FrameworkTop.runners.MyThirdDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on fourth device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10004"/>
              <parameter name="chromeDriverPort" value="11004"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFourthDeviceTestngRunnerTest"/>
              </classes>
          </test>
      </suite>
      ````
2. **Lancer l'exécution**
- Depuis l'IDE:</br>
  Depuis le fichier **testng.xml** ou **Main.java**
  
- **Depuis la CLI** (Command Line Interface = Invite de commande)
  Depuis l'invite de commande, exécuter le script suivant:
  ```shell
  mvn clean test
  ```
### 🎯Exécution parallèle 
Ce mode d'exécution permet de voir le framework se dérouler sur les devices en simultané selon la configuration définie dans le fichier **_testng.xml_**

#### 🔴Android Devices
Il s'agira de paramétrer et d'exécuter le framework sur plusieurs devices Android</br>

**Etapes**:
1. **Configurer le fichier testng.xml en suivant le template suivant pour chaque device** (**Maximum 4 devices**) :
      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
      
      <suite name="Suite" parallel="tests>
      
          <test name="Tests on first device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10001"/>
              <parameter name="chromeDriverPort" value="11001"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFirstDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on second device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10002"/>
              <parameter name="chromeDriverPort" value="11002"/>
              <classes>
                  <class name="FrameworkTop.runners.MySecondDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on third device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10003"/>
              <parameter name="chromeDriverPort" value="11003"/>
              <classes>
                  <class name="FrameworkTop.runners.MyThirdDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on fourth device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10004"/>
              <parameter name="chromeDriverPort" value="11004"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFourthDeviceTestngRunnerTest"/>
              </classes>
          </test>
      </suite>
      ````
2. **Lancer l'exécution**
    - **Depuis l'IDE**:</br>
      Depuis le fichier **testng.xml** ou **Main.java**
      
    - **Depuis la CLI (Command Line Interface = Invite de commande)**
      Depuis l'invite de commande, exécuter le script suivant:
   ```shell
    mvn clean test
    ```
#### 🔴iOS Devices
Il s'agira de paramétrer et d'exécuter le framework sur plusieurs devices iOS</br>

**Etapes**:
1. **Configurer le fichier testng.xml en suivant le template suivant pour chaque device** (**Maximum 4 devices**) :
      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
      
      <suite name="Suite" parallel="tests>
      
          <test name="Tests on first device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10001"/>
              <parameter name="webkitDebugProxyPort" value="11001"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFirstDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on second device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10002"/>
              <parameter name="webkitDebugProxyPort" value="11002"/>
              <classes>
                  <class name="FrameworkTop.runners.MySecondDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on third device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10003"/>
              <parameter name="webkitDebugProxyPort" value="11003"/>
              <classes>
                  <class name="FrameworkTop.runners.MyThirdDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on fourth device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10004"/>
              <parameter name="webkitDebugProxyPort" value="11004"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFourthDeviceTestngRunnerTest"/>
              </classes>
          </test>
      </suite>
      ````
2. **Lancer l'exécution**
- **Depuis l'IDE**:</br>
  Depuis le fichier **testng.xml** ou **Main.java**
  
- **Depuis la CLI (Command Line Interface = Invite de commande)**
  Depuis l'invite de commande, exécuter le script suivant:
  ```shell
  mvn clean test
  ```

#### 🔴Android and iOS Devices
Il s'agira de paramétrer et d'exécuter le framework sur plusieurs devices</br>

**Etapes**:
1. **Configurer le fichier testng.xml en suivant le template suivant pour chaque device** (**Maximum 4 devices**) :
      ````xml
      <?xml version="1.0" encoding="UTF-8"?>
      <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
     
      <suite name="Suite" parallel="tests>
      
          <test name="Tests on first device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10001"/>
              <parameter name="webkitDebugProxyPort" value="11001"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFirstDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on second device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10002"/>
              <parameter name="chromeDriverPort" value="11002"/>
              <classes>
                  <class name="FrameworkTop.runners.MySecondDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on third device">
              <parameter name="platformName" value="iOS"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="wdaLocalPort" value="10003"/>
              <parameter name="webkitDebugProxyPort" value="11003"/>
              <classes>
                  <class name="FrameworkTop.runners.MyThirdDeviceTestngRunnerTest"/>
              </classes>
          </test>
          <test name="Tests on fourth device">
              <parameter name="platformName" value="Android"/>
              <parameter name="udid" value="device_udid"/>
              <parameter name="deviceName" value="device_name"/>
              <parameter name="virtualDevice" value="true_or_false"/>
              <parameter name="systemPort" value="10004"/>
              <parameter name="chromeDriverPort" value="11004"/>
              <classes>
                  <class name="FrameworkTop.runners.MyFourthDeviceTestngRunnerTest"/>
              </classes>
          </test>
      </suite>
      ````
2. **Lancer l'exécution**
   Depuis le fichier **testng.xml** ou **Main.java**

- **Depuis la CLI (Command Line Interface = Invite de commande)**
  Depuis l'invite de commande, exécuter le script suivant:
  ```shell
  mvn clean test
  ```
#### 🎯Reporting
Les différents rapports et artefacts resultants de l'exécution des tests seront disponibles dans le dossier:
- **_Test-output:_**
  - **_cucumber-report_**
  - **_allure-report_**
  - **_Enregistrement videos_**
  - **_Logs_**

## 🎯Mise à jour et adaptation du Framework

### 🪙Ajout nouvelle application
  1. **Ajouter la(les) nouvelle(s) application(s) dans le dossier **apps** (_chemin d'accès_: src/test/resources/apps)**
  2. **Mettre a jour les informations de l'application dans le fichier **config.properties**(_chemin d'accès_: src/main/resources/config.properties)** </br>
     - Android
     
      | **Variable**       | **value**         |   
      |--------------------|-------------------|
      | androidAppLocation | apk_path          | 
      | androidAppActivity | apk_activity_name | 
      | androidAppPackage  | apk_package_name  |
    
     - iOS

      | **Variable**   | **value**           |   
      |----------------|---------------------|
      | iOSAppLocation | app_or_ipa_path     | 
      | iOSBundleId    | app_or_ipa_BundleID | 

### 🪙Ajout de nouveaux scénarios
1. **Ajouter le nouveau _feature file_ dans le dossier src/test/resources** suivant l'un des templates suivants:
```gherkin
@test
Feature: write here your feature title

Scenario: write here scenario title 
Given I do first step
When I do second step next
Then thrid step should be expected result
```

```gherkin
@test
Feature: Login scenarios

Scenario Outline: write here scenario title (scenario with datas)
Given this first step
When I use this data: "<username>"
And this data: "<password>"
Then I should get this data: "<err>"
Examples:
| username | password | err |
| invalidUsername | secret_sauce | Username and password do not match any user in this service. |
```
2. **Définir les methodes de "steps definition" dans le dossier **stepdef** (_chemin d'accès : src/test/java/FrameworkTop/stepdef_)**
3. **En utilisant le Page Object Model design, créer les pages contentant les object spécifiques dans le dossier **pages** (_Chemin d'accès: src/test/java/FrameworkTop/pages_)**
4. **Utiliser les "objets" créés pour la redaction des methodes de step definition**

### 🪙Ajout de devices supplémentaires
1. **Ajouter un nouveau runner(fichier d'exécution) pour le nouveau device dans le dossier **runners** (_chemin d'accès : src/test/java/FrameworkTop/runners_)** en suivant le template suivant:
```java
package FrameworkTop.runners;


import io.cucumber.testng.*;

// A personnaliser au besoin
@CucumberOptions(plugin = {
        "pretty",
        "html:test-output/reports/cucumber/fifth_device/report.html",
        "junit:test-output/reports/cucumber/fifth_device/report.xml",
        "json:test-output/reports/cucumber/fifth_device/report.json",
        "summary",
},
        features = {"src/test/resources"},
        glue = "FrameworkTop.stepdef",
        tags = "@test",
        monochrome = false
)
public class MyfifthDeviceTestngRunnerTest extends RunnerBase{


}
```
2. **Ajouter une nouvelle section <test> dans le fichier _testng.xml_** en suivant le template suivant:
```xml
<test name="Tests on fifth device">
    <parameter name="platformName" value="Android_or_iOS"/>
    <parameter name="udid" value="simulator_udid"/>
    <parameter name="deviceName" value="simulator_device_name"/>
    <parameter name="virtualDevice" value="true_or_false"/>
    <!--only for iOS devices-->
    <parameter name="wdaLocalPort" value="10005"/>
    <parameter name="webkitDebugProxyPort" value="11005"/>
    <!--only for Android devices-->
    <parameter name="systemPort" value="10003"/>
    <parameter name="chromeDriverPort" value="11003"/>
    <classes>
        <class name="FrameworkTop.runners.MyFifthDeviceTestngRunnerTest"/>
    </classes>
</test>
```
## 🎯Déboggage et Maintenance

### 🔴Débogage
- Erreur suite à une tentative de **_Build module_** : 
Vérifier que l'environnement de travail et l'IDE sont bien paramétrés pour **Java 11**
- Erreur suite à une tentative de **_maven compile_** :
Vérifier que l'environnement de travail et l'IDE sont bien paramétrés pour **Java 11**

### 🔴Maintenance
- **Dépendances:**
Régulièrement vérifier le fichier pom.xml pour s'assurer que les dependances sont a jour, si non les mettre a jour.
Site de téléchargement des dépendances maven : https://mvnrepository.com

