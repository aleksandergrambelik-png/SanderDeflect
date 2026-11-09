# SanderDeflect v1.0

A standalone Android defense dashboard built by Aleksander. Written in pure Java, with zero external dependencies, no Gradle, and no root access required.

## Overview

SanderDeflect is a native Android application designed for network reconnaissance, deception, and active defense. It runs directly on the device as an APK without requiring Termux or any other environment.

## POC

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/a67b39bc-4a02-4b0a-8750-00f65116797c" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/22d07774-e3ca-4d92-9a67-80eeeaf8fb73" width="300" /></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/8807e2ed-798b-4574-aceb-4e99a90aa1aa" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/765b7f44-33dc-4311-bf7c-b07b80d1ee41" width="300" /></td>
  </tr>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/6c4a1ca5-5a4d-43db-ae00-35ecf1f7c537" width="300" /></td>
    <td><img src="https://github.com/user-attachments/assets/65d5883e-6d7c-48c0-bf77-3555975b0891" width="300" /></td>
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
