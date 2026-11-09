# Music Library (viewer only, no player)

Tiny dependency-free Android app (plain Java, no AndroidX) that lists your music by Albums / Artists / Songs.

## Build with GitHub
1. Create a new GitHub repo and upload everything in this folder (keep the `.github/workflows/build.yml` path).
2. Open the **Actions** tab -> "Build APK" runs on every push (or press **Run workflow**).
3. When it finishes, open the run and download the **mlib-apk** artifact, unzip, install the APK.

## Use
- First launch asks you to pick your music folder (system picker, no storage permission needed).
- It scans all sub-folders recursively. Names show up first, tags and covers fill in after.
- Circle at top-right = manual refresh (only re-reads new or changed files). Folder icon = change folder.
- Tap the stats line at the top for full stats. Tap an artist -> albums, album -> songs, song -> details.
- Back button (or swipe back) returns to the previous list at the exact scroll position you left it.
- Targets Android 16 (API 36).
