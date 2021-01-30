> This project was created during my internship <a href="https://dcoder.tech/" target="_blank">@dcodermobile</a>
<kbd><img src="https://play-lh.googleusercontent.com/PWUsRLZ8fawBOdTjMrSWwa6-EBpzOguNIlvqxepMRFmBD8eTq8UPGj2241I2qFF1Eg=s360-rw" width="14" height="14" /></kbd>.
I am open sourcing it to give back to community. 
> <br/><a href="https://play.google.com/store/apps/details?id=com.paprbit.dcoder" target="_blank">Download Dcoder app for Android</a>

# Language Drawable [![](https://jitpack.io/v/avishekdas128/Language-Drawbale.svg)](https://jitpack.io/#avishekdas128/Language-Drawbale)
A language drawable generator like GitHub in Android.

## A quick demo


## How to implement in your project
### Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
      ...
      maven { url 'https://jitpack.io' }
    }
}
```
### Add the dependency in your app build.gradle
```
dependencies {
	implementation 'com.github.avishekdas128:Language-Drawbale:0.1.0'
}
```
### Now in your Java code,
```JAVA
languageLayout = findViewById(R.id.language_layout);

//The language model takes the fraction of the language and color.
languageList = new ArrayList<>();
languageList.add(new LanguageModel(.2f, Color.RED));
languageList.add(new LanguageModel(.1f, Color.GREEN));
languageList.add(new LanguageModel(.4f, Color.BLUE));
languageList.add(new LanguageModel(.3f, Color.BLACK));
  
languageLayout.setBackground(new LanguageDrawable(languageList));
```

That's it. You've added a GitHub like different language drawable.
