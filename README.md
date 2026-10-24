# 🔧 Repair Assistant (मरम्मत सहायक)
> **Home Appliance Repair Diagnosis & Cost Estimator Android App**  
> *पंखा, कूलर, मोबाइल, फ्रिज, वॉशिंग मशीन और आरओ की खराबी पहचानें, अंदाज़िया खर्चा देखें और मिस्त्री के फ़ालतू बिल से बचें।*

[![Android](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0+-purple.svg)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/UI-Jetpack%20Compose%20M3-blue.svg)](https://developer.android.com/jetpack/compose)
[![Room Database](https://img.shields.io/badge/Storage-Room%20DB-orange.svg)](https://developer.android.com/training/data-storage/room)
[![Min SDK](https://img.shields.io/badge/Min%20SDK-24-brightgreen.svg)](https://developer.android.com)
[![Target SDK](https://img.shields.io/badge/Target%20SDK-36-teal.svg)](https://developer.android.com)

---

## 📖 परिचय (About The App)

**Repair Assistant** एक आधुनिक एंड्रॉइड ऐप्लिकेशन है जो भारतीय घरों में इस्तेमाल होने वाले आम बिजली के उपकरणों (Fan, Air Cooler, Mobile Phone, Refrigerator, Washing Machine, Microwave/Induction, Water Purifier RO) की खराबी को आसानी से डायग्नोज़ करने, अंदाज़िया रिपेयर खर्चा बताने और यह तय करने में मदद करती है कि क्या आप इसे खुद घर पर ठीक कर सकते हैं (DIY) या किसी पेशेवर टेक्नीशियन (Mistri) को बुलाना ज़रूरी है।

---

## ✨ मुख्य फ़ीचर्स (Key Features)

### 1. 🔍 बोलचाल की हिंदी/हिंग्लिश में स्मार्ट सर्च (Hinglish Smart Search)
- सीधे अपनी भाषा में लिखें जैसे:
  - *"fan awaaz kar raha hai"*
  - *"mobile charge nahi hota"*
  - *"cooler mein current lag raha hai"*
  - *"fridge mein barf jam gayi"*
  - *"washing machine spin nahi ho rahi"*
- इंस्टेंट टोकन स्कोरिंग के साथ सबसे सटीक खराबी और लक्षण सबसे ऊपर दिखाए जाते हैं।

### 2. 🛠️ 7 प्रमुख घरेलू उपकरण (7 Detailed Appliance Guides)
- **🌀 Fan (सीलिंग व टेबल पंखा):** बंद पंखा, धीमी स्पीड (कमज़ोर कैपेसिटर), आवाज़ व कंपन, जलने की बदबू व वाइंडिंग बर्नआउट।
- **❄️ Cooler (एयर कूलर):** ठंडी हवा न आना (पंप/हनीकॉम्ब पैड), मोटर हम करना, बॉडी में करंट/अर्थिंग फ़ॉल्ट (**Urgent**), पंखुड़ी की आवाज़।
- **📱 Mobile (स्मार्टफ़ोन):** चार्जिंग समस्या (पोर्ट की धूल vs सब-बोर्ड vs बैटरी), बैटरी ड्रेन, सिर्फ़ ग्लास टूटा vs पूरा फ़ोल्डर, हैंग व हीटिंग, पानी में गिरने पर इमर्जेंसी प्रोटोकॉल।
- **🧊 Refrigerator (फ्रिज):** कूलिंग न होना (थर्मोस्टेट, डोर गैसकेट, गैस लीक, कंप्रेसर), ड्रेन पाइप चोक व बर्फ जमना, कंप्रेसर कंपन।
- **🧺 Washing Machine (वॉशिंग मशीन):** स्पिन न होना, कॉइन ट्रैप चोक, लिड स्विच, ड्राइव बेल्ट, वॉटर इनलेट वाल्व।
- **⚡ Microwave & Induction:** खाना गर्म न होना (HV फ़्यूज़/मैग्नेट्रॉन), E0/E1 एरर कोड, माइका शीट में चिंगारी।
- **💧 RO Water Purifier:** पानी न आना (प्री-फ़िल्टर कैंडल / मेम्ब्रेन), कड़वा स्वाद या बदबू, लगातार वेस्ट पानी बहना।

### 3. 📍 शहर के अनुसार खर्चे का हिसाब (City Cost Multiplier)
भारत के अलग-अलग शहरों में लेबर और पार्ट्स के दाम अलग होते हैं:
- **Lucknow (1.0x Base Rate)**
- **Delhi NCR (1.15x)**
- **Mumbai (1.25x)**
- **Bengaluru / Hyderabad (1.20x)**
- **Kolkata (1.05x)**
- **छोटा शहर / क़स्बा / Tier-2/3 (0.90x)**

### 4. 🏷️ DIY vs Technician बैज और मिस्त्री टिप्स
- हर खराबी पर स्पष्ट बैज:
  - 🟢 **"खुद चेक कर सकते हैं"** (Safe DIY)
  - 🔴 **"Technician ज़रूरी"** (Requires professional tools)
- असली मिस्त्री की जांच करने का तरीक़ा और बाज़ार में पार्ट्स की अंदाज़िया क़ीमत।

### 5. 🚨 बिजली सुरक्षा और चेतावनी (Safety Guidelines)
- करंट, शॉर्ट-सर्किट, फूली हुई बैटरी, और हाई-वोल्टेज कैपेसिटर से बचाव के लिए गाइड।

### 6. 📝 सेव्ड रिपेयर्स और कोटेशन नोट्स (Room Database)
- अपनी समस्याओं को बुकमार्क करें, लोकल मिस्त्री का कोटेशन नोट करें और काम पूरा होने पर "Theek ho gaya" मार्क करें।

### 7. ⚖️ "Repair vs नया उपकरण?" कैलकुलेटर (50% Rule)
- क्या पुराने उपकरण में पैसा लगाना चाहिए या नया लेना फ़ायदेमंद है? 50% रूल और उम्र (Age in Years) के आधार पर तुरंत निष्पक्ष सलाह।

---

## 🏗️ तकनीकी संरचना (Tech Stack & Architecture)

- **Language:** Kotlin (100%)
- **UI Toolkit:** Jetpack Compose (Material Design 3)
- **Architecture:** MVVM (Model-View-ViewModel) with Clean StateFlow
- **Local Database:** Android Jetpack Room (Offline-first persistence)
- **Dependency Management:** Gradle Version Catalog (`libs.versions.toml`)
- **Compatibility:** Min SDK 24 (Android 7.0+) to Target SDK 36 (Android 16+)
- **Testing:** Unit Testing & Robolectric JVM tests

---

## 📁 प्रोजेक्ट स्ट्रक्चर (Project Structure)

```text
app/src/main/
├── AndroidManifest.xml
├── java/com/example/
│   ├── MainActivity.kt                     # Main entry activity & Scaffold navigation
│   ├── data/
│   │   ├── local/                          # Room Database
│   │   │   ├── AppDatabase.kt
│   │   │   ├── SavedReportDao.kt
│   │   │   └── SavedReportEntity.kt
│   │   └── model/                          # Domain models & diagnostic data
│   │       ├── Appliance.kt
│   │       └── RepairDatabase.kt
│   └── ui/
│       ├── components/                     # Reusable UI widgets
│       │   ├── AppTopBar.kt
│       │   ├── CitySelectorSheet.kt
│       │   └── CommonComponents.kt
│       ├── screens/                        # Compose Screens
│       │   ├── HomeScreen.kt
│       │   ├── DiagnosisDetailScreen.kt
│       │   ├── SavedRepairsScreen.kt
│       │   ├── SafetyGuideScreen.kt
│       │   └── RepairVsBuyCalculatorScreen.kt
│       ├── theme/                          # Colors, Typography & Material3 Theme
│       │   ├── Color.kt
│       │   ├── Theme.kt
│       │   └── Type.kt
│       └── viewmodel/                      # State & Business logic
│           └── RepairAssistantViewModel.kt
└── res/
    ├── drawable/                           # Adaptive icons & visuals
    └── values/                             # Strings, Colors & Styles
```

---

## 🚀 अपने कंप्यूटर पर कैसे चलाएं (How to Run Locally)

### आवश्यकताएं (Prerequisites)
1. **Android Studio** (Ladybug / Meerkat या नवीनतम संस्करण)
2. **JDK 17 या 21**
3. **Android SDK 36**

### स्टेप्स (Steps):
1. **Repository क्लोन करें:**
   ```bash
   git clone https://github.com/<YOUR_USERNAME>/<REPO_NAME>.git
   cd <REPO_NAME>
   ```
2. **Android Studio में खोलें:**
   - Android Studio खोलें और `Open Project` चुनकर प्रोजेक्ट फ़ोल्डर सेलेक्ट करें।
   - Gradle Sync पूरा होने दें।
3. **App रन करें:**
   - किसी Android Emulator या USB Debugging वाले रियल फ़ोन को कनेक्ट करें।
   - ऊपर दिए गए हरे **▶ Run (Shift + F10)** बटन पर क्लिक करें।

---

## 🧪 टेस्ट कैसे रन करें (Running Tests)

Unit और Robolectric टेस्ट चलाने के लिए टर्मिनल में रन करें:
```bash
./gradlew testDebugUnitTest
```
*(Windows पर: `gradlew.bat testDebugUnitTest`)*

---

## 📤 GitHub पर कैसे अपलोड करें (How to Push to GitHub)

### तरीक़ा 1: Terminal / Command Line से

1. अपने कंप्यूटर पर GitHub CLI या Git टर्मिनल खोलें और प्रोजेक्ट फ़ोल्डर में जाएं:
   ```bash
   cd <project-folder>
   ```

2. अगर Git इनिशियलाइज़ नहीं है:
   ```bash
   git init
   git add .
   git commit -m "Initial commit: Repair Assistant Android App"
   ```

3. डिफ़ॉल्ट ब्रांच का नाम `main` करें:
   ```bash
   git branch -M main
   ```

4. GitHub पर नया रिपॉज़िटरी बनाएं (उदा. `repair-assistant-android`) और रिमोट जोड़ें:
   ```bash
   git remote add origin https://github.com/<YOUR_GITHUB_USERNAME>/<REPO_NAME>.git
   ```

5. कोड पुश करें:
   ```bash
   git push -u origin main
   ```

---

## 📄 लाइसेंस (License)

यह प्रोजेक्ट [MIT License](LICENSE) के तहत ओपन-सोर्स है। आप इसे अपनी ज़रूरत अनुसार उपयोग व संशोधित कर सकते हैं।
