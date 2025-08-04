# Radiance Fm
Radiance FM – A sleek, Jetpack Compose-powered radio streaming app delivering seamless playback, modern UI, and real-time audio experiences.




✅ Project Architecture Overview (MVVM-based)

```java
📦 com.example.radiance
│
├── 📁 data          ← Data sources (stream URLs, repositories)
├── 📁 domain        ← Optional: Use cases, business logic
├── 📁 model         ← Data classes (Station, Metadata, etc.)
├── 📁 ui            ← Jetpack Compose Screens
├── 📁 viewmodel     ← State & business logic
└── 📁 util          ← Helpers, constants, audio player manager

