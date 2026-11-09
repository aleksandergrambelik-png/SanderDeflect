# SanderDeflect v1.0

A standalone Android defense dashboard built by Aleksander. Written in pure Java, with zero external dependencies, no Gradle, and no root access required.

## Overview

SanderDeflect is a native Android application designed for network reconnaissance, deception, and active defense. It runs directly on the device as an APK without requiring Termux or any other environment.

## POC

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/3187aca2-1351-4d4e-b344-be5e82e455ac" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/dada24c0-2568-4494-a170-f6620d7a2f14" width="300" /></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/5025e579-52d6-43f3-b647-f46dcd39c65f" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/12e284f1-4b05-4dc8-95c1-30ffbf2eeeef" width="300" /></td>
  </tr>
</table>

## Features

- Math Challenge: The application requires solving a random arithmetic problem before granting access. Intended as a basic filter against automated script kiddies.
- Recon: Fetches a target URL and displays the raw HTML response.
- Decoy: Serves a fake "Router Login" page to mislead automated scanners.
- Tarpit (Socket): Listens on port 8080 and intentionally delays or traps incoming connections with sarcastic responses.
- Sinkhole: Logs incoming IP addresses, User-Agents, and HTTP requests in JSON format.
- Mirror: Reflects malicious requests (e.g., `/admin`) back to the sender.

## Installation

1. Download the latest `SanderDeflect.apk` from the [Releases](https://github.com/aleksandergrambelik-png/SanderDeflect/releases) tab.
2. Install the APK on your Android device.
3. Open the app and solve the math challenge to proceed.

## Source Code Notice

This repository only contains the UI layer (`MainActivity`, `Dashboard`) and resource files.

The core logic modules (`DeflectHttp`, `DeflectSocket`, `SanderGuard`, etc.) are private and are not included in this public repository. This is to prevent unauthorized repackaging or misuse of the tool.

If you intend to build this from source, you must provide your own module implementations.

## Credits & AI Collaboration

This project was made possible through a collaboration between human logic and AI assistance:

- Idea & Architecture: Aleksander (@aleksandergrambelik-png)
- Core Logic & Implementation: Aleksander
- AI Assistance (Debugging): DeepSeek V4.1 Pro (and other LLMs used during development)

The tools used here are merely instruments. The final design, quality control, and decision-making remain in the hands of the developer.

## License

This project is licensed under the GNU Affero General Public License v3.0 (AGPL-3.0). See the [LICENSE](LICENSE) file for details.

## Author

Aleksander
- GitHub: [@aleksandergrambelik-png](https://github.com/aleksandergrambelik-png)

---
Copyright (C) 2026 Aleksander.
