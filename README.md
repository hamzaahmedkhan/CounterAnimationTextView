# CounterAnimationTextView
A tiny Android library makes very easier count animation of TextView.

<img src="demo/demo.gif" width="32%">

# Usage
Include the CounterAnimationTextView widget in your layout.
```xml
      <com.github.hamzaahmedkhan.counteranimationtextview.CountAnimationTextView
          android:id="@+id/moneyPositive"
          android:layout_width="wrap_content"
          android:layout_height="wrap_content"
          android:text="0"
          android:textColor="@color/black"
          android:textSize="20sp" />
```
Animate Count with Duration
```Kotlin
    counterAnimationTextView
        .setAnimationDuration(5000)
        .countAnimation(0, 99999)
```
Animate Count with DecimalFormat
```Kotlin
    counterAnimationTextView
        .setDecimalFormat(new DecimalFormat("###,###,###"))
        .setAnimationDuration(10000)
        .countAnimation(0, 9999999)
```
Animate Count with interPolator
```Kotlin
    counterAnimationTextView
        .setInterpolator(AccelerateInterpolator())
        .countAnimation(0, 9999999)
```

# Gradle

Add the dependency to your build.gradle.

```
dependencies {
    implementation 'com.github.hamzaahmedkhan:CountAnimationTextView:1.0.0'
}
```


## If this project helps you in anyway, show your love :heart: by putting a :star: on this project :v: ........ ALSO FEEL FREE TO FORK AND CONTRIBUTE!!