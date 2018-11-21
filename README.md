# NFC Sweetspot Library

NFC Sweetspot library provides an activity that shows where your phone's NFC sweetspot is located.

![](https://github.com/cotechde/nfc-sweetspot/raw/master/screenshot.png)

## Adding to project

Add this to your build.gradle:

```gradle
repositories {
    jcenter()
}

dependencies {
    compile 'de.cotech:nfc-sweetspot:1.1'
}
```

## Usage

1. Add ``de.cotech.sweetspot.ShowNfcSweetspotActivity`` to your Manifest, similar to this:
```xml

<activity
    android:name="de.cotech.sweetspot.ShowNfcSweetspotActivity"
    android:exported="false"
    />

```

2. Start activity where needed.

# Thanks to
 * The sweetspot data was collected by [McLear Ltd](https://mclear.com) and released under Apache v2
 * The server to collect this data is [open source](https://github.com/JohnMcLear/sweetspot-server)
 * This library is maintained by [Cotech](https://cotech.de)

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
