# NFC Sweetspot Library

NFC Sweetspot library provides a activity that shows where your phone's NFC sweetspot is located.

## Adding to project

Add this to your build.gradle:

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'de.cotech:nfc-sweetspot:1.0'
}
```

## Usage

1. Define a fullscreen style, similar to this:
```xml

<style name="Theme.YourApp.AppCompat.Fullscreen" parent="Theme.AppCompat.Light">
    <item name="android:windowFullscreen">true</item>
    <item name="android:windowIsFloating">false</item>
    <item name="windowActionBar">false</item>
    <item name="windowNoTitle">true</item>
    <item name="android:colorBackgroundCacheHint">@null</item>
    <item name="android:windowIsTranslucent">true</item>
    <item name="android:windowAnimationStyle">@android:style/Animation.Translucent</item>
    <item name="android:windowContentOverlay">@null</item>
    <item name="android:windowBackground">@android:color/transparent</item>
</style>
```

2. Add ``de.cotech.sweetspot.ShowNfcSweetspotActivity`` to your Manifest, similar to this:
```xml

<activity
    android:name="de.cotech.sweetspot.ShowNfcSweetspotActivity"
    android:exported="false"
    android:theme="@style/Theme.YourApp.AppCompat.Fullscreen"
    />

```

3. Start activity where needed.

# Thanks to
 * The database has been assembled by [McLear Ltd](https://mclear.com) and released under Apache v2
 * This library has been put together by [Cotech](https://cotech.de)

# License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
