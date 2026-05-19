# Vaje3Compose — Android Jetpack Compose

Android projekt z osmimi vajami iz Jetpack Compose. Vsaka vaja je v ločeni datoteki z `@Preview` anotacijo.

## Pomembno: rabiš Android Studio, ne IntelliJ Community

Compose razvoj zahteva Android SDK in emulator, kar IntelliJ Community ne podpira. Prenesi **Android Studio** brezplačno z [developer.android.com/studio](https://developer.android.com/studio).

## Odpiranje projekta

1. Razpakiraj zip kjerkoli.
2. Android Studio → **File → Open** → izberi mapo `Vaje3Compose` (tisto z `settings.gradle.kts`).
3. "Trust Project" → počakaj na Gradle sync (prvič 3–10 min, prenese AGP, Compose BOM, Material 3 itd.).
4. Ko sync uspe, levo zgoraj izberi konfiguracijo **app** in poženi (zelena puščica).

## Zagon: emulator ali pravi telefon

- **Emulator**: `Tools → Device Manager → Create Virtual Device`, izberi npr. Pixel 6 z API 34. Po kreaciji izberi v top barvi in pritisni Run.
- **Pravi telefon**: omogoči Developer Options + USB Debugging, priklopi prek USB, izberi napravo.

## Preview brez emulatorja

Vsaka `.kt` vaja ima `@Preview` funkcijo. Odpri katerokoli `Vaja##_*.kt` in v zgornjem desnem kotu klikni **Split** (ali ikono očesa). Compose preview se prikaže ob kodi — brez emulatorja, le statičen renderiranje. Hitro za vizualne popravke.

## Struktura

```
Vaje3Compose/
├── settings.gradle.kts
├── build.gradle.kts                      (root)
├── gradle.properties
├── gradle/wrapper/gradle-wrapper.properties
└── app/
    ├── build.gradle.kts                  (app modul - Compose, Material 3, BOM)
    ├── proguard-rules.pro
    └── src/main/
        ├── AndroidManifest.xml
        ├── java/com/example/vaje3/
        │   ├── MainActivity.kt           (meni z vsemi 8 vajami)
        │   ├── ui/theme/Theme.kt
        │   └── vaje/
        │       ├── Vaja01_Vizitka.kt
        │       ├── Vaja02_JedilniList.kt
        │       ├── Vaja03_Urnik.kt
        │       ├── Vaja04_Kalkulator.kt
        │       ├── Vaja05_KalkulatorNapredni.kt
        │       ├── Vaja06_KalkulatorNapredni2.kt
        │       ├── Vaja07_Kliker.kt
        │       └── Vaja08_IgraKliker.kt
        └── res/values/
            ├── strings.xml
            ├── themes.xml
            └── (colors.xml ni potreben - Compose uporablja Material 3)
```

## Pregled vaj

| # | Vaja | Compose koncepti |
|---|------|-----------------|
| 1 | Osebna vizitka | `Column`, `Text`, `background`, `padding`, `horizontalAlignment` |
| 2 | Jedilni list | `Column` + `Row`, `Arrangement.SpaceBetween` |
| 3 | Šolski urnik | Temno ozadje, `Column` + `Row` z urami in predmeti |
| 4 | Kalkulator (osnoven) | `remember`, `mutableStateOf`, `OutlinedTextField`, `Button` |
| 5 | Kalkulator napredni | 5 operatorjev v `Row` z `weight(1f)`, `when` izraz |
| 6 | Kalkulator napredni II | + zgodovina računov, `mutableStateListOf`, `verticalScroll` |
| 7 | Kliker | Celozaslonski gumb, `mutableIntStateOf` |
| 8 | Igra kliker | Dva gumba (po pol ekrana), zmagovalec pri ±20, prikaz konca igre |

## Različice (`build.gradle.kts`)

- AGP 8.5.2
- Kotlin 2.0.21 (s Compose Compiler Plugin)
- compileSdk 34, minSdk 24, targetSdk 34
- Compose BOM 2024.09.00 (Material 3)
- Gradle 8.9
- JDK 17

## Kako navigirati v aplikaciji

`MainActivity` prikaže meni z osmimi gumbi. Klik odpre izbrano vajo. V vsaki vaji je v desnem spodnjem kotu **FAB s puščico ←** za vrnitev v meni. Tako lahko hitro testiraš vsako vajo brez ponovnega zagona aplikacije.
